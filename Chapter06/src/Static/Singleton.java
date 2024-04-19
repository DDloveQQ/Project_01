package Static;
// 单例模式: 采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例,
//          并且该类只提供一个取得其对象实例的方法。
// 优点: 只生成一个实例,减少了系统性能开销
public class Singleton {
}

// 单例模式---饿汉式(饿的不行,必须在软件运行开始的时候就建立好对象)
// 特点: 立即加载 (使用类时对象已经创建完毕)
// 优点: 实现简单,没有多线程安全问题
// 缺点: 当类被加载的时候，会初始化static的实例，静态变量被创建并分配内存空间，从这以后，
//      这个static的实例便一直占着这块内存，直到类被回收时，静态变量被摧毁，并释放所占有的内
//      存。因此在某些特定条件下会耗费内存。
class Singleton01 {
    // 1.私有化构造器
    private Singleton01() {
    }
    // 2.内部提供一个当前类的实例
    // 4.此实例也必须静态化
    private static Singleton01 single = new Singleton01();
    // 3.提供公共的静态的方法，返回当前类的对象
    public static Singleton01 getInstance() {
        return single;
    }
}

// 单例模式--懒汉式(懒得不行,只有在需要对象的时候才会建立对象)
// 特点: 延迟加载 (使用类时才会创建对象)
// 优点: 当静态方法第一次被调用时才会初始化实例变量,并分配内存,因此在某些特定条件下会节约内存
// 缺点: 在多线程环境中线程不安全,无法保证单例的唯一性
class Singleton02 {
    // 1.私有化构造器
    private Singleton02() {
    }
    // 2.内部提供一个当前类的实例
    // 4.此实例也必须静态化
    private static Singleton02 single;
    // 3.提供公共的静态的方法，返回当前类的对象
    public static Singleton02 getInstance() {
        if(single == null) {
            single = new Singleton02();
        }
        return single;
    }
}

// main()函数的理解
class Something {
    public static void main(String[] something_to_do) {
        System.out.println("Do something ...");
    }
}