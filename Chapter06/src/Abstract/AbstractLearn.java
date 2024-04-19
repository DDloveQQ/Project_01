package Abstract;

// 抽象类与抽象方法
// 将一个父类设计得非常抽象，以至于它没有具体的实例，此时他便成为抽象类
// 没有方法体的方法称为抽象方法。
// Java语法规定，包含抽象方法的类必须是抽象类。
// 抽象类: 被abstract修饰的类
// 抽象方法: 被abstract修饰没有方法体的方法

// 注意:
// 1. 抽象类不能创建对象，只能创建其非抽象子类的对象。
// 2. 抽象类中，也有构造方法，是供子类创建对象时，初始化父类成员变量使用的。
// 3. 抽象类中，不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
// 4. 抽象类的子类，必须重写抽象父类中所有的抽象方法，否则，编译无法通过而报错。除非该子类也是抽象类。
// 5. 不能用abstract修饰变量、代码块、构造器.
// 6. 不能用abstract修饰私有方法、静态方法、final的方法、final的类。

public class AbstractLearn {
}

abstract class Animal {
    public abstract void eat();  // 抽象方法声明
}

class Cat extends Animal {
    public void eat (){  // 实现方法
        System.out.println("小猫吃鱼和猫粮");
    }
}

class CatTest {
    public static void main(String[] args) {
// 创建子类对象
        Cat c = new Cat();
// 调用eat方法
        c.eat();
    }
}

/////////////////////////////////////////////////////////////////
//抽象类的应用：模板方法的设计模式
class TemplateMethodTest {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();
        BankTemplateMethod btm2 = new ManageMoney();
        btm2.process();
    }
}
abstract class BankTemplateMethod {
    // 具体方法
    public void takeNumber() {
        System.out.println("取号排队");
    }
    public abstract void transact(); // 办理具体的业务 //钩子方法

    public void evaluate() {
        System.out.println("反馈评分");
    }

    // 模板方法，把基本操作组合到一起，子类一般不能重写(final修饰)
    public final void process() {
        this.takeNumber();
        this.transact();  // 像个钩子，具体执行时，挂哪个子类，就执行哪个子类的实现代码
        this.evaluate();
    }
}
class DrawMoney extends BankTemplateMethod {
    public void transact() {
        System.out.println("我要取款！！！");
    }
}
class ManageMoney extends BankTemplateMethod {
    public void transact() {
        System.out.println("我要理财！我这里有2000万美元!!");
    }
}