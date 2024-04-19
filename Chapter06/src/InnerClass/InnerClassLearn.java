package InnerClass;
public class InnerClassLearn {
}

// 内部类
// 定义: 将一个类A定义在另一个类B里面，里面的那个类A就称为内部类（InnerClass），类B则称为外部类（OuterClass）。
// 使用内部类的原因: 当一个事物A的内部，还有一个部分需要一个完整的结构B进行描述，
// 而这个内部的完整的结构B又只为外部事物A提供服务，不在其他地方单独使用，那么整个内部的完整结构B最好使用内部类
// 分类:
    //  成员内部类
        //  静态成员内部类
        //  非静态成员内部类
    //  局部内部类
        //  非匿名局部内部类
        //  匿名局部内部类

// 1. 成员内部类
// 定义: 如果成员内部类中不使用外部类的非静态成员，那么通常将内部类声明为静态内部类，否则声明为非静态内部类
// 特征:
    // 1. 当成员内部类作为类的成员角色时
        // 和外部类不同，Inner class还可以声明为private或protected；
        // 可以调用外部类的结构。
        // Inner class 可以声明为static的，但此时就不能再使用外层类的非static的成员变量；
    // 2. 当成员内部类作为类的角色时
        // 可以在内部定义属性、方法、构造器等结构
        // 可以继承自己的想要继承的父类，实现自己想要实现的父接口们，和外部类的父类和父接口无关
        // 可以声明为abstract类 ，因此可以被其它的内部类继承
        // 可以声明为final的，表示不能被继承
        // 编译以后生成OuterClass$InnerClass.class字节码文件（也适用于局部内部类）

class TestMemberInnerClass {
    public static void main(String[] args) {
        //创建静态内部类实例，并调用方法
        Outer.StaticInner inner = new Outer.StaticInner();
        inner.inFun();
        //调用静态内部类静态方法
        Outer.StaticInner.inMethod();
        System.out.println("*****************************");
        //创建非静态内部类实例（方式1），并调用方法
        Outer outer = new Outer();
        Outer.NoStaticInner inner1 = outer.new NoStaticInner();
        inner1.inFun();
        //创建非静态内部类实例（方式2）(使用函数返回一个新建立的对象)
        Outer.NoStaticInner inner2 = outer.getNoStaticInner();
        inner1.inFun();
    }
}
class Outer{
    private static String a = "外部类的静态a";
    private static String b = "外部类的静态b";
    private String c = "外部类对象的非静态c";
    private String d = "外部类对象的非静态d";
    static class StaticInner{  // 静态内部类声明
        private static String a = "静态内部类的静态a";
        private String c = "静态内部类对象的非静态c";
        public static void inMethod(){
            System.out.println("Inner.a = " + a);
            System.out.println("Outer.a = " + Outer.a);
            System.out.println("b = " + b);
        }
        public void inFun(){
            System.out.println("Inner.inFun");
            System.out.println("Outer.a = " + Outer.a);
            System.out.println("Inner.a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            // System.out.println("d = " + d);//不能访问外部类的非静态成员
        }
    }
    class NoStaticInner{
        private String a = "非静态内部类对象的非静态a";
        private String c = "非静态内部类对象的非静态c";
        public void inFun(){
            System.out.println("NoStaticInner.inFun");
            System.out.println("Outer.a = " + Outer.a);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("Outer.c = " + Outer.this.c);
            System.out.println("c = " + c);
            System.out.println("d = " + d);
        }
    }
    public NoStaticInner getNoStaticInner(){
        return new NoStaticInner();
    }
}

// 2. 局部内部类
    // 1. 非匿名局部内部类
        // 编译后有自己的独立的字节码文件，只不过在内部类名前面冠以外部类名、$符号、编号。
            // 这里有编号是因为同一个外部类中，不同的方法中存在相同名称的局部内部类
        // 和成员内部类不同的是，它前面不能有权限修饰符等
        // 局部内部类如同局部变量一样，有作用域
        // 局部内部类中是否能访问外部类的非静态的成员，取决于所在的方法
class TestLocalInner {
    public static void main(String[] args) {
        Outer_2.outMethod();
        System.out.println("-------------------");
        Outer_2 out = new Outer_2();
        out.outTest();
        System.out.println("-------------------");
        Runner runner = Outer_2.getRunner();  // = new LocalRunner()
        runner.run();
    }
}
class Outer_2{
    public static void outMethod(){
        System.out.println("Outer.outMethod");
        final String c = "局部变量c";
        class Inner{  // 创建非匿名局部内部类
            public void inMethod(){
                System.out.println("Inner.inMethod");
                System.out.println(c);  // 可以调用作用域内的局部变量
            }
        }
        Inner in = new Inner();
        in.inMethod();
    }
    public void outTest(){
        class Inner{  // 创建非匿名局部内部类
            public void inMethod1(){
                System.out.println("Inner.inMethod1");
            }
        }
        Inner in = new Inner();
        in.inMethod1();
    }
    public static Runner getRunner(){
        class LocalRunner implements Runner{  // 创建非匿名局部内部类并实现一个接口
            @Override
            public void run() {
                System.out.println("LocalRunner.run");
            }
        }
        return new LocalRunner();  // 直接返回一个类
    }
}
interface Runner{
    void run();
}

    // 2. 匿名内部类
    // 使用匿名内部类的方式来实现，避免给类命名的问题。
// 使用匿名内部类的对象直接调用方法：
interface A{
    void a();
}
class Test{
    public static void main(String[] args){
        new A(){  // 匿名new A()
            @Override
            public void a() {
                System.out.println("aaaa");
            }
        }.a();
    }
}

// 通过父类或父接口的变量多态引用匿名内部类的对象
class Test02{
    public static void main(String[] args){
        A obj = new A(){  // 匿名new A()
            @Override
            public void a() {
                System.out.println("aaaa");
            }
        };
        obj.a();  // 多态---编译使用接口中的方法a(), 运行使用匿名对象中重写的方法a()
    }
}

// 匿名内部类的对象作为实参
class Test03{
    public static void test(A a){
        a.a();
    }
    public static void main(String[] args){
        test(new A(){  // 调用上方test函数,但是传入实参用临时组件的匿名对象
            @Override
            public void a() {
                System.out.println("aaaa");
            }
        });
    }
}
