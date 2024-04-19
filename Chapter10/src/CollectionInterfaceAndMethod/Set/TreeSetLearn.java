package CollectionInterfaceAndMethod.Set;

import org.junit.Test;
import java.util.Iterator;
import java.util.TreeSet;

// TreeSet 是 SortedSet 接口的实现类，TreeSet 可以按照添加的元素的指定的属性的大小顺序进行遍历。
// TreeSet底层使用红黑树结构存储数据
// TreeSet特点：不允许重复、实现排序（自然排序或定制排序）
// TreeSet 两种排序方法： 自然排序和定制排序。默认情况下，TreeSet 采用自然排序。
    // 自然排序: TreeSet 会调用集合元素的 compareTo(Object obj) 方法来比较元素之间的大小关系，
            // 然后将集合元素按升序(默认情况)排列。
    // 定制排序: 如果元素所属的类没有实现Comparable接口，或不希望按照升序(默认情况)的方
            //式排列元素或希望按照其它属性大小进行排序，则考虑使用定制排序。定制排序，通过
            //Comparator接口来实现。需要重写compare(T o1,T o2)方法。

public class TreeSetLearn {
    /*
    * 自然排序：针对String类的对象
    */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        set.add("MM");
        set.add("CC");
        set.add("AA");
        set.add("DD");
        set.add("ZZ");
        //set.add(123); //报ClassCastException的异常
        Iterator iterator = set.iterator();  // 获取迭代器对象
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    /*
     * 自然排序：针对User类的对象
     * */
    @Test
    public void test2(){
        TreeSet set = new TreeSet();
        set.add(new User("Tom",12));
        set.add(new User("Rose",23));
        set.add(new User("Jerry",2));
        set.add(new User("Eric",18));
        set.add(new User("Tommy",44));
        set.add(new User("Jim",23));
        set.add(new User("Maria",18));
        //set.add("Tom");
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(set.contains(new User("Tom", 12))); //true
    }
}

class User implements Comparable{
    String name;
    int age;
    public User() {
    }
    public User(String name, int age) {
        this.name = name;
        this.age = age;
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
