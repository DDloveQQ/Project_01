package Generics.Container;

import org.junit.Test;

import java.util.*;

// Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。
// 即，把不安全的因素在编译期间就排除了，而不是运行期；既然通过了编译，那么类型一定是符合要求的，就避免了类型转换。
// 同时，代码更加简洁、健壮。

public class GenericsLearn {
    //泛型在List中的使用
    @Test
    public void test1(){
        //举例：将学生成绩保存在ArrayList中
        //标准写法：
        //ArrayList<Integer> list = new ArrayList<Integer>();
        //jdk7的新特性：类型推断
        ArrayList<Integer> list = new ArrayList<>();
        list.add(56); //自动装箱
        list.add(76);
        list.add(88);
        list.add(89);
        //当添加非Integer类型数据时，编译不通过
        //list.add("Tom");//编译报错
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            //不需要强转，直接可以获取添加时的元素的数据类型
            Integer score = iterator.next();
            System.out.println(score);
        }
    }

    //泛型在Map中的使用
    @Test
    public void test2(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Tom",67);
        map.put("Jim",56);
        map.put("Rose",88);
        //编译不通过
        // map.put(67,"Jack");
        //遍历key集
        Set<String> keySet = map.keySet();
        for(String str:keySet){
            System.out.println(str);
        }
        //遍历value集
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        while(iterator.hasNext()){
            Integer value = iterator.next();
            System.out.println(value);
        }
        //遍历entry集
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Map.Entry<String, Integer> entry = iterator1.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }
}
