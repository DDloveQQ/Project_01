//  数组本身是引用数据类型，而数组中的元素可以是任何数据类型，包括基本数据类型和引用数据类型。
//  创建数组对象会在内存中开辟一整块连续的空间。占据的空间的大小，取决于数组的长度和数组中元素的类型。
//  数组中的元素在内存中是依次紧密排列的，有序的。
//  数组，一旦初始化完成，其长度就是确定的。数组的长度一旦确定，就不能修改。
//  我们可以直接通过下标(或索引)的方式调用指定位置的元素，速度很快。
//  数组名中引用的是这块连续空间的首地址。

//  问: 为什么数组要从0开始编号,而不是1?
//  答: 因为数组的索引表示了数组元素距离首地址的偏移量,而第一个元素地址与首地址相同.所以偏移量为0

import java.util.Scanner;

public class ArrayLearn {
    public static void main(String[] args) {

        double[] prices;  // 声明数组
        // 静态初始化: 数组变量的赋值与数组元素的赋值操作同时进行
        prices = new double[]{20.0, 30.0, 40.0, 50.0};

        String[] foods;
        foods = new String[4];

        // 动态初始化：数组变量的赋值与数组元素的赋值操作分开进行
        String[] foods2 = new String[3];

        // 其他正确方式
        int arr[] = new int[4];
        int[] arr1 = {1, 2, 3, 4};  // 自动类型推断

        // 数组元素调用(通过脚标)
        System.out.println(prices[0]);
        System.out.println(prices[3]);

        foods[0] = "大闸蟹";
        foods2[0] = "烤乳猪";

        // 数组的长度
        System.out.println(foods.length);

        // 数组的遍历
        // 普通for
        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i]);
        }
        // 增强for
        for (double price : prices) {
            System.out.println(price);
        }

        System.out.println(arr);  // [I@3b07d329 数组的内存首地址

    }
}

class ArrayLearn02 {
    public static void main(String[] args) {
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数字(1-7)");
        int num = scan.nextInt() - 1;

        if (num < 0 || num > 6) {
            System.out.println("输入错误");
        } else {
            System.out.println(weeks[num]);
        }
    }
}

class ArrayLearn03{
    public static void main(String[] args) {
        // 二维数组声明
        // 方式一: 静态初始化 :数组变量的赋值与数组元素的赋值操作同时进行
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // 方式二: 动态初始化1: 数组变量的赋值与数组元素的赋值操作分开进行
        String[][] arr2 = new String[3][4];

        // 动态初始化2
        double[][] arr3 = new double[2][];

        //其他正确的方式
        int arr4[][]  = new int[][]{{1,2,3},{4,5},{6,7,8,9}};
        int [] arr5 []  = new int[][]{{1,2,3},{4,5},{6,7,8,9}};
        int arr6[][]  = {{1,2,3},{4,5},{6,7,8,9}};  //类型推断
        String arr7[][]  = new String[3][4];

        // 二维数组元素调用
        System.out.println(arr1[0][0]);  // 1
        System.out.println(arr1[0]);  // [I@4eec7777 返回地址

        // 数组的长度
        System.out.println(arr1.length);  // 3
        System.out.println(arr1[0].length);  // 3

        // 遍历数组
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
                System.out.print(arr1[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class ArrayLearn04 {
    public static void main(String[] args) {
        String [][] employees = new String[][]{{"10","1","段誉","22","3000"},
                {"11","2","令狐冲","32","18000","15000","2000"},
                {"12","3","赵敏","23","7000"}
        };

        System.out.println("员工类型\t编号\t姓名\t年龄\t薪资\t奖金\t股票");

        for (String[] employee : employees) {
            String employeeType = employee[0];

            switch (employeeType) {
                case "10" -> System.out.print("普通员工\t");
                case "11" -> System.out.print("架构师\t\t");
                case "12" -> System.out.print("程序员\t\t");
            }

            for (String s : employee) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
    }
}