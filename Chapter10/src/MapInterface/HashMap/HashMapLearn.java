package MapInterface.HashMap;

import java.util.*;

import org.junit.Test;

// HashMap是 Map 接口使用频率最高的实现类。
// HashMap是线程不安全的。允许添加 null 键和 null 值。
// 存储数据采用的哈希表结构，底层使用一维数组+ 单向链表+ 红黑树进行key-value数据的存储。
// 与HashSet一样，元素的存取顺序不能保证一致。
// HashMap 判断两个key相等的标准是：两个 key 的hashCode值相等，通过 equals() 方法返回true。
// HashMap 判断两个value相等的标准是：两个 value 通过 equals() 方法返回 true。

// 案例: 使用HashSet和HashMap添加你喜欢的歌手以及你喜欢他唱过的歌曲
public class HashMapLearn {
    @Test
    // 方式1: HashSet + HashMap
    public void test1() {
        Singer singer1 = new Singer("周杰伦");
        Singer singer2 = new Singer("陈奕迅");
        Song song1 = new Song("双节棍");
        Song song2 = new Song("本草纲目");
        Song song3 = new Song("夜曲");
        Song song4 = new Song("浮夸");
        Song song5 = new Song("十年");
        Song song6 = new Song("孤勇者");
        HashSet<Song> h1 = new HashSet<Song>();// 存放歌手一的歌曲
        h1.add(song1);
        h1.add(song2);
        h1.add(song3);
        HashSet<Song> h2 = new HashSet<Song>();// 寸放歌手二的歌曲
        h2.add(song4);
        h2.add(song5);
        h2.add(song6);
        HashMap<Singer, HashSet<Song>> hashMap = new HashMap<>();// 存放歌手和他对应的歌曲, 键为歌手姓名,值为存放歌手歌曲的HashSet
        hashMap.put(singer1, h1);
        hashMap.put(singer2, h2);
        for (Object obj : hashMap.keySet()) {
            System.out.println(obj + "=" + hashMap.get(obj));  // 输出方式: 歌手=[歌曲1, 歌曲2, 歌曲3, ...]
        }
    }

    // 方式2: HashMap
    public static void main(String[] args) {
        //创建一个HashMap用于保存歌手和其歌曲集
        HashMap singers = new HashMap();

        //声明一组key,value
        String singer1 = "周杰伦";
        ArrayList<String> songs1 = new ArrayList<String>();
        songs1.add("双节棍");
        songs1.add("本草纲目");
        songs1.add("夜曲");
        songs1.add("稻香");

        //添加到map中
        singers.put(singer1,songs1);

        //声明一组key,value
        String singer2 = "陈奕迅";
        List<String> songs2 = Arrays.asList("浮夸", "十年", "红玫瑰", "好久不见", "孤勇者");

        //添加到map中
        singers.put(singer2,songs2);

        //遍历map
        Set entrySet = singers.entrySet();  // 获得map的entry(Set类型)
        for(Object obj : entrySet){
            Map.Entry entry = (Map.Entry)obj;  // Set向下转型为Map.Entry
            String singer = (String) entry.getKey();  // 键向下转型为String
            List songs = (List) entry.getValue();  // 值向下转型为List
            System.out.println("歌手：" + singer);
            System.out.println("歌曲有：" + songs);
        }
    }
}

//歌曲
class Song implements Comparable {
    private String songName;//歌名

    public Song() {
        super();
    }

    public Song(String songName) {
        super();
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String toString() {
        return "《" + songName + "》";
    }

    @Override
    public int compareTo(Object o) {
        if (o == this) {
            return 0;
        }
        if (o instanceof Song) {
            Song song = (Song) o;
            return songName.compareTo(song.getSongName());
        }
        return 0;
    }
}

//歌手
class Singer implements Comparable {
    private String name;
    private Song song;

    public Singer() {
        super();
    }

    public Singer(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        if (o == this) {
            return 0;
        }
        if (o instanceof Singer) {
            Singer singer = (Singer) o;
            return name.compareTo(singer.getName());
        }
        return 0;
    }
}