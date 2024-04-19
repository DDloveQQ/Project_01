package Interface;
// 接口
// 接口的定义，它与定义类方式相似，但是使用 interface 关键字。它也会被编译成.class文件，但一定
// 要明确接口并不是类，而是另外一种引用数据类型。
// 引用数据类型(数组, 类, 枚举, 接口, 注解)
public class InterfaceLearn {

}

// 接口定义实例代码
interface USB3{
    // JDK<8.0  静态常量(public static final 可以省略)
    long MAX_SPEED = 500*1024*1024;//500MB/s

    // JDK<8.0  抽象方法(public abstract 可以省略)
    void in();
    void out();

    // JDK<=8.0  默认方法(public可以省略，建议保留，但是default不能省略)
    default void start(){
        System.out.println("开始");
    }
    default void stop(){
        System.out.println("结束");
    }

    // JDK<=8.0  静态方法(public 可以省略，建议保留，但是static不能省略)
    static void show(){
        System.out.println("USB 3.0可以同步全速地进行读写操作");
    }

    // JDK=9.0  私有方法
    private void test(){
        System.out.println("内测");
    }
}
