package Thread;

public class ThreadTask {
    public static void main(String[] args) {
        MyThread_Even even = new MyThread_Even();
        MyThread_Odd odd = new MyThread_Odd();

        Thread t1 = new Thread(even, "线程一");
        Thread t2 = new Thread(odd, "线程二");

        t1.start();
        t2.start();
    }
}

class MyThread_Even implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0) {
                System.out.println("线程一输出偶数: " + i);
            }
        }
    }
}

class MyThread_Odd implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 1) {
                System.out.println("线程二输出奇数: " + i);
            }
        }
    }
}