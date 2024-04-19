package IOstream.OtherStream;

// System.in和System.out分别代表了系统标准的输入和输出设备
// 默认输入设备是：键盘，输出设备是：显示器
// System.in的类型是InputStream
// System.out的类型是PrintStream，其是OutputStream的子类FilterOutputStream 的子类
// 重定向：通过System类的setIn，setOut方法对默认设备进行改变。
    //public static void setIn(InputStream in)
    //public static void setOut(PrintStream out)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdIoStream {
    public static void main(String[] args) {
        System.out.println("请输入信息(退出输入e或exit):");
        // 把"标准"输入流(键盘输入)这个字节流包装成字符流,再包装成缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            while ((s = br.readLine()) != null) { // 读取用户输入的一行数据 --> 阻塞程序
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    System.out.println("安全退出!!");
                    break;
                }
                // 将读取到的整行字符串转成大写输出
                System.out.println("-->:" + s.toUpperCase());
                System.out.println("继续输入信息");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close(); // 关闭过滤流时,会自动关闭它包装的底层节点流
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
