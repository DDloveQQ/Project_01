package Abnormal;
import java.util.Scanner;

public class ManualExceptionTask {
    static void methodA() {
        try {
            System.out.println("进入方法A");  // 1
            throw new RuntimeException("制造异常");  // 3.1
        }finally {
            System.out.println("用A方法的finally");  // 2
        }
    }
    static void methodB() {
        try {
            System.out.println("进入方法B");  // 4
            return;
        } finally {
            System.out.println("调用B方法的finally");  // 5
        }
    }
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());  // 3.2
        }
        methodB();
    }
}

class EcDef extends Exception {
    static final long serialVersionUDI = 123123123L;
    public EcDef(String message) {
        super(message);
    }
}

class EcmDef {
    public static int ecm(int a, int b) throws EcDef{
        if(a < 0 || b < 0) {
            throw new EcDef("输入数据不可为负数");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {  // try体系快捷建:ctrl + alt + T
            int m = Integer.parseInt(args[0]);
            int n = Integer.parseInt(args[1]);
            int out = ecm(m, n);
            System.out.println(out);
        } catch (EcDef e) {
            System.out.println("输入负数");
        } catch (ArithmeticException e){
            System.out.println("除0错误");
        } catch (NumberFormatException e){
            System.out.println("数据类型不一致");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行");
        }

    }
}
