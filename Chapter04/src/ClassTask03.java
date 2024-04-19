
public class ClassTask03 {

}

class MathTools {
    //求两个整数的最大值
    public int max(int a,int b){
        return Math.max(a, b);
    }
    //求两个小数的最大值
    public double max(double a, double b){
        return Math.max(a, b);
    }
    //求三个整数的最大值
    public int max(int a, int b, int c){
        return max(max(a,b),c);
    }
    //求n个整数的最大值
    public int max(int... nums){
        int max = nums[0];//如果没有传入整数，或者传入null，这句代码会报异常
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
    /* //求n整数的最大值
    public int max(int[] nums){ //编译就报错，与(int... nums)无法区分
        int max = nums[0];//如果没有传入整数，或者传入null，这句代码会报异常
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }*/

    /* //求n整数的最大值
    public int max(int first, int... nums){ //当前类不报错，但是调用时会引起多个方法同时匹配
        int max = first;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }*/
}

class ArrayTypeParam {
    //冒泡排序，实现数组从小到大排序
    public void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //打印数组的元素
    public void print(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayTypeParam tools = new ArrayTypeParam();
        int[] nums = {4,3,1,6,7};
        System.out.println("排序之前：");
        tools.print(nums);
        tools.sort(nums);//对nums数组进行排序(数组也属于引用传递,传入的是数组首元素的地址,因此形参变化会影响实参)
        System.out.println("排序之后：");
        tools.print(nums);//输出nums数组的元素
    }
}


//栈：每个方法在调用时，都会有以栈帧的方法压入栈中。栈帧中保存了当前方法中声明的变量：方法内声明的，形参
//堆：存放new出来的"东西"：对象（成员变量在对象中）、数组实体（数组元素）。
//注意：变量前如果声明有类型，那么这就是一个新的刚要定义的变量。如果变量前没有声明类型，那就说明此变量在之前已经声明过。
class TransferTest {
    public static void main(String args[]) {
        TransferTest test = new TransferTest();
        test.first();
    }
    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i); // 20
    }
    public void second(Value v, int i) {
        i = 0;  // i是值传递,所以实参不受影响
        v.i = 20;  // v是引用传递,所以实参受影响
        Value val = new Value();
        v = val;
        // 将 v 这个引用变量指向了一个新的 Value 对象 val，
        // 而原始的 v 对象引用仍然指向 first() 方法中创建的对象
        // 尽管在 second() 方法内部 v 的指向发生了变化，
        // 但这个变化只在 second() 方法的作用域内有效。
        System.out.println(v.i + " " + i);  // 15  0
    }
}
class Value {
    int i = 15;
}

class TransferTest02 {
    public static void main(String[] args) {
        PassObject passObject = new PassObject();
        Circle circle = new Circle();
        System.out.println("Radius" + "\t\t" + "Area");
        passObject.printAreas(circle, 5);
    }
}
class Circle {
    double radius;
    public double findArea() {
        return Math.PI * radius * radius;
    }
}
class PassObject {
    public void printAreas(Circle c, int time) {
        for ( double i = 1.0; i <= time; i++) {
            c.radius = i;
            System.out.println(i + "\t\t" + c.findArea());
        }
    }
}

class RecursionTask {
    public int fibonacci (int num){
        if (num < 1) {
            return 1;
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        return fibonacci(num - 2) + fibonacci(num - 1);
    }

    public static void main(String[] args) {
        RecursionTask recursionTask = new RecursionTask();
        System.out.println(recursionTask.fibonacci(10));
    }
}

class RecursionTask02 {
    private int count = 0;
    public int recursion(int k) {
        count++;
        System.out.println("count1:" + count + " k:" + k);
        if (k <= 0) {
            return 0;
        }
        return recursion(k - 1) + recursion(k - 2);//287
        //return recursion(k - 1);//11
        //return recursion(k - 1) + recursion(k - 1);//2047
    }

    public static void main(String[] args) {
        RecursionTask02 recursionTask02 = new RecursionTask02();
        System.out.println(recursionTask02.recursion(10));
    }
}