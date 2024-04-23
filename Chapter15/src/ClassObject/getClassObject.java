package ClassObject;

import org.junit.Test;

import java.lang.reflect.Field;

public class getClassObject {
    @Test
    public void test01() throws ClassNotFoundException{
        Class c1 = getClassObject.class;
        getClassObject obj = new getClassObject();
        Class c2 = obj.getClass();
        Class c3 = Class.forName("ClassObject.getClassObject");  // 不是路径，而是一种类似于import的方法
        Class c4 = ClassLoader.getSystemClassLoader().loadClass("ClassObject.getClassObject");
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c1 == c4);
    }
    @Test
    public void test02() throws Exception {
        Class clazz = Class.forName("ClassObject.Person");

        Object obj = clazz.newInstance();  // 调用的是默认构造函数

        Field field = clazz.getField("name");  // name必须要是public
        field.set(obj, "Peter");
        Object name = field.get(obj);
        System.out.println(name);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String str = "123";

        Class clazz = String.class;

        Class clazz2 = "123".getClass();

        Class clazz3 = Class.forName("java.lang.String");
    }
}
