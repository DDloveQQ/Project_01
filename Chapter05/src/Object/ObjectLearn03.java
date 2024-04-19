package Object;

public class ObjectLearn03 {
    // clone的使用
    // 创建并返回当前对象的一个复制(与原对象地址不同,但内容相同)
    public static void main(String[] args) {
        Animal a1 = new Animal("花花");
        try {
            Animal a2 = (Animal) a1.clone();
            System.out.println("原始对象：" + a1);
            a2.setName("毛毛");
            System.out.println("clone之后的对象：" + a2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Animal implements Cloneable{
    private String name;
    public Animal() {
        super();
    }
    public Animal(String name) {
        super();
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Animal [name=" + name + "]";
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
        return super.clone();
    }
}

class FinalizeTest {
    // finaliz的使用
    // 当对象被回收时，系统(对象本身)自动调用该对象的 finalize() 方法。(类似于析构函数)
    // 在JDK9以后此方法过时
    public static void main(String[] args) {
        Person3 p = new Person3("Peter", 12);
        System.out.println(p);
        p = null;//此时对象实体就是垃圾对象，等待被回收。但时间不确定。
        System.gc();//强制性释放空间
    }
}

class Person3{
    private String name;
    private int age;
    public Person3(String name, int age) {
        super();
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
    //子类重写此方法，可在释放对象前进行某些操作
    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象被释放--->" + this);
    }
    @Override
    public String toString() {
        return "Person3 [name=" + name + ", age=" + age + "]";
    }
}