package String;

import org.junit.Test;

public class StringLearn01 {
    @Test
    public void test01(){
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = s1 + "world";  // s4字符串内容也helloworld，s1是变量，"world"常量，变量 + 常量的结果在堆中
        String s5 = s1 + s2;  // s5字符串内容也是helloworld，s1和s2都是变量，变量 + 变量的结果在堆中
        String s6 = "hello" + "world";// 常量 + 常量 结果在常量池中，因为编译期间就可以确定结果
        System.out.println(s3 == s4);  // false(池 != 堆)
        System.out.println(s3 == s5);  // false(池 != 堆)
        System.out.println(s3 == s6);  // true(池 == 池)
    }
    @Test
    public void test02(){
        final String s1 = "hello";  // final修饰后变为常量
        final String s2 = "world";
        String s3 = "helloworld";
        String s4 = s1 + "world";  //s4字符串内容也helloworld，s1是常量，"world"常量，常量 + 常量结果在常量池中
        String s5 = s1 + s2;  //s5字符串内容也helloworld，s1和s2都是常量，常量 + 常量 结果在常量池中
        String s6 = "hello" + "world";//常量 + 常量 结果在常量池中，因为编译期间就可以确定结果
        System.out.println(s3 == s4);  //true
        System.out.println(s3 == s5);  //true
        System.out.println(s3 == s6);  //true
    }
    @Test
    public void test03(){
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = (s1 + "world").intern();  // 把拼接的结果放到常量池中
        String s5 = (s1 + s2).intern();  // 把拼接的结果放到常量池中
        System.out.println(s3 == s4);  //true
        System.out.println(s3 == s5);  //true
    }

    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////////

        String s1_1 = "hello";
        String s1_2 = "hello";
        // s1, s2共享方法区的字符串常量池中“Hello”元素
        System.out.println(s1_1 == s1_2);  // true
        // 内存中只有一个"hello"对象被创建，同时被s1和s2共享。

        /////////////////////////////////////////////////////////////////

        Person p1 = new Person();
        Person p2 = new Person();
        // p1和p2存在于堆区
        p1.name = "Tom";
        p2.name = "Tom";
        // p1和p2的name("Tom")共享在字符串常量池

        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == p2.name); // true
        System.out.println(p1.name == "Tom"); // true

        /////////////////////////////////////////////////////////////////

        String s2_1 = "javaEE";
        String s2_2 = "javaEE";
        // s2_1, s2_2存在字符串常量池

        String s2_3 = new String("javaEE");
        String s2_4 = new String("javaEE");
        // s2_3, s2_4是String对象, 存在于堆区, 其值存在于字符串常量池

        System.out.println(s2_1 == s2_2);  //true
        System.out.println(s2_1 == s2_3);  //false
        System.out.println(s2_1 == s2_4);  //false
        System.out.println(s2_3 == s2_4);  //false

        /////////////////////////////////////////////////////////////////

        String s3_1 = "hello";
        String s3_2 = "world";
        String s3_3 = "hello" + "world";  // 字符串常量池中不允许出现相同的字符串,因此拼接字符串时要在常量池建立新的空间
        String s3_4 = s3_1 + "world";  // 常量与变量 或 变量与变量拼接后的结果在堆中
        String s3_5 = s3_1 + s3_2;  // 常量与变量 或 变量与变量拼接后的结果在堆中
        String s3_6 = (s3_1 + s3_2).intern();  // 拼接后调用intern方法会将返回值存储在字符串常量池中
        String s3_7 = "hello".concat("world");  // concat方法拼接，哪怕是两个常量对象拼接，结果也是在堆。
        // 堆空间的s3_1对象在调用intern()之后，会将常量池中已经存在的"ab"字符串赋值给s4。
        System.out.println(s3_3 == s3_4);  // false (字符串常量池和堆不是一个位置)
        System.out.println(s3_3 == s3_5);  // false (字符串常量池和堆不是一个位置)
        System.out.println(s3_4 == s3_5);  // false (虽然值相同,但在堆区的位置不同)
        System.out.println(s3_3 == s3_6);  // true  (两者值相同且都在常量池中,因为字符串常量池中不允许出现相同的字符串, 所以两者必然相等)
        System.out.println(s3_7 == s3_6);  // false (字符串常量池和堆不是一个位置)
    }
}

class Person {
    String name;
}

class StringTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {
        str = "test ok";  // 值传递,不改变实参
        ch[0] = 'b';    // 地址传递,改变实参(test -> best)
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//
        System.out.println(ex.ch);
    }
}
