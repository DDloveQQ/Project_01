package BasicUse.GetConstruction;

import ClassObject.Person;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

// 获取其他结构(构造器、父类、接口、包、注解等)

public class GetConstruction3 {
    /*
    获取当前类中的所有的构造器
    */
    @Test
    public void test1(){
        Class clazz = Person.class;
        Constructor[] cons = clazz.getDeclaredConstructors();
        for(Constructor c :cons){
            System.out.println(c);
        }
    }
    /*
    获取运行时类的父类
    */
    @Test
    public void test2(){
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass); //class java.lang.Object
    }
    /*
    获取运行时类的所在的包
    */
    @Test
    public void test3(){
        Class clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack); //package ClassObject
    }
    /*
    获取运行时类的注解
    */
    @Test
    public void test4(){
        Class clazz = Person.class;
        Annotation[] annos = clazz.getAnnotations();
        for (Annotation anno : annos) {
            System.out.println(anno);
        }
    }
    /*
    获取运行时类所实现的接口
    */
    @Test
    public void test5(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }
    /*
    获取运行时类的带泛型的父类
    */
    @Test
    public void test6(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);  //class java.lang.Object
    }
}
