package String;

import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StringApi {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //  字面量定义方式：字符串常量对象
        String str = "hello";
        //  构造器定义方式：无参构造
        String str1 = new String();
        //  构造器定义方式：创建"hello"字符串常量的副本
        String str2 = new String("hello");
        //  构造器定义方式：通过字符数组构造
        char chars[] = {'a', 'b', 'c','d','e'};
        String str3 = new String(chars); // "abcde"
        String str4 = new String(chars,0,3);  // "abc"
        //  构造器定义方式：通过字节数组构造
        byte bytes[] = {97, 98, 99 };
        String str5 = new String(bytes);
        String str6 = new String(bytes,"GBK");
        //  从字符串截取值构造
        char[] data = {'h','e','l','l','o','j','a','v','a'};
        String s1 = String.copyValueOf(data);
        String s2 = String.copyValueOf(data,0,5);
        int num = 123456;
        //  基本类型 -> 字符串
        String s3 = String.valueOf(num);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    // String相关的类型转换
    @Test
    public void test01() throws Exception {
        String str = "中国";
        System.out.println(str.getBytes("ISO8859-1").length);  // 2
        // ISO8859-1把所有的字符都当做一个byte处理，处理不了多个字节
        System.out.println(str.getBytes("GBK").length);  // 4 每一个中文都是对应2个字节
        System.out.println(str.getBytes("UTF-8").length);  // 6 常规的中文都是3个字节
        /*
         * 不乱码：（1）保证编码与解码的字符集名称一样（2）不缺字节
         */
        System.out.println(new String(str.getBytes("ISO8859-1"), "ISO8859-1"));// 乱码
        System.out.println(new String(str.getBytes("GBK"), "GBK"));// 中国
        System.out.println(new String(str.getBytes("UTF-8"), "UTF-8"));// 中国
    }

    // API-1: 常用方法
    @Test
    public void test02(){
        //将用户输入的单词全部转为小写，如果用户没有输入单词，重新输入
        Scanner input = new Scanner(System.in);
        String word;
        while(true){
            System.out.print("请输入单词：");
            word = input.nextLine();
            if(word.trim().length()!=0){
                word = word.toLowerCase();  // 将字符串中大写字母转为小写
                break;
            }
        }
        System.out.println(word);
    }
    @Test
    public void test03(){
        //随机生成验证码，验证码由0-9，A-Z,a-z的字符组成
        char[] array = new char[26*2+10];
        for (int i = 0; i < 10; i++) {
            array[i] = (char)('0' + i);
        }
        for (int i = 10,j=0; i < 10+26; i++,j++) {
            array[i] = (char)('A' + j);
        }
        for (int i = 10+26,j=0; i < array.length; i++,j++) {
            array[i] = (char)('a' + j);
        }
        String code = "";
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            code += array[rand.nextInt(array.length)];
        }
        System.out.println("验证码：" + code);
        //将用户输入的单词全部转为小写，如果用户没有输入单词，重新输入
        Scanner input = new Scanner(System.in);
        System.out.print("请输入验证码：");
        String inputCode = input.nextLine();
        if(!code.equalsIgnoreCase(inputCode)){  // 比较字符串是否相等，不区分大小写
            System.out.println("验证码输入不正确");
        }
    }

    // API-2: 查找
    @Test
    public void test04(){
        String str = "尚硅谷是一家靠谱的培训机构，尚硅谷可以说是IT培训的小清华，JavaEE是尚硅谷的当家学科，" +
                "尚硅谷的大数据培训是行业独角兽。尚硅谷的前端和UI专业一样独领风骚。";
        System.out.println("是否包含清华：" + str.contains("清华"));
        System.out.println("培训出现的第一次下标：" + str.indexOf("培训"));
        System.out.println("培训出现的最后一次下标：" + str.lastIndexOf("培训"));
    }

    // API-3: 字符串截取
    @Test
    public void test05(){
        String str = "helloworldjavaatguigu";
        String sub1 = str.substring(5);
        String sub2 = str.substring(5,10);
        System.out.println(sub1);
        System.out.println(sub2);
    }
    @Test
    public void test06(){
        String fileName = "快速学习Java的秘诀.dat";
        //截取文件名
        System.out.println("文件名：" + fileName.substring(0,fileName.lastIndexOf(".")));
        //截取后缀名
        System.out.println("后缀名：" + fileName.substring(fileName.lastIndexOf(".")));
    }

    // API-4: 和字符/字符数组相关
    @Test
    public void test07(){
        //将字符串中的字符按照大小顺序排列
        String str = "helloworldjavaatguigu";
        char[] array = str.toCharArray();  // 将此字符串转换为一个新的字符数组返回
        Arrays.sort(array);
        str = new String(array);
        System.out.println(str);
    }
    @Test
    public void test08(){
        //将首字母转为大写
        String str = "jack";
        str = Character.toUpperCase(str.charAt(0))+str.substring(1);  // 截取前后两段,前段大写,后段正常
        System.out.println(str);
    }
    @Test
    public void test09(){
        char[] data = {'h','e','l','l','o','j','a','v','a'};
        String s1 = String.copyValueOf(data);
        String s2 = String.copyValueOf(data,0,5);
        int num = 123456;
        String s3 = String.valueOf(num);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    // API-5: 开头与结尾
    @Test
    public void test1(){
        String name = "张三";
        System.out.println(name.startsWith("张"));  // 测试此字符串是否以指定的前缀开始
    }
    @Test
    public void test2(){
        String file = "Hello.txt";
        if(file.endsWith(".java")){  // 测试此字符串是否以指定的后缀结束
            System.out.println("Java源文件");
        }else if(file.endsWith(".class")){
            System.out.println("Java字节码文件");
        }else{
            System.out.println("其他文件");
        }
    }

    // API-6: 替换
    @Test
    public void test3(){
        String str1 = "hello244world.java;887";
        //把其中的非字母去掉
        str1 = str1.replaceAll("[^a-zA-Z]", "");
        // 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
        System.out.println(str1);
        String str2 = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str2.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);
    }
}
