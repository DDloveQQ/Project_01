package Thread;

import org.junit.Test;

// 懒汉式：延迟创建对象，第一次调用getInstance方法再创建对象, 在不加改进的情况下线程不安全

// 内部类只有在外部类被调用才加载，产生INSTANCE实例；又不用加锁。
// 此模式具有之前两个模式的优点，同时屏蔽了它们的缺点，是最好的单例模式。
// 此时的内部类，使用enum进行定义，也是可以的。
class LazySingle {
    private LazySingle(){}
    public static LazySingle getInstance(){
        return Inner.INSTANCE;
    }
    private static class Inner{
        static final LazySingle INSTANCE = new LazySingle();
    }
}

public class ThreadSafety02 {

    @Test
    public void test01(){
        LazySingle s1 = LazySingle.getInstance();
        LazySingle s2 = LazySingle.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }

    //把s1和s2声明在外面，是想要在线程的匿名内部类中为s1和s2赋值
    LazySingle s1;
    LazySingle s2;
    @Test
    public void test02(){
        Thread t1 = new Thread(() -> s1 = LazySingle.getInstance());
        Thread t2 = new Thread(() -> s2 = LazySingle.getInstance());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
    LazySingle obj1;
    LazySingle obj2;
    @Test
    public void test03(){
        Thread t1 = new Thread(){
            public void run(){
                obj1 = LazySingle.getInstance();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                obj2 = LazySingle.getInstance();
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj1 == obj2);
    }
}