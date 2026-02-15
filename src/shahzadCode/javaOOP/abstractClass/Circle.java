package shahzadCode.javaOOP.abstractClass;

public class Circle extends Shape {
    double radius;

    Circle(double radius){
        if(radius <= 0 ) throw new IllegalArgumentException("Radius must be > 0 ");
        this.radius = radius;
    }

    @Override
    double area() {
        // formulla 2Pi* radius square
        return Math.PI*radius*radius;
    }

    @Override
    double perimeter() {
        // Formulla 2PI* radius
        return Math.PI * radius;
    }
}
