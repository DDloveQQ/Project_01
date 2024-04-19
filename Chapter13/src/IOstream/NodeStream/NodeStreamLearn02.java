package IOstream.NodeStream;


import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class NodeStreamLearn02 {
    ///////////////////////////////// 文件输入流 ///////////////////////////////////
    @Test
    public void test() throws IOException {
        // 使用文件名称创建流对象
        FileInputStream fis = new FileInputStream("src/Files/aaa.txt");
        // 读取数据，返回一个字节
        int read = fis.read();  // read()读取的字节将自动提升为int类型
        System.out.println((char) read);
        read = fis.read();  // read()会接着上次的位置继续读
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        // 读取到末尾,返回-1
        read = fis.read();
        System.out.println(read);
        // 关闭资源
        fis.close();
    }

    @Test
    public void test02() throws IOException {
        // 使用文件名称创建流对象
        FileInputStream fis = new FileInputStream("src/Files/aaa.txt");
        // 定义变量，保存数据
        int b;
        // 循环读取
        while ((b = fis.read()) != -1) {  // 当没读到末尾时就继续读
            System.out.println((char) b);
        }
        // 关闭资源
        fis.close();
    }

    @Test
    public void test03()throws IOException{
        // 使用文件名称创建流对象.
        FileInputStream fis = new FileInputStream("src/Files/aaa.txt"); // 文件中为abcde
        // 定义变量，作为有效个数
        int len;
        // 定义字节数组，作为装字节数据的容器
        byte[] b = new byte[2];
        // 循环读取
        while (( len = fis.read(b))!=-1) {
            // 每次读取后,把数组变成字符串打印
            System.out.println(new String(b, 0, len));
            // 是由于最后一次读取时，只读取一个字节`o`，所以要通过`len`获取有效的字节, 否则会出现额外的错误字节
        }
        // 关闭资源
        fis.close();
    }

    ///////////////////////////////// 文件输出流 ///////////////////////////////////
    @Test
    public void test1() throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("src/Files/ccc.txt");
        // 写出数据
        fos.write(97); // 写出第1个字节
        fos.write(98); // 写出第2个字节
        fos.write(99); // 写出第3个字节
        // 关闭资源
        fos.close();
        /* 输出结果：abc*/
    }

    @Test
    public void test2()throws IOException {
        // 使用文件名称创建流对象(true表示内容追加)
        FileOutputStream fos = new FileOutputStream("src/Files/ccc.txt", true);
        // 字符串转换为字节数组
        byte[] b = "abcde".getBytes();
        // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
        fos.write(b,2,2);  // cd
        // 关闭资源
        fos.close();
    }

    //使用FileInputStream\FileOutputStream，实现对文件的复制
    @Test
    public void test05() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1. 造文件-造流
            //复制图片：成功
            // fis = new FileInputStream(new File("pony.jpg"));
            // fos = new FileOutputStream(new File("pony_copy1.jpg"));
            //复制文本文件：成功
            fis = new FileInputStream(new File("src/Files/ccc.txt"));
            fos = new FileOutputStream(new File("src/Files/ddd.txt"));
            //2. 复制操作（读、写）
            byte[] buffer = new byte[1024];
            int len;//每次读入到buffer中字节的个数
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                // String str = new String(buffer,0,len);
                // System.out.print(str);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //3. 关闭资源
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
