package Abnormal;

public class ManualException {
    public static void main(String[] args) {
        try {
            System.out.println(max(4,2,31,1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(max(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(max());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int max(int... nums){
        if(nums == null || nums.length==0){
            // 手动抛出异常 IllegalArgumentException( <Exception )
            throw new IllegalArgumentException("没有传入任何整数，无法获取最大值");
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}

///////////////////////////////////////////////////////////////////
//////// 如何定义一个自定义异常类:
//////// 1. 要继承一个异常类型
//////// 2. 提供至少两个构造器(无参构造和string message构造)
//////// 3. 自定义异常需要提供serialVersionUID
///////////////////////////////////////////////////////////////////
//////// 注意:
//////// 1. 自定义的异常只能通过throw抛出。
//////// 2. 自定义异常最重要的是异常类的名字和message属性
//////// 3. 自定义异常对象只能手动抛出。抛出后由try..catch处理，也可以甩锅throws给调用者处理
///////////////////////////////////////////////////////////////////

class MyException extends Exception {
    static final long serialVersionUID = 23423423435L;
    private int id_error;
    public MyException(String message, int id) {
        super(message);
        this.id_error = id;
    }
    public int getId() {
        return id_error;
    }
}
class MyExpTest {
    public void regist(int num) throws MyException {
        if (num < 0)
            throw new MyException("人数为负值，不合理", 3);
        else
            System.out.println("登记人数" + num);
    }

    public void manager() {
        try {
            regist(100);
        } catch (MyException e) {
            System.out.println("登记失败，错误代码: " + e.getId());
        } finally {
            System.out.print("本次登记操作结束");
        }

    }

    public static void main(String args[]) {
        MyExpTest t = new MyExpTest();
        t.manager();
    }
}