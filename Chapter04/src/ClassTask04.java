import javax.swing.text.html.CSS;

public class ClassTask04 {
    public static void main(String[] args) {
        Customer person1 = new Customer("Jane", "Smith");
        Account account1 = new Account(1000, 2000.0, 1.23);
        person1.setAccount(account1);
        // 存入100元
        person1.getAccount().deposit(100.0);
        // 取出960元
        person1.getAccount().withdraw(960.0);
        // 取出2000元
        person1.getAccount().withdraw(2000.0);
        // 打印信息
        System.out.println(
                    "Customer: " + person1.getFirstName() + " " + person1.getLastName() + " " +
                    "\nAccount id: " + person1.getAccount().getId() +
                    "\nAnnual interest rate: " + account1.getAnnualInterestRate() +
                    "\nBalance is: " + account1.getBalance()
        );
    }
}

class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int i, double b, double a) {
        this.id = i;
        this.balance = b;
        this.annualInterestRate = a;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw (double amount) {
        if (amount > this.balance) {
            System.out.println("余额不足!");
        } else {
            this.balance -= amount;
            System.out.println("成功取出: " + amount);
        }
    }

    public void deposit (double amount) {
        this.balance += amount;
        System.out.println("成功存入: " + amount);
    }
}

class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer (String f, String L) {
        this.firstName = f;
        this.lastName = L;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
