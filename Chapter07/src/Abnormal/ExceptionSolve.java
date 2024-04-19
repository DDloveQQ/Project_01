package Abnormal;

import org.junit.Test;

// Java的异常处理方式
// 方式1: try-catch-finally
    // 抓抛模型
    // 1. Java程序的执行过程中如出现异常，会生成一个异常类对象，该异常对象将被提交给Java运行时系统，这个过程称为抛出(throw)异常。
    // 2. 如果一个方法内抛出异常，该异常对象会被抛给调用者方法中处理。如果异常没有在调用者方法中处理，它继续被抛给这个调用方法的上层方法。
    //    这个过程将一直继续下去，直到异常被处理。这一过程称为捕获(catch)异常
    // 3. 如果一个异常回到main()方法，并且main()也不处理，则程序运行终止。

public class ExceptionSolve {
    @Test
    public void test1(){
        try{
            String str1 = "atguigu.com";
//            str1 = null;
            System.out.println(str1.charAt(0));
        }catch(NullPointerException e){
            //异常的处理方式1
            System.out.println("不好意思，亲~出现了小问题，正在加紧解决...");
        }catch(ClassCastException e){
            //异常的处理方式2
            System.out.println("出现了类型转换的异常");
        }catch(RuntimeException e){
            //异常的处理方式3
            System.out.println("出现了运行时异常");
        }finally {  // finally中的程序在try-catch结束的过程中无论如何都会执行(除非异常处理中使用System.exit(0)来强制退出虚拟机)
            System.out.println("程序暂时退出");
        }
            //此处的代码，在异常被处理了以后，是可以正常执行的
        System.out.println("抓抛测试结束");
    }
    public static void main(String[] args) {
        String[] friends = { "lisa", "bily", "kessy" };
        try {  // try中包含可能产生异常的代码
            for (int i = 0; i < 5; i++) {
                System.out.println(friends[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {  // 要捕获的异常类型
            System.out.println("index err");  // 当产生异常时的处理措施
        }
        // 当完成catch后,try中程序结束,执行try-catch后续程序
        System.out.println("\nthis is the end");
    }
}

