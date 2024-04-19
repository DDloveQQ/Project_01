package Stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class StackLearn {
    /*
     * 测试Stack
     * */
    @Test
    public void test1() {
        Stack<Integer> list = new Stack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        System.out.println("list = " + list);
        System.out.println("list.peek()=" + list.peek());
        System.out.println("list.peek()=" + list.peek());
        System.out.println("list.peek()=" + list.peek());
        /*
        System.out.println("list.pop() =" + list.pop());
        System.out.println("list.pop() =" + list.pop());
        System.out.println("list.pop() =" + list.pop());
        System.out.println("list.pop() =" +
        list.pop());//java.util.NoSuchElementException
        */
        while (!list.empty()) {
            System.out.println("list.pop() =" + list.pop());
        }
    }

    /*
     * 测试LinkedList
     * */
    @Test
    public void test2() {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        System.out.println("list = " + list);
        System.out.println("list.peek()=" + list.peek());
        System.out.println("list.peek()=" + list.peek());
        System.out.println("list.peek()=" + list.peek());
        /*
        System.out.println("list.pop() =" + list.pop());
        System.out.println("list.pop() =" + list.pop());
        System.out.println("list.pop() =" + list.pop());
        System.out.println("list.pop() =" +
        list.pop());//java.util.NoSuchElementException
        */
        while (!list.isEmpty()) {
            System.out.println("list.pop() =" + list.pop());
        }
    }
}
