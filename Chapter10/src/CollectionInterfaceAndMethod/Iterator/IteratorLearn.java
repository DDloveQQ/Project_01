package CollectionInterfaceAndMethod.Iterator;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;


// Collection接口与Map接口主要用于存储元素
// Iterator，主要用于遍历Collection中的元素

// Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，
// 那么所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象。
    // public Iterator iterator() : 获取集合对应的迭代器，用来遍历集合中的元素的。
    // 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
// Iterator接口的常用方法如下:
    // public E next() :返回迭代的下一个元素。
    // public boolean hasNext() :如果仍有元素可以迭代，则返回 true。

// 注意：在调用it.next()方法之前必须要调用it.hasNext()进行检测。
// 若不调用，且下一条记录无效，直接调用it.next()会抛出NoSuchElementException异常。
public class IteratorLearn {
    @Test
    public void test01(){
        Collection coll = new ArrayList();
        coll.add("小李广");
        coll.add("扫地僧");
        coll.add("石破天");
        Iterator iterator = coll.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next()); //报NoSuchElementException异常, 因为下一条记录无效
    }
    @Test
    public void test02(){
        Collection coll = new ArrayList();
        coll.add("小李广");
        coll.add("扫地僧");
        coll.add("石破天");
        Iterator iterator = coll.iterator();//获取迭代器对象
        while(iterator.hasNext()) {//判断是否还有元素可迭代
            System.out.println(iterator.next());//取出下一个元素
        }
    }

    // 迭代器删除元素
    @Test
    public void test03(){
        Collection coll = new ArrayList();
        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(4);
        coll.add(5);
        coll.add(6);
        Iterator iterator = coll.iterator();  // 获取迭代器对象
        while(iterator.hasNext()){
            Integer element = (Integer) iterator.next();  // 数据强转为Integer
            if(element % 2 == 0){
                iterator.remove();
            }
        }
        System.out.println(coll);
    }

    // JDK8.0后, collection中条件删除方法
    @Test
    public void test04(){
        Collection coll = new ArrayList();
        coll.add("小李广");
        coll.add("扫地僧");
        coll.add("石破天");
        coll.add("佛地魔");
        System.out.println("coll = " + coll);
        coll.removeIf(new Predicate() {  // 匿名对象重写方法并作为形参传入
            @Override
            public boolean test(Object o) {
                String str = (String) o;
                return str.contains("地");
            }
        });
        System.out.println("删除包含\"地\"字的元素之后coll = " + coll);
    }
}
