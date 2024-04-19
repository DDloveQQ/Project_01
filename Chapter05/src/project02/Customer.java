package project02;

public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    // *************** set 方法 ***************
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // *************** get 方法 ***************
    public String getName() {
        return name;
    }
    public char getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setAge(10);
        customer.setName("张三");
        customer.setGender('男');
        customer.setPhone("010-12345");
        customer.setEmail("123@qq.com");

        System.out.println(
                customer.getName() + "\n" +
                customer.getGender() + "\n" +
                customer.getAge() + "\n" +
                customer.getPhone() + "\n" +
                customer.getEmail()
        );
    }
}
