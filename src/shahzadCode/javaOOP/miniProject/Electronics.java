package shahzadCode.javaOOP.miniProject;

public class Electronics extends Product{
    String brand;

    Electronics(String name, double price, String brand) {
        super(name, price);  // call Product constructor
        this.brand = brand;
    }

    @Override
    void showDetails() {
        System.out.println("Electronics: " + name + ", Brand: " + brand + ", Price: $" + price);
    }




}
