package Packaging;

// 包装类
// 基本数据类型对应的包装类
// byte ---> Byte
// short ---> Short
// int ---> Integer
// long ---> Long
// float ---> Float
// double ---> Double
// 以上六种包装类的父类为Number

// boolean ---> Boolean
// char ---> Characters

public class PackagingLearn {
    public static void main(String[] args) {
        // 基本数据类型转字符串
        int a = 10;
        // 方法1: 调用字符串重载的valueOf()方法
        String str = String.valueOf(a);
        // 方法2:(更直接的方式)
        String str2 = a + "";

        // 包装类的其他API
        // 1. 数据类型的最大最小值
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // 2. 字符转大小写
        System.out.println(Character.toUpperCase('x'));
        System.out.println(Character.toLowerCase('X'));

        // 3. 整数转进制
        System.out.println(Integer.toBinaryString(a));  // 二进制
        System.out.println(Integer.toHexString(a));  // 十六进制
        System.out.println(Integer.toOctalString(a));  // 八进制

        // 4. 比较的方法
        System.out.println(Integer.compare(10, 12));  // -1
        System.out.println(Integer.compare(20, 12));  // 1

        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);  //1.0

        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//
    }
}

// 自定义包装类
class MyInteger {
    int value;
    public MyInteger() {
    }
    public MyInteger(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}


