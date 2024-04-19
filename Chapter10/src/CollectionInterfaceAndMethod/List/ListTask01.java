package CollectionInterfaceAndMethod.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Objects;

public class ListTask01 {
    public static void main(String[] args) {
        Collection<Student> coll = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);

        boolean EndFlag = false;

        while (!EndFlag) {
            System.out.print("选择(1 -> 录入; 0 -> 退出): ");
            if (scanner.nextInt() == 0) {
                EndFlag = true;
            }
            else {
                System.out.print("姓名: ");
                String name = scanner.next();
                System.out.print("年龄: ");
                int age = scanner.nextInt();
                coll.add(new Student(name, age));
            }
        }

        for (Student o : coll) {
            System.out.println(o);
        }

    }
}
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名: " + name + " 年龄: "+ age ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }
}

