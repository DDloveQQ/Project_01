package Generics.Wildcard;

import java.util.ArrayList;
import java.util.List;

// 当我们声明一个变量/形参时，这个变量/形参的类型是一个泛型类或泛型接口，例如：Comparator类型,
// 但是我们仍然无法确定这个泛型类或泛型接口的类型变量的具体类型，此时我们考虑使用类型通配符

// 比如： List<?> ， Map<?,?>
// List<?> 是List<String> 、List<Object> 等各种泛型List的父类。

public class WildcardLearn {
    public static void main(String[] args) {
        List<?> list = null;
        list = new ArrayList<String>();
        list = new ArrayList<Double>();
        // list.add(3);//编译不通过
        list.add(null);
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        l1.add("尚硅谷");
        l2.add(15);
        read(l1);
        read(l2);
    }
    public static void read(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
