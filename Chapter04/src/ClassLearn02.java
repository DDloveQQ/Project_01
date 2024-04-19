
/*
 * 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。
 */
class Student {
    int number;//学号
    int state;//年级
    int score;//成绩
    public void info(){
        System.out.println("number : " + number
                + ", state : " + state + ", score : " + score);
    }
}

public class ClassLearn02 {
    public static void main(String[] args) {

        // 对象数组的创建(用对象当数组的数据类型)
        Student[] students = new Student[20];
        // 通过循环结构给数组的属性赋值
        for (int i = 0; i < students.length; i++) {
            // 数组元素的赋值
            students[i] = new Student();
            // 数组元素是一个对象，给对象的各个属性赋值
            students[i].number = (i + 1);
            students[i].state = (int) (Math.random() * 6 + 1);// [1,6]
            students[i].score = (int) (Math.random() * 101);// [0,100]
        }

        // 问题一：打印出3年级(state值为3）的学生信息。
        for (int i = 0; i < students.length; i++) {
            if (students[i].state == 3) {
                students[i].info();
            }
        }
        System.out.println("******************************");

        // 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
        // 排序前:
        for (int i = 0; i < students.length; i++) {
            students[i].info();
        }
        System.out.println();

        // 排序中(冒泡排序)：
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].score > students[j + 1].score) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    // 对象数组中元素的互换,temp也需要是相同的数据类型
                }
            }
        }
        // 排序后：
        for (int i = 0; i < students.length; i++) {
            students[i].info();
        }
    }
}