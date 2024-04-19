package Thread;

public class ThreadSafetyTask {

}

class Account extends Thread {
    private static int money = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            ///////////////////////////
            deposit();  // 线程在此排队
            ///////////////////////////
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 可以锁, 因为方法是静态的, 所有对象共享同一个
    public synchronized static void deposit() {
            money += 1000;
            System.out.println(Thread.currentThread().getName() + "存入1000元" + "当前余额: " + money);
    }
}

class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account();
        Account a2 = new Account();

        a1.start();
        a2.start();
    }
}