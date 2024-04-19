package JavaMathPak;

import org.junit.Test;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Random;


public class JavaMathPakLearn {
    // BigInteger
    // java.math包的BigInteger可以表示不可变的任意精度的整数
    // 提供所有 Java 的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法
    @Test
    public void test01(){
        //long bigNum = 123456789123456789123456789L;
        BigInteger b1 = new BigInteger("12345678912345678912345678");
        BigInteger b2 = new BigInteger("78923456789123456789123456789");
        //System.out.println("和：" + (b1+b2));//错误的，无法直接使用+进行求和
        System.out.println("和：" + b1.add(b2));
        System.out.println("减：" + b1.subtract(b2));
        System.out.println("乘：" + b1.multiply(b2));
        System.out.println("除：" + b2.divide(b1));
        System.out.println("余：" + b2.remainder(b1));
    }

    // BigDecimal
    // 一般的Float类和Double类可以用来做科学计算或工程计算，但会有一定的精度损失
    // 但在商业计算中，要求数字精度比较高，故用到java.math.BigDecimal类
    @Test
    public void test02(){
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        // System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
        // divisor是除数，scale指明保留几位小数，
        // roundingMode指明舍入模式（ROUND_UP :向上加1、ROUND_DOWN :直接舍去、ROUND_HALF_UP:四舍五入）
    }

    // Random: 用于产生随机数
    @Test
    public void test04(){
        Random r = new Random();
        System.out.println("随机整数：" + r.nextInt());
        System.out.println("随机小数：" + r.nextDouble());
        System.out.println("随机布尔值：" + r.nextBoolean());
    }
}
