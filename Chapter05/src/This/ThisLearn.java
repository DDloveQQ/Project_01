package This;

public class ThisLearn {
    private String name;
    private int age;
    // 无参构造(1)
    public ThisLearn() {
    // this("",18);//调用本类有参构造器, 会报错
    }
    // 有参构造(2)
    public ThisLearn(String name) {
        this();//调用本类无参构造器
        this.name = name;
    }
    // 有参构造(3)
    public ThisLearn(String name,int age){
        this(name);//调用本类中有一个String参数的构造器
        this.age = age;
    }

    // (3)调用了(2),(2)调用了(1),因此(1)不能再调用(2)或(3)了,否则就相当于(1)调用了自己,产生了递归错误

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getInfo(){
        return "姓名：" + name +"，年龄：" + age;
    }
}


