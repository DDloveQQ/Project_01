package StringBB;

import org.junit.Test;

//  因为String对象是不可变对象，虽然可以共享常量对象，但是对于频繁字符串的修改和拼接操作，效率极低，空间消耗也比较高。
//  因此，JDK又在java.lang包提供了可变字符序列StringBuffer和StringBuilder类型。

//  StringBuffer: 可变的字符序列；线程安全（方法有synchronized修饰），效率低；底层使用char[]数组存储 (JDK8.0中)
//  StringBuilder: 可变的字符序列； jdk1.5引入，线程不安全的，效率高；底层使用char[]数组存储(JDK8.0中)
//  两者API完全一致, 很多方法与String相同

public class StringBB {
    @Test
    public void test1(){
        StringBuilder s = new StringBuilder();
        s.append("hello").append(true).append('a').append(12).append("atguigu");
        System.out.println(s);
        System.out.println(s.length());
    }
    @Test
    public void test2(){
        StringBuilder s = new StringBuilder("helloworld");
        s.insert(5, "java");
        s.insert(5, "chailinyan");
        System.out.println(s);
    }
    @Test
    public void test3(){
        StringBuilder s = new StringBuilder("helloworld");
        s.delete(1, 3);
        s.deleteCharAt(4);
        System.out.println(s);
    }
    @Test
    public void test4(){
        StringBuilder s = new StringBuilder("helloworld");
        s.reverse();
        System.out.println(s);
    }
    @Test
    public void test5(){
        StringBuilder s = new StringBuilder("helloworld");
        s.setCharAt(2, 'a');
        System.out.println(s);
    }
    @Test
    public void test6(){
        StringBuilder s = new StringBuilder("helloworld");
        s.setLength(30);  // 设置当前字符序列长度为newLength(默认值用null 补齐)
        System.out.println(s);
    }

    public static void main(String[] args) {
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));  // 1
        /////////////////////////////////////////////////////////////////////////////////

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));  // 1
        /////////////////////////////////////////////////////////////////////////////////

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));  // 129
        /////////////////////////////////////////////////////////////////////////////////

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);  // 插入的不是空值null,而是"null"(字符串!!!)
        System.out.println(sb.length());    // "null"的长度为4
        System.out.println(sb); // "null"(字符串!!!)
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);  //输出不出来,因为sb1中的值是空值null
    }
}
