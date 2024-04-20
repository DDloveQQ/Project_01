package NetworkProgram.NetWorkApi;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.junit.Test;

// InetAddress类主要表示IP地址，有两个子类：Inet4Address、Inet6Address。
// InetAddress 类没有提供公共的构造器，而是提供了几个静态方法来获取InetAddress实例

public class InetAddressClass {
    @Test
    public void test01() throws UnknownHostException{
        InetAddress localHost = InetAddress.getLocalHost();  //由LocalHost获得InetAddress对象
        System.out.println(localHost);
    }
    @Test
    public void test02() throws UnknownHostException{
        InetAddress atguigu = InetAddress.getByName("www.atguigu.com");  //由域名获得InetAddress对象
        System.out.println(atguigu);
    }
    @Test
    public void test03() throws UnknownHostException{
        // byte[] addr = {112,54,108,98};
        byte[] addr = {(byte)192,(byte)168,24,56};
        InetAddress atguigu = InetAddress.getByAddress(addr);  //由地址获得InetAddress对象
        System.out.println(atguigu);
    }
}
