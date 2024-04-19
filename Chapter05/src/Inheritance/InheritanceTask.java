package Inheritance;

public class InheritanceTask {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();

        System.out.println(cylinder.findVolume());
    }
}

class Circle {
    private double radius;

    public Circle() {
        this.radius = 1.0;
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

class Cylinder extends Circle {
    private double length;

    public Cylinder() {
        this.length = 1;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getLength() {
        return length;
    }
    public double findVolume() {
        return findArea() * length;
    }
}