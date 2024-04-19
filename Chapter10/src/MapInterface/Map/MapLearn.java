package MapInterface.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

// Map与Collection并列存在。用于保存具有映射关系的数据：key-value(键值对)
// Map 中的 key 和 value 都可以是任何引用类型的数据。但常用String类作为Map的“键”。
// Map接口的常用实现类： HashMap 、LinkedHashMap 、TreeMap 和`Properties 。
// 其中，HashMap是 Map 接口使用频率最高的实现类。


// Map 中的 key用Set来存放,不允许重复
// 同一个 Map 对象所对应的类，须重写hashCode()和equals()方法
// 不同key对应的value可以重复。value所在的类要重写equals()方法。

// key和value构成一个entry。所有的entry彼此之间是无序的、不可重复的。

// Map接口常用的方法(增删改查)
public class MapLearn {

    public static void main(String[] args) {
        //创建 map对象
        HashMap map = new HashMap();
        //添加元素到集合(map用的是put,而非add)
        map.put("黄晓明", "杨颖");
        map.put("李晨", "李小璐");
        map.put("李晨", "范冰冰");  // 键相同但值不同,则更新值
        map.put("邓超", "孙俪");
        System.out.println(map);  // 后put的先输出,先put的后输出
        //删除指定的key-value
        System.out.println(map.remove("黄晓明"));  // 删除key的同时会返回对应的value
        System.out.println(map);
        //查询指定key对应的value
        System.out.println(map.get("邓超"));
        System.out.println(map.get("黄晓明"));  // 没有则返回null
    }
}

// Map接口常用的方法(元视图)
class MapLearn02 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("许仙", "白娘子");
        map.put("董永", "七仙女");
        map.put("牛郎", "织女");
        map.put("许仙", "小青");
        System.out.println("所有的key:");
        Set keySet = map.keySet();  // 创建类型为Set的对象来接收map的key集合
        for (Object key : keySet) {
            System.out.println(key);  // 许仙, 董永, 牛郎 (先进先出顺序)
        }
        System.out.println("所有的value:");
        Collection values = map.values();  // 创建类型为Collection的对象来接收map的value集合
        for (Object value : values) {
            System.out.println(value);  // 小青, 七仙女, 织女 (先进先出顺序)
        }
        System.out.println("所有的映射关系:");
        Set entrySet = map.entrySet();
        for (Object mapping : entrySet) {
            System.out.println(mapping);  // 输出方式: key = value
            Map.Entry entry = (Map.Entry) mapping;  // key和value构成一个entry, 所以将mapping向下转型为entry,以此来调用其中的方法
            System.out.println(entry.getKey() + "->" + entry.getValue());  // 输出方式: key -> value
        }
    }
}