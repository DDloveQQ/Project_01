import java.util.Scanner;

public class IfElseLearn {
    public static void main(String[] args) {
        int heartBeats = 120;
        if (heartBeats < 60 || heartBeats > 120) {
            System.out.println("心率有问题！");
        }
        System.out.println("体检结束");
    }
}

class IfElseTest02 {
    public static void main(String[] args) {
        int a = 12;
        if (a % 2 == 0) {
            System.out.println(a + "是偶数");
        } else {
            System.out.println(a + "是奇数");
        }
    }
}

class IfElseTest03 {
    public static void main(String[] args) {
        int score = 95;
        if (score < 60) {
            System.out.println("揍");
        } else if (score >= 60 && score <= 80) {
            System.out.println("环球影城一日游");
        } else if (score > 80 && score <= 99) {
            System.out.println("山地自行车");
        } else {
            System.out.println("跑车一辆");
        }
    }
}

class IfElseTest04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int num1 = in.nextInt();
        System.out.println("请输入第二个数");
        int num2 = in.nextInt();
        System.out.println("请输入第三个数");
        int num3 = in.nextInt();

        if (num1 >= num2) {
            if (num2 >= num3) {
                System.out.println(num3 + " " + num2 + " " + num1);
            } else if (num3 >= num1) {
                System.out.println(num2 + " " + num1 + " " + num3);
            } else {
                System.out.println(num2 + " " + num3 + " " + num1);
            }
        } else {
            if (num3 <= num1){
                System.out.println(num3 + " " + num1 + " " + num2);
            } else if (num3 >= num2) {
                System.out.println(num1 + " " + num2 + " " + num3);
            } else {
                System.out.println(num1 + " " + num3 + " " + num2);
            }
        }
    }
}

