package Object;

public class ObjectLearn02 {
    public static void main(String[] args) {
        // 2. toString()
        // 默认情况下,toString()返回的是“对象的运行时类型 @ 对象的hashCode值的十六进制形式"
        // 在进行String与其它类型数据的连接操作时，自动调用toString()方法
        // 如果我们直接System.out.println(对象)，默认会自动调用这个对象的toString()
        Date now = new Date();
        System.out.println("now="+now); //自动调用toString() "now=Object.Date@682a0b20"
        System.out.println("now="+now.toString()); // "now=Object.Date@682a0b20"

        // 可以根据需要在用户自定义类型中重写toString()方法
        Person2 person = new Person2("张三", 10);

        System.out.println(person);
        // 重写前: Object.Person2@214c265e
        // 重写后: Person2{name='张三', age=10}
    }
}

class Date {
}

class Person2 {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    手动重写toString
//    @Override
//    public String toString() {
//        return "Person2{" + "name='" + name + '\'' + ", age=" + age + '}';
//    }

    // 自动重写toString
    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}