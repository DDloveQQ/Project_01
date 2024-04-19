package Inheritance;

public class InheritanceLearn {
    // 类的继承-----关键词: extends
}

/*
 * 定义动物类Animal，做为父类
 */
class Animal {
    // 定义name属性
    String name;
    // 定义age属性
    int age;
    // 定义动物的吃东西方法
    public void eat() {
        System.out.println(age + "岁的" + name + "在吃东西");
    }
}

/*
 * 定义猫类Cat 继承 动物类Animal
 */
class Cat extends Animal {
    int count;//记录每只猫抓的老鼠数量
    // 定义一个猫抓老鼠的方法catchMouse
    public void catchMouse() {
        count++;
        System.out.println("抓老鼠，已经抓了" + count + "只老鼠");
    }
}

class TestCat {
    public static void main(String[] args) {
        // 创建一个猫类对象
        Cat cat = new Cat();
        // 为该猫类对象的name属性进行赋值
        cat.name = "Tom";
        // 为该猫类对象的age属性进行赋值
        cat.age = 2;
        // 调用该猫继承来的eat()方法
        cat.eat();
        // 调用该猫的catchMouse()方法
        cat.catchMouse();
        cat.catchMouse();
        cat.catchMouse();
    }
}