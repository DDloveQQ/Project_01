package FileClass;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.io.FileFilter;
import java.io.FilenameFilter;
import org.junit.Test;

// File类及本章下的各种流，都定义在java.io包下。
// 一个File对象代表硬盘或网络中可能存在的一个文件或者文件目录（俗称文件夹），与平台无关。（体会万事万物皆对象）
//File 能新建、删除、重命名文件和目录，但 File 不能访问文件内容本身。如果需要访问文件内容本身，则需要使用输入/输出流。
    //File对象可以作为参数传递给流的构造器。
//想要在Java程序中表示一个真实存在的文件或目录，那么必须有一个File对象，但是Java程序中的一个File对象，可能没有一个真实存在的文件或目录。

// 绝对路径：从盘符开始的路径，这是一个完整的路径。
// 相对路径：相对于项目目录的路径，这是一个便捷的路径，开发中经常使用。
    // IDEA中，main中的文件的相对路径，是相对于" 当前工程"
    // IDEA中，单元测试方法中的文件的相对路径，是相对于" 当前module "

public class FileLearn {

    public static void main(String[] args) {
        // 文件路径名
        String pathname = "E:\\JavaLearn\\Project_01\\Chapter13\\src\\Files\\aaa.txt";
        File file1 = new File(pathname);
        // 文件路径名
        String pathname2 = "E:\\JavaLearn\\Project_01\\Chapter13\\src\\Files\\bbb.txt";
        File file2 = new File(pathname2);
        // 通过父路径和子路径字符串
        String parent = "E:\\JavaLearn\\Project_01\\Chapter13\\src\\Files";
        String child = "aaa.txt";
        File file3 = new File(parent, child);
        // 通过父级File对象和子路径字符串
        File parentDir = new File("E:\\JavaLearn\\Project_01\\Chapter13\\src\\Files");
        String childFile = "bbb.txt";
        File file4 = new File(parentDir, childFile);

        // File类常用的方法1 --- 获取文件基本信息
        File f = new File("src\\Files\\aaa.txt");
        System.out.println("文件构造路径:"+f.getPath());
        System.out.println("文件名称:"+f.getName());
        System.out.println("文件长度:"+f.length()+"字节");
        System.out.println("文件最后修改时间：" +
        LocalDateTime.ofInstant(Instant.ofEpochMilli(f.lastModified()),ZoneId.of("Asia/Shanghai")));
        System.out.println("--------------------------------");
        File f2 = new File("src/Files/bbb.txt");
        System.out.println("目录构造路径:"+f2.getPath());
        System.out.println("目录名称:"+f2.getName());
        System.out.println("目录长度:"+f2.length()+"字节");
        System.out.println("文件最后修改时间：" +
        LocalDateTime.ofInstant(Instant.ofEpochMilli(f.lastModified()),ZoneId.of("Asia/Shanghai")));
    }
    @Test
    public void test01() throws IOException {
        File f1 = new File("E:\\JavaLearn\\Project_01\\Chapter13\\src\\HelloWorld.java"); //绝对路径
        System.out.println("文件/目录的名称：" + f1.getName());
        System.out.println("文件/目录的构造路径名：" + f1.getPath());
        System.out.println("文件/目录的绝对路径名：" + f1.getAbsolutePath());
        System.out.println("文件/目录的父目录名：" + f1.getParent());
    }
    @Test
    public void test02()throws IOException{
        // 注意: 无论该路径下是否存在文件或者目录，都不影响File对象的创建
        File f2 = new File("/Test.java");  //绝对路径，从根路径开始(用于Linux)
        System.out.println("文件/目录的名称：" + f2.getName());
        System.out.println("文件/目录的构造路径名：" + f2.getPath());
        System.out.println("文件/目录的绝对路径名：" + f2.getAbsolutePath());
        System.out.println("文件/目录的父目录名：" + f2.getParent());
    }
    @Test
    public void test03() throws IOException {
        File f3 = new File("src\\HelloWorld.java");  //相对路径(从Chapter13开始算起)
        System.out.println("user.dir =" + System.getProperty("user.dir"));  //相对路径的起点
        System.out.println("文件/目录的名称：" + f3.getName());
        System.out.println("文件/目录的构造路径名：" + f3.getPath());
        System.out.println("文件/目录的绝对路径名：" + f3.getAbsolutePath());
        System.out.println("文件/目录的父目录名：" + f3.getParent());
    }

    @Test
    // File类常用的方法2 --- 列出目录的下一级
    public void test04() {
        File dir = new File("E:\\JavaLearn\\Project_01\\Chapter13");
        String[] subs = dir.list();  // 使用String数组存储此目录下的所有文件
        for (String sub : subs) {
            System.out.println(sub);
        }
    }

    @Test
    // File类常用的方法3 --- 重命名功能
    public void test05() {
        File dir = new File("src/Files/ccc.txt");
        if (dir.renameTo(new File("src/Files/aaa.txt"))) {
            System.out.println("文件改名成功");
        }
    }

    @Test
    // File类常用的方法4 --- 判断功能的方法
    public void test06() {
        File f = new File("d:\\aaa\\bbb.java");
        File f2 = new File("src/Files/aaa.txt");
        // 判断是否存在
        System.out.println("d:\\aaa\\bbb.java 是否存在:"+f.exists());
        System.out.println("src/Files/aaa.txt 是否存在:"+f2.exists());
        // 判断是文件还是目录
        System.out.println("src/Files/aaa.txt 是文件吗?:"+f2.isFile());
        System.out.println("src/Files/aaa.txt 是目录吗?:"+f2.isDirectory());
        // 判断是否可读/可写/隐藏
        System.out.println("src/Files/aaa.txt 是否可读?:"+f2.canRead());
        System.out.println("src/Files/aaa.txt 是否可写?:"+f2.canWrite());
        System.out.println("src/Files/aaa.txt 是否隐藏?:"+f2.isHidden());
    }

    @Test
    // File类常用的方法5 --- 创建, 删除功能
    public void test07() throws IOException {
        // 文件的创建
        File f = new File("aaa.txt");
        System.out.println("aaa.txt是否存在:"+f.exists());
        System.out.println("aaa.txt是否创建:"+f.createNewFile());
        System.out.println("aaa.txt是否存在:"+f.exists());
        // 目录的创建
        File f2= new File("newDir");
        System.out.println("newDir是否存在:"+f2.exists());
        System.out.println("newDir是否创建:"+f2.mkdir());
        System.out.println("newDir是否存在:"+f2.exists());
        // 创建一级目录
        File f3= new File("newDira\\newDirb");
        System.out.println("newDira\\newDirb创建：" + f3.mkdir());
        File f4= new File("newDir\\newDirb");
        System.out.println("newDir\\newDirb创建：" + f4.mkdir());
        // 创建多级目录
        File f5= new File("newDira\\newDirb");
        System.out.println("newDira\\newDirb创建：" + f5.mkdirs());
        // 文件的删除
        System.out.println("aaa.txt删除：" + f.delete());
        // 目录的删除
        System.out.println("newDir删除：" + f2.delete());
        System.out.println("newDir\\newDirb删除：" + f4.delete());
    }

}
