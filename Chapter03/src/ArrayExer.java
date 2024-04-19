
public class ArrayExer {
    // 数组赋值
    public static void main(String[] args) {
        //(1)创建一个名为ArrayTest的类，在main()方法中声明array1和array2两个变量，他们是int[]类型的数组。
        int[] array1,array2;
        //(2)使用大括号{}，把array1初始化为8个素数：2,3,5,7,11,13,17,19。
        array1 = new int[]{2,3,5,7,11,13,17,19};
        //(3)显示array1的内容。
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        //(4)赋值array2变量等于array1，修改array2中的偶索引元素，使其等于索引值(如array[0]=0,array[2]=2)。
        array2 = array1;

        for (int i = 0; i < array2.length; i++) {
            if (i % 2 == 0){
                array2[i] = i;
            }
        }

        System.out.println(); //换行
        System.out.println(array1);  // [I@4dd8dc3
        System.out.println(array2);  // [I@4dd8dc3

        // 打印出array1。
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
    }
    // 解释: array1 和 array2 是两个变量，共同指向了堆空间中的同一个数组结构，即二者的地址值相同
    // 因此对array2中元素的改变也会直接影响到array1
}

class ArrayExer02 {
    // 数组复制
    public static void main(String[] args) {
        //(1)创建一个名为ArrayTest的类，在main()方法中声明array1和array2两个变量，他们是int[]类型的数组。
        int[] array1,array2;
        //(2)使用大括号{}，把array1初始化为8个素数：2,3,5,7,11,13,17,19。
        array1 = new int[]{2,3,5,7,11,13,17,19};
        //(3)显示array1的内容。
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        //(4)复制array1数组给array2，修改array2中的偶索引元素，使其等于索引值(如array[0]=0,array[2]=2)。
        array2 = new int[array1.length];

        // 使用遍历的方式一个个复制array1中的元素到array2
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }

        System.out.println(); //换行
        System.out.println(array1);
        System.out.println(array2);

        for (int i = 0; i < array2.length; i++) {
            if (i % 2 == 0){
                array2[i] = i;
            }
        }
        // 打印出array1。
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        // 解释: array2是new出来的,并且使用了遍历复制的方法,因此两个数组相互独立
    }
}

class ArrayExer03 {
    public static void main(String[] args) {

        int[] arr = new int[]{23,55,78,45,84,95};

        //遍历
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        //反转操作
        //方式1：数组劈两半,遍历前面的去依次替换后面的
/*        for (int i = 0; i < arr.length / 2; i++) {
            //交换 arr[i] 与 arr[arr.length - i - 1] 位置的元素
            int temp = arr[i];
            arr[i] = arr[arr.length  - 1 - i];
            arr[arr.length - 1 - i ] = temp;
        }*/

        //方式2：与方式1的思想类似,但是双向进行,不需要计算被调换位置的索引数
        for (int i = 0 , j = arr.length -1; i < j ; i++,j--) {
            //交换 arr[i] 与 arr[j] 位置的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


/*      //方式3： 创建一个新数组(不推荐,因为空间占用和遍历次数翻倍了,且面对大规模的数组时效率低下)
        int[] newArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0 ; i--) {
            newArr[arr.length -1 -i] = arr[i];
        }
        arr = newArr;
*/

        //遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}

class ArrayExer04 {
    // 数组扩容(不能在原数组上扩容,只能新建更大的数组)
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        //扩容1倍容量
        int[] newArr = new int[arr.length * 2];
        // 或
        // int[] newArr1 = new int[arr.length << 1];

        //将原有数组中的元素复制到新的数组中
        for (int i = 0; i < arr.length; i++) {

            newArr[i] = arr[i];
        }

        //将10,20,30三个数据添加到新的数组中
        newArr[arr.length] = 10;
        newArr[arr.length + 1] = 20;
        newArr[arr.length + 2] = 30;

        //将新的数组的地址赋值给原有的数组变量
        arr = newArr;

        //遍历arr
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}

class ArrayExer05 {
    // 数组缩容(删除某一索引指定的元素)
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};

        int deleteIndex  = 4;

/*      //方式1：不新建数组,用后面的数向前覆盖
        for (int i = deleteIndex; i < arr.length -1; i++) {
            arr[i] = arr[i +1];
        }
        //最后的元素，设置为默认值0
        arr[arr.length -1] = 0;*/

        //方式2：新建数组，新的数组长度比原有数组的长度少一个
        int[] newArr = new int[arr.length -1];
        // deleteIndex之前的移植
        for (int i = 0; i < deleteIndex; i++) {
            newArr[i] = arr[i];
        }
        // deleteIndex之后的移植
        for (int i = deleteIndex; i < arr.length -1; i++) {
            newArr[i] = arr[i + 1];
        }

        arr = newArr;

        //遍历arr数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
