public class ArrayAlgorithm {
    public static void main(String[] args) {
        // 1. 动态初始化方式创建数组
        int[] arr = new int[10];

        // 2. 通过循环给数组元素赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (99 - 10 + 1)) + 10;
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        // 3. 求最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("数组最大值: " + max);

        // 4. 求最小值
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println("数组最小值: " + min);

        // 5. 求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("数组总和: " + sum);

        // 6. 平均值
        int average = sum / arr.length;
        System.out.println("平均值: " + average);
    }
}

class ArrayAlgorithm02 {
    public static void main(String[] args) {
        int n = 7;
        int[][] arr = new int[n][n];

        int count = 0;
        int xMax = n - 1;
        int yMax = n - 1;
        int xMin = 0;
        int yMin = 0;

        while (xMin <= xMax){
            for (int x = xMin; x <= xMax; x++){
                arr[yMin][x] = ++count;
            }
            yMin++;
            for (int y = yMin; y <= yMax; y++){
                arr[y][xMax] = ++count;
            }
            xMax--;
            for (int x = xMax; x >= xMin; x--){
                arr[yMax][x] = ++count;
            }
            yMax--;
            for (int y = yMax; y >= yMin; y--){
                arr[y][xMin] = ++count;
            }
            xMin++;
        }
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length;j++) {
                String space = (arr[i][j]+"").length()==1 ? " ":"";
                System.out.print(space+arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
