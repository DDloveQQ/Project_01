package NewMethodInJdk5;

import java.util.concurrent.*;

public class NewThread {
}


// JDK 5.0新增的线程创建方式
//////////////////////////////////////////////////////////////////////////
// 新增方式一: 实现Callable接口

/*
 * 创建多线程的方式三：实现Callable （jdk5.0新增的）
 */
//1.创建一个实现Callable的实现类
class NumThread implements Callable {
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
class CallableTest {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();
        // 接收返回值
        try {
        //6.获取Callable中call方法的返回值
        //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//////////////////////////////////////////////////////////////////////////
// 新增方式二: 使用线程池
// 提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。可以避免频繁创建销毁、实现重复利用
class NumberThread implements Runnable{  // 线程1
    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){  // 输出偶数
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
class NumberThread1 implements Runnable{  // 线程2
    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 != 0){  // 输出奇数
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
class NumberThread2 implements Callable {  // 线程3(Callable创建的有返回值的线程)
    @Override
    public Object call() throws Exception {
        int evenSum = 0;//记录偶数的和
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                evenSum += i;
            }
        }
        return evenSum;
    }
}
class ThreadPoolTest {    // 线程池
    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
        // System.out.println(service.getClass());//ThreadPoolExecutor
        service1.setMaximumPoolSize(50); //设置线程池中线程数的上限
        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());//适合适用于Runnable
        try {
            Future future = service.submit(new NumberThread2());//适合使用于Callable
            System.out.println("总和为：" + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.关闭连接池
        service.shutdown();
    }
}
