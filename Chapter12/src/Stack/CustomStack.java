package Stack;

public class CustomStack {
    // 向栈当中存储元素，我们这里使用一维数组模拟。存到栈中，就表示存储到数组中。
    // 为什么选择Object类型数组？因为这个栈可以存储java中的任何引用类型的数据
    private Object[] elements;
    // 栈帧，永远指向栈顶部元素
    // 那么这个默认初始值应该是多少。注意：最初的栈是空的，一个元素都没有。
    //private int index = 0; // 如果index采用0，表示栈帧指向了顶部元素的上方。
    //private int index = -1; // 如果index采用-1，表示栈帧指向了顶部元素。
    private int index;

    /**
     * 无参数构造方法。默认初始化栈容量10.
     */
    public CustomStack() {
        // 一维数组动态初始化
        // 默认初始化容量是10.
        this.elements = new Object[10];
        // 给index初始化
        this.index = -1;
    }

    /**
     * 压栈的方法
     *
     * @param obj 被压入的元素
     */
    public void push(Object obj) throws Exception {
        if (index >= elements.length - 1) {
            //方式1：
            //System.out.println("压栈失败，栈已满！");
            //return;
            //方式2：
            throw new Exception("压栈失败，栈已满！");
        }
        // 程序能够走到这里，说明栈没满
        // 向栈中加1个元素，栈帧向上移动一个位置
        index++;
        elements[index] = obj;
        System.out.println("压栈" + obj + "元素成功，栈帧指向" + index);
    }

    /**
     * 弹栈的方法，从数组中往外取元素。每取出一个元素，栈帧向下移动一位。
     *
     * @return
     */
    public Object pop() throws Exception {
        if (index < 0) {
            //方式1：
            //System.out.println("弹栈失败，栈已空！");
            //return;
            //方式2：
            throw new Exception("弹栈失败，栈已空！");
        }
        // 程序能够执行到此处说明栈没有空。
        Object obj = elements[index];
        System.out.print("弹栈" + obj + "元素成功，");
        elements[index] = null;
        // 栈帧向下移动一位。
        index--;
        return obj;
    }

    // set和get也许用不上，但是你必须写上，这是规矩。你使用IDEA生成就行了。
    // 封装：第一步：属性私有化，第二步：对外提供set和get方法。
    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
