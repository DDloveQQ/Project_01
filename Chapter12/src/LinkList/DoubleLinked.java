package LinkList;

import java.util.Iterator;

public class DoubleLinked {
    public static void main(String[] args) {
        MyLinkedList<String> my = new MyLinkedList<>();
        my.add("hello");
        my.add("world");
        my.add(null);
        my.add(null);
        my.add("java");
        my.add("java");
        my.add("atguigu");
        System.out.println("一共有：" + my.size());
        System.out.println("所有元素：");
        for (String s : my) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------");
        System.out.println("查找java,null,haha的结果：");
        System.out.println(my.contains("java"));
        System.out.println(my.contains(null));
        System.out.println(my.contains("haha"));
        System.out.println("-------------------------------------");
        System.out.println("替换java,null后：");
        my.update("java", "JAVA");
        my.update(null, "songhk");
        System.out.println("所有元素：");
        for (String s : my) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------");
        System.out.println("删除hello，JAVA,null，atguigu后：");
        my.delete("hello");
        my.delete("JAVA");
        my.delete(null);
        my.delete("atguigu");
        System.out.println("所有元素：");
        for (String s : my) {
            System.out.println(s);
        }
    }
}

// 双链表结点
class dNode<E> {
    dNode prev;
    E data;
    dNode next;

    dNode(dNode prev, E data, dNode next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

/**
 * 链表类(双向链表)
 *
 * @author 尚硅谷-宋红康
 * @create 15:05
 */
class MyLinkedList<E> implements Iterable<E> {
    private dNode first; //链表的首元素
    private dNode last; //链表的尾元素
    private int total;

    public void add(E e) {
        dNode newNode = new dNode(last, e, null);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        total++;
    }

    public int size() {
        return total;
    }

    public void delete(Object obj) {
        dNode find = findNode(obj);
        if (find != null) {
            if (find.prev != null) {
                find.prev.next = find.next;
            } else {
                first = find.next;
            }
            if (find.next != null) {
                find.next.prev = find.prev;
            } else {
                last = find.prev;
            }
            find.prev = null;
            find.next = null;
            find.data = null;
            total--;
        }
    }

    private dNode findNode(Object obj) {
        dNode node = first;
        dNode find = null;
        if (obj == null) {
            while (node != null) {
                if (node.data == null) {
                    find = node;
                    break;
                }
                node = node.next;
            }
        } else {
            while (node != null) {
                if (obj.equals(node.data)) {
                    find = node;
                    break;
                }
                node = node.next;
            }
        }
        return find;
    }

    public boolean contains(Object obj) {
        return findNode(obj) != null;
    }

    public void update(E old, E value) {
        dNode find = findNode(old);
        if (find != null) {
            find.data = value;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    // 内部类
    private class Itr implements Iterator<E> {
        private dNode<E> node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E value = node.data;
            node = node.next;
            return value;
        }
    }
}