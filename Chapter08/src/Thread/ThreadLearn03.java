package Thread;

// 线程的生命周期有五种状态：
// 新建（New）、就绪（Runnable）、运行（Running）、阻塞（Blocked）、死亡（Dead）
public class ThreadLearn03 {
    public static void main(String[] args) throws InterruptedException {
        SubThread t = new SubThread();
        System.out.println(t.getName() + " 状态 " + t.getState());  // 状态为NEW
        t.start();
        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " 状态 " + t.getState());
            Thread.sleep(500);
            // 由于mainThread要先于SubThread运行,所以第一次状态输出时SubThread的状态为RUNABLE
            // 但当mainThread进入sleep(500)状态时,SubThread开始运行,打印设定信息
            // 由于SubThread的SLEEP时间为1000,因此一般会出现mainThread执行两次,SubThread执行一次的情况
            // 执行mainThread期间,SubThread状态为TIME_WAITING
        }
        System.out.println(t.getName() + " 状态 " + t.getState());  // 状态为TERMINATED
    }
}

class SubThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("打印：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
