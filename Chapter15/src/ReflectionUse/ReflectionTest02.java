package ReflectionUse;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest02 {
    //体会反射的动态性：动态的创建指定字符串对应类的对象，并调用指定的方法
    public Object invoke(String className,String methodName) throws Exception {
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        //动态的创建指定字符串对应类的对象
        Object obj = constructor.newInstance();
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(obj);
    }
    @Test
    public void test2() throws Exception {
        String info = (String) invoke("BasicUse.User", "show");
        System.out.println("返回值为：" + info);
    }
}
