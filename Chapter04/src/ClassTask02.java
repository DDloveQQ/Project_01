class Rectangle {
    int length;
    int width;

    public int area() {
        return length * width;
    }

    public int perimeter() {
        return 2 * (length + width);
    }

    public String getInfo() {
        return ("长: " + this.length + " 宽: " + this.width + " 面积: " + this.area() + " 周长: " + this.perimeter());
    }
}

public class ClassTask02 {
    public static void main(String[] args) {
        // 建立数组对象
        Rectangle[] rec = new Rectangle[3];

        // 实例化对象(千万别忘了)
        rec[0] = new Rectangle();  // 实例化对象0
        rec[0].length = 10;
        rec[0].width = 5;

        rec[1] = new Rectangle();  // 实例化对象1
        rec[1].length = 20;
        rec[1].width = 15;

        rec[2] = new Rectangle();  // 实例化对象2
        rec[2].length = 30;
        rec[2].width = 25;

        for (Rectangle rectangle : rec) {
            System.out.println(rectangle.getInfo());
        }

        // 方式2
//        for (int i = 0; i < rec.length; i++) {
//            //创建矩形对象
//            rec[i] = new Rectangle();
//            //为矩形对象的成员变量赋值
//            rec[i].length = (i+1) * 10;
//            rec[i].width = (2*i+1) * 5;
//            //获取并输出对象对象的信息
//            System.out.println(rec[i].getInfo());
//        }

    }
}
