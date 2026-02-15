package shahzadCode.javaOOP.polymorphism;

public class Animal {

     void sound(){
         System.out.println("Animal makes sounds");

    }

    public static void main(String[] args) {

         Dog dog = new Dog();
         dog.sound();

    }
}

class Dog extends Animal{
    @Override
    void sound() {
        super.sound();
        System.out.println("Dog Barks");
    }
}

