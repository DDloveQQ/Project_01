package CollectionInterfaceAndMethod.Set;

import java.util.Objects;
import org.junit.Test;
import java.util.HashSet;

// Set接口是Collection的子接口，Set接口相较于Collection接口没有提供额外的方法
// Set 集合不允许包含相同的元素，如果试把两个相同的元素加入同一个 Set 集合中，则添加操作失败。
// Set集合支持的遍历方式和Collection集合一样：foreach和Iterator。
// Set的常用实现类有：HashSet、TreeSet、LinkedHashSet。

// 1. HashSet
// HashSet添加元素
class Mydate {
    private int year;
    private int month;
    private int day;
    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    // 对于存放在Set容器中的对象，对应的类一定要重写hashCode()和equals(Object obj)方法，以实现对象相等规则
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mydate myDate = (Mydate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }
    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +'}';
    }
}

public class HashSetLearn {
    @Test
    public void test01(){
        HashSet<String> set = new HashSet<String>();
        set.add("张三");
        set.add("张三");  // 重复了不会报错,但Hashset中只有一个
        set.add("李四");
        set.add("王五");
        set.add("王五");
        set.add("赵六");
        System.out.println("set = " + set);//不允许重复，无序
    }
    @Test
    public void test02(){
        HashSet set = new HashSet();
        set.add(new Mydate(2021,1,1));
        set.add(new Mydate(2021,1,1));
        set.add(new Mydate(2022,2,4));
        set.add(new Mydate(2022,2,4));
        System.out.println("set = " + set);//不允许重复，无序
    }
}

