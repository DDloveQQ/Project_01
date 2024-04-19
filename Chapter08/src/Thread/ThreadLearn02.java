package Thread;

public class ThreadLearn02 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                // 当前只有main线程被执行,所以输出的结果的属于main的
                System.out.println(getName() + "的优先级：" + getPriority());
            }
        };  // 创建一个匿名内部类继承Thread类

        t.setPriority(Thread.MAX_PRIORITY);  // 设置线程优先级至最高 -> MAX_PRIORITY
        t.start();  // 线程开始

        // public static Thread currentThread() :返回对当前正在执行的线程对象的引用(在Thread子类中就是this)
        // public String getName() :获取当前线程名称。
        // public final int getPriority() ：返回线程优先级

        System.out.println(Thread.currentThread().getName() +"的优先级：" +
                Thread.currentThread().getPriority());
    }
}


class TestThreadStateChange {
    public static void main(String[] args) {
        // 声明一个匿名内部类继承Thread类,并重写run方法, 实现打印[1,100]之间的偶数, 打印间隔1秒
        Thread te = new Thread() {
            @Override
            public void run() {
                for (int i = 2; i <= 100; i += 2) {
                    System.out.println("偶数线程：" + i);
                    try {
                        Thread.sleep(100);  // 使当前正在执行的线程以指定的毫秒数暂停
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        te.start();

        // 声明一个匿名内部类继承Thread类,并重写run方法, 实现打印[1,100]之间的奇数
        Thread to = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i += 2) {
                    System.out.println("奇数线程：" + i);
                    if (i == 5) {
                        // Thread.yield();  // 让当前线程暂停一下(一旦执行该方法,便主动释放CPU的执行权)
                        System.out.println("to线程等待te线程运行结束");
                        try {
                            te.join();  // 等待te线程终止后再继续程序(即te完成所有输出,线程结束以后), 此时的to被阻塞BLOCKED
                            System.out.println("te线程结束, to线程开始");
                            System.out.println(te.getState());  // 获取te当前状态
                            System.out.println(te.isAlive());  // 获取te存活与否
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        to.start();
    }
}