package Object;

// Object类型的变量与除Object以外的任意引用数据类型的对象都存在多态引用
// 所有对象（包括数组）都实现这个类的方法
// 如果一个类没有特别指定父类，那么默认则继承自Object类
// 说白了,object就是Java设计者创造的女娲, 任何对象都继承自它

public class ObjectLearn {
    public static void main(String[] args) {
        // 1. equals: 所有类都继承了Object, 也就获得了equals()方法. 还可以重写.
        // 只能比较引用类型, 比较是否指向同一个对象。
        // 特例: 对类File、String、Date及包装类（Wrapper Class）来说，equals()比较类型及内容,而非指向同一个对象
        // 原因: 以上类对equals()进行了重写
        // 所以,在实际开发过程中,我们也可以对equals()重写,以此来实现自定义的比较(类似重载==运算符)
            // 重写equals的原则:
            // 对称性: 如果x.equals(y)返回是“true”，那么y.equals(x)也应该返回是“true”。
            // 自反性: x.equals(x)必须返回是“true”。
            // 传递性: 如果x.equals(y)返回是“true”，而且y.equals(z)返回是“true”，那么z.equals(x)也应该返回是“true”。
            // 一致性: 如果x.equals(y)返回是“true”，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是“true”。
            // 任何情况下，x.equals(null)，永远返回是“false”; x.equals(和x不同类型的对象)永远返回是“false”。
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.equals(p2));  // false
        System.out.println(p1 == p2);  // false
    }
}

class Person {

}

// 重写to_string和equal的示例
class User{
    private String host;
    private String username;
    private String password;
    public User(String host, String username, String password) {
        super();
        this.host = host;
        this.username = username;
        this.password = password;
    }
    public User() {
        super();
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [host=" + host + ", username=" + username + ", password=" +
                password + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (host == null) {
            if (other.host != null)
                return false;
        } else if (!host.equals(other.host))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
}