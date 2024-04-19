package JavaComparator;

//  Java实现对象排序的方式有两种：
//  1. 自然排序：java.lang.Comparable(this比object) -> 方法重写在this中
//  2. 定制排序：java.util.Comparator(object1比object2) -> 方法重写在新的类



// 1. 自然排序：java.lang.Comparable

// Comparable接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序
// 实现 Comparable 的类必须实现 compareTo(Object obj) 方法，两个对象即通过compareTo(Object obj) 方法的返回值来比较大小。
// 如果当前对象this大于形参对象obj，则返回正整数，如果当前对象this小于形参对象obj，则返回负整数，
// 如果当前对象this等于形参对象obj，则返回零。

import java.util.Arrays;

public class ComparableLearn {

}

class Student implements Comparable {
    private int id;
    private String name;
    private int score;
    private int age;
    public Student(int id, String name, int score, int age) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        //这些需要强制，将o对象向下转型为ComparableLearn类型的变量，才能调用ComparableLearn类中的属性
        //默认按照学号比较大小
        Student stu = (Student) o;
        return this.id - stu.id;
    }
}

class TestStudent {
    public static void main(String[] args) {
        Student[] arr = new Student[5];
        arr[0] = new Student(3,"张三",90,23);
        arr[1] = new Student(1,"熊大",100,22);
        arr[2] = new Student(5,"王五",75,25);
        arr[3] = new Student(4,"李四",85,24);
        arr[4] = new Student(2,"熊二",85,18);
        //单独比较两个对象
        System.out.println(arr[0].compareTo(arr[1]));  // (>)2
        System.out.println(arr[1].compareTo(arr[2]));  // (<)-4
        System.out.println(arr[2].compareTo(arr[2]));  // (=)0
        System.out.println("所有学生：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("按照学号排序：");
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j].compareTo(arr[j+1])>0){
                    Student temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}


class Goods implements Comparable {
    private String name;
    private double price;
    //按照价格，比较商品的大小
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods) {
            // 将object对象向下转型为good对象,这样才能调用goods内部
            Goods other = (Goods) o;
            if (this.price > other.price) {
                return 1;
            } else if (this.price < other.price) {
                return -1;
            }
            return 0;
        }
        throw new RuntimeException("输入的数据类型不一致");
    }

    Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
class ComparableTest{
    public static void main(String[] args) {
        Goods[] all = new Goods[4];
        all[0] = new Goods("《红楼梦》", 100);
        all[1] = new Goods("《西游记》", 80);
        all[2] = new Goods("《三国演义》", 140);
        all[3] = new Goods("《水浒传》", 120);
        Arrays.sort(all);
        System.out.println("按照价格排序");
        System.out.println(Arrays.toString(all));
    }
}