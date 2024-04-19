package String;

import org.junit.Test;

public class StringApiTask {
    // 方式一：
    public String reverse1(String str, int start, int end) {// start:2,end:5
        if (str != null) {
            // 1.
            char[] charArray = str.toCharArray();
            // 2.
            for (int i = start, j = end; i < j; i++, j--) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
            }
            // 3.
            return new String(charArray);
        }
        return null;
    }
    // 方式二：
    public String reverse2(String str, int start, int end) {
        // 1.
        String newStr = str.substring(0, start);// ab
        // 2.
        for (int i = end; i >= start; i--) {
            newStr += str.charAt(i);
        } // abfedc
        // 3.
        newStr += str.substring(end + 1);
        return newStr;
    }
    // 方式三：推荐 （相较于方式二做的改进）
    public String reverse3(String str, int start, int end) {// ArrayList list =new ArrayList(80);
        // 1.
        StringBuffer s = new StringBuffer(str.length());
        // 2.
        s.append(str.substring(0, start));// ab
        // 3.
        for (int i = end; i >= start; i--) {
            s.append(str.charAt(i));
        }
        // 4.
        s.append(str.substring(end + 1));
        // 5.
        return s.toString();
    }
    @Test
    public void testReverse() {
        String str = "abcdefg";
        String str1 = reverse3(str, 2, 5);
        System.out.println(str1);// abfedcg
    }
}
