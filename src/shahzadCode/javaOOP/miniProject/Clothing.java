package shahzadCode.javaOOP.miniProject;

public class Clothing extends Product{
    String size;


    Clothing(String name, double price, String size ){
        super(name,price);
        this.size=size;

    }

    @Override
    void showDetails() {
        System.out.println("Clothing: " + name + ", Size: " + size + ", Price: $" + price);
    }


}
