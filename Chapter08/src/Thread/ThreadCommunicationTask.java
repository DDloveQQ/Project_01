package Thread;

// 生产者消费者问题
// 注意: 该问题也同样有线程安全问题, 即生产或消费一时间只能进行一个,所以需要用到同步锁

public class ThreadCommunicationTask {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();  // Clerk作为资源类控制生产消费过程与产品
        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);
        Consumer c2 = new Consumer(clerk);
        p1.setName("生产者1");
        c1.setName("消费者1");
        c2.setName("消费者2");
        p1.start();
        c1.start();
        c2.start();
    }
}
//生产者
class Producer extends Thread{
    private Clerk clerk;
    // 构造函数
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    // 多线程run函数
    @Override
    public void run() {
        System.out.println("=========生产者开始生产产品========");
        while(true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //要求clerk去增加产品(线程在此排队)
            clerk.addProduct();
        }
    }
}
//消费者
class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println("=========消费者开始消费产品========");
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //要求clerk去减少产品(线程在此排队)
            clerk.minusProduct();
        }
    }
}
//资源类
class Clerk {
    private int productNum = 0;//产品数量
    private static final int MAX_PRODUCT = 20;
    private static final int MIN_PRODUCT = 1;
    //增加产品(只有生产者能调用)
    public synchronized void addProduct() {
        if(productNum < MAX_PRODUCT){
            productNum++;
            System.out.println(Thread.currentThread().getName() +
                    "生产了第" + productNum + "个产品");
            //生产了产品后立即唤醒消费者
            this.notifyAll();
        }else{
            try {
                this.wait();  // 如果当前产品数量大于最大数量, 则阻塞调用addProduct的生产者(释放同步监视器)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //减少产品(只有消费者能调用)
    public synchronized void minusProduct() {
        if(productNum >= MIN_PRODUCT){
            System.out.println(Thread.currentThread().getName() +
                    "消费了第" + productNum + "个产品");
            productNum--;
            //消费了产品后立即唤醒生产者
            this.notifyAll();
        }else{
            try {
                this.wait();  // 如果当前产品数量小于最小数量, 则阻塞调用minusProduct的消费者(释放同步监视器)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}