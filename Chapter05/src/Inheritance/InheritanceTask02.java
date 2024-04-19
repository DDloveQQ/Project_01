package Inheritance;

public class InheritanceTask02 {
    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount(1122, 20000, 4.5, 5000);
        checkAccount.withdraw(5000);
        System.out.println("账户余额: " + checkAccount.getBalance());
        System.out.println("可透支额: " + checkAccount.getOverdraft());
        System.out.println();

        checkAccount.withdraw(18000);
        System.out.println("账户余额: " + checkAccount.getBalance());
        System.out.println("可透支额: " + checkAccount.getOverdraft());
        System.out.println();


        checkAccount.withdraw(3000);
        System.out.println("账户余额: " + checkAccount.getBalance());
        System.out.println("可透支额: " + checkAccount.getOverdraft());
        System.out.println();

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

    public double getMonthlyInterest() {
        return this.getAnnualInterestRate() / 12.0;
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

class CheckAccount extends Account {

    private double overdraft;

    public CheckAccount(int i, double b, double a, double overdraft) {
        super(i, b, a);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount < this.getBalance()) {
            super.withdraw(amount);
        }
        if (amount > this.getBalance()) {
            double overdraftRequired = amount - this.getBalance();
            if (overdraftRequired < this.overdraft) {
                this.setBalance(0);
                this.overdraft -= overdraftRequired;
            } else {
                System.out.println("可透支额度不够!");
            }
        }
    }

    public double getOverdraft() {
        return overdraft;
    }
}