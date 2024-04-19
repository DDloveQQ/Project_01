package IOstream.ObjectStream;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;

// 对象流：ObjectOutputStream、ObjectInputStream

// 对象流的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。

// 序列化机制:
// 1. Java对象序列化为二进制形式存储于文件中
// 2. 文件中的二进制信息反序列化为Java对象

// 为了让某个类是可序列化的，该类必须实现java.io.Serializable 接口

// 1. 如果对象的某个属性也是引用数据类型，那么如果该属性也要序列化的话，也要实现Serializable 接口
// 2. 该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用transient 关键字修饰。
// 3. 静态（static）变量的值不会序列化。因为静态变量的值不属于任何对象。

public class ObjectStreamLearn {
    @Test
    public void save() throws IOException {
        String name = "巫师";
        int age = 300;
        char gender = '男';
        int energy = 5000;
        double price = 75.5;
        boolean relive = true;
        // 创建输出对象流的对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game.dat"));
        oos.writeUTF(name);
        oos.writeInt(age);
        oos.writeChar(gender);
        oos.writeInt(energy);
        oos.writeDouble(price);
        oos.writeBoolean(relive);
        oos.close();
    }
    @Test
    public void reload()throws IOException{
        // 创建输入对象流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("game.dat"));
        String name = ois.readUTF();
        int age = ois.readInt();
        char gender = ois.readChar();
        int energy = ois.readInt();
        double price = ois.readDouble();
        boolean relive = ois.readBoolean();
        System.out.println(name+"\n" + age + "\n" + gender + "\n" + energy + "\n" +
                price + "\n" + relive);
        ois.close();
    }
    @Test
    public void save2() throws IOException {
        Employee.setCompany("尚硅谷");
        Employee e = new Employee("小谷姐姐", "宏福苑", 23);
        // 创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream("employee.dat"));
        // 写出对象
        oos.writeObject(e);
        // 释放资源
        oos.close();
        System.out.println("Serialized data is saved"); // 姓名，地址被序列化，年龄没有被序列化。
    }
    @Test
    public void reload2() throws IOException, ClassNotFoundException {
        // 创建反序列化流
        FileInputStream fis = new FileInputStream("employee.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        // 读取一个对象
        Employee e = (Employee) ois.readObject();
        // 释放资源
        ois.close();
        fis.close();
        System.out.println(e);  // 因为static和transit修饰的无法被序列化,所以输出值是默认值
    }

    // 如果有多个对象需要序列化，则可以将对象放到集合中，再序列化集合对象即可。
    @Test
    public void save3() throws IOException {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("张三", "宏福苑", 23));
        list.add(new Employee("李四", "白庙", 24));
        list.add(new Employee("王五", "平西府", 25));
        // 创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"));
        // 写出对象
        oos.writeObject(list);
        // 释放资源
        oos.close();
    }
    @Test
    public void reload3() throws IOException, ClassNotFoundException {
        // 创建反序列化流
        FileInputStream fis = new FileInputStream("employees.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        // 读取一个对象
        ArrayList<Employee> list = (ArrayList<Employee>) ois.readObject();
        // 释放资源
        ois.close();
        fis.close();
        System.out.println(list);
    }
}

class Employee implements Serializable {
    static final long serialVersionUID = 23234234234L;  // 序列版本号, 由程序员自行指定
    public static String company; //static修饰的类变量，不会被序列化
    public String name;
    public String address;
    public transient int age; // transient瞬态修饰成员,不会被序列化
    public Employee(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public static String getCompany() {
        return company;
    }
    public static void setCompany(String company) {
        Employee.company = company;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", company=" + company +
                '}';
    }
}

class ReadWriteObject {

}