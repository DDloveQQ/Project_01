package Abnormal;

import org.junit.Test;
import java.util.Scanner;

// 异常的定义: 程序在执行过程中，出现的非正常情况，如果不处理最终会导致JVM的非正常停止。(异常指的并不是语法错误和逻辑错误)

class ArrayTools {
    // 对给定的数组通过给定的角标获取元素。
    public static int getElement(int[] arr, int index) {
        int element = arr[index];
        return element;
    }

}
class ExceptionDemo {
    public static void main(String[] args) {
        int[] arr = { 34, 12, 67 };
        int num = ArrayTools.getElement(arr, 4);  // 异常类型: ArrayIndexOutOfBoundsException
        System.out.println("num=" + num);
        System.out.println("over");
    }
}

// 1. Throwable
// Throwable中常用的方法:
    // 1. public void printStackTrace(): 打印异常的详细信息
    // 2. public String getMessage(): 获取发生异常的原因。
// Throwable的分类:
    // 1. Error: Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。一般不编写针对性的代码进行处理.
    // 2. Exception: 其它因编程错误或偶然的外在因素导致的一般性问题，需要使用针对性的代码进行处理，使程序继续运行.
// 异常的分类:
    // 1. 编译时异常(受检异常): 在代码编译阶段，编译器就能明确警示当前代码可能发生（不是一定发生）xx异常，并明确督促程序员提前编写处理它的代码
    // 2. 运行时异常(非受检异常): 在代码编译阶段，编译器完全不做任何检查，无论该异常是否会发生，编译器都不给出任何提示。
    //    只有等代码运行起来并确实发生了xx异常，它才能被发现。

// 2. Error
public class AbnormalLearn {
    @Test
    public void test01(){
        //StackOverflowError测试
        recursion();
    }
    public void recursion(){ //递归方法
        recursion();
    }

    @Test
    public void test02(){
        //OutOfMemoryError测试
        //方式一：
        int[] arr = new int[Integer.MAX_VALUE];
    }

    @Test
    public void test03(){
        //OutOfMemoryError测试
        //方式二：
        StringBuilder s = new StringBuilder();
        while(true){
            s.append("atguigu");
        }
    }
}

