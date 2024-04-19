package Packaging;
import java.util.Vector;
import java.util.Scanner;

public class PackagingTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector v = new Vector();

        int maxScore = 0;

        boolean Flag = true;

        while (Flag) {
            System.out.print("请输入学生成绩");
            int score = scanner.nextInt();

            /////////////////////////////////////
            // 利用自动装箱
            v.addElement(score);
            /////////////////////////////////////

            if (maxScore < score) {
                maxScore = score;
            }
            if (score < 0) {
                Flag = false;
            }
        }
        System.out.println("最高分为: " + maxScore);

        for (int i = 0; i < v.size(); i++) {
            Object objScore = v.elementAt(i);

            /////////////////////////////////////
            // 自动拆箱
            int score = (Integer) objScore;
            /////////////////////////////////////

            if (maxScore - 10 < score) {
                System.out.println("学生" + i + "的等级为: A");
            } else if (maxScore - 20 < score) {
                System.out.println("学生" + i + "的等级为: B");
            } else if (maxScore - 30 < score) {
                System.out.println("学生" + i + "的等级为: C");
            } else {
                System.out.println("学生" + i + "的等级为: D");
            }
        }

    }
}

