import java.util.*;
import java.util.function.ToIntFunction;

public class Task {
}

class PokerTest {
    public static void main(String[] args) {
        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] color = {"方片", "梅花", "红桃", "黑桃"};
        HashMap<Integer, String> map = new HashMap<>(); // 存储索引和扑克牌
        ArrayList<Integer> list = new ArrayList<>(); // 存储索引
        int index = 0;

        // 造牌
        for (String s1 : num) {
            for (String s2 : color) {
                list.add(index);
                map.put(index, s2 + s1);
                index++;
            }
        }
        list.add(index);
        map.put(index, "小王");
        index++;
        list.add(index);
        map.put(index, "大王");

        // 洗牌
        Collections.shuffle(list);

        // 发牌(将牌存入TreeSet中会自动排序)
        TreeSet<Integer> tomCards = new TreeSet<>();
        TreeSet<Integer> jerryCards = new TreeSet<>();
        TreeSet<Integer> myCards = new TreeSet<>();
        TreeSet<Integer> lastCards = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            // 这里只把每张牌的索引号输入,就是为了方便后续对每个人手牌进行排序后展示
            if (list.size() - i <= 3) {
                lastCards.add(list.get(i));
            }
            if (i % 3 == 0) {
                tomCards.add(list.get(i));
            } else if (i % 3 == 1) {
                jerryCards.add(list.get(i));
            } else {
                myCards.add(list.get(i));
            }
        }

        PokeLooker("Tom", tomCards, map);
        PokeLooker("Jerry", jerryCards, map);
        PokeLooker("Me", myCards, map);
        PokeLooker("Last", lastCards, map);

    }

    public static void PokeLooker (String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.println(name + "的牌是: ");
        for (Integer index : ts) {
            System.out.print(hm.get(index) + " ");
        }
        System.out.println();
    }
}


