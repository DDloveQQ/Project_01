package BasicUse.InvokeStructure;

import org.junit.Test;
import java.lang.reflect.Method;

// 调用指定的方法
public class InvokeStructure2 {
    @Test
    public void test()throws Exception {
        // 1、获取Person的Class对象
        Class<?> clazz = Class.forName("ClassObject.Person");
        //2、获取方法对象
        /*
         * 在一个类中，唯一定位到一个方法，需要：（1）方法名（2）形参列表，因为方法可能重载
         *
         * 例如：void setName(String name)
         */
        Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
        //3、创建实例对象
        Object stu = clazz.newInstance();
        //4、调用方法
        /*
         * 以前：学生对象.setName(值)
         * 现在：方法对象.invoke(学生对象，值)
         */
        Object setNameMethodReturnValue = setNameMethod.invoke(stu, "张三");
        System.out.println("stu = " + stu);

        //setName方法返回值类型void，没有返回值，所以setNameMethodReturnValue为null
        System.out.println("setNameMethodReturnValue = " + setNameMethodReturnValue);
        Method getNameMethod = clazz.getDeclaredMethod("getName");

        Object getNameMethodReturnValue = getNameMethod.invoke(stu);
        //getName方法返回值类型String，有返回值，getNameMethod.invoke的返回值就是getName方法的返回值
        System.out.println("getNameMethodReturnValue = " + getNameMethodReturnValue);//张三
    }
    @Test
    public void test02()throws Exception{
        Class<?> clazz = Class.forName("ClassObject.Person");
        Method printInfoMethod = clazz.getMethod("printInfo", String.class);
        //printInfo方法是静态方法
        printInfoMethod.invoke(null,"尚硅谷");
    }
}
