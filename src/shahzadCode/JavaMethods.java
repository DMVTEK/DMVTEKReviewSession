package shahzadCode;

public class JavaMethods {

    int number ;
// TO check number is Even or Odd
    public static void checkNum(int num){
        if(num%2==0){
            System.out.println("Even");
        }else{
            System.out.println("ODD");
        }
    }

// to create String[] of three websites
    String[] websites ={"GOOGLE.COM", "GOOGLE.COM","GOOGLE.COM"};




    public static void main(String[] args) {
        String[]  car = new String[4];
       checkNum(101);
       car[0]= "BMW";

        System.out.println(car[0]);

    }
}
