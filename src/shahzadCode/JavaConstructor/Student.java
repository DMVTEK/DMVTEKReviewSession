package shahzadCode.JavaConstructor;

import java.sql.SQLOutput;

public class Student {

    String name;
    int age;

    Student(String name, int age){
        this.name=name;
        this.age=age;
    }

    void info(){
        System.out.println(" Student Name is : " + name);
        System.out.println("Studnet age is : "+ age);
    }

    public static void main(String[] args) {

        Student std=new Student("Shahzad",27);
        std.info();
    }


}
