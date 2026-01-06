package shahzadCode;

public class Task1 {

    String customer_name ;
    int customer_age;
    boolean prime_member;

    Task1(){

    }

    Task1(String name){
        this.customer_name=name;
    }

    Task1(String name , int age){
        this.customer_name=name;
        this.customer_age=age;
    }

    Task1(String name, int age, boolean member){
        this.customer_name=name;
        this.customer_age=age;
        this.prime_member=member;
    }

    void display(){
        System.out.println(customer_name.toUpperCase());
        System.out.println(customer_name.substring(0,2));
        System.out.println(" Welcome Back, "+ prime_member);

    }

    public static void main(String[] args) {

        Task1 task=new Task1("Hello,", 27, true);
        task.display();



    }



}
