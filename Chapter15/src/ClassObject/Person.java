package ClassObject;

public class Person {
    public String name;
    public int age;
    private int ID;

    public static void printInfo(String str) {
        System.out.println(str);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

//    public Person(String name, int age, int ID) {
//        this.name = name;
//        this.age = age;
//        this.ID = ID;
//    }

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

    private void test() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ID=" + ID +
                '}';
    }
}
