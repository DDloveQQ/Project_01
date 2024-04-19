package Generics.CustomGenerics;

// 声明类或接口时，在类名或接口名后面声明泛型类型，我们把这样的类或接口称为泛型类或泛型接口。

// 声明方法时，在【修饰符】与返回值类型之间声明类型变量，我们把声明了类型变量的方法，称为泛型方法。

// 当我们在类或接口中定义某个成员时，该成员的相关类型是不确定的，而这个类型需要在使用这个类或接口时才可以确定，那么我们可以使用泛型类、泛型接口。
public class CustomGenericsLearn {
}
class Person<T> {
    // 使用T类型定义变量
    private T info;
    // 使用T类型定义一般方法
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    // 使用T类型定义构造器
    public Person() {
    }
    public Person(T info) {
        this.info = info;
    }
    // static的方法中不能声明泛型
    //public static void show(T t) {
    //
    //}
    // 不能在try-catch中使用泛型定义
    //public void test() {
    //try {
    //
    //} catch (MyException<T> ex) {
    //
    //}
    //}
}

class Father<T1, T2> {
}
// 子类不保留父类的泛型
// 1)没有类型 擦除
class Son1 extends Father {  // 等价于class Son extends Father<Object,Object>{
}
// 2)具体类型
class Son2 extends Father<Integer, String> {
}
// 子类保留父类的泛型
// 1)全部保留
class Son3<T1, T2> extends Father<T1, T2> {
}
// 2)部分保留
class Son4<T2> extends Father<Integer, T2> {
}


// 子类不保留父类的泛型
// 1)没有类型 擦除
class Son5<A, B> extends Father{//等价于class Son extends Father<Object,Object>{
}
// 2)具体类型，夹带私货失去意义
class Son6<A, B> extends Father<Integer, String> {
}
// 子类保留父类的泛型
// 1)全部保留,并夹带私货
class Son7<T1, T2, A, B> extends Father<T1, T2> {
}
// 2)部分保留，并夹带私货
class Son8<T2, A, B> extends Father<Integer, T2> {
}