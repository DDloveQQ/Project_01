package NetworkProgram.TcpProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatRoomServer {
    //这个集合用来存储所有在线的客户端
    static ArrayList<Socket> online = new ArrayList<Socket>();  // 数据类型为Socket

    public static void main(String[] args) throws Exception {
        //1、启动服务器，绑定端口号
        ServerSocket server = new ServerSocket(8989);
        //2、接收n多的客户端同时连接
        while (true) {
            Socket accept = server.accept();
            online.add(accept);//把新连接的客户端添加到online列表中
            MessageHandler mh = new MessageHandler(accept);
            mh.start();  //线程开始(多线程Thread下的start方法)
        }
    }

    static class MessageHandler extends Thread {
        private Socket socket;
        private String ip;

        public MessageHandler(Socket socket) {
            super();
            this.socket = socket;
        }

        public void run() {
            try {
                ip = socket.getInetAddress().getHostAddress();
                //插入：给其他客户端转发“我上线了”
                sendToOther(ip + "上线了");
                //(1)接收该客户端的发送的消息
                InputStream input = socket.getInputStream();  //输入流
                InputStreamReader reader = new InputStreamReader(input);  //字符输入流
                BufferedReader br = new BufferedReader(reader);  //带缓冲的字符输入流
                String str;
                while ((str = br.readLine()) != null) {
                //(2)给其他在线客户端转发
                    sendToOther(ip + ":" + str);
                }
                sendToOther(ip + "下线了");
            } catch (IOException e) {
                try {
                    sendToOther(ip + "掉线了");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } finally {
                //从在线人员中移除我
                online.remove(socket);
            }
        }

        //封装一个方法：给其他客户端转发xxx消息
        public void sendToOther(String message) throws IOException {
            //遍历所有的在线客户端，一一转发
            for (Socket on : online) {
                OutputStream every = on.getOutputStream();
                //为什么用PrintStream？目的用它的println方法，按行打印
                PrintStream ps = new PrintStream(every);
                ps.println(message);
            }
        }
    }
}

