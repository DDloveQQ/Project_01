public class ClassLearn03 {
    // 方法重载
    public int max(int a, int b) {
        return Math.max(a, b);
    }

    public double max(double a, double b) {
        return Math.max(a, b);
    }

    public double max(double a, double b, double c) {
        return Math.max(max(a, b), c);
    }

    public static void main(String[] args) {
        ClassLearn03 cl03 = new ClassLearn03();
        System.out.println(cl03.max(5, 10));
        System.out.println(cl03.max(5.0, 9.5));
        System.out.println(cl03.max(5.0, 9.5, 15.0));
    }
}

class VarargsLearn {
    // 可变个数形参机制(JDK5.0新特性)
    // 格式: 方法名(参数的类型名... 参数名), 此时的参数可以认为是一个长度不定的数组
    // 而传入参数时,无需将传入量转化为数组,而是直接逗号隔开即可
    String concat(String... args){
        String str = "";
        for (int i = 0; i < args.length; i++) {
            if(i==0){
                str += args[i];  // 如果是首部string,则不需加拼接符"-",直接加输入内容args
            }else{
                str += '-' + args[i];  // 如果非首部字符,则先加加拼接符"-",再加输入内容args
            }
        }
        return str;
    }

    public static void main(String[] args) {
        VarargsLearn tools = new VarargsLearn();
        System.out.println(tools.concat());
        System.out.println(tools.concat("hello"));
        System.out.println(tools.concat("hello","world"));
        System.out.println(tools.concat("hello","world","java"));
    }
}

class ParameterPassing {
    // 参数传递
    public void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }

    public void swap(Data data) {
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        ParameterPassing PP = new ParameterPassing();
        System.out.println(m + " " + n);
        PP.swap(m, n);  // 基本数据类型 ---> 值传递 ---> 传入的实参不受影响
        System.out.println(m + " " + n);

        Data data = new Data();
        data.m = 10;
        data.n = 20;
        System.out.println(data.m + " " + data.n);
        PP.swap(data);  // 引用数据类型 ---> 地址传递 ---> 传入的实参受影响
        System.out.println(data.m + " " + data.n);
    }
}

class Data{
    int m;
    int n;
}

class RecursionLearn {
    // 在要求高性能的情况下尽量避免使用递归，递归调用既花时间又耗内存。考虑使用循环迭代

    public static void main(String[] args) {
        RecursionLearn demo = new RecursionLearn();
        //计算1~num的和，使用递归完成
        int num = 5;
        // 调用求和的方法
        int sum = demo.getSum(num);
        // 输出结果
        System.out.println(sum);
    }
    /*
    通过递归算法实现.
    参数列表:int
    返回值类型: int
    */
    public int getSum(int num) {
        /*
        num为1时,方法返回1,
        相当于是方法的出口,num总有是1的情况
        */
        if(num == 1){
            return 1;
        }
        /*
        num不为1时,方法返回 num +(num-1)的累和
        递归调用getSum方法
        */
        return num + getSum(num-1);
    }
}