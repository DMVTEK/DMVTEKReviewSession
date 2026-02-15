package shahzadCode.javaOOP.miniProject;

public class Product
{
    public String name;
    public double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void showDetails(){
        System.out.println(" product name is : "+ name);
        System.out.println(" product price is " + price);
    }


    // Overloading: Apply discount by percentage
    void applyDiscount(double percent) {
        price = price - (price * percent / 100);
        System.out.println("Applied " + percent + "% discount. New Price: $" + price);
    }

    // Overloading: Apply discount by fixed amount
    void applyDiscount(int amount) {
        price = price - amount;
        System.out.println("Applied $" + amount + " discount. New Price: $" + price);
    }

    public static void main(String[] args) {

       Product product =new Product("Airpods", 200);
       product.showDetails();

    }
}


