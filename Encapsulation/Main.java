package Encapsulation;
class Employee{
    private int id;
    private String name;
    private double salary;
    Employee(int id, String name,double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public void setName(String name ){
        this.name = name;
    }
    public void setSalary(double salary){
        if (salary>0){
            this.salary = salary;
        }
        else{
            System.out.println("Invalid Salary!");
        }

    }
    public void displayEmployee(){
        System.out.println("ID: "+ id);
        System.out.println("Name: "+ name);
        System.out.println("Salary: "+ salary);
        System.out.println();
    }

}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(101,"Nivea",300000);
        e1.displayEmployee();
        e1.setName("Nivea K");
        e1.setSalary(500000);
        e1.displayEmployee();
        e1.setSalary(-5000);
        e1.displayEmployee();
    }
}
    
