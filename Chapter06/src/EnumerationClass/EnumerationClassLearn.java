package EnumerationClass;

import java.util.Scanner;
public class EnumerationClassLearn {
}

// 枚举类
// 枚举类型本质上也是一种类，只不过是这个类的对象是有限的、固定的几个，不能让用户随意创建。
// 例如: 星期, 季节, 性别......
// 若枚举只有一个对象, 则可以作为一种单例模式的实现方式。

// 定义枚举类
class Season{
    private final String SEASONNAME;//季节的名称
    private final String SEASONDESC;//季节的描述
    private Season(String seasonName,String seasonDesc){  // 1. 私有化构造器, 保证不能在类的外部创建其对象
        this.SEASONNAME = seasonName;
        this.SEASONDESC = seasonDesc;
    }
    // 2. 在类的内部创建枚举类的实例。声明为： public static final ，对外暴露这些常量对象
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "白雪皑皑");
    @Override
    public String toString() {
        return "Season{" +
                "SEASONNAME='" + SEASONNAME + '\'' +
                ", SEASONDESC='" + SEASONDESC + '\'' +
                '}';
    }
}
class SeasonTest{
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
    }
}

// enum关键词定义枚举类
// 要求与特点:
// 枚举类的常量对象列表必须在枚举类的首行，因为是常量，所以建议大写。
// 列出的实例系统会自动添加 public static final 修饰。
// 如果常量对象列表后面没有其他代码，那么“；”可以省略，否则不可以省略“；”。
// 编译器给枚举类默认提供的是private的无参构造，如果枚举类需要的是无参构造，就不需要声明，写常量对象列表时也不用加参数
// 如果枚举类需要的是有参构造，需要手动定义，有参构造的private可以省略，调用有参构造的方法就是在常量对象名后面加(实参列表)就可以。
// 枚举类默认继承的是java.lang.Enum类，因此不能再继承其他的类型。
// JDK5.0 之后switch，提供支持枚举类型，case后面可以写枚举常量名，无需添加枚举类作为限定。

enum SeasonEnum {
    SPRING("春天","春风又绿江南岸"),
    SUMMER("夏天","映日荷花别样红"),
    AUTUMN("秋天","秋水共长天一色"),
    WINTER("冬天","窗含西岭千秋雪");
    private final String seasonName;
    private final String seasonDesc;
    private SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }
}

// enum中常用的方法
// 1. String toString()  可以手动重写该方法
// 2. static 枚举类型[] values()   返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值，是一个静态方法
// 3. static 枚举类型 valueOf(String name)   可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”
// 4. String name()   得到当前枚举常量的名称。建议优先使用toString()。
// 5. int ordinal()   返回当前枚举常量的次序号，默认从0开始

class TestEnumMethod {
    public static void main(String[] args) {
        //values()
        SeasonEnum[] values = SeasonEnum.values();
        for (SeasonEnum value : values) {
            //ordinal()、name()
            System.out.println((value.ordinal() + 1) + "->" +
                    value.name());
        }
        System.out.println("------------------------");

        Scanner input = new Scanner(System.in);
        System.out.print("请输入季节数：");
        int seasonValue = input.nextInt();
        SeasonEnum seasonEnum = values[seasonValue-1];
        //toString()
        System.out.println(seasonEnum);
        System.out.print("请输入季节名：");
        String seasonName = input.next();
        //valueOf()
        seasonEnum = SeasonEnum.valueOf(seasonName);
        System.out.println(seasonEnum);
        input.close();
    }
}
