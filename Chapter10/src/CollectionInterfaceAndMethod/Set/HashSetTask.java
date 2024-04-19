package CollectionInterfaceAndMethod.Set;

import java.util.Objects;
import org.junit.Test;
import java.util.HashSet;
import java.util.Scanner;

public class HashSetTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Character> hashSet = new HashSet<Character>();

        System.out.println("请输入内容: ");
        String in = scanner.next();

        char[] arr = in.toCharArray();

        for (char c : arr) {
            hashSet.add(c);
        }
        System.out.println(hashSet);
    }
}
