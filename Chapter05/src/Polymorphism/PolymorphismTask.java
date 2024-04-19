package Polymorphism;

public class PolymorphismTask {

}
/////////////////////////////////////////////////////
// 练习1
class Base {
    int count = 10;
    public void display() {
        System.out.println(this.count);
    }
}
class Sub extends Base {
    int count = 20;
    public void display() {
        System.out.println(this.count);
    }
}
class FieldMethodTest {
    public static void main(String[] args){
        Sub s = new Sub();
        System.out.println(s.count);  // 20 默认使用子类的count, 若无则向父类找
        s.display();  // 20 默认使用子类的方法, 若无则向父类找
        Base b = s;
        System.out.println(b == s);  // true b和s地址相同,都指向相同的对象Sub
        System.out.println(b.count);  // 10 子类的成员变量不具有多态性,因此输出父类的count
        b.display();  // 10 子类的方法具有多态性,因此输出子类的display()
    }
}

/////////////////////////////////////////////////////
// 练习2
//考查多态的笔试题目：
class InterviewTest1 {
    public static void main(String[] args) {
        Base2 base2 = new Sub2();  // 多态,向上转型
        base2.add(1, 2, 3); // "Sub2_1" 编译时认为是Base2的,而实际运行时是Sub2的
        Sub2 s2 = (Sub2)base2;  // 向下转型
        s2.add(1,2,3);  // 向下转型后可以调用子类的方法
    }
}
class Base2 {
    public void add(int a, int... arr) {
        System.out.println("Polymorphism.Base2");
    }
}
class Sub2 extends Base2 {
    public void add(int a, int[] arr) {
        System.out.println("Sub2_1");
    }
    public void add(int a, int b, int c) {
        System.out.println("Sub2_2");
    }
}

/////////////////////////////////////////////////////
// 练习3
//getXxx()和setXxx()声明在哪个类中，内部操作的属性就是哪个类里的。
class InterviewTest2 {
    public static void main(String[] args) {
        Father2 f = new Father2();
        Son2 s = new Son2();
        System.out.println(f.getInfo());  // "atguigu"
        System.out.println(s.getInfo());  // "尚硅谷"
        s.test();  // "尚硅谷" \n "atguigu"
        System.out.println("-----------------");
        s.setInfo("大硅谷");
        System.out.println(f.getInfo());  // "atguigu"
        System.out.println(s.getInfo());  // "大硅谷"
        s.test();  // "大硅谷" \n "atguigu"
    }
}
class Father2 {
    private String info = "atguigu";
    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
}
class Son2 extends Father2 {
    private String info = "尚硅谷";
    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
    public void test() {
        System.out.println(this.getInfo());
        System.out.println(super.getInfo());
    }
}

/////////////////////////////////////////////////////
// 练习4
// 多态是编译时行为还是运行时行为?
// 答: 运行时行为