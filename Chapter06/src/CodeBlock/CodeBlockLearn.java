package CodeBlock;
// 代码块
// 作用: 对Java类或对象进行初始化
// 分类: 一个类中代码块若有修饰符，则只能被static修饰，称为静态代码块(static block)
//      没有使用static修饰的，为非静态代码块。
public class CodeBlockLearn {
}

// 静态代码块
// 特点:
//  1. 可以有输出语句。
//  2. 可以对类的属性、类的声明进行初始化操作。
//  3. 不可以对非静态的属性初始化。即：不可以调用非静态的属性和方法。
//  4. 若有多个静态的代码块，那么按照从上到下的顺序依次执行。
//  5. 静态代码块的执行要先于非静态代码块。
//  6. 静态代码块随着类的加载而加载，且只执行一次。
class Chinese {
    // private static String country = "中国";
    private static String country;
    private String name;
    // 代码块前不加static,则是非静态代码块(优先级低,但是每次创建对象时就会执行一次,且先于构造器)
    {
        System.out.println("非静态代码块，country = " + country);
    }
    // 代码块前加static,则是静态代码块(他的优先级比非静态更高,因此要先执行,但只执行一次)
    static {
        country = "中国";  // 可以对类的属性、类的声明进行初始化操作。
        System.out.println("静态代码块");
    }
    public Chinese(String name) {
        this.name = name;
    }
}

class TestStaticBlock {
    public static void main(String[] args) {
        Chinese c1 = new Chinese("张三");
        Chinese c2 = new Chinese("李四");
        // 静态代码块随着类的加载而加载, 且只执行一次, 因此第二次不会再输出"静态代码块"
    }
}

// 非静态代码块
// 特点:
//  1. 可以有输出语句。
//  2. 可以对类的属性、类的声明进行初始化操作。
//  3. 除了调用非静态的结构外，还可以调用静态的变量或方法。
//  4. 若有多个非静态的代码块，那么按照从上到下的顺序依次执行。
//  5. 每次创建对象的时候，都会执行一次。且先于构造器执行。

class User {
    private String username;
    private String password;
    private long registrationTime;

    // 将构造函数中的公共代码提取至非静态代码块,便可以在构造函数运行前运行代码块中的内容
    // 这样便可以提高代码的复用性,减少代码量
    {
        System.out.println("新用户注册");
        registrationTime = System.currentTimeMillis();
    }

    public User() {
//        System.out.println("新用户注册");
//        this.registrationTime = System.currentTimeMillis();
        username = registrationTime + "";
        password = "123456";
    }
    public User(String username,String password) {
//        System.out.println("新用户注册");
//        registrationTime = System.currentTimeMillis();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getRegistrationTime() {
        return registrationTime;
    }
    public String getInfo() {
        return "用户名：" + username + "，密码：" + password + "，注册时间：" + registrationTime;
    }
}

class UserTest{
    public static void main(String[] args) {
        User u1 = new User();
        System.out.println(u1.getInfo());
        User u2 = new User("song","8888");
        System.out.println(u2.getInfo());
    }
}

// 总结: 实例变量赋值顺序
// 1. 声明成员变量的默认初始化 (public int i)
// 2. 显示初始化, 多个初始化代码块按照级别依次执行(public int j = 0) ---> ({ ... })
// 3. 构造器初始化 (** () { ... })
// 4. 通过"对象.属性"或"对象.方法"多次给属性赋值
