package EnumerationClass;

public class EnumerationClassLearn02 {
}

// 实现接口的枚举类
// 和普通 Java 类一样，枚举类可以实现一个或多个接口
// 若每个枚举值在调用实现的接口方法呈现相同的行为方式，则只要统一实现该方法即可。
// 若需要每个枚举值在调用实现的接口方法呈现出不同的行为方式，则可以让每个枚举值分别来实现该方法

interface Info{
    void show();
}

// 使用enum关键字定义枚举类
enum Season1 implements Info{
    // 1. 创建枚举类中的对象,声明在enum枚举类的首位
    SPRING("春天","春暖花开"){
        public void show(){
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        public void show(){
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        public void show(){
            System.out.println("秋天是丰收的季节");
        }
    },
    WINTER("冬天","白雪皑皑"){
        public void show(){
            System.out.println("2002年的第一场雪");
        }
    };
    // 2. 声明每个对象拥有的属性:private final修饰
    private final String SEASON_NAME;
    private final String SEASON_DESC;
    // 3. 私有化类的构造器
    private Season1(String seasonName,String seasonDesc){
        this.SEASON_NAME = seasonName;
        this.SEASON_DESC = seasonDesc;
    }
    public String getSEASON_NAME() {
        return SEASON_NAME;
    }
    public String getSEASON_DESC() {
        return SEASON_DESC;
    }
}