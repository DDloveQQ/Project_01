package Abnormal;

import org.junit.Test;

import java.util.Scanner;

// 3. 运行时异常
public class TestRuntimeException {
    @Test
    public void test01() {
        //NullPointerException: 空指针异常
        int[][] arr = new int[3][];
        System.out.println(arr[0].length);
    }

    @Test
    public void test02() {
        //ClassCastException: 类型转换异常
        Object obj = 15;
        String str = (String) obj;
    }

    @Test
    public void test03() {
        //ArrayIndexOutOfBoundsException: 数组索引超出上限
        int[] arr = new int[5];
        for (int i = 1; i <= 5; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void  test04() {
        //InputMismatchException: 输入不匹配异常
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个整数：");//输入非整数
        int num = input.nextInt();
        input.close();
    }

    @Test
    public void test05() {
        int a = 1;
        int b = 0;
        //ArithmeticException: 除以0异常(算数异常)
        System.out.println(a / b);
    }
}
