package Generics.Comparator;

import java.util.ArrayList;

public class GenericsTask {
    public static void main(String[] args) {

        ArrayList<Rectangle> arrayList = new ArrayList<>();
        arrayList.add(new Rectangle(2, 3));
        arrayList.add(new Rectangle(5, 10));
        arrayList.add(new Rectangle(4, 4));
        arrayList.add(new Rectangle(1, 8));
        arrayList.add(new Rectangle(2, 8));
        System.out.println("------------------ 排序前 -------------------");
        for (Rectangle rectangle:arrayList) {
            System.out.println(rectangle);
        }

        arrayList.sort(Rectangle::compareTo);

        System.out.println("------------------ 排序后 -------------------");
        for (Rectangle rectangle:arrayList) {
            System.out.println(rectangle);
        }
    }
}

class Rectangle implements Comparable<Rectangle>{
    private int width;
    private int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", area=" + getArea() +
                ", Circumference=" + getCircumference() +
                '}';
    }

    public int getArea() {
        return width * length;
    }

    public int getCircumference() {
        return 2 * (length + width);
    }

    @Override
    public int compareTo(Rectangle o) {
        int compare = Integer.compare(this.getArea(), o.getArea());
        return compare != 0 ? compare: Integer.compare(this.getCircumference(), o.getCircumference());
    }
}