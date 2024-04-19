package Generics.CustomGenerics;

public class CustomGenericsTask {
    public static void main(String[] args) {
        Student<String> student1 = new Student<>("优秀", "张三", "1000");
        Student<Double> student2 = new Student<>(90.0, "李四", "1001");
        Student<Character> student3 = new Student<>('A', "王五", "1002");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}

class Student<T> {
    private T score;
    private String name;
    private String id;

    public Student(T score, String name, String id) {
        this.score = score;
        this.name = name;
        this.id = id;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}