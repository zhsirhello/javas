package inet.nettynio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg)
            throws Exception{
        //ByteBuf类似于jdk的java.nio.ByteBuffer
        ByteBuf buf = (ByteBuf) msg;
        //readanleBytes可获取缓冲区的字节数
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("The time server receive order:" + body);

        ByteBuf resp = Unpooled.copiedBuffer(new Date().toString().getBytes());
        //异步发送，将消息写入发送缓冲数组中
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx)
            throws Exception{
        //将发送缓冲数组中的数据写入
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        //释放资源
        ctx.close();
    }
}
