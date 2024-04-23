package BasicUse;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class BasicUseTask {
    @Test
    public void test01() throws Exception {
        // 获取Person类对象
        Class<?> clazz = Class.forName("BasicUse.User");

        // 创建Properties对象
        Properties pros = new Properties();

        // 通过classloader获取info.properties的输入流
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("config/info2.properties");

        // pros装在properties文件中的信息
        pros.load(is);

        // 找到指定key的信息
        String name = pros.getProperty("name");

        // 因为User类的构造器是有参构造,所以要建立Constructor对象来获取有参构造器对象
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        Object user = constructor.newInstance(name);

        // 获取User类中的方法时,要先针对要调用的方法建立Method对象
        Method userPrintMethod = clazz.getDeclaredMethod("show");

        // 然后使用Method对象中的invoke方法来指定执行这一方法的类(user),此时方法才可被执行
        userPrintMethod.invoke(user);

        // 对以上过程的理解:
        // 在不使用反射技术时,调用类中的方法要先通过new实例化,并实例化对象,再寻找对象下要执行的方法
        // 而使用反射技术后,则是先实例化类对象,然后选择要执行的方法,最后选择执行该方法的对象
    }
}
