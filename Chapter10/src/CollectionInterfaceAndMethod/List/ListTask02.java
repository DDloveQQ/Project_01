package CollectionInterfaceAndMethod.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Objects;

public class ListTask02 {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> arr = new ArrayList<String>();

    ListTask02() {
        System.out.println("歌曲库初始化成功");
        System.out.println("-------------欢迎来到点歌系统------------");
    }

    public static void main(String[] args) {
        boolean endFlag = false;
        new ListTask02();

        while (!endFlag) {
            System.out.println("1.添加歌曲至列表");
            System.out.println("2.将歌曲置顶");
            System.out.println("3.将歌曲前移一位");
            System.out.println("4.退出");
            System.out.println("--------------------------------------");
            System.out.print("请选择功能: ");

            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> addSonToList();
                case 2 -> addSonToTop();
                case 3 -> moveSonForward();
                case 4 -> endFlag = true;
                default -> System.out.println("输入有误,请重新输入");
            }
        }
    }

    private static void addSonToList() {
        System.out.println("请输入要点播的歌名");
        String son = scanner.next();
        arr.add(son);
        System.out.println("-------------当前歌曲列表------------");
        printSonList();
        System.out.println("-------------歌曲点播成功------------");
    }

    private static void addSonToTop() {
        System.out.println("请输入要置顶的歌曲编号");
        int index = scanner.nextInt();
        if (index - 1 == 0) {
            System.out.println("此歌曲已经在最顶了");
            return;
        }
        if (index < 1 || index > arr.size()) {
            System.out.println("编号输入错误");
            return;
        }
        String son = arr.remove(index - 1);
        arr.add(0, son);
        System.out.println("-------------当前歌曲列表------------");
        printSonList();
        System.out.println("-------------歌曲置顶成功------------");
    }

    private static void moveSonForward() {
        System.out.println("请输入要前移的歌曲编号");
        int index = scanner.nextInt();
        if (index - 1 == 0) {
            System.out.println("此歌曲已经在最顶了");
            return;
        }
        if (index < 1 || index > arr.size()) {
            System.out.println("编号输入错误");
            return;
        }
        String son = arr.remove(index - 1);
        arr.add(index - 2 , son);
        printSonList();
    }

    private static void printSonList() {
        int count = 0;
        if (arr.size() == 0) {
            System.out.println("你还没有点歌!!!");
            return;
        }
        for (String str: arr) {
            System.out.println(++count + ". " +  str);
        }
    }
}
