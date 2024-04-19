package Interface;

public class InterfaceLearn03 {
}


// JDK8中接口的相关冲突问题
//////////////////////////////////////////////////////////////////////////////////
// 1. 默认方法冲突
// 1.1 类优先原则
// 当一个类，既继承一个父类，又实现若干个接口时，父类中的成员方法与接口中的抽象方法重名，冲突便形成
// 此时的子类会就近选择执行父类的成员方法

// 接口
interface Friend {
    default void date(){//约会
        System.out.println("吃喝玩乐");
    }
}

// 父类
class Father {
    public void date(){//约会
        System.out.println("爸爸约吃饭");
    }
}

// 子类既继承父类,又实现接口
class Son extends Father implements Friend {
    @Override
    public void date() {
        //(1)不重写默认保留父类的
        //(2)强制调用父类的方法
        super.date();  // 爸爸约吃饭
        //(3)强制调用接口的方法
        Friend.super.date();  // 吃喝玩乐
        //(4)完全重写
        System.out.println("跟康师傅学Java");  // 跟康师傅学Java
    }
}

class TestSon {
    public static void main(String[] args) {
        Son s = new Son();
        s.date();
    }
}

//////////////////////////////////////////////////////////////////////////////////
// 1.2. 接口冲突
// 问题描述: 当一个类同时实现了多个父接口，而多个父接口中包含方法签名相同的默认方法
// 解决方法: 选择保留其中一个，通过“ 接口名.super.方法名"的方法选择保留哪个接口的默认方法

interface BoyFriend {
    default void date(){//约会
        System.out.println("神秘约会");
    }
}

class Girl implements Friend,BoyFriend{
    @Override
    public void date() {
        //(1)保留其中一个父接口的
         Friend.super.date();  // 强制调用friend接口的方法
         BoyFriend.super.date();  // 强制调用Boyfriend接口的方法
        //(2)完全重写则以上哪个都不调用
        System.out.println("跟康师傅学Java");
    }
}

class TestGirl {
    public static void main(String[] args) {
        Girl girl = new Girl();
        girl.date();
    }
}

//////////////////////////////////////////////////////////////////////////////////
// 2. 常量冲突
// 问题描述:
// 1. 当子类继承父类又实现父接口，而父类中存在与父接口常量同名的成员变量，并且该成员变量名在子类中仍然可见
// 2. 当子类同时实现多个接口，而多个接口存在相同同名常量
class SuperClass {  // 父类
    int x = 1;
}
interface SuperInterface {  // 父接口
    int x = 2;
    int y = 2;
}
interface MotherInterface {  // 母接口
    int x = 3;
}
class SubClass extends SuperClass implements SuperInterface,MotherInterface {  // 子类继承父类并实现两个接口
    public void method(){
        // System.out.println("x = " + x);  // 会报错,因为模糊不清
        System.out.println("super.x = " + super.x);
        System.out.println("SuperInterface.x = " + SuperInterface.x);
        System.out.println("MotherInterface.x = " + MotherInterface.x);
        System.out.println("y = " + y);//没有重名问题，可以直接访问
    }
}
class SubClassTest00 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method();
    }
}