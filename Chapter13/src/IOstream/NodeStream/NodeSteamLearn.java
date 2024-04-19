package IOstream.NodeStream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class NodeSteamLearn {
    //////////////////////////////  读文件  /////////////////////////////////////
    // 读取aaa.txt文件中的字符数据,并输出在控制台上
    //实现方式1
    @Test
    public void test1() throws IOException {
        //1. 创建File类的对象，对应着物理磁盘上的某个文件
        File file = new File("src\\Files\\aaa.txt");
        //2. 创建FileReader流对象，将File类的对象作为参数传递到FileReader的构造器中
        FileReader fr = new FileReader(file);
        //3. 通过相关流的方法，读取文件中的数据
        // int data = fr.read(); //每调用一次读取一个字符
        // while (data != -1) {
        // System.out.print((char) data);
        // data = fr.read();
        // }
        int data;
        while ((data = fr.read()) != -1) {
            System.out.print((char) data);
        }
        System.out.println();
        //4. 关闭相关的流资源，避免出现内存泄漏
        fr.close();
    }
    //实现方式1.5：在方式1的基础上改进，使用try-catch-finally处理异常。保证流是可以关闭的
    @Test
    public void test2() {
        FileReader fr = null;
        try {
            //1. 创建File类的对象，对应着物理磁盘上的某个文件
            File file = new File("src\\Files\\aaa.txt");
            //2. 创建FileReader流对象，将File类的对象作为参数传递到FileReader的构造器中
            fr = new FileReader(file);
            //3. 通过相关流的方法，读取文件中的数据
            /*
             * read():每次从对接的文件中读取一个字符。并将此字符返回。
             * 如果返回值为-1,则表示文件到了末尾，可以不再读取。
             * */
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭相关的流资源，避免出现内存泄漏
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //实现方式2：调用read(char[] cbuf),每次从文件中读取多个字符(效率应该更高)
    @Test
    public void test3() {
        FileReader fr = null;
        try {
            //1. 创建File类的对象，对应着物理磁盘上的某个文件
            File file = new File("src\\Files\\aaa.txt");
            //2. 创建FileReader流对象，将File类的对象作为参数传递到FileReader的构造器中
            fr = new FileReader(file);
            //3. 通过相关流的方法，读取文件中的数据
            char[] cbuf = new char[5];
            /*
            * read(char[] cbuf) : 每次将文件中的数据读入到cbuf数组中，并返回读入到数组中的字符的个数。
            *
            * */
            int len; //记录每次读入的字符的个数
            while ((len = fr.read(cbuf)) != -1) {
                //处理char[]数组即可
                //错误：(为什么错误?因为cbuf可能存在装不满的情况,此时如果遍历整个cbuf数组会导致额外的字符产生)
                // for(int i = 0;i < cbuf.length;i++){
                // System.out.print(cbuf[i]);
                // }
                //错误：(错误原因同上)
                // String str = new String(cbuf);
                // System.out.print(str);
                //正确：
                // for(int i = 0;i < len;i++){
                // System.out.print(cbuf[i]);
                // }
                //正确：
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭相关的流资源，避免出现内存泄漏
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //////////////////////////////  写文件  /////////////////////////////////////
    @Test
    public void test01()throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter(new File("src/Files/ccc.txt"));
        // 写出数据
        fw.write(97); // 写出第1个字符
        fw.write('b'); // 写出第2个字符
        fw.write('C'); // 写出第3个字符
        fw.write(30000); // 写出第4个字符，中文编码表中30000对应一个汉字。
        //关闭资源
        fw.close();
    }
    //注意：应该使用try-catch-finally处理异常。这里出于方便阅读代码，使用了throws的方式
    @Test
    public void test02()throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter(new File("src/Files/ccc.txt"));
        // 字符串转换为字节数组
        char[] chars = "尚硅谷".toCharArray();
        // 写出字符数组
        fw.write(chars); // 尚硅谷
        // 写出从索引1开始，2个字符。
        fw.write(chars,1,2); // 硅谷
        // 关闭资源
        fw.close();
    }

    @Test
    // 类似与test02,但使用string实现
    public void test03()throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("src/Files/ccc.txt");
        // 字符串
        String msg = "尚硅谷";
        // 写出字符数组
        fw.write(msg); //尚硅谷
        // 写出从索引1开始，2个字符。
        fw.write(msg,1,2); // 硅谷
        // 关闭资源
        fw.close();
    }
    @Test
    public void test04(){
        FileWriter fw = null;
        try {
            //1. 创建File的对象
            File file = new File("src/Files/ccc.txt");
            //2. 创建FileWriter的对象，将File对象作为参数传递到FileWriter的构造器中
            //如果输出的文件已存在，则会对现有的文件进行覆盖
//            fw = new FileWriter(file);
            // fw = new FileWriter(file,false);
            //如果输出的文件已存在，则会在现有的文件末尾写入数据(续写)
             fw = new FileWriter(file,true);
            //3. 调用相关的方法，实现数据的写出操作
            //write(String str) / write(char[] cbuf)
            fw.write("I love you,");
            fw.write("you love him.");
            fw.write("so sad".toCharArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源，避免内存泄漏
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //////////////////////////////  flush刷新  /////////////////////////////////////
    // 因为内置缓冲区的原因，如果FileWriter不关闭输出流，无法写出字符到文件中。但是关闭的流对象，
    // 是无法继续写出数据的。如果我们既想写出数据，又想继续使用流，就需要flush() 方法了。

    // flush() ：刷新缓冲区，流对象可以继续使用。
    // close() ：先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。

    @Test
    public void test() throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("src/Files/ccc.txt");
        // 写出数据，通过flush
        fw.write('刷'); // 写出第1个字符
        fw.flush();
        fw.write('新'); // 继续写出第2个字符，写出成功
        fw.flush();
        // 写出数据，通过close
        fw.write('关'); // 写出第1个字符
        fw.close();
//        fw.write('闭'); // 继续写出第2个字符,【报错】java.io.IOException: Stream closed
//        fw.close();
    }
}
