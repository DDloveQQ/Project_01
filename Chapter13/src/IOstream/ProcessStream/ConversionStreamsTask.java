package IOstream.ProcessStream;

import org.junit.Test;

import java.io.*;

public class ConversionStreamsTask {
    @Test
    public void test01() throws IOException {
        String fileName1 = "src/Files/康师傅的话.txt";
        String fileName2 = "src/Files/寄语.txt";

        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        try {
            // 读文件
            isr = new InputStreamReader(new FileInputStream(fileName1), "GBK");
            // 写文件
            osw = new OutputStreamWriter(new FileOutputStream(fileName2), "utf-8");

            char[] charBuff = new char[1024];  // 存储字符的数组
            int len;
            while ((len = isr.read(charBuff)) != -1) {
                osw.write(charBuff, 0, len);
                osw.flush();  // 刷新缓冲区,但流对象仍可继续使用
            }
            System.out.println("文件复制并转码完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osw != null) osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
