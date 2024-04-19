package Generics;

interface Info{}  // 只有此接口的子类才是表示人的信息

class Contact implements Info {
    private String address;
    private String telephone;
    private String zipcode;

    public Contact(String address, String telephone, String zipcode) {
        this.address = address;
        this.telephone = telephone;
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}

class Introduction implements Info {
    private String name;
    private String sex;
    private int age;

    public Introduction(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Introduction{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}

// 限制T必须继承自Info接口
class Person<T extends Info> {
    private T info;

    public Person(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "info=" + info +
                '}';
    }
}


public class Task {
    public static void main(String[] args) {
        Person<Contact> person1 = new Person<Contact>(new Contact("北京市","01088888888","102206"));
        System.out.println(person1);

        Person<Introduction> person2 = new Person<Introduction>(new Introduction("李雷","男",24));
        System.out.println(person2);
    }
}
