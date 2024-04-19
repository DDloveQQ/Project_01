package Object;

import java.rmi.ConnectIOException;

public class ObjectTask02 {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println(circle.findArea());  // 3.141592653589793
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(1);
        System.out.println(circle1.equals(circle));  // false
        System.out.println(circle2.equals(circle));  // true
        System.out.println(circle1);  // 圆的半径: 3.0
    }
}

class GeometricObject {
    protected String color;
    protected double weight;

    protected GeometricObject() {
        color = "white";
        weight = 1.0;
    }
    protected GeometricObject(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Circle extends GeometricObject {
    private double radius;

    public Circle() {
        color = "white";
        weight = 1.0;
        radius = 1.0;
    }
    public Circle(double radius) {
        color = "white";
        weight = 1.0;
        this.radius = radius;
    }
    public Circle(double radius, String color, double weight) {
        this.radius = radius;
        this.color = color;
        this.weight = weight;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Circle circle) {
            return circle.radius == this.radius;
        }
        return false;
    }

    @Override
    public String toString() {
        return "圆的半径: " + this.radius;
    }
}
