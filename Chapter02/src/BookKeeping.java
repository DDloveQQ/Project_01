import java.util.Objects;
import java.util.Scanner;

public class BookKeeping {
    public static void main(String[] args) {

        int functionSelection;
        boolean closeFlag = false;

        Scanner scan = new Scanner(System.in);
        BookKeepingFunctions BKF = new BookKeepingFunctions();

        while (!closeFlag){
            System.out.println("------------------ 谷粒记账软件 -------------------");
            System.out.println("                   1. 收支明细                    ");
            System.out.println("                   2. 登记收入                    ");
            System.out.println("                   3. 登记支出                    ");
            System.out.println("                   4. 退   出                   ");
            System.out.println("------------------ 请选择(1-4): ------------------");

            functionSelection = scan.nextInt();
            switch (functionSelection) {
                case 1 -> BKF.printDetail();
                case 2 -> BKF.registeredIncome();
                case 3 -> BKF.registeredOutcome();
                case 4 -> closeFlag = BKF.exitSoftware();
                default -> System.out.println("输入有误!请重新输入");
            }
        }
    }
}

class BookKeepingFunctions {

    String info = "";
    String yesOrNo = "";
    int money = 10000;

    Scanner scan = new Scanner(System.in);
    public void registeredIncome () {
        System.out.println("请输入收入金额");
        int income = scan.nextInt();
        System.out.println("请输入收入描述");
        String description = scan.next();
        if (income > 0){
            money += income;
            info += "收入"+ "\t\t" + income + "\t\t\t" + money + "\t\t\t" + description + "\n";
            printDetail();
        } else {
            System.out.println("输入有误");
        }

    }

    public void registeredOutcome () {
        System.out.println("请输入支出金额");
        int outcome = scan.nextInt();
        System.out.println("请输入支出描述");
        String description = scan.next();
        if (outcome > 0){
            money -= outcome;
            info += "支出"+ "\t\t" + outcome + "\t\t\t" + money + "\t\t\t" + description + "\n";
            printDetail();
        } else {
            System.out.println("输入有误");
        }
    }

    public void printDetail () {
        System.out.println("类型"+ "\t\t" + "金额" + "\t\t\t" + "余额" + "\t\t\t" + "描述" + "\n");
        System.out.println(info);
    }

    public boolean exitSoftware () {
        System.out.println("您是否真的要退出(Y/N)?");
        boolean isExit = false;
        boolean outFlag = false;
        while (!outFlag) {
            yesOrNo = scan.next();
            if (Objects.equals(yesOrNo, "Y") || Objects.equals(yesOrNo, "y")) {
                System.out.println("感谢使用谷粒记账软件!");
                isExit = true;
                outFlag = true;
            } else if (Objects.equals(yesOrNo, "N") || Objects.equals(yesOrNo, "n")) {
                outFlag = true;
            } else {
                System.out.println("输入错误! 请重新输入");
            }
        }
        return isExit;
    }
}
