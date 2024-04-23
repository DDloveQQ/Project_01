package ClassLoader;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderLearn {
    @Test
    public void test01(){
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();  // 获取默认的系统类加载器
        System.out.println("systemClassLoader = " + systemClassLoader);
    }
    @Test
    public void test02()throws Exception{
        ClassLoader c1 = String.class.getClassLoader();
        System.out.println("加载String类的类加载器：" + c1);
        ClassLoader c2 =
                Class.forName("ClassObject.Person").getClassLoader();
        System.out.println("加载ClassObject.Person类的类加载器：" + c2);
                ClassLoader c3 = ClassLoaderLearn.class.getClassLoader();
        System.out.println("加载当前类的类加载器：" + c3);
    }
    @Test
    public void test03(){
        ClassLoader c1 = ClassLoaderLearn.class.getClassLoader();
        System.out.println("加载当前类的类加载器c1=" + c1);
        ClassLoader c2 = c1.getParent();
        System.out.println("c1.parent = " + c2);
        ClassLoader c3 = c2.getParent();
        System.out.println("c2.parent = " + c3);
    }
    @Test
    public void test5() throws IOException {
        Properties pros = new Properties();
        //方式1：使用FileInputStream获取流,此时默认的相对路径是当前的module
        // FileInputStream is = new FileInputStream("info.properties");
        // FileInputStream is = new FileInputStream("src//info1.properties");

        //方式2：使用类的加载器获取类路径下的指定文件的输入流
        //此时默认的相对路径是当前module的src目录
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("config/info.properties");
        pros.load(is);
        //获取配置文件中的信息
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = " + name + "\npassword = " + password);
    }
}
