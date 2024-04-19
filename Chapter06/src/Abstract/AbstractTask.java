package Abstract;

import java.util.Objects;

public class AbstractTask {
}

abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    // 构造函数
    public Employee() {
    }
    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }
    // getter和setter
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public MyDate getBirthday() {
        return birthday;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString() +
                '}';
    }

}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toDateString() {
        return year + "年" + month + "月" + day + "日";
    }
}

class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "合同工\n" + "姓名: " + this.getName() + "\n工号: " + this.getNumber()
                 + "\n生日: " + this.getBirthday().toDateString();
    }
}

class HourlyEmployee extends Employee {
    private double wage;
    private int hour;

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "临时工\n" + "姓名: " + this.getName() + "\n工号: " + this.getNumber()
                + "\n生日: " + this.getBirthday().toDateString();
    }

}

class PayrollSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        MyDate today = new MyDate(2024, 4, 3);

        employees[0] = new SalariedEmployee("张三", 1, new MyDate(2000, 4, 3), 20000);
        employees[1] = new HourlyEmployee("李四", 2, new MyDate(2000, 2, 5), 150, 20);
        employees[2] = new SalariedEmployee("王五", 3, new MyDate(2000, 4, 5), 25000);

        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
                if (employee.getBirthday().getMonth() == today.getMonth() && employee.getBirthday().getDay() == today.getDay()) {
                    System.out.println("过生日!工资加100");
                    System.out.println("工资为: " + (employee.earnings() + 100.0));
                } else {
                    System.out.println("工资为: " + employee.earnings());
                }
                System.out.println();
            }
        }
    }

}
