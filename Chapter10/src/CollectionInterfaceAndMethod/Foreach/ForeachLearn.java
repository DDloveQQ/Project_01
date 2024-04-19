package CollectionInterfaceAndMethod.Foreach;

// foreach循环（也称增强for循环）是 JDK5.0 中定义的一个高级for循环，专门用来遍历数组和集合
// 它用于遍历Collection和数组。通常只进行遍历元素，不要在遍历的过程中对集合元素进行增删操作。
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;

public class ForeachLearn {
    @Test
    public void test01(){
        Collection coll = new ArrayList();
        coll.add("小李广");
        coll.add("扫地僧");
        coll.add("石破天");
        //foreach循环其实就是使用Iterator迭代器来完成元素的遍历的。
        for (Object o : coll) {
            System.out.println(o);
        }
    }
    @Test
    public void test02(){
        int[] nums = {1,2,3,4,5};
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("-----------------");
        String[] names = {"张三","李四","王五"};
        for (String name : names) {
            System.out.println(name);
        }
    }

    // 练习: 判断输出结果
    @Test
    public static void main(String[] args) {
        String[] str = new String[5];  // string的默认值是null
        for (String myStr : str) {
            myStr = "atguigu";
            System.out.println(myStr);  // 5个atguigu, 因为要循环5次
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);  // 5个null, 因为循环5次且str未赋值
        }
    }
}
