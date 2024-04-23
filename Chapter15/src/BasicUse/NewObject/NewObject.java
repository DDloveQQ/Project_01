package BasicUse.NewObject;

// 反射技术的基本应用1 --- 创建运行时类的对象

import org.junit.Test;
import java.lang.reflect.Constructor;

public class NewObject {
    @Test
    public void test1() throws Exception{
        // AtGuiguClass obj = new AtGuiguClass();//编译期间无法创建
        Class<?> clazz = Class.forName("ClassObject.Person");
        //clazz代表ClassObject.Person类型
        //clazz.newInstance()创建的就是Person的对象(但只能调用无参构造)
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
    @Test
    public void test3()throws Exception{
        //(1)获取Class对象
        Class<?> clazz = Class.forName("ClassObject.Person");
        /*
         * 获取ClassObject.Person类型中的有参构造
         * 如果构造器有多个，我们通常是根据形参【类型】列表来获取指定的一个构造器的
         * 例如：public Person(String title, int num)
         */
        //(2)获取有参构造器对象getDeclaredConstructor
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class,int.class);
        //(3)创建实例对象
        // T newInstance(Object... initargs) 这个Object...是在创建对象时，给有参构造的实参列表
        // 此时对constructor对象使用newInstance即可实现有参构造
        Object obj = constructor.newInstance("尚硅谷",2022);
        System.out.println(obj);
    }
}
