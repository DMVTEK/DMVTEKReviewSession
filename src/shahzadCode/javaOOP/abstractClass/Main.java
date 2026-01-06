package shahzadCode.javaOOP.abstractClass;

public class Main {



    public static void main(String[] args) {


    Shape circle = new Circle(10);
    Shape rectangle = new Rectangle(5,4);



        System.out.println(circle.area());
        System.out.println(  rectangle.perimeter());

}


}