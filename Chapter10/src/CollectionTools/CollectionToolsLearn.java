package CollectionTools;

import org.junit.Test;

import java.text.Collator;
import java.util.*;

public class CollectionToolsLearn {
    @Test
    public void test01() {
        /*
        public static <T> boolean addAll(Collection<? super T> c,T... elements)
        将所有指定元素添加到指定 collection 中。Collection的集合的元素类型必须>=T类型
        */
        Collection<Object> coll = new ArrayList<>();
        Collections.addAll(coll, "hello", "java");
        Collections.addAll(coll, 1, 2, 3, 4);
        Collection<String> coll2 = new ArrayList<>();
        Collections.addAll(coll2, "hello", "java");
        //Collections.addAll(coll2, 1,2,3,4);//String和Integer之间没有父子类关系
    }

    @Test
    public void test03() {
        /*
         * public static void reverse(List<?> list)
         * 反转指定列表List中元素的顺序。
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "java", "world");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    @Test
    public void test04() {
        /*
         * public static void shuffle(List<?> list)
         * List 集合元素进行随机排序，类似洗牌，打乱顺序
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "java", "world");
        Collections.shuffle(list);
        System.out.println(list);
    }

    @Test
    public void test06() {
        /*
         * public static void swap(List<?> list,int i,int j)
         * 将指定 list 集合中的 i 处元素和 j 处元素进行交换
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "java", "world");
        Collections.swap(list, 0, 2);
        System.out.println(list);
    }

    @Test
    public void test07() {
        /*
         * public static int frequency(Collection<?> c,Object o)
         * 返回指定集合中指定元素的出现次数
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "java", "world", "hello", "hello");
        int count = Collections.frequency(list, "hello");
        System.out.println("count = " + count);
    }

    @Test
    public void test08() {
        /*
        * public static <T> void copy(List<? super T> dest,List<? extends T>
        src)
        * 将src中的内容复制到dest中
        */
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {//1-5
            list.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 11; i <= 13; i++) {//11-13
            list2.add(i);
        }
        Collections.copy(list, list2);  // 从头开始覆盖
        System.out.println(list);
        List<Integer> list3 = new ArrayList<>();
        for (int i = 11; i <= 20; i++) {//11-20
            list3.add(i);
        }
        //java.lang.IndexOutOfBoundsException: Source does not fit in dest
        //Collections.copy(list, list3);
        //System.out.println(list);
    }

    @Test
    public void test09(){
        /*
         * public static <T> boolean replaceAll(List<T> list，T oldVal，T newVal)
         * 使用新值替换 List 对象的所有旧值
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"hello","java","world","hello","hello");
        Collections.replaceAll(list, "hello","song");
        System.out.println(list);
    }
}
