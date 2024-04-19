package Polymorphism;

public class PolymorphismTask02 {
    public static void equalsArea(GeometricObject GO1, GeometricObject GO2) {
        // 方法的形参声明实现多态
        if (GO1.findArea() == GO2.findArea()) {
            System.out.println("面积相等");
        } else {
            System.out.println("面积不相等");
        }
    }

    public static void displayGeometricObject(GeometricObject GO) {
        // 方法的形参声明实现多态
        System.out.println(GO.findArea());
    }

    public static void main(String[] args) {
        Circle circle = new Circle(2, "red", 10);
        MyRectangle myRectangle = new MyRectangle(2, 1, "blue", 10);

        equalsArea(circle, myRectangle);
        displayGeometricObject(circle);
        displayGeometricObject(myRectangle);
    }
 }

class GeometricObject {
    protected String color;
    protected double weight;

    protected GeometricObject(String color, double weight) {
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }
    public double findArea() {
        return 0;
    }
}

class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }
}

class MyRectangle extends GeometricObject {
    private double width;
    private double height;

    public MyRectangle(double width, double height, String color, double weight) {
        super(color, weight);
        this.height = height;
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    @Override
    public double findArea() {
        return width * height;
    }
}

