package inet.tcpsocket.numThread.server.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * ，避免阻塞，在socket客户端也用了两个线程，一个用来输入，一个用来读取。
 */
public class MyClient {
    public static void main(String[] args)
            throws IOException
    {
        Socket s = s = new Socket("127.0.0.1" , 30000);
        //客户端启动ClientThread线程不断读取来自服务器的数据
        new Thread(new ClientThread(s)).start();
        //获取该Socket对应的输出流
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        //不断读取键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null)
        {
            //将用户的键盘输入内容写入Socket对应的输出流
            ps.println(line);
        }
    }
}
