public class OtherTask {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();  //总毫秒数  从1970年1月1日开始计算

        for (int i = 2; i < 100000; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
            // 解释: 如果数c不是素数，则说明还有其他因子,假设为a,b,那么其中必有一个大于sqrt(c) ，一个小于sqrt(c)
            //      所以素数必有一个小于或等于其平方根的因数，那么验证素数时就只需要验证到其平方根就可以了
            //      如此一来,时间复杂度便从O(n)降到了O(√n)
            //      实际运行时间: 老方法->628ms, 新方法->20ms
            // for (int j = 2; j < i; j++) {
                if (i % j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "毫秒");
    }
}

