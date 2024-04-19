package IOstream.ProcessStream;

// 为了提高数据读写的速度，Java API提供了带缓冲功能的流类：缓冲流。
// 缓冲流要“套接”在相应的节点流之上，根据数据操作单位可以把缓冲流分为：
    //字节缓冲流： BufferedInputStream ， BufferedOutputStream
    //字符缓冲流： BufferedReader ， BufferedWriter
// 缓冲流的基本原理：在创建流对象时，内部会创建一个缓冲区数组（缺省使用8192个字节(8Kb) 的缓冲区），
// 通过缓冲区读写，减少系统IO次数，从而提高读写的效率。

import org.junit.Test;

import java.io.*;

// 字符缓冲流特有方法(读一行文字、写一行行分隔符)
public class BufferStream {
    @Test
    public void testReadLine()throws IOException {
        // 创建流对象
        BufferedReader br = new BufferedReader(new FileReader("src/Files/aaa.txt"));
        // 定义字符串,保存读取的一行文字
        String line;
        // 循环读取,读取到最后返回null
        while ((line = br.readLine())!=null) {
            System.out.println(line);
        }
        // 释放资源
        br.close();
    }
    @Test
    public void testNewLine()throws IOException{
        // 创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/Files/bbb.txt"));
        // 写出数据
        bw.write("尚");
        // 写出换行
        bw.newLine();
        bw.write("硅");
        bw.newLine();
        bw.write("谷");
        bw.newLine();
        // 释放资源
        bw.close();
    }
}
