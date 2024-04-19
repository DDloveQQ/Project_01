package TimeApi;

import java.util.Scanner;
import java.util.Calendar;

public class TimeApiTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year;
        int month;
        int day = 0;
        boolean yearFlag = false;

        System.out.print("请输入年份: ");
        year = scanner.nextInt();
        System.out.print("请输入月份: ");
        month = scanner.nextInt();

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + "年是闰年");
            yearFlag = true;
        } else {
            System.out.println(year + "年是平年");
        }

        switch (month){
            case 1, 3, 5, 7, 8, 10, 12 -> day = 31;
            case 4, 6, 9, 11 -> day = 30;
            case 2 -> {
                if (yearFlag){
                    day = 29;
                } else {
                    day = 28;
                }
            }
        }
        System.out.println(month + "月有"+ day + "天");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        int week = calendar.get(Calendar.DAY_OF_WEEK); // 从周日开始算,所以比实际要大1

        int row_count = 0;
        int day_count = 1;
        boolean out_bool = true;
        System.out.println("日\t\t一\t\t二\t\t三\t\t四\t\t五\t\t六\t\t");
       while (out_bool){
            for (int j = 0; j < 7; j++) {
                if (j < week - 1 && row_count == 0) {
                    System.out.print("\t\t");
                } else if (j == 6) {
                    System.out.println(day_count++ + "\t\t");
                } else {
                    System.out.print(day_count++ + "\t\t");
                }
                if (day_count-1 == day){
                    out_bool = false;
                    break;
                }
            }
            row_count++;
        }


    }
}
