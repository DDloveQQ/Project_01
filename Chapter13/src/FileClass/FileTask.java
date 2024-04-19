package FileClass;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Field;

import org.junit.Test;

public class FileTask {
    public static void main(String[] args) {
        // 判断指定目录下是否有后缀名为.jpg的文件。如果有，就输出该文件名称
        String dir = "src\\Files";
        File file = new File(dir);
        String[] fileNames = file.list();
        for (String string : fileNames) {
            if (string.endsWith(".txt")) {  // 判断string是否以.txt作为结尾
                System.out.println(string);
            }
        }
    }

    @Test
    // 方法2 --- 重写File类提供的文件过滤方法
    public void test01() {
        File file = new File("src\\Files");

        File[] subFiles = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        for (File f : subFiles) {
            System.out.println(f.getName());
        }
    }
}

class ListFileTest {
    public static void printSubFile(File dir) {
        // 打印目录的子文件
        File[] subfiles = dir.listFiles();
        for (File f : subfiles) {
            if (f.isDirectory()) {  // 文件目录
                printSubFile(f);  // 递归调用,以此来实现对多层子目录的遍历
            } else {  // 文件
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    @Test
    public void testListAllFiles(){
        // 1.创建目录对象
        File dir = new File("E:\\JavaLearn\\Project_01\\Chapter13");
        // 2.打印目录的子文件
        printSubFile(dir);
    }

    // 拓展1：求指定目录所在空间的大小
    public long getDirectorySize(File file) {
        // file是文件，那么直接返回file.length()
        // file是目录，把它的下一级的所有file大小加起来就是它的总大小
        long size = 0;
        if (file.isFile()) {
            size = file.length();
        } else {
            File[] all = file.listFiles();// 获取file的下一级
            // 累加all[i]的大小
            for (File f : all) {
                size += getDirectorySize(f);// f的大小;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        ListFileTest listFileTest = new ListFileTest();
        listFileTest.testListAllFiles();

        File dir = new File("E:\\JavaLearn\\Project_01\\Chapter13");
        long size = listFileTest.getDirectorySize(dir);
        System.out.println(size);
    }


}