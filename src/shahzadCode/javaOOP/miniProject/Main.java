package shahzadCode.javaOOP.miniProject;

public class Main {


        public static void main(String[] args) {
            // Using Electronics
            Electronics p1 = new Electronics("iPhone 15", 1200, "Apple");
            p1.showDetails(); // runtime polymorphism
            p1.applyDiscount(10.0);   // percentage discount
            p1.applyDiscount(100);  // fixed discount
            p1.showDetails();

            System.out.println();

            // Using Clothing
            Product p2 = new Clothing("T-Shirt", 50, "L");
            p2.showDetails();
            p2.applyDiscount(20);   // 20% off
            p2.applyDiscount(5);    // $5 off
            p2.showDetails();
        }
    }

