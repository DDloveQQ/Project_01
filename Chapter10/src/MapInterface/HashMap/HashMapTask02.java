package MapInterface.HashMap;

import java.util.HashMap;

public class HashMapTask02 {
    public static void main(String[] args) {
        String str = "aaaabbbcccccccccc";
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for (char c : arr) {
            if (hm.containsKey(c)) {
                hm.put(c, (hm.get(c) + 1));
            } else {
                hm.put(c, 1);
            }
        }
        // 传统方法(如果输入不确定就不能用了)
//        System.out.println("字符a出现的次数: " + hm.get('a'));
//        System.out.println("字符b出现的次数: " + hm.get('b'));
//        System.out.println("字符c出现的次数: " + hm.get('c'));

        // 遍历HashMap方法
        for (Object key : hm.keySet()) {  // 创建Object(Character也行)对象key, 用于接收hm的key集合(keySet)
            System.out.println("字符" + key + "出现的次数: " + hm.get(key));
        }
    }
}
