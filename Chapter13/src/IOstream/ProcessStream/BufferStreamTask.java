package IOstream.ProcessStream;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class BufferStreamTask {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(new File("src/Files/name.txt")));
            String line;
            StringBuffer buffer = new StringBuffer();  // 可变长度的String
            flag:
            while ((line = br.readLine()) != null) {
                char[] chars = line.toCharArray();
                for (char aChar : chars) {
                    if (aChar != ' ') {
                        buffer.append(aChar);  // 使用这种方法来处理两个字的性
                    } else {
                        if (hashMap.containsKey(buffer.toString())) {
                            int count = hashMap.get(buffer.toString());
                            hashMap.put(buffer.toString(), ++count);
                        } else {
                            hashMap.put(buffer.toString(), 1);
                        }
                        buffer.delete(0, buffer.length());  //清空buffer以迎接下一姓氏
                        continue flag;  //回到设立的continue标识点，开始检索下一行
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 一般输出方式
        System.out.println(hashMap);

        // 挨个输出方式
        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();  // 用Set接收hashMap的键值对set
        for (Map.Entry<String, Integer> end : set) {
            System.out.println(end);
        }
    }
}
