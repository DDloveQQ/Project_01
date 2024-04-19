package IOstream.ProcessStream;

import org.junit.Test;

import java.io.*;

// 使用FileReader 读取项目中的文本文件。由于IDEA设置中针对项目设置了UTF-8编码，当读取
// Windows系统中创建的文本文件时，如果Windows系统默认的是GBK编码，则读入内存中会出现乱码。

// 此时可以使用转换流实现编码的转换


public class ConversionStreams {
    @Test
    // 转换流 java.io.InputStreamReader 是Reader的子类，是从字节流到字符流的桥梁。
    // 它读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集。
    public void test01() throws Exception {
        // 定义文件路径,文件为gbk编码
        String fileName = "src/Files/GBK_test.txt";

        //方式1：
        // 创建流对象,不指定编码形式(默认UTF8编码)
        InputStreamReader isr1 = new InputStreamReader(new FileInputStream(fileName));
        // 定义变量,保存字符
        int charData;
        // 使用默认编码字符流读取,乱码
        while ((charData = isr1.read()) != -1) {
            System.out.print((char)charData); //���,����
        }
        System.out.println();
        isr1.close();

        //方式2：
        // 创建流对象,指定GBK编码
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream(fileName) , "GBK");
        // 使用指定编码字符流读取,正常解析
        while ((charData = isr2.read()) != -1) {
            System.out.print((char)charData);  //你好,我是GBK
        }
        isr2.close();
    }

    @Test
    // 转换流java.io.OutputStreamWriter ，是Writer的子类，是从字符流到字节流的桥梁。使
    //用指定的字符集将字符编码为字节。它的字符集可以由名称指定，也可以接受平台的默认字符集。
    public void test02() throws Exception {
        // 定义文件路径
        String FileName = "src/Files/GBK_test.txt";
        // 创建流对象,默认UTF8编码
        OutputStreamWriter osw = new OutputStreamWriter(new
                FileOutputStream(FileName));
        // 写出数据
        osw.write("你好"); // 保存为6个字节
        osw.close();

        // 定义文件路径
        String FileName2 = "src/Files/GBK_test.txt";
        // 创建流对象,指定GBK编码
        OutputStreamWriter osw2 = new OutputStreamWriter(new
                FileOutputStream(FileName2),"GBK");
        // 写出数据
        osw2.write("你好");// 保存为4个字节
        osw2.close();
    }
}


