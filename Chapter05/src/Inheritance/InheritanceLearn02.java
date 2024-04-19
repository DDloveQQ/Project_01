package Inheritance;

public class InheritanceLearn02 {
    // 子类方法重写
    // 原则:
    // 1. 子类重写的方法必须和父类被重写的方法具有相同的方法名称、参数列表。
    // 2. 子类重写的方法的返回值类型不能大于父类被重写的方法的返回值类型。(注意：如果返回值类型是基本数据类型和void，那么必须相同)
    // 3. 子类重写的方法使用的访问权限不能小于父类被重写的方法的访问权限(public > protected > 缺省 > private)
    // (注意: ① 父类私有方法不能重写 ② 跨包的父类缺省的方法也不能重写)
    // 4. 子类方法抛出的异常不能大于父类被重写方法的异常
    // 5. 子类与父类中同名同参数的方法必须同时声明为非static的(即为重写)，或者同时声明为static的（不是重写）。
}

class TestOverloadOverride {
    public static void main(String[] args) {
        Son s = new Son();
        s.method(1);//只有一个形式的method方法
        s.printMethod();
        Daughter d = new Daughter();
        d.method(1);
        d.method(1,2);//有两个形式的method方法
    }
}
class Father{
    public void method(int i){
        System.out.println("Inheritance.Father.method");
    }
}
class Son extends Father{
    public void method(int i){//重写
        System.out.println("Inheritance.Son.method");
    }
    public void printMethod() {
        method(1);
        super.method(1);  // 在父类方法被子类重写后,如果还想调用父类方法,则需要使用super(仅限类内使用,类似于this)
    }
}
class Daughter extends Father{
    public void method(int i,int j){//重载(因为输入参数数量不同)
        System.out.println("Inheritance.Daughter.method");
    }
}

/////////////////////////////////////////////////////////////////
// 子类构造器中调用父类构造器问题
class A{
    A(){
        System.out.println("A类无参构造器");
    }
}
class B extends A{
}
class Test {
    public static void main(String[] args) {
        B b = new B();
        //A类显示声明一个无参构造，
        //B类默认有一个无参构造，
        //B类的默认无参构造中会默认调用A类的无参构造
        //可以看到会输出“A类无参构造器"
    }
}

/////////////////////////////////////////////////////////////////
class A_2{
    A_2(){
        System.out.println("A_2类无参构造器");
    }
}
class B_2 extends A_2{
    B_2(){
        System.out.println("B_2类无参构造器");
    }
}
class Test_2{
    public static void main(String[] args){
        B_2 b_2 = new B_2();
        //A_2类显示声明一个无参构造，
        //B_2类显示声明一个无参构造，
        //B_2类的无参构造中虽然没有写super()，但是仍然会默认调用A类的无参构造
        //可以看到会输出“A类无参构造器"和"B类无参构造器")
    }
}

/////////////////////////////////////////////////////////////////
class A_3{
    A_3(){
        System.out.println("A_3类无参构造器");
    }
}
class B_3 extends A_3{
    B_3(){
        super();
        System.out.println("B_3类无参构造器");
    }
}
class Test_3{
    public static void main(String[] args){
        B_3 b_3 = new B_3();
        //A类显示声明一个无参构造，
        //B类显示声明一个无参构造，
        //B类的无参构造中明确写了super()，表示调用A类的无参构造
        //可以看到会输出“A类无参构造器"和"B类无参构造器")
    }
}

/////////////////////////////////////////////////////////////////
//class A_4{
//    A_4(int a){
//        System.out.println("A_4类有参构造器");
//    }
//}
//class B_4 extends A_4{
//    B_4(){
//        // 没说调用A_4构造,则默认调用A_4的无参构造器,但A_4没有无参构造器
//        System.out.println("B_4类无参构造器");
//    }
//}
//class Test05{
//    public static void main(String[] args){
//        B_4 b_4 = new B_4();
//        //A类显示声明一个有参构造，没有写无参构造，那么A类就没有无参构造了
//        //B类显示声明一个无参构造，
//        //B类的无参构造没有写super(...)，表示默认调用A类的无参构造
//        //编译报错，因为A类没有无参构造
//    }
//}

/////////////////////////////////////////////////////////////////
//class A_5{
//    A_5(int a){
//        System.out.println("A_5类有参构造器");
//    }
//}
//class B_5 extends A_5{
//    B_5(){
//        super();  // super()表示强制调用父类无参构造,但是父类没有,所以报错
//        System.out.println("B_5类无参构造器");
//    }
//}
//class Test06{
//    public static void main(String[] args){
//        B_5 b_5 = new B_5();
//        //A类显示声明一个有参构造，没有写无参构造，那么A类就没有无参构造了
//        //B类显示声明一个无参构造，
//        //B类的无参构造明确写super()，表示调用A类的无参构造
//        //编译报错，因为A类没有无参构造
//    }
//}

/////////////////////////////////////////////////////////////////
class A_6{
    A_6(int a){
        System.out.println("A_6类有参构造器");
    }
}
class B_6 extends A_6{
    B_6(int a){
        super(a);
        System.out.println("B_6类有参构造器");
    }
}
class Test07{
    public static void main(String[] args){
        B_6 b_6 = new B_6(10);
        //A类显示声明一个有参构造，没有写无参构造，那么A类就没有无参构造了
        //B类显示声明一个有参构造，
        //B类的有参构造明确写super(a)，表示调用A类的有参构造
        //会打印“A类有参构造器"和"B类有参构造器"
    }
}

/////////////////////////////////////////////////////////////////
class A_7{
    A_7(){
        System.out.println("A_7类无参构造器");
    }
    A_7(int a){
        System.out.println("A_7类有参构造器");
    }
}
class B_7 extends A_7{
    B_7(){
        super();//可以省略，调用父类的无参构造
        System.out.println("B_7类无参构造器");
    }
    B_7(int a){
        super(a);//调用父类有参构造
        System.out.println("B_7类有参构造器");
    }
}
class Test8{
    public static void main(String[] args){
        B_7 b1 = new B_7();
        B_7 b2 = new B_7(10);
    }
}