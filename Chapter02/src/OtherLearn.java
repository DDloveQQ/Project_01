import java.util.Scanner;

public class OtherLearn {
    public static void main(String[] args) {

        // break 和 continue的区别:
        // break一旦执行,就跳出当前循环结构
        // continue一旦执行,就跳出当次循环

        for(int i = 1;i <= 10;i++){
            if(i % 4 == 0){
                //break;//123(直接跳出for循环,到达第15行)
                continue;//123567910(跳出当次循环,回到第8行执行下一循环)
            }
            System.out.print(i);
        }
        System.out.println();
        System.out.println("############");

        //嵌套循环中的使用
        for(int i = 1;i <= 4;i++){  // 内存循环的break无法波及到外层循环,因此这个循环一定会执行4次
            for(int j = 1;j <= 10;j++){
                if(j % 4 == 0){
                    //break; //结束的是包裹break关键字的最近的一层循环！
                    continue;//结束的是包裹break关键字的最近的一层循环的当次！
                }
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("############");

        // 使用标签来指定break或continue影响的循环
        label_1: for (int i = 1;i <= 4;i++) {
            label_2: for (int j = 1;j <= 10;j++) {
                if(j % 4 == 0){
                    //break label_1; //123(直接跳出外循环,因此外循环只执行了1次)
                    continue label_1;//123123123123(直接作用于外循环,因此内循环的输出也受到了一定的影响)
                }
                System.out.print(j);  // 无论是break还是continue,该句都不会执行
            }
            System.out.println();
        }
    }
}


class ScannerTest {
    public static void main(String[] args) {

        //步骤2：创建Scanner的对象
        Scanner scan = new Scanner(System.in);

        System.out.println("欢迎来到交友网！");
        System.out.println("请输入你的网名： ");
        //步骤3：调用Scanner类中的方法，获取指定类型的变量
        String name = scan.next();

        System.out.println("请输入你的年龄： ");
        int age = scan.nextInt();

        System.out.println("请输入你的体重： ");
        double weight = scan.nextDouble();

        System.out.print("你是否单身（true/false)：");
        boolean isSingle = scan.nextBoolean();

        System.out.print("请输入你的性别（男/女）:");
        char gender = scan.next().charAt(0);  // 获取用户输入的字符串中的第0个字符

        System.out.println("你的基本情况如下：");
        System.out.println("网名：" + name + "\n年龄：" + age + "\n体重：" + weight + "\n单身：" + isSingle + "\n性别：" + gender);
        System.out.println("注册完成，欢迎继续进入体验！");

        //步骤4：关闭资源，调用Scanner类的close()
        scan.close();

    }
}

/*
如何产生一个随机数？

1、可以使用java提供的api：math类的random()
2、random()调用以后，会返回一个[0.0,1.0)范围的一个double型的随机数

3、需求1：获取 [0,100） 范围的随机整数
   需求2：获取 [1,100） 范围的随机整数

4、需求：获取[a,b] 范围的随机整数
 (int)Math.random() * (b - a + 1) + a
*/


class RandomTest {
    public static void main(String[] args) {

        double d1 = Math.random();
        System.out.println("d1 = " + d1);

        int d2 = (int)(Math.random() * 101) ;
        System.out.println("d2 = " + d2);

        int d3 = (int)(Math.random() * 100) +1 ;
        System.out.println("d3 = " + d3);
    }
}

