package MapInterface.Properties;

// Properties 类是 Hashtable 的子类，该对象用于处理属性文件
// 所以 Properties 中要求 key 和 value 都是字符串类型
// 存取数据时，建议使用setProperty(String key,String value)方法和getProperty(String key)方法


import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLearn {
    @Test
    public void test01() {
        Properties properties = System.getProperties();
        String fileEncoding = properties.getProperty("file.encoding");//当前源文件字符编码
        System.out.println("fileEncoding = " + fileEncoding);
    }
    @Test
    public void test02() {
        Properties properties = new Properties();
        properties.setProperty("user","songhk");
        properties.setProperty("password","123456");
        System.out.println(properties);
    }
    @Test
    public void test03() throws IOException {
        Properties pros = new Properties();
        pros.load(new FileInputStream("jdbc.properties"));
        String user = pros.getProperty("user");
        System.out.println(user);
    }
}
