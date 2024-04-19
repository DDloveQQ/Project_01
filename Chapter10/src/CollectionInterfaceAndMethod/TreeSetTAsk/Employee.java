package CollectionInterfaceAndMethod.TreeSetTAsk;

public class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "姓名: " + name + " 年龄: " + age + " 生日: " + birthday.getYear() + "年" +
                birthday.getMonth() + "月" + birthday.getDay() + "日";
    }

    @Override
    public int compareTo(Object o) {
        if(o == this){
            return 0;
        }
        if(o instanceof Employee employee){
            return this.name.compareTo(employee.name);
        }
        throw new RuntimeException("输入的类型不匹配");
    }
}
