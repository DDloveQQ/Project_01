package Generics.Comparator;
import java.util.Comparator;


public class GenericsLearn {

}

class Circle{
    private double radius;
    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}

// 比较器使用泛型(在实现接口时给出数据类型)
class CircleComparator1 implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        //不再需要强制类型转换，代码更简洁(因为传入的数据类型已经规定了是Circle)
        return Double.compare(o1.getRadius(), o2.getRadius());
    }
}
//测试类
class TestHasGeneric {
    public static void main(String[] args) {
        CircleComparator1 com = new CircleComparator1();
        System.out.println(com.compare(new Circle(1), new Circle(2)));
        //System.out.println(com.compare("圆1", "圆2"));
        //编译错误，因为"圆1", "圆2"不是Circle类型，是String类型，编译器提前报错，
        //而不是冒着风险在运行时再报错。
    }
}