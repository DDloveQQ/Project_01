package project02;

public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer){
        if (total >= customers.length) {
            System.out.println("客户存储系统已满");
            return false;
        } else {
            customers[total++] = customer;
            return true;
        }
    }

    public boolean replaceCustomer(int index, Customer customer){
        if (index < 0 || index > total) {
            System.out.println("索引无效");
            return false;
        } else {
            customers[index] = customer;
            return true;
        }
    }

    public boolean deleteCustomer(int index){
        if (index < 0 || index > total) {
            System.out.println("索引无效");
            return false;
        } else {
            for (int i = index; i < total - 1; i++) {
                customers[i] = customers[i + 1];
            }
            customers[--total] = null;  // 自定义类型的默认值为null
            return true;
        }
    }

    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;  // 不能直接返回Customers[], 因为返回的是数组的地址, 后续的改变会影响类中封装的数组
    }

    public Customer getCustomer(int index){
        if (index < 0 || index > total) {
            System.out.println("索引无效");
            return null;
        } else {
            return customers[index];
        }

    }
    public int getTotal(){
        return total;
    }

    public static void main(String[] args) {
        CustomerList customerList = new CustomerList(5);
        Customer customer0 = new Customer();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();

        customerList.addCustomer(customer0);
        customerList.addCustomer(customer1);
        customerList.addCustomer(customer2);
        customerList.addCustomer(customer3);

        customerList.replaceCustomer(6, customer4);

        customerList.deleteCustomer(6);

        Customer[] customers = new Customer[5];
        customers = customerList.getAllCustomers();
        System.out.println(customers.length);

        customers[0] = customerList.getCustomer(6);

        int total = customerList.getTotal();
    }

}
