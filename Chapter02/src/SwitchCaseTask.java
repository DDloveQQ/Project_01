import java.util.Scanner;

public class SwitchCaseTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入学生成绩");
        int score = scan.nextInt();
        // 增强 switch case
        String level = switch (score / 10) {
            case 10, 9 -> "A";
            case 8, 7 -> "B";
            case 6 -> "C";
            default -> "D";
        };
        // 普通 switch case
//        switch (score / 10) {
//            case 10, 9:
//                level = "A";
//                break;
//            case 8, 7:
//                level = "B";
//                break;
//            case 6:
//                level = "C";
//                break;
//            default:
//                level = "D";
//                break;
//        }
        System.out.println("学生的成绩等级为" + level);
    }
}

class SwitchCaseTask02 {
    public static void main(String[] args) {
        int a = (int)(Math.random() * 6 + 1);  // Math.random()能够产生[0,1)范围内的小数
        int b = (int)(Math.random() * 6 + 1);
        int c = (int)(Math.random() * 6 + 1);

        Scanner scan = new Scanner(System.in);
        System.out.println("请押宝");
        String guess = scan.next();
        scan.close();

        boolean result = false;

        switch (guess){
            case "豹子":
                result = (a == b) && (b == c);
                break;
            case "小":
                result = (a + b + c) <= 9;
                break;
            case "大":
                result = (a + b + c) > 9;
                break;
            default:
                System.out.println("输入有误!");
        }
        System.out.println("a = " + a + ", b = " + b + ", c = " + c );
        System.out.println(result ? "猜中了" : "猜错了");
    }
}
