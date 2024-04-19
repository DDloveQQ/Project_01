
public class ClassLearn04 {
    // 类的封装性与构造函数
    public double getArea(ClassLearn04_2 triangle) {
        return triangle.getBase() * triangle.getHeight() * 0.5;
    }

    public static void main(String[] args) {
        ClassLearn04_2 triangle = new ClassLearn04_2(5.0, 10.0);
        ClassLearn04 CL04 = new ClassLearn04();
        System.out.println(CL04.getArea(triangle));
    }

}

class ClassLearn04_2 {
    private double base;
    private double height;

    ClassLearn04_2(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}