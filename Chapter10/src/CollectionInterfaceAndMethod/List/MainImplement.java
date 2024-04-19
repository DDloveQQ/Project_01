package CollectionInterfaceAndMethod.List;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


// 1. ArrayList
// ArrayList 是 List 接口的主要实现类
// 本质上，ArrayList是对象引用的一个”变长”数组
// Arrays.asList(…) 方法返回的 List 集合，既不是 ArrayList 实例，也不是 Vector 实例。
// Arrays.asList(…) 返回值是一个固定长度的 List 集合

// 2. LinkedList
// 对于频繁地插入或删除元素的操作，建议使用LinkedList类，效率较高。这是由底层采用链表（双
// 向链表）结构存储数据决定的。
// 特有方法：
    //void addFirst(Object obj)
    //void addLast(Object obj)
    //Object getFirst()
    //Object getLast()
    //Object removeFirst()
    //Object removeLast()

// 3. Vector
// Vector大多操作与ArrayList相同,但线程安全
// LinkedList；Vector总是比ArrayList慢，所以尽量避免使用。

public class MainImplement {
    @Test
    public void testListRemove() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//[1,2]
    }
    private static void updateList(List<Integer> list) {
        list.remove(2);  // 此处的数为index, 不是元素值
    }
}
