
public class ArrayFind {
    // 查找数组元素
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,1,17,34,2,5,12,15,9};

        int target = 5;

/*      //方式1：线性查找(一个一个的遍历,直到找到元素)
            优点：算法简单
            缺点：效率低。执行的时间复杂度0（n）
        boolean isFlag = true;
        for (int i = 0; i < arr.length ; i++) {
            if (target == arr[i] ){
                System.out.println("找到了" + target + "，对应位置为:" + i);
                isFlag = false;
                break;
            }
        }
        if (isFlag){
            System.out.println("不好意思，没有找到此元素");
        }*/

        // 方式1增强版
        int i = 0;
        for (; i < arr.length; i++) {
            if (target == arr[i]){
                System.out.println("找到了" + target + "，对应位置为:" + i);
                break;
            }
        }

        if (i == arr.length){
            System.out.println("不好意思，没有找到此元素");
        }
    }
}

class ArrayFind02 {
    // 查找数组元素----二分查找法
    // 优点：执行效率高
    // 缺点：算法相对于顺序查找难一点，前提，数组必须有序
    public static void main(String[] args) {
        int[] arr = {4,5,6,1,25,34,12,15,9};
        int target = 5;
        int head = 0; //默认的首索引
        int end = arr.length -1; //默认的尾索引
        boolean isFlag = true; //判断是否找到了指定元素

        while (head <= end){
            int middle = (head + end) / 2;
            if (target == arr[middle]){
                System.out.println("找到了" + target + ",对应的位置为：" + middle);
                isFlag = false;
                break;
            }else if (target > arr[middle]){
                head = middle + 1; // 若小了,则将头移到middle,舍弃middle前的部分
            }else {
                end = middle - 1; // 若大了,则将尾移到middle,舍弃middle后的部分
            }
        }

        if (isFlag){
            System.out.println("不好意思，没有找到");
        }
    }
}





