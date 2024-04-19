package CollectionInterfaceAndMethod.TreeSetTAsk;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Employee e1 = new Employee("Tom", 23, new MyDate(1999, 7, 9));
        Employee e2 = new Employee("Rose",43,new MyDate(1999,7,19));
        Employee e3 = new Employee("Jack",54,new MyDate(1998,12,21));
        Employee e4 = new Employee("Jerry",12,new MyDate(2002,4,21));
        Employee e5 = new Employee("Tony",22,new MyDate(2001,9,12));

//        TreeSet<Employee> treeSet = new TreeSet<Employee>();
//        treeSet.add(e1);
//        treeSet.add(e2);
//        treeSet.add(e3);
//        treeSet.add(e4);
//        treeSet.add(e5);
//
//        Iterator iterator = treeSet.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        MyComparator myComparator = new MyComparator();
        TreeSet<Employee> treeSet = new TreeSet(myComparator);

        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
//        }
        }
    }
}


class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Employee && o2 instanceof Employee) {
            Employee e1 = (Employee) o1;
            Employee e2 = (Employee) o2;
            MyDate birthday1 = e1.getBirthday();
            MyDate birthday2 = e2.getBirthday();

            return birthday1.compareTo(birthday2);
        }
        throw new RuntimeException("输入的类型不匹配");
    }
}