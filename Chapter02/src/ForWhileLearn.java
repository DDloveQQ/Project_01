import java.util.Scanner;

public class ForWhileLearn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int num1 = input.nextInt();
        System.out.println("请输入第二个数");
        int num2 = input.nextInt();

        int min = Math.min(num1, num2);

        // 求最大公约数(最大的被除为整数的数)
        int maxCommonDivisor = 1;
        for (int i = min; i >= 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                maxCommonDivisor = i;
                break;  // 一旦执行就跳出当前for循环
            }
        }

        // 求最小公倍数
        int max = Math.max(num1, num2);
        int minCommonMultiple = max;
        for (int j = max; j < num1 * num2; j++) {
            if (j % num1 == 0 && j % num2 == 0) {
                minCommonMultiple = j;
                break;  // 一旦执行就跳出当前for循环
            }
        }

        // 输出结果
        System.out.println("最大公约数: " + maxCommonDivisor);
        System.out.println("最小公倍数: " + minCommonMultiple);

    }
}

class ForWhileLearn02 {
    public static void main(String[] args) {
        double paper = 0.1;
        double mountain = 8848860;
        int count = 0;

        while (paper < mountain){
            paper *= 2;
            count++;
        }
        System.out.println("折纸最终高度: " + paper / 1000 + "米");
        System.out.println("折纸次数: " + count + "次");
    }
}

class ForWhileLearn03{
    public static void main(String[] args) {
        //while循环:(未满足条件则一次都不执行)
        int num1 = 10;
        while(num1 > 10){
            System.out.println("hello:while");
            num1--;
        }

        //do-while循环:(未满足条件至少能执行一次)
        int num2 = 10;
        do{
            System.out.println("hello:do-while");
            num2--;
        }while(num2 > 10);
    }
}

// 总结
// * 遍历有明显的循环次数（范围）的需求，选择for循环
// * 遍历没有明显的循环次数（范围）的需求，选择while循环
// * 如果循环体语句块至少执行一次，可以考虑使用do-while循环
// * 本质上：三种循环之间完全可以互相转换，都能实现循环的功能

