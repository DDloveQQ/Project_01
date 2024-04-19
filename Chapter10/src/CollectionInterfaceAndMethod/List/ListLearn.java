package CollectionInterfaceAndMethod.List;

import java.util.ArrayList;
import java.util.List;

// 鉴于Java中数组用来存储数据的局限性，我们通常使用java.util.List 替代数组
// JDK API中List接口的实现类常用的有： ArrayList 、LinkedList 和Vector

// List接口方法
// 插入元素
    //void add(int index, Object ele) :在index位置插入ele元素
    //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
//获取元素
    //Object get(int index) :获取指定index位置的元素
    //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
//获取元素索引
    //int indexOf(Object obj):返回obj在集合中首次出现的位置
    //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
//删除和替换元素
    //Object remove(int index) :移除指定index位置的元素，并返回此元素
    //Object set(int index, Object ele) :设置指定index位置的元素为ele

public class ListLearn {
    public static void main(String[] args) {
        // 创建List集合对象
        List<String> list = new ArrayList<String>();  // 模板指定数据类型
        // 往尾部添加指定元素
        list.add("图图");
        list.add("小美");
        list.add("不高兴");
        System.out.println(list);  // [图图, 小美, 不高兴]
        // add(int index,String s) 往指定位置添加
        list.add(1,"没头脑");
        System.out.println(list);  // [图图, 没头脑, 小美, 不高兴]
        // String remove(int index) 删除指定位置元素 返回被删除元素
        // 删除索引位置为2的元素
        System.out.println("删除索引位置为2的元素");
        System.out.println(list.remove(2));  // 小美
        System.out.println(list);  // [图图, 没头脑, 不高兴]
        // String set(int index,String s)
        // 在指定位置 进行 元素替代（改）
        // 修改指定位置元素
        list.set(0, "三毛");
        System.out.println(list);  // [三毛, 没头脑, 不高兴]
        // String get(int index) 获取指定位置元素
        // 跟size() 方法一起用 来 遍历的
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //还可以使用增强for
        for (String string : list) {
            System.out.println(string);
        }
    }
}
