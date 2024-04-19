package Thread;

import java.util.concurrent.locks.ReentrantLock;

// 在JDK5.0以后新增的功能(Lock),与采用synchronized相比，Lock可提供多种锁方案，更灵活、更强大。
// Lock通过显式定义同步锁对象来实现同步。同步锁使用Lock对象充当。
// 在实现线程安全的控制中，比较常用的是ReentrantLock ，可以显式加锁、释放锁。

public class LockLearn {
}


class Window implements Runnable{
    int ticket = 100;
    //1. 创建Lock的实例，必须确保多个线程共享同一个Lock实例
    private final ReentrantLock lock = new ReentrantLock();
    public void run(){
        while(true){
            try{
                //2. 调动lock()，实现需共享的代码的锁定
                lock.lock();
                if(ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticket--);
                }else{
                    break;
                }
            }finally{
                //3. 调用unlock()，释放共享代码的锁定
                lock.unlock();
            }
        }
    }
}
class ThreadLock {
    public static void main(String[] args) {
        Window t = new Window();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }
}

// synchronized与Lock的对比
// 1. Lock是显式锁（手动开启和关闭锁，别忘记关闭锁），synchronized是隐式锁，出了作用域、遇到异常等自动解锁
// 2. Lock只有代码块锁，synchronized有代码块锁和方法锁
// 3. 使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类），更体现面向对象。
// 开发建议中处理线程安全问题优先使用顺序为：
// Lock ----> 同步代码块 ----> 同步方法