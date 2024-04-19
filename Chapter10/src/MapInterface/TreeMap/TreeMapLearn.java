package MapInterface.TreeMap;

// TreeMap存储 key-value 对时，需要根据 key-value 对进行排序。TreeMap 可以保证所有的 keyValue对处于有序状态。
// TreeSet底层使用红黑树结构存储数据
// TreeMap 的 Key 的排序：
    // 自然排序：TreeMap 的所有的 Key 必须实现 Comparable 接口，而且所有的 Key 应该是同一个类的对象，否则将会抛出 ClassCastException
    // 定制排序：创建 TreeMap 时，构造器传入一个 Comparator 对象，该对象负责对 TreeMap中的所有 key 进行排序。
    //         此时不需要 Map 的 Key 实现 Comparable 接口
//TreeMap判断两个key相等的标准：两个key通过compareTo()方法或者compare()方法返回0。

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapLearn {
    /*
     * 自然排序举例(key必须实现Comparable接口)
     * */
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        map.put("CC",45);
        map.put("MM",78);
        map.put("DD",56);
        map.put("GG",89);
        map.put("JJ",99);
        Set entrySet = map.entrySet();
        for(Object entry : entrySet){
            System.out.println(entry);
        }
    }
    /*
     * 定制排序
     *
     * */
    @Test
    public void test2(){
        //按照User的姓名的从小到大的顺序排列
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return u1.name.compareTo(u2.name);
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });
        map.put(new User("Tom",12),67);
        map.put(new User("Rose",23),"87");
        map.put(new User("Jerry",2),88);
        map.put(new User("Eric",18),45);
        map.put(new User("Tommy",44),77);
        map.put(new User("Jim",23),88);
        map.put(new User("Maria",18),34);
        Set entrySet = map.entrySet();
        for(Object entry : entrySet){
            System.out.println(entry);
        }
    }
}

class User implements Comparable{
    String name;
    int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public User() {
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    /*
    举例：按照age从小到大的顺序排列，如果age相同，则按照name从大到小的顺序排列
    * */
    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if(o instanceof User){
            User user = (User)o;
            int value = this.age - user.age;
            if(value != 0){
                return value;
            }
            return -this.name.compareTo(user.name);
        }
        throw new RuntimeException("输入的类型不匹配");
    }
}
