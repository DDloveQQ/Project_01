package Interface;

public class InterfaceLearn02 {
}

// 接口使用规则

// 1. 类实现接口
// 接口不能创建对象，但是可以被类实现（ implements ，类似于被继承）。

// 注意:
// 1. 如果接口的实现类是非抽象类，那么必须重写接口中所有抽象方法,除非类是抽象类
// 2. 默认方法可以选择保留，也可以重写。(重写时，default单词就不要再写了，)
// 3. 接口中的静态方法不能被继承也不能被重写
interface USB{ //
    public void start() ;
    public void stop() ;
}
class Computer{
    public static void show(USB usb){
        usb.start() ;
        System.out.println("=========== USB 设备工作 ========") ;
        usb.stop() ;
    }
    public void setUsb(USB3 usb3) {

    }

};
class Flash implements USB{
    public void start(){ // 重写方法
        System.out.println("U盘开始工作。") ;
    }
    public void stop(){ // 重写方法
        System.out.println("U盘停止工作。") ;
    }
};
class Print implements USB{
    public void start(){ // 重写方法
        System.out.println("打印机开始工作。") ;
    }
    public void stop(){ // 重写方法
        System.out.println("打印机停止工作。") ;
    }
};
class InterfaceDemo{
    public static void main(String[] args){
        Computer.show(new Flash()) ;  // USB usb = new Flash() (class Flash implements USB)
        Computer.show(new Print()) ;  // USB usb = new Print() (class Print implements USB)
        Computer.show(new USB(){  // USB usb = new USB() {...}
            public void start(){  // 现场重写方法
                System.out.println("移动硬盘开始运行");
            }
            public void stop(){  // 现场重写方法
                System.out.println("移动硬盘停止运行");
            }
        });
    }
}

// 2. 接口的多实现
// 对于接口而言，一个类是可以实现多个接口, 这叫做接口的多实现
// 一个类在继承一个父类的同时还能实现多个接口。
// 接口中,如果抽象方法有重名的,只需要重写一次。

interface A {
    void showA();
}
interface B {
    void showB();
}

class C implements A,B {  // 接口多实现
    @Override
    public void showA() {  // 接口方法重写
        System.out.println("showA");
    }
    @Override
    public void showB() {  // 接口方法重写
        System.out.println("showB");
    }
}

class TestC {
    public static void main(String[] args) {
        C c = new C();
        c.showA();
        c.showB();
    }
}

// 3. 接口的多继承
// 一个接口能继承另一个或者多个接口，接口的继承也使用 extends 关键字，子接口继承父接口的方法。

// 定义父接口
interface Chargeable {
    void charge();
    void in();
    void out();
}

// 定义子接口
interface UsbC extends Chargeable,USB3 {
    void reverse();
}

// 定义子接口实现类
class TypeCConverter implements UsbC {
    @Override
    public void reverse() {
        System.out.println("正反面都支持");
    }
    // 所有父接口的抽象方法都有重写。
    @Override
    public void charge() {
        System.out.println("可充电");
    }
    @Override
    public void in() {
        System.out.println("接收数据");
    }
    @Override
    public void out() {
        System.out.println("输出数据");
    }
}

// 4. 接口与实现类对象构成多态引用
// 实现类实现接口，类似于子类继承父类，因此，接口类型的变量与实现类的对象之间，也可以构成多态引用。
// 通过接口类型的变量调用方法，最终执行的是你new的实现类对象实现的方法体。
// 用法: 接口名 变量名 = new 实现类的对象

class Mouse implements USB3 {
    @Override
    public void out() {
        System.out.println("鼠标发送脉冲信号");
    }
    @Override
    public void in() {
        System.out.println("鼠标不接收信号");
    }
}
class KeyBoard implements USB3{
    @Override
    public void in() {
        System.out.println("键盘不接收信号");
    }
    @Override
    public void out() {
        System.out.println("键盘发送按键信号");
    }
}

class TestComputer {
    public static void main(String[] args) {
        Computer computer = new Computer();
        USB3 usb = new Mouse();  // 接口与实现类对象构成多态引用 USB3是接口,Mouse是接口实现类
        // 此时usb在编译时便调用的是USB3接口中的方法,但在实现时调用的是Mouse()类中的重写方法
        usb.start();  // USB3 默认方法 ---> 借助实现类来调用
        usb.out();  // USB3 抽象方法 ---> Mouse重写
        usb.in();  // USB3 抽象方法 ---> Mouse重写
        usb.stop();  // USB3 默认方法 ---> 借助实现类来调用
        System.out.println("--------------------------");
        usb = new KeyBoard();
        usb.start();  // USB3 默认方法 ---> 借助实现类来调用
        usb.out();  // USB3 抽象方法 ---> Mouse重写
        usb.in();  // USB3 抽象方法 ---> Mouse重写
        usb.stop();  // USB3 默认方法 ---> 借助实现类来调用
        System.out.println("--------------------------");
    }
}

// 5. 使用接口的静态成员
// 接口不能直接创建对象，但是可以通过接口名直接调用接口的静态方法和静态常量。

class TestUSB3 {
    public static void main(String[] args) {
        //通过“接口名.”调用接口的静态方法 (JDK8.0才能开始使用)
        USB3.show();
        //通过“接口名.”直接使用接口的静态常量
        System.out.println(USB3.MAX_SPEED);
    }
}

// 6. 使用接口的非静态方法
// 对于接口的抽象方法、默认方法，只能通过实现类对象才可以调用
// 因为接口不能创建对象, 只能创建实现类, 并借助此类实例化出能实现方法的对象
// 示例见4