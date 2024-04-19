package Generics.Wildcard;

// 有限制的通配符
// 通配符指定上限： <? extends 类/接口 >
//      使用时指定的类型必须是继承某个类，或者实现某个接口，即<=
// 通配符指定下限： <? super 类/接口 >
//      使用时指定的类型必须是操作的类或接口，或者是操作的类的父类或接口的父接口，即>=

import java.util.ArrayList;
import java.util.Collection;

public class WildcardLearn02 {
}
class Creature{}
class Person extends Creature{}
class Man extends Person{}
class PersonTest {
    // 限制T必须继承自Person, 或者就是Person本身
    public static <T extends Person> void test(T t){
        System.out.println(t);
    }
    public static void main(String[] args) {
        test(new Person());
        test(new Man());
        // Creature是Person的父类,所以会报错
        // test(new Creature());
    }
}

class Test02 {
    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();
        getElement1(list1);
//        getElement1(list2);//报错
        getElement1(list3);
//        getElement1(list4);//报错
//        getElement2(list1);//报错
//        getElement2(list2);//报错
        getElement2(list3);
        getElement2(list4);
    }
    // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement1(Collection<? extends Number> coll){}
    // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll){}
}