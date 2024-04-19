import java.util.Scanner;

public class IfElseTask {
    public static void main(String[] args) {
        boolean b = true;
// 如果写成if(b=false)能编译通过吗？如果能，结果是？
// --> 能执行，可以看作赋值 'b = false' 作为条件使用，实际数据结果为 "c"
        if(b == false)      //建议：if(!b)
            System.out.println("a");
        else if(b)
            System.out.println("b");
        else if(!b)
            System.out.println("c");
        else
            System.out.println("d");
    }
}

class IfElseTask02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int num1 = scan.nextInt();
        System.out.println("请输入第二个数");
        int num2 = scan.nextInt();

        if (num1 + num2 >= 50){
            System.out.println("hello world");
        } else {
            System.out.println("两数之和不够大");
        }
    }
}
