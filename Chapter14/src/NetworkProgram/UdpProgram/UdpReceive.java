package NetworkProgram.UdpProgram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {
    public static void main(String[] args) throws Exception {
        // 建立接收端的DatagramSocket，需要指定本端的监听端口号
        DatagramSocket ds = new DatagramSocket(9999);  // 基于UDP协议的Socket

        //一直监听数据
        while (true) {
            // 建立数据包DatagramPacket
            byte[] buffer = new byte[1024 * 64];  //一次最多64kb
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);  //DatagramSocket发送、接收的数据包
            // 调用Socket的接收方法
            ds.receive(dp);
            // 拆封数据
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println(str);
        }
        // ds.close();  //不可到达,因为while循环会一直监听数据
    }
}
