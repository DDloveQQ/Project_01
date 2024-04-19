package Thread;

// 线程间的相互通信---等待唤醒机制
// 1. wait: 线程不再活动，不再参与调度，进入wait set中，因此不会浪费CPU资源，也不会去竞争锁了，这时的线程状态是 WAITING 或 TIMED_WAITING
// 2. notify: 选取所通知对象的 wait set 中的一个线程释放(线程唤醒)
// 3. 则释放所通知对象的 wait set 上的全部线程。

// 注意: 被唤醒的线程如果能获得锁, 则状态变为RUNNABLE, 否则编程BLOCKED

// wait和notify使用细节: (同对象 + 同步)
// 1. wait方法与notify方法必须要由同一个锁对象调用
// 2. wait方法与notify方法都属于Object类方法
// 3. wait方法与notify方法必须要在同步代码块或者是同步函数中使用, 因为必须要通过锁对象调用这2个方法
public class ThreadCommunicate {
    public static void main(String[] args) {
        Communication communication = new Communication();
        Thread t1 = new Thread(communication, "线程1");
        Thread t2 = new Thread(communication, "线程2");
        t1.start();
        t2.start();
    }
}

// 示例: 两个线程交替打印 1 -> 100
class Communication implements Runnable {
    int i = 1;
    public void run() {
        while (true) {
            // 线程在此排队
            synchronized (this) {  // 代码块方式实现同步锁
                notify();  // 唤醒当前线程

                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                } else
                    break;

                try {
                    wait();  // 当前线程进入等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}