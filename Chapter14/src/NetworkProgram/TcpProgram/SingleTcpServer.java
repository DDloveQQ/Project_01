package NetworkProgram.TcpProgram;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 演示单个客户端与服务器单次通信
// TCP服务器端程序包含以下四个基本的步骤:
// 1. 调用 ServerSocket(int port), 创建一个服务器端套接字用于监听客户端
// 2. 调用 accept(), 监听连接请求
// 3. 调用 该Socket 类对象的 getOutputStream() 和 getInputStream () ：获取输出流和输入流，开始网络数据的发送和接收。
// 4. 关闭 Socket对象

public class SingleTcpServer {
    public static void main(String[] args)throws Exception {
        //1、准备一个ServerSocket对象，并绑定8888端口
        ServerSocket server = new ServerSocket(8888);
        System.out.println("等待连接....");
        //2、在8888端口监听客户端的连接，该方法(accept)是个阻塞的方法，如果没有客户端连接，将一直等待
        Socket socket = server.accept();
        InetAddress inetAddress = socket.getInetAddress();
        System.out.println(inetAddress.getHostAddress() + "客户端连接成功！！");
        //3、获取输入流，用来接收该客户端发送给服务器的数据
        InputStream input = socket.getInputStream();
        //接收数据
        byte[] data = new byte[1024];
        StringBuilder s = new StringBuilder();
        int len;
        while ((len = input.read(data)) != -1) {
            s.append(new String(data, 0, len));
        }
        System.out.println(inetAddress.getHostAddress() + "客户端发送的消息是：" + s);
        //4、获取输出流，用来发送数据给该客户端
        OutputStream out = socket.getOutputStream();
        //发送数据
        out.write("欢迎登录".getBytes());
        out.flush();
        //5、关闭socket，不再与该客户端通信
        //socket关闭，意味着InputStream和OutputStream也关闭了
        socket.close();
        //6、如果不再接收任何客户端通信，可以关闭ServerSocket
        server.close();
    }
}
