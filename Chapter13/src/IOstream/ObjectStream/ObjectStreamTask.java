package IOstream.ObjectStream;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamTask {
    @Test
    public void Save() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Files/save.bin"));
        List<Orders> list = new ArrayList<>();
        list.add(new Orders("可乐", 3, 10));
        list.add(new Orders("薯片", 5, 5));
        list.add(new Orders("糖果", 1, 50));
        oos.writeObject(list);
        oos.close();
        System.out.println("订单生成完毕");
    }

    @Test
    public void Load() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Files/save.bin"));
        List<Orders> list = (ArrayList<Orders>) ois.readObject();
        int sum = 0;
        for (Orders orders : list) {
            sum += orders.getPrice() * orders.getNumber();
        }
        ois.close();
        System.out.println(list);
        System.out.println("订单总价" + sum);
    }
}

class Orders implements Serializable {
    private String name;
    private int price;
    private int number;

    public Orders(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return name + "\t\t" + price + "\t\t" + number + "\n";
    }
}