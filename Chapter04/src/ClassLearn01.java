public class ClassLearn01 {
    public static void main(String[] args) {
        // 实例化对象的两个方法：
        // 方法1: 一般方式
        Person ps1 = new Person();
        // 方法2: 匿名对象
        // 如果一个对象只需要进行一次方法调用，那么就可以使用匿名对象。
        // 我们经常将匿名对象作为实参传递给一个方法调用。
        new Person();

        // 对象属性或方法的调用
        ps1.age = 20;
        ps1.eat();
    }
}

class Person{
    //声明属性age
    int age ;
    //声明方法showAge()
    public void eat() {
        System.out.println("人吃饭");
    }
}

class StudentTest{
    public static void main(String[] args){
        System.out.println(new Person());  // Person@3b07d329
        Person stu = new Person();
        System.out.println(stu);  // Person@41629346
        int[] arr = new int[5];
        System.out.println(arr);  // [I@404b9385

        // 类、数组都是引用数据类型，引用数据类型的变量中存储的是对象的地址，或者说指向堆中对象的首地址。
    }
}



