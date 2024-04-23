package BasicUse.GetConstruction;

// 反射技术的基本应用2 --- 获取运行时类的完整结构

// 可以获取：包、修饰符、类型名、父类（包括泛型父类）、父接口（包括泛型父接口）、成员（属性、
// 构造器、方法）、注解（类上的、方法上的、属性上的）。

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;
import ClassObject.Person;

public class GetConstruction {
    @Test
    public void test1(){
        Class clazz = Person.class;
        //getFields():获取当前运行时类本身及其所有的父类中声明为public权限的属性
        System.out.println("当前运行时类本身及其所有的父类中声明为public权限的属性");
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }

        //getDeclaredFields():获取当前运行时类中声明的所有属性(包括private和protect)
        System.out.println("当前运行时类中声明的所有属性");
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        }
    }

    @Test
    //权限修饰符 变量类型 变量名
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //1.权限修饰符
            /*
            * 0x是十六进制
            * PUBLIC = 0x00000001; 1 1
            * PRIVATE = 0x00000002; 2 10
            * PROTECTED = 0x00000004; 4 100
            * STATIC = 0x00000008; 8 1000
            * FINAL = 0x00000010; 16 10000
            * ...
            *
            * 设计的理念，就是用二进制的某一位是1，来代表一种修饰符，整个二进制中只有一位是1，
            其余都是0
            *
            * mod = 17 0x00000011
            * if ((mod & PUBLIC) != 0) 说明修饰符中有public
            * if ((mod & FINAL) != 0) 说明修饰符中有final
            */
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.print(fName);
            System.out.println();
        }
    }
}
