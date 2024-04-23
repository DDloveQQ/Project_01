package ReflectionUse;

import ClassObject.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class ReflectionTest {
    //体会反射的动态性：动态的创建给定字符串对应的类的对象
    public <T> T getInstance(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return (T) constructor.newInstance();
    }
    @Test
    public void test1() throws Exception {
        String className = "ClassObject.Person";
        Person p1 = getInstance(className);
        System.out.println(p1);
    }
}
