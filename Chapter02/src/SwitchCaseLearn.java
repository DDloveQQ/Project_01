import java.util.Scanner;

public class SwitchCaseLearn {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入月份");
        int month = scan.nextInt();
        String season;
        if (month >= 3 && month <= 5) {
            season = "spring";
        } else if (month >= 6 && month <= 8) {
            season = "summer";
        } else if (month >= 9 && month <= 11) {
            season = "autumn";
        } else {
            season = "winter";
        }
        switch (season) {
            case "spring":
                System.out.println("春暖花开");
                break;
            case "summer":
                System.out.println("夏日炎炎");
                break;
            case "autumn":
                System.out.println("秋高气爽");
                break;
            case "winter":
                System.out.println("冬雪纷飞");
                break;
            default:
                System.out.println("季节有误");
        }
    }
}

class SwitchCaseLearn02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入月份");
        int month = scan.nextInt();
        System.out.println("请输入日期");
        int day = scan.nextInt();
        int sumDay = 0;

        // 方法一: 冗余（不推荐）
        // 可以使用增强switch case来缩减篇幅
//        switch (month) {
//            case 1 -> System.out.println(day);
//            case 2 -> System.out.println(31 + day);
//            case 3 -> System.out.println(59 + day);
//            case 4 -> System.out.println(90 + day);
//            case 5 -> System.out.println(120 + day);
//            case 6 -> System.out.println(151 + day);
//            case 7 -> System.out.println(181 + day);
//            case 8 -> System.out.println(212 + day);
//            case 9 -> System.out.println(243 + day);
//            case 10 -> System.out.println(273 + day);
//            case 11 -> System.out.println(304 + day);
//            case 12 -> System.out.println(334 + day);
//            default -> System.out.println("输入有误");
//        }

        // 方法二: 更容易
        switch (month) {
            case 12:
                sumDay += 30;
            case 11:
                sumDay += 31;
            case 10:
                sumDay += 30;
            case 9:
                sumDay += 31;
            case 8:
                sumDay += 31;
            case 7:
                sumDay += 30;
            case 6:
                sumDay += 31;
            case 5:
                sumDay += 30;
            case 4:
                sumDay += 31;
            case 3:
                sumDay += 29;
            case 2:
                sumDay += 31;
            case 1:
                sumDay += day;
                break;
        }
        System.out.println(month + "月" + day + "日是2024年的第" + sumDay + "天");

    }
}
