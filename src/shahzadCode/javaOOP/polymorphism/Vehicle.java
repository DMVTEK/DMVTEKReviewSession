package shahzadCode.javaOOP.polymorphism;

public class Vehicle {
    void drive(){
        System.out.println("What do you drive: ");
    }

    public static void main(String[] args) {
        Car car=new Car();
        Bike bike = new Bike();

        car.drive();
        bike.drive();
    }
}





class Car extends Vehicle{
    @Override
    void drive() {
        super.drive();
        System.out.println(" I drive BMW");
    }
}

class Bike extends Vehicle{
    @Override
    void drive() {
        super.drive();
        System.out.println(" I drive Bike");
    }
}