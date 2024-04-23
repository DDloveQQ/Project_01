package ReflectionUse;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

// 反射技术的体会: 实现了代码和数据的分离
// 原先想要榨什么水果汁,要在编写代码时提前创建好对象,再运行相应的办法
// 即使使用了多态技术,也依然需要再编写代码时指明对象
// 而使用了反射技术后,只需将想榨的果汁类名放在properties文件中,在程序运行时就会自动运行相应的办法
// 想改变所榨果汁的类型,也只需变更配置文件即可

public class ReflectionTest03 {
    @Test
    public void test1() throws Exception {
        //1.加载配置文件，并获取指定的fruitName值
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("config/info3.properties");
        pros.load(is);
        String fruitStr = pros.getProperty("fruitName");
        //2.创建指定全类名对应类的实例
        Class clazz = Class.forName(fruitStr);
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Fruit fruit = (Fruit) constructor.newInstance();
        //3. 调用相关方法，进行测试
        Juicer juicer = new Juicer();
        juicer.run(fruit);
    }
}

interface Fruit {
    public void squeeze();
}

class Apple implements Fruit {
    public void squeeze() {
        System.out.println("榨出一杯苹果汁儿");
    }
}

class Orange implements Fruit {
    public void squeeze() {
        System.out.println("榨出一杯桔子汁儿");
    }
}

class Juicer {
    public void run(Fruit f) {
        f.squeeze();
    }
}
