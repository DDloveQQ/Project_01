package Final;

// final关键字(类似于C++的const)

// final修饰的类不能被继承，没有子类(以此提高安全性与可读性)
// 例如：官方的String类、System类、StringBuffer类都被final修饰

// final修饰的方法不能被子类重写
// 例如：Object类中的getClass()

// final修饰的变量(成员变量或局部变量)一经赋值便无法修改,即"常量",命名时要用全大写字母以及下划线连接
public class FinalLearn {
}

class Something {
    public static void main(String[] args) {
        Other o = new Other();
        new Something().addOne(o);
    }
    public void addOne(final Other o) {
        // o = new Other(); 错,因为o被final修饰,无法改变
        o.i++;  // 对,因为i未被final修饰,因此可以改变
    }
}
class Other {
    public int i;
}