package InnerClass;

public class InnerClassTask {
}

////////////////////////////////////////////////////
class Test_A {
    public Test_A() {
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        s2.a = 20;
        Test_A.Inner s3 = new Test_A.Inner();
        System.out.println(s3.a);  // 5
    }
    class Inner {
        public int a = 5;
    }
    public static void main(String[] args) {
        Test_A t = new Test_A();
        Inner r = t.new Inner();
        System.out.println(r.a);  // 5
    }
}
////////////////////////////////////////////////////
class Test_b {
    public static void main(String[] args) {
        new Object(){
            public void test(){
                System.out.println("123123");
            }
        }.test();
    }
}