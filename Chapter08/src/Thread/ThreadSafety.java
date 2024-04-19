package Thread;


public class ThreadSafety {

}

// 当多个线程同时读写同一资源时,会出现线程安全问题
//多个Thread线程使用同一个Runnable对象,虽然实例变量是共享的,但线程不安全,会出现重复票或负数票
class TicketSaleRunnable implements Runnable {
    private int ticket = 100;
    public void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(10);//加入这个，使得问题暴露的更明显
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出一张票，票号:" + ticket);
            ticket--;
        }
    }
}
class SaleTicketDemo {
    public static void main(String[] args) {
        TicketSaleRunnable tr = new TicketSaleRunnable();
        Thread t1 = new Thread(tr, "窗口一");
        Thread t2 = new Thread(tr, "窗口二");
        Thread t3 = new Thread(tr, "窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

// 解决方法: 采用同步机制解决线程安全问题
// 如何实现: 同步代码块 -> ：synchronized 关键字可以用于某个区块前面，表示只对这个区块的资源实行互斥访问
//          同步方法 -> synchronized 关键字直接修饰方法，表示同一时刻只有一个线程能进入这个方法，其他线程在外面等着。

//////////////////////////////////////////////////////////////////////////////////////////////////////////
// 解决方案1: 静态方法加锁(类级别的锁) + 继承Thread类的多线程方法
class TicketSaleThread extends Thread{
    private static int ticket = 500;  // 类(静态)变量
    public void run(){  //直接锁这里肯定不行，会导致只有一个窗口卖票
        while (ticket > 0) {
            saleOneTicket();  // 线程在这里排队
        }
    }
    //锁对象是TicketSaleThread类的Class对象，而一个类的Class对象在内存中肯定只有一个
    public synchronized static void saleOneTicket(){  // 类(静态)方法
        if(ticket > 0) {
            // 不加条件，相当于条件判断没有进入锁管控，线程安全问题就没有解决
            // 假设线程A和B都过了run()方法下的ticket > 0判断, 在saleOneTicket()方法前排队, 当A执行完后票数变为0
            // 此时如果不加这一层ticket > 0判断,则B还会再执行一次,此时票数变为-1,与实际需求不符
            System.out.println(Thread.currentThread().getName() + "卖出一张票，票号:" + ticket);
            ticket--;
        }
    }
}
class SaleTicketDemo3 {
    public static void main(String[] args) {
        TicketSaleThread t1 = new TicketSaleThread();
        TicketSaleThread t2 = new TicketSaleThread();
        TicketSaleThread t3 = new TicketSaleThread();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
// 解决方法2: 非静态方法加锁(对象级别的锁) + 实现Runnable接口的多线程方法
class TicketSaleRunnable02 implements Runnable {
    private int ticket = 1000;
    public void run() {  //直接锁这里，肯定不行，会导致，只有一个窗口卖票
        while (ticket > 0) {
            saleOneTicket();
        }

    }
    // 锁对象是this，这里就是TicketSaleRunnable对象，因为上面3个线程使用同一个TicketSaleRunnable02对象，所以可以
    // 在实际开发时, 可以通过判断this是不是唯一的来判断该方法是否可锁, 如果类只实例化了一个对象, 且所有线程公用该对象,
    // 那么当前的this是唯一的, 锁以后可以解决线程安全问题; 否则可能无法解决线程安全问题
    public synchronized void saleOneTicket() {
        if (ticket > 0) {  //不加条件，相当于条件判断没有进入锁管控，线程安全问题就没有解决
            System.out.println(Thread.currentThread().getName() + "卖出一张票，票 号:" + ticket);
            ticket--;
        }
    }
}
class SaleTicketDemo4 {
    public static void main(String[] args) {

        TicketSaleRunnable02 tr = new TicketSaleRunnable02();
        Thread t1 = new Thread(tr, "窗口1");
        Thread t2 = new Thread(tr, "窗口2");
        Thread t3 = new Thread(tr, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
// 解决方法3: 同步代码块 + 资源类管理参数 + 匿名内部类对象来实现多线程
//1、编写资源类
class Ticket {
    private int ticket = 500;
    public void sale() {  //也可以直接给这个方法加锁(对象级锁)，锁对象是this，这里就是Ticket对象
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出一张票，票 号:" + ticket);
            ticket--;
        }
    }
}

class SaleTicketDemo5 {
    public static void main(String[] args) {
        //2、创建资源对象
        Ticket ticket = new Ticket();
        //3、启动多个线程操作资源类的对象
        Thread t1 = new Thread("窗口1") {
            //不能给run()直接加锁，因为t1,t2,t3的三个run方法分别属于三个Thread类对象
            @Override
            public void run() {
                while (true) {
                //////////// 同步代码块 /////////////
                    synchronized (ticket) {
                        ticket.sale();  // 给ticket资源对象下的sale()方法上锁
                    }
                //////////////////////////////////
                }
            }
        };
        Thread t2 = new Thread("窗口2") {
            @Override
            public void run() {
                while (true) {
                //////////// 同步代码块 /////////////
                    synchronized (ticket) {
                        ticket.sale();
                    }
                //////////////////////////////////
                }
            }
        };
        // 匿名内部类对象来实现线程的创建和启动
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                //////////// 同步代码块 /////////////
                    synchronized (ticket) {
                        ticket.sale();
                    }
                //////////////////////////////////
                }
            }
        }, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
