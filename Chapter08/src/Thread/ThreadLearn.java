package Thread;

public class ThreadLearn{

}

// 多线程
// 1. 线程的概念: 程序 -> 进程 -> 线程
// 线程是CPU调度和执行的最小单位,一个进程中的多个线程共享相同的内存单元

// 2. 线程调度:
//    (1) 分时调度: 所有线程轮流使用 CPU 的使用权，并且平均分配每个线程占用 CPU 的时间。
//    (2) 抢占式调度: 让优先级高的线程以较大的概率优先使用 CPU。如果线程的优先级相同，那么会随机选择一个(线程随机性)
//    Java使用的为抢占式调度。

// 3. 多线程程序的优点
//    (1) 提高应用程序的响应。对图形化界面更有意义，可增强用户体验。(一个线程控制一个GUI窗口)
//    (2) 提高计算机系统CPU的利用率
//    (3) 改善程序结构。将既长又复杂的进程分为多个线程，独立运行，利于理解和修改

// 4. Java多线程
//    (1) 使用java.lang.Thread 类代表线程，所有的线程对象都必须是Thread类或其子类的实例。
//    (2) 每个线程都是通过某个特定Thread对象的run()方法来完成操作的，因此把run()方法体称为线程执行体
//    (3) 通过该Thread对象的start()方法来启动这个线程，而非直接调用run()
//    (4) 要想实现多线程，必须在主线程中创建新的线程对象。


// 多线程方式1: 通过继承Thread类来创建并启动多线程
//  (1) 定义Thread类的子类，并重写该类的run()方法，该run()方法的方法体就代表了线程需要完成的任务
//  (2) 创建Thread子类的实例，即创建了线程对象
//  (3) 调用线程对象的start()方法来启动该线程(一个线程对象只能调用一次start()方法启动,否则抛出IllegalThreadStateException异常)

class MyThread extends Thread {
    //定义指定线程名称的构造方法
    public MyThread(String name) {
        //调用父类的String参数的构造方法，指定线程的名称
        super(name);
    }
    /**
     * 重写run方法，完成该线程执行的逻辑
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+"：正在执行！"+i);
        }
    }
}

class TestMyThread {
    public static void main(String[] args) {
        //创建自定义线程对象1
        MyThread mt1 = new MyThread("子线程1");
        //开启子线程1
        mt1.start();
        //创建自定义线程对象2
        MyThread mt2 = new MyThread("子线程2");
        //开启子线程2
        mt2.start();
        //在主方法中执行for循环
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程！"+i);
        }
    }
}

// 多线程方式2: 实现Runnable接口
//  (1) 定义Runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体
//  (2) 创建Runnable实现类的实例，并以此实例作为Thread的target参数来创建Thread对象，该Thread对象才是真正的线程对象。
//  (3) 调用线程对象的start()方法，启动线程。调用Runnable接口实现类的run方法。

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class TestMyRunnable {
    public static void main(String[] args) {
        //创建自定义类对象 线程任务对象
        MyRunnable mr = new MyRunnable();
        //创建线程对象(以接口实现类的实例作为thread对象的参数)
        Thread t = new Thread(mr, "长江");
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("黄河 " + i);
        }
    }
}

// 比较方法1和方法2: 实现Runnable接口比继承Thread类更有优势
// (1) 避免了单继承的局限性
// (2) 多个线程可以共享同一个接口实现类的对象，非常适合多个相同线程来处理同一份资源(继承Thread类的方法每进行一个线程都需要new一个新对象)
// (3) 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。


// 变形写法: 使用匿名内部类对象来实现线程的创建和启动(代码更加简洁)
class ThreadLearn_2 {
    public static void main(String[] args) {
        new Thread("新的线程！"){  // 调用Thread类的String参数的构造方法，指定线程的名称
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName()+"：正在执行！"+i);
                }
            }  // 重写run()方法
        }.start();  // 启动线程

        new Thread(new Runnable(){  // 定义匿名的Runnable接口实现类
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"：" + i);
                }
            }  // 重写run()方法
        }).start();  // 启动线程
    }
}



