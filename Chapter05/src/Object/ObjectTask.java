package Object;

import java.util.Objects;

public class ObjectTask {
    public static void main(String[] args) {
        int it = 65;
        float fl = 65.0f;
        System.out.println("65和65.0f是否相等？" + (it == fl)); // true  因为65.0f可以自动类型转换为(int)65
        char ch1 = 'A'; char ch2 = 12;
        System.out.println("65和'A'是否相等？" + (it == ch1)); // true  'A'可以自动类型转换为(int)65
        System.out.println("12和ch2是否相等？" + (12 == ch2)); // true!!
        // 注意! 12对应的ASCii码值为FF, 直接输出ch2时虽然显示的是FF,但在与(int)12进行比较时依然会自动转换回原先的int类型

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("str1和str2是否相等？"+ (str1 == str2)); // false 因为两者并没有指向同一个对象
        System.out.println("str1是否equals str2？"+(str1.equals(str2))); // true 因为String重写了equals方法,使其可以比较两个string的内容

//      System.out.println("hello" == new java.util.Date()); // 报错, 因为两边类型不同,且无自动类型转换

        Order order1 = new Order(10, "张三");
        Order order2 = new Order(10, "张三");
        Order order3 = new Order(15, "张三");

        System.out.println(order1.equals(order2));  // true(重写equals后)
        System.out.println(order1.equals(order3));  // false(重写equals后)
    }
}

class Order {
    private int orderId;
    private String orderName;

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }
    public String getOrderName() {
        return orderName;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }


//    @Override
//    手动实现equals重写
//    public boolean equals(Object obj) {
//        if(this == obj) {
//            return true;
//        }
//        if (obj instanceof Order) {
//            Order order = (Order) obj;  // Obj -> Order: 向下转型
//            return this.orderId == order.orderId && this.orderName.equals(order.orderName);
//        }
//        return false;
//    }

    // IDEA自动实现equals重写 (快捷键 Alt+Ins, 前提是注解之前手动重写的equals())
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Objects.equals(orderName, order.orderName);
    }

}

class EqualsTest {
    public static void main(String[] args) {
        MyDate m1 = new MyDate(14, 3, 1976);
        MyDate m2 = new MyDate(14, 3, 1976);
        if (m1 == m2) {
            System.out.println("m1==m2");
        } else {
            System.out.println("m1!=m2"); // m1 != m2
        }
        if (m1.equals(m2)) {
            System.out.println("m1 is equal to m2");// m1 is equal to m2
        } else {
            System.out.println("m1 is not equal to m2");
        }
    }
}
class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

//    手动重写equals()
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj instanceof MyDate) {
//            MyDate myDate = (MyDate) obj;
//            return myDate.year == this.year && myDate.month == this.month && myDate.day == this.day;
//        }
//        return false;
//    }

    // 自动重写equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

}
