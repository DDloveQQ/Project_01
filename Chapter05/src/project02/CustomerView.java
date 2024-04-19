package project02;

import java.util.Scanner;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    private Scanner scan = new Scanner(System.in);

    private void addNewCustomer() {
        Customer customer = new Customer();
        System.out.println("------------------ 添加客户 -------------------");
        // 设置姓名
        System.out.print("请输入姓名: ");
        String name = CMUtility.readString(20);
        customer.setName(name);
        // 设置性别
        System.out.print("请输入性别: ");
        char gender = CMUtility.readChar();
        customer.setGender(gender);
        // 设置年龄
        System.out.print("请输入年龄: ");
        int age = CMUtility.readInt();
        customer.setAge(age);
        // 设置电话
        System.out.print("请输入电话: ");
        String phone = CMUtility.readString(12);
        customer.setPhone(phone);
        // 设置邮箱
        System.out.print("请输入邮箱: ");
        String email = CMUtility.readString(20);
        customer.setEmail(email);

        this.customerList.addCustomer(customer);
        System.out.println("------------------ 添加完成 -------------------");
    }
    private void modifyCustomer() {
        System.out.println("------------------ 修改客户 -------------------");
        System.out.println("请选择待修改客户的编号(-1退出): ");
        int index = CMUtility.readInt();
        if (index == -1) {
            System.out.println("------------------ 退出修改 -------------------");
        } else {
            Customer customer = new Customer();
            // 修改姓名
            System.out.print("姓名(" + customerList.getCustomer(index).getName() + "): ");
            String name = CMUtility.readString(20, customerList.getCustomer(index).getName());
            customer.setName(name);
            // 设置性别
            System.out.print("性别(" + customerList.getCustomer(index).getGender() + "): ");
            char gender = CMUtility.readChar(customerList.getCustomer(index).getGender());
            customer.setGender(gender);
            // 设置年龄
            System.out.print("年龄(" + customerList.getCustomer(index).getAge() + "): ");
            int age = CMUtility.readInt(customerList.getCustomer(index).getAge());
            customer.setAge(age);
            // 设置电话
            System.out.print("电话(" + customerList.getCustomer(index).getPhone() + "): ");
            String phone = CMUtility.readString(12, customerList.getCustomer(index).getPhone());
            customer.setPhone(phone);
            // 设置邮箱
            System.out.print("邮箱(" + customerList.getCustomer(index).getEmail() + "): ");
            String email = CMUtility.readString(20, customerList.getCustomer(index).getEmail());
            customer.setEmail(email);

            customerList.replaceCustomer(index, customer);
            System.out.println("------------------ 修改完成 -------------------");
        }
    }
    private void deleteCustomer() {
        System.out.println("------------------ 删除客户 -------------------");
        System.out.println("请选择待删除客户的编号(-1退出): ");
        int index = CMUtility.readInt();
        if (index == -1 ) {
            System.out.println("------------------ 退出删除 -------------------");
        } else {
            System.out.println("是否确认删除(Y/N): ");
            char confirm = CMUtility.readConfirmSelection();
            if (confirm == 'N') {
                System.out.println("------------------ 退出删除 -------------------");
            } else {
                customerList.deleteCustomer(index);
                System.out.println("------------------ 删除完成 -------------------");
            }
        }
    }
    private void listAllCustomers() {
        System.out.println("------------------ 客户列表 -------------------");
        System.out.println("编号\t" + "姓名\t" + "性别\t" + "年龄\t" + "电话\t" + "邮箱\t");
        Customer[] customers;
        customers =  customerList.getAllCustomers();
        for (int i = 0; i < customers.length; i++) {
            System.out.println(
                    i + "\t" +
                    customers[i].getName() + "\t" +
                    customers[i].getGender() + "\t" +
                    customers[i].getAge() + "\t" +
                    customers[i].getPhone() + "\t" +
                    customers[i].getEmail() + "\t"
            );
        }
    }
    private boolean ExitSystem() {
        System.out.println("------------------ 退出系统 -------------------");
        System.out.println("是否确认退出(Y/N): ");
        char confirm = CMUtility.readConfirmSelection();
        if (confirm == 'N') {
            System.out.println("------------------ 放弃退出 -------------------");
            return false;
        } else {
            System.out.println("------------  欢迎再次使用拼电商客户管理系统 -------------");
            return true;
        }
    }

    public void enterMainMenu() {
        boolean closeFlag = false;

        while (!closeFlag) {
            System.out.println("------------------ 拼电商客户管理系统 -------------------");
            System.out.println("                     1. 添加客户                       ");
            System.out.println("                     2. 修改客户                       ");
            System.out.println("                     3. 删除客户                       ");
            System.out.println("                     4. 客户列表                       ");
            System.out.println("                     5. 退   出                       ");
            System.out.println("-------------------- 请选择(1-5): ---------------------");

            switch (CMUtility.readInt()) {
                case 1 -> this.addNewCustomer();
                case 2 -> this.modifyCustomer();
                case 3 -> this.deleteCustomer();
                case 4 -> this.listAllCustomers();
                case 5 -> closeFlag = this.ExitSystem() ;
                default -> System.out.println("输入有误!请重新输入");
            }
        }
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();

        customerView.enterMainMenu();
    }
}
