package Generics.Container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class GenericsTask {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(32);
        arrayList.add(27);
        arrayList.add(30);
        arrayList.add(14);
        arrayList.add(95);

        for (Integer arr : arrayList){
            System.out.println(arr);
        }

        arrayList.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer % 2 == 0) {
                    return true;
                }
                return false;
            }
        });

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
