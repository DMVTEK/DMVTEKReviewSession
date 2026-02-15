package shahzadCode.javaOOP.abstractClass;

public class Rectangle extends Shape {

    double length;
    double breadth;

    Rectangle(double length , double breadth){
        if(length <= 0 || breadth <= 0)throw new IllegalArgumentException(" Value should not be zero");
        this.breadth = breadth;
        this.length = length;

    }






    @Override
    double area() {
        return length * breadth;
    }

    @Override
    double perimeter() {
        return 2 * ( length+ breadth);
    }
}
