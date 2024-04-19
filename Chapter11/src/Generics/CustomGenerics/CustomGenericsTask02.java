package Generics.CustomGenerics;

import java.util.Arrays;

public class CustomGenericsTask02 {
    public static <E> void method01 (E[] e, int a, int b) {
        E temp;
        temp = e[a];
        e[a] = e[b];
        e[b] = temp;
    }

    public static void main(String[] args) {
        String[] strings = new String[] {"1", "2", "3", "4", "5"};
        method01(strings, 0, 3);
        System.out.println(Arrays.toString(strings));
    }
}
