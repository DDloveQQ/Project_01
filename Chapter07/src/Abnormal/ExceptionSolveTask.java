package Abnormal;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionSolveTask {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("请输入第一个整数：");
            int a = input.nextInt();
            System.out.print("请输入第二个整数：");
            int b = input.nextInt();
            int result = a / b;
            System.out.println(a + "/" + b + "=" + result);
        } catch (InputMismatchException e) {
            System.out.println("数字格式不正确，请输入两个整数");
        } catch (ArithmeticException e) {
            System.out.println("第二个整数不能为0");
        } finally {
            // finally可以用于确保资源关闭
            System.out.println("程序结束，释放资源");
            input.close();
        }
    }

    @Test
    public void test1() {
        FileInputStream fis = null;
        try {
            File file = new File("hello1.txt");
            fis = new FileInputStream(file);//FileNotFoundException
            int b = fis.read();//IOException
            while (b != -1) {
                System.out.print((char) b);
                b = fis.read();//IOException
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();//IOException
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// 函数中使用try-catch --- 从try中返回
class FinallyTest1 {
    public static void main(String[] args) {
        int result = test("12");
        System.out.println(result);
    }
    public static int test(String str){
        try{
            Integer.parseInt(str);
            return 1;
        }catch(NumberFormatException e){
            return -1;
        }finally{
            System.out.println("test结束");
        }
    }
}

// 函数中使用try-catch --- 从catch中返回
class FinallyTest2 {
    public static void main(String[] args) {
        int result = test("a");
        System.out.println(result);
    }
    public static int test(String str) {
        try {
            Integer.parseInt(str);
            return 1;
        } catch (NumberFormatException e) {
            return -1;
        } finally {
            System.out.println("test结束");  // 先输出
        }
    }
}

// 函数中使用try-catch --- 从finally中返回
class FinallyTest3 {
    public static void main(String[] args) {
        int result = test("a");
        System.out.println(result);
    }
    public static int test(String str) {
        try {
            Integer.parseInt(str);
            return 1;
        } catch (NumberFormatException e) {
            return -1;
        } finally {
            System.out.println("test结束");
            return 0;
        }
    }
}

// 笔试题
class ExceptionTest {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);  // 100
        // 为什么结果是100?
        // 答: 因为在finally之前就已经return了i=100, 所以result收到的数为100
    }
    public static int test(){
        int i = 100;
        try {
            return i;
        } finally {
            i++;
            System.out.println(i); // 101
        }
    }
    // 为什么程序输出的结果是 101 \n 100 ?
    // 因为输出result需要在test函数结束以后,而test函数中的finally必须被执行
    // 因此先输出i(100+1),后输出result(100)
}

// 编程练习
class ExceptionTest01 {
    public static void main(String[] args) {
        try{
            int a = 0;
            int b = 3;
            int c = b / a;
        }catch (ArithmeticException e) {
            System.out.println("发生除0异常");
            e.printStackTrace();
        }finally {
            System.out.println("程序结束");
        }
    }
}