import java.util.Scanner;

class User {
    String name = "";
    int password;

    User(String name, int password){
        System.out.println("用户注册成功");
        this.name = name;
        this.password = password;
    }

    public boolean userLogIn () {
        boolean isCorrect;
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入用户名");
        String nameIn = scan.next();
        System.out.println("请输入密码");
        int passwordIn = scan.nextInt();

        return nameIn.equals(name) && passwordIn == password;
    }
}

public class ClassTask01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入注册用户名");
        String nameRegi = scan.next();
        System.out.println("请输入注册密码");
        int passwordRegi = scan.nextInt();

        User u1 = new User(nameRegi, passwordRegi);

        if (u1.userLogIn()) {
            System.out.println("欢迎你: " + u1.name);
        } else {
            System.out.println("用户名或密码错误！");
        }

        scan.close();
    }
}
