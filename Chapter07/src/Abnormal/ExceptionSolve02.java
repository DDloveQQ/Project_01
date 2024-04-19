package Abnormal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
// 方式2: throws + 异常类型
    // 如果在编写方法体的代码时，某句代码可能发生某个编译时异常，不处理编译不通过，但是在当前
    // 方法体中可能不适合处理或无法给出合理的处理方式，则此方法应显示地声明抛出异常，表明该方
    // 法将不对这些异常进行处理，而由该方法的调用者负责处理。

// 针对编译时异常
public class ExceptionSolve02 {
    public static void main(String[] args) {
        System.out.println("上课倒计时开始.....");
        try {
            afterClass();  // 换到这里处理异常
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("准备提前上课");
        }
        System.out.println("上课.....");
    }
    public static void afterClass() throws InterruptedException {
        for(int i=10; i>=1; i--){
            // 因为 Thread.sleep() 方法会阻塞当前线程指定的时间，而其他线程可能会中断当前线程，
            // 从而导致 sleep()方法抛出 InterruptedException,属于编译时异常
            Thread.sleep(1000);
            //本来应该在这里处理异常,但是加入了throws InterruptedException后,异常被往上(函数外)抛出
            System.out.println("距离上课还有：" + i + "分钟");
        }
    }
}

// 针对运行时异常
class TestThrowsRuntimeException {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("请输入第一个整数：");
            int a = input.nextInt();
            System.out.print("请输入第二个整数：");
            int b = input.nextInt();
            int result = divide(a, b);
            System.out.println(a + "/" + b + "=" + result);
        } catch (InputMismatchException | ArithmeticException e) {
            e.printStackTrace();
            System.out.println("除0错误或输入数据类型不匹配");
        }
    }
    public static int divide(int a, int b)throws ArithmeticException{
        // 运行时异常类型，写或不写对于编译器和程序执行来说都没有任何区别。
        // 如果写了，唯一的区别就是调用者调用该方法后，使用try...catch结构时，IDEA可以获得更多的信息，需要添加哪种catch分支.
        return a/b;
    }
}

// 重写方法时对于throws异常列表要求:
// 1. 如果父类被重写方法的方法签名后面没有 “throws 编译时异常类型”，那么重写方法时，方法签名
//    后面也不能出现“throws 编译时异常类型”。
// 2. 如果父类被重写方法的方法签名后面有 “ throws 编译时异常类型”，那么重写方法时，throws的编
//    译时异常类型必须 <= 被重写方法throws的编译时异常类型，或者不throws编译时异常。
// 3. 方法重写，对于“ throws 运行时异常类型”没有要求。

class Father{
    public void method()throws Exception{
        System.out.println("Father.method");
    }
}
class Son extends Father{
    @Override
    public void method() throws IOException,ClassCastException {
        // IOException,ClassCastException <= Exception
        System.out.println("Son.method");
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////
//// try-catch 和 throws 两种异常处理方式的选择
//// 1. 涉及到资源的调用（流、数据库连接、网络连接等），则必须考虑使用try-catch-finally来处理，保证不出现内存泄漏。
//// 2. 如果父类被重写的方法没有throws异常类型，则子类重写的方法中如果出现异常，只能考虑使用try-catch-finally进行处理，不能throws。
//// 3. 方法a中依次调用了方法b,c,d等方法，方法b,c,d之间是递进关系。此时，如果方法b,c,d中有异常，我们通常选择使用throws，
////    而方法a中通常选择使用try-catch-finally。(逐级向上仍,末端用try-catch接住)
///////////////////////////////////////////////////////////////////////////////////////////////
