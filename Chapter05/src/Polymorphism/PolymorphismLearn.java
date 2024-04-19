package Polymorphism;

public class PolymorphismLearn {
    // 对象的多态: 子类的对象可以替代父类的对象使用, 所以, 一个引用类型变量可能指向(引用)多种不同类型的对象
    // 多态性的体现: 编译时类型和运行时类型不一致
    // 多态使用的前提: 1. 类的继承关系
    //              2. 方法的重写
}
class Pet {
    private String nickname; //昵称
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void eat(){
        System.out.println(nickname + "吃东西");
    }
}

class Kitty extends Pet {
    //子类重写父类的方法
    @Override
    public void eat() {
        System.out.println("猫咪" + getNickname() + "吃鱼仔");
    }
    //子类扩展的方法
    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}

class Dog extends Pet {
    //子类重写父类的方法
    @Override
    public void eat() {
        System.out.println("狗子" + getNickname() + "啃骨头");
    }
    //子类扩展的方法
    public void watchHouse() {
        System.out.println("看家");
    }
}

///////////////////////////////////////////////////////////////////////
//方法内局部变量的赋值体现多态
class TestPet {
    public static void main(String[] args) {
        //多态引用
        Pet pet = new Dog();
        pet.setNickname("小白");

        //多态的表现形式
        /*
        编译时看父类：只能调用父类声明的方法，不能调用子类扩展的方法；(看左边)
        运行时，看“子类”，如果子类重写了方法，一定是执行子类重写的方法体；(看右边)
        个人理解: 写代码的时候,父类优先;运行代码的时候,子类优先
        */
        // pet.watchHouse();//不能调用Dog子类扩展的方法,因为编译时只能调用父类声明的方法
        pet.eat();//运行时执行子类Dog重写的方法,因为运行时看右边

        pet = new Kitty();  // pet局部变量前面已经实例化过,因此无需再次实例化,而赋值的对象变成了Kitty
        pet.setNickname("雪球");
        pet.eat();//运行时执行子类Cat重写的方法
    }
}

///////////////////////////////////////////////////////////////////////
// 方法的形参声明体现多态
class Person{
    private Pet pet;
    public void adopt(Pet pet) {//形参是父类类型，实参是子类对象
        this.pet = pet;
    }
    public void feed(){
        pet.eat();//pet实际引用的对象类型不同，执行的eat方法也不同
    }
}

class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        Dog dog = new Dog();
        dog.setNickname("小白");
        person.adopt(dog);  // 实参是dog子类对象(person.adopt(dog))，形参是父类Pet类型(public void adopt(Polymorphism.Pet pet))
        // 执行完此步骤后,person内部的pet多态化为dog
        person.feed();  // 狗子小白啃骨头

        Kitty kitty = new Kitty();
        kitty.setNickname("雪球");
        person.adopt(kitty);  // 实参是kitty子类对象，形参是父类Pet类型
        person.feed();  // 猫咪雪球吃鱼仔
    }
}

///////////////////////////////////////////////////////////////////////
// 方法的返回值类型体现多态
class PetShop {
    //返回值类型是父类类型(Polymorphism.Pet)，实际返回的是子类对象(Polymorphism.Dog/Polymorphism.Kitty)
    public Pet sale(String type){
        switch (type){
            case "Polymorphism.Dog":
                return new Dog();  // 记得使用new(Polymorphism.Pet ** = new Polymorphism.Dog)
            case "Polymorphism.Kitty":
                return new Kitty();  // 记得使用new(Polymorphism.Pet ** = new Polymorphism.Kitty)
        }
        return null;
    }
}

class TestPetShop {
    public static void main(String[] args) {
        PetShop shop = new PetShop();
        Pet pet = shop.sale("Polymorphism.Dog");  // 等价于: Polymorphism.Pet pet = new Polymorphism.Dog
        pet.setNickname("小白");
        pet.eat();  // 狗子小白啃骨头

        pet = shop.sale("Polymorphism.Kitty");  // 等价于:  pet = new Polymorphism.Kitty
        pet.setNickname("雪球");
        pet.eat();  // 猫咪雪球吃鱼仔
    }
}

///////////////////////////////////////////////////////////////////////
// 向下转型
class ClassCastTest {
    public static void main(String[] args) {
        //没有类型转换
        Dog dog = new Dog();//dog的编译时类型和运行时类型都是Dog

        //向上转型
        Pet pet = new Dog();//pet的编译时类型是Pet，运行时类型是Dog
        pet.setNickname("小白");
        pet.eat();//可以调用父类Pet有声明的方法eat，但执行的是子类重写的eat方法体
        // pet.watchHouse();//不能调用父类没有的方法watchHouse

        // 向下转型(pet->dog)
        Dog d = (Dog) pet;
        System.out.println("d.nickname = " + d.getNickname());
        d.eat();//可以调用eat方法
        d.watchHouse();//可以调用子类扩展的方法watchHouse

        Kitty k = (Kitty) pet;// 编译通过，因为从语法检查来说，pet的编译时类型是Pet，Kitty是Pet的子类，所以向下转型语法正确
        // 这句代码运行报错ClassCastException，因为pet变量的运行时类型是Dog，Dog和Kitty之间是没有继承关系的
        // 解释: Dog先于Kitty占领了Pet(第131行)
        // 想要运行不报错,则应该新实例化一个pet2,并用Dog为其赋值

    }
}

///////////////////////////////////////////////////////////////////////
// instanceof校验向下转型
class TestInstanceof {
    public static void main(String[] args) {
        Pet[] pets = new Pet[2];  // 使用数组管理Pet类

        pets[0] = new Dog();  // 多态引用
        pets[0].setNickname("小白");

        pets[1] = new Kitty();  // 多态引用
        pets[1].setNickname("雪球");

        for (int i = 0; i < pets.length; i++) {
            pets[i].eat();
            if(pets[i] instanceof Dog){  // 检测pet[i] (= new Polymorphism.Dog() / new Polymorphism.Kitty)是否为Dog的对象
                Dog dog = (Dog) pets[i];
                dog.watchHouse();
            }
            if(pets[i] instanceof Kitty){  // 检测pet[i] (= new Polymorphism.Dog() / new Polymorphism.Kitty)是否为Kitty的对象
                Kitty kitty = (Kitty) pets[i];
                kitty.catchMouse();
            }
            // 如此一来,就可以在保证安全的情况下既使用多态,又能够调用子类的方法
        }
    }
}
