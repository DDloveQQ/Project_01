package CodeBlock;

public class CodeBlockTask {

}
//////////////////////////////////////////////////////////////
// 分析加载顺序1.0
class Root{
    static{
        System.out.println("Root的静态初始化块");  // 1
    }
    {
        System.out.println("Root的普通初始化块");  // 4
    }
    public Root(){
        System.out.println("Root的无参数的构造器");  // 5
    }
}
class Mid extends Root{
    static{
        System.out.println("Mid的静态初始化块");  // 2
    }
    {
        System.out.println("Mid的普通初始化块");  // 6
    }
    public Mid(){
        System.out.println("Mid的无参数的构造器");  // 7
    }
    public Mid(String msg){
        //通过this调用同一类中重载的构造器
        this();
        System.out.println("Mid的带参数构造器，其参数值："  // 8
                + msg);
    }
}
class Leaf extends Mid{
    static{
        System.out.println("Leaf的静态初始化块");  // 3
    }
    {
        System.out.println("Leaf的普通初始化块");  // 9
    }
    public Leaf(){
        //通过super调用父类中有一个字符串参数的构造器
        super("尚硅谷");
        System.out.println("Leaf的构造器");   // 10
    }
}
class LeafTest{
    public static void main(String[] args){
        new Leaf();
        // 总结:
        // 1. 静态代码块优先级最高,在程序开始时便执行,甚至快于主程序代码,顺序从上至下
        // 2. 非静态代码块次之, 但须在父类构造函数结束后才能执行
        // 3. 构造函数最后执行,且无参构造优先于带参构造
    }
}

//////////////////////////////////////////////////////////////
// 分析加载顺序2.0
class Father {
    static {
        System.out.println("11111111111");  // 1
    }
    {
        System.out.println("22222222222");  // 5  // 10  // 15
    }
    public Father() {
        System.out.println("33333333333");  // 6  // 11  // 16
    }
}
class Son extends Father {
    static {
        System.out.println("44444444444");  // 2
    }
    {
        System.out.println("55555555555");  // 7  // 12
    }
    public Son() {
        System.out.println("66666666666");  // 8  // 13
    }
    public static void main(String[] args) {
        System.out.println("77777777777");  // 3
        System.out.println("************************");  // 4
        new Son();
        System.out.println("************************");  // 9
        new Son();
        System.out.println("************************");  // 14
        new Father();
    }
}

//////////////////////////////////////////////////////////////
// 分析加载顺序3.0

// 运行顺序:
// 父类静态显示初始化 -> 父类静态代码块 -> 子类静态显示初始化 -> 子类静态代码块 ->
// 父类非静态显示初始化 -> 父类非静态代码块 -> 父类构造器 ->
// 子类非静态显示初始化 -> 子类非静态代码块 -> 子类构造器

// 总结:
// static > 非static
// 显示初始化 > 代码块
// 父类 > 子类
class Test04 {
    public static void main(String[] args) {
        Zi zi = new Zi();
    }
}

class Fu{
    private static int i = getNum("（1）i");  // 1 （1）i->0
    private int j = getNum("（2）j");  // 5 （2）j->1
    static{
        print("（3）父类静态代码块");  // 2 （3）父类静态代码块->1
    }
    {
        print("（4）父类非静态代码块，又称为构造代码块");  // 6 （4）父类非静态代码块，又称为构造代码块->2
    }
    Fu(){
        print("（5）父类构造器");  // 7 （5）父类构造器->2
    }
    public static void print(String str){
        System.out.println(str + "->" + i);
    }
    public static int getNum(String str){
        print(str);
        return ++i;
    }
}
class Zi extends Fu{
    private static int k = getNum("（6）k");  // 3 （6）k->0
    private int h = getNum("（7）h");  // 8 （7）h->1
    static{
        print("（8）子类静态代码块");  // 4 （8）子类静态代码块->1
    }
    {
        print("（9）子类非静态代码块，又称为构造代码块");  // 9 （9）子类非静态代码块，又称为构造代码块->2
    }
    Zi(){
        print("（10）子类构造器");  // 10 （10）子类构造器->2
    }
    public static void print(String str){
        System.out.println(str + "->" + k);
    }
    public static int getNum(String str){
        print(str);
        return ++k;
    }
}