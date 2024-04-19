package CollectionInterfaceAndMethod.Set;

import org.junit.Test;
import java.util.LinkedHashSet;

// LinkedHashSet 是 HashSet 的子类，不允许集合元素重复。
// LinkedHashSet 根据元素的 hashCode 值来决定元素的存储位置，但它同时使用双向链表维护元素的次序，
// 这使得元素看起来是以添加顺序保存的。
// LinkedHashSet 插入性能略低于 HashSet，但在迭代访问 Set 里的全部元素时有很好的性能。

public class LinkedHashSetLearn {

    @Test
    public void test01(){
        LinkedHashSet set = new LinkedHashSet();
        set.add("张三");
        set.add("张三");
        set.add("李四");
        set.add("王五");
        set.add("王五");
        set.add("赵六");
        System.out.println("set = " + set);//不允许重复，体现添加顺序
    }
}
