package MapInterface.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// LinkedHashMap 是 HashMap 的子类
// 存储数据采用的哈希表结构+链表结构，在HashMap存储结构的基础上，使用了一对双向链表来记
// 录添加元素的先后顺序，可以保证遍历元素时，与添加的顺序一致。
// 通过哈希表结构可以保证键的唯一、不重复，需要键所在类重写hashCode()方法、equals()方法。
public class LinkedHashMapLearn {
    public static void main(String[] args) {
        LinkedHashMap<String, Double> map = new LinkedHashMap<String, Double>();
        map.put("王五", 13000.0);
        map.put("张三", 10000.0);
        //key相同，新的value会覆盖原来的value
        //因为String重写了hashCode和equals方法
        map.put("张三", 12000.0);
        map.put("李四", 14000.0);
        //HashMap支持key和value为null值
        String name = null;
        Double salary = null;
        map.put(name, salary);

        // 使用Set类型接收entrySet并向下转型为Map.Entry以实现遍历
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry);
        }
    }
}
