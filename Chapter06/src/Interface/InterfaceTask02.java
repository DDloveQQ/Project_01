package Interface;

public class InterfaceTask02 {
}

interface IPower {
    public void power();
}

class Developer {
    private String name;
    private int age;

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

    public void takingVehicle(Vehicle vehicle) {
        vehicle.run();
    }
}

abstract class Vehicle {
    private String brand;
    private String color;

    public Vehicle() {

    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public abstract void run();
}

class Bycicle extends Vehicle {
    public Bycicle(String brand, String color){
        setBrand(brand);
        setColor(color);
    }

    @Override
    public void run() {
        System.out.println("自行车跑");
    }
}

class ElectricVehicle extends Vehicle implements IPower{
    public ElectricVehicle(String brand, String color){
        setBrand(brand);
        setColor(color);
    }

    @Override
    public void run() {
        System.out.println("电动车跑");
    }
    public void power() {
        System.out.println("电动车充电");
    }
}

class Car extends Vehicle implements IPower{
    private String carNumber;

    public Car(String brand, String color, String carNumber){
        setBrand(brand);
        setColor(color);
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("汽车跑");
    }
    public void power() {
        System.out.println("汽车加油");
    }
}

class VehicleTest {
    public static void takingVehicle(Vehicle vehicle) {
        System.out.print("阿里程序员今天的载具为: ");
        System.out.println(vehicle.getColor() + vehicle.getBrand());
        System.out.print("载具当前状态: ");
        vehicle.run();
    }
    public static void addPower(Vehicle vehicle) {
        // 方法1 ---> 类的向下转型
//        if (vehicle instanceof ElectricVehicle electricVehicle) {
//            System.out.println("载具开了一天,下面将需要: ");
//            electricVehicle.power();
//        }
//        if (vehicle instanceof Car car) {
//            System.out.println("载具开了一天,下面将需要: ");
//            car.power();
//        }

        // 方法2 ---> 接口向下转型(推荐, 这样就可以只写一次)
        if (vehicle instanceof IPower) {
            System.out.print("载具开了一天,下面将需要: ");
            ((IPower) vehicle).power();
        }
    }
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Bycicle("捷安特", "白色");
        vehicles[1] = new ElectricVehicle("雅迪", "红色");
        vehicles[2] = new Car("奔驰", "黑色", "京A88888");

        VehicleTest.takingVehicle(vehicles[0]);
        VehicleTest.addPower(vehicles[0]);
        System.out.println("-----------------------------");

        VehicleTest.takingVehicle(vehicles[1]);
        VehicleTest.addPower(vehicles[1]);
        System.out.println("-----------------------------");

        VehicleTest.takingVehicle(vehicles[2]);
        VehicleTest.addPower(vehicles[2]);
        System.out.println("-----------------------------");
    }
}