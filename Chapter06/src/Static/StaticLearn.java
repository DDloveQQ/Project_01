package Static;
// 被Static修饰的成员具有以下特点:
    // 随着类的加载而加载
    // 优先于对象存在
    // 修饰的成员，被所有对象所共享
    // 访问权限允许时，可不创建对象，直接被类调用
public class StaticLearn {
    public static void main(String[] args) {
        Chinese c1 = new Chinese("康师傅",36);
        c1.nation = "中华人民共和国";  // 类变量调用方式1(不推荐)
        Chinese c2 = new Chinese("老干妈",66);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(Chinese.nation);  // 类变量调用方式2(推荐)
    }
}

class Chinese {
    //实例变量(存储在堆区)
    String name;
    int age;
    //类变量(存储在方法区)
    static String nation;//国籍

    public Chinese() {
    }

    public Chinese(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Chinese{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                '}';
    }
}

class Employee {
    private static int total;//这里私有化，在类的外面必须使用get/set方法的方式来访问静态变量
    static String company; //这里缺省权限修饰符，是为了方便类外以“类名.静态变量”的方式访问
    private int id;
    private String name;
    public Employee() {
        total++;
        id = total;//这里使用total静态变量的值为id属性赋值
    }
    public Employee(String name) {
        this();
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // 静态方法
    // 静态方法在本类的任意方法、代码块、构造器中都可以直接被调用。
    // 只要权限修饰符允许，静态方法在其他类中可以通过“类名.静态方法“的方式调用。也可以通过”对象.静态方法“的方式调用（但是更推荐使用类名.静态方法的方式）。
    // 在static方法内部只能访问类的static修饰的属性或方法，不能访问类的非static的结构。
    // 静态方法可以被子类继承，但不能被子类重写。
    // 静态方法的调用都只看编译时类型。
    // 因为不需要实例就可以访问static方法，因此static方法内部不能有this，也不能有super。如果有重名问题，使用“类名.”进行区别。
    public static int getTotal() {
        return total;
    }
    public static void setTotal(int total) {
        Employee.total = total;
    }
    @Override
    public String toString() {
        return "Employee{company = " + company + ",id = " + id + " ,name=" +
                name +"}";
    }
}

class TestStaticVariable {
    public static void main(String[] args) {
//静态变量total的默认值是0
        System.out.println("Employee.total = " + Employee.getTotal());
        Employee e1 = new Employee("张三");
        Employee e2 = new Employee("李四");
        System.out.println(e1);//静态变量company的默认值是null
        System.out.println(e2);//静态变量company的默认值是null
        System.out.println("Employee.total = " + Employee.getTotal());//静态变量total值是2
        Employee.company = "尚硅谷";
        System.out.println(e1);//静态变量company的值是尚硅谷
        System.out.println(e2);//静态变量company的值是尚硅谷
        //只要权限修饰符允许,虽然不推荐，但是也可以通过“对象.静态变量”的形式来访问
        e1.company = "超级尚硅谷";
        System.out.println(e1);//静态变量company的值是超级尚硅谷
        System.out.println(e2);//静态变量company的值是超级尚硅谷
    }
}

class StaticTest {
    public static void main(String[] args) {
        Demo test = null;
        test.hello();
    }
}
class Demo{
    public static void hello(){
        System.out.println("hello!");
    }
}



