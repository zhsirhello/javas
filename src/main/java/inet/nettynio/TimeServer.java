package inet.nettynio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {

    public void bind(int port) throws Exception {
        //创建了两个线程组，用于网络事件的处理，实际上就是Reactor线程组
        //一个用于服务端接受客户端的连接，一个用于进行SocketChannel的网络读写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            //启动nio服务端的辅助启动类
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    //设置channel，对应jdk nio中的ServerSocketChannel
                    .channel(NioServerSocketChannel.class)
                    //配置上一个设置的tcp相关参数
                    .option(ChannelOption.SO_BACKLOG,1024)
                    //i/o事件的处理类
                    .childHandler(new ChildChanelHandler());
            //绑定端口，返回类似jdk 的Future，用于异步操作通知回调
            ChannelFuture f = b.bind(port).sync();

            //此处用于阻塞，在服务端链路关闭后可通
            f.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChanelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            /**
             * 与客户端同样添加解决粘包问题
             * socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));//以换行符为标志的解码器
             * socketChannel.pipeline().addLast(new StringDecoder());  //StringDecoder的作用是转换成字符串
             */
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception{
        int port = 8080;
        if(args !=null && args.length > 0 ){
            try{

                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }

        new TimeServer().bind(port);
    }
}

