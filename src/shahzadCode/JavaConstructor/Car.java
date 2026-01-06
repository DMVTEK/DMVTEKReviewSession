package shahzadCode.JavaConstructor;

public class Car {
    String brand;
    int year;

    Car(String b, int y){
      this.brand=b;
      this.year=y;
    }

    void display(){
        System.out.println("Brand : "+ brand + "Year : "+ "" +year );
    }

    public static void main(String[] args) {

        Car car=new Car("BMW" , 2030);
        car.display();
    }
}
