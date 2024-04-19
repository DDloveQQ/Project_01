package Generics.CustomGenerics;


// 方法，也可以被泛型化，与其所在的类是否是泛型类没有关系。
// 泛型方法中的泛型参数在方法被调用时确定。
// 泛型方法可以根据需要，声明为static的。

import java.util.ArrayList;
import java.util.Collection;

// [访问权限] <泛型> 返回值类型 方法名([泛型标识 参数名称]) [抛出的异常]{
// }
public class CustomGenericsLearn02 {

}

class DAO {
    public <E> E get(int id, E e) {
        E result = null;
        return result;
    }
    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
    }
    public static void main(String[] args) {
        Object[] ao = new Object[100];
        Collection<Object> co = new ArrayList<Object>();
        fromArrayToCollection(ao, co);
        String[] sa = new String[20];
        Collection<String> cs = new ArrayList<>();
        fromArrayToCollection(sa, cs);
        Collection<Double> cd = new ArrayList<>();
        // 下面代码中T是Double类，但sa是String类型，编译错误。
        // fromArrayToCollection(sa, cd);
        // 下面代码中T是Object类型，sa是String类型，可以赋值成功。
        fromArrayToCollection(sa, co);
    }
}


