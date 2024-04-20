package NetworkProgram.UdpProgram;

import NetworkProgram.NetWorkApi.InetAddressClass;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

// 发送端程序包含以下四个基本的步骤：
    // 1. 创建DatagramSocket ：默认使用系统随机分配端口号。
    // 2. 创建DatagramPacket：将要发送的数据用字节数组表示，并指定要发送的数据长度，接收方的IP地址和端口号。
    // 3. 调用该DatagramSocket 类对象的send方法 ：发送数据报DatagramPacket对象。
    // 4. 关闭DatagramSocket 对象：发送端程序结束，关闭通信套接字。

public class UdpSend {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        // 要发送的数据
        ArrayList<String> all = new ArrayList<>();
        all.add("尚硅谷让天下没有难学的技术！");
        all.add("学高端前沿的IT技术来尚硅谷！");
        all.add("尚硅谷让你的梦想变得更具体！");
        all.add("尚硅谷让你的努力更有价值！");

        // 接收方IP地址
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        // 接收方的端口
        int port = 9999;
        // 发送多个数据包
        for (int i = 0; i < all.size(); i++) {
            // 建立数据包DatagramPacket
            byte[] data = all.get(i).getBytes();
            DatagramPacket dp = new DatagramPacket(data, 0, data.length, ip, port);
            // 调用Socket的发送方法
            ds.send(dp);
        }
        ds.close();
    }
}
