class Student {

    // Instance Variables
    int id;
    String name;
    int age;
    String course;

    // Default Constructor
    Student() {
        System.out.println("Student Object Created");
    }

    // Parameterized Constructor
    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Method to display student details
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println();
    }

    // Method to show studying message
    void study() {
        System.out.println(name + " is studying " + course);
        System.out.println();
    }

    // Bonus Method
    boolean isAdult() {
        return age >= 18;
    }
}

public class Main {

    public static void main(String[] args) {

        // Using Default Constructor
        Student temp = new Student();

        System.out.println();

        // Using Parameterized Constructor
        Student s1 = new Student(101, "Rahul", 20, "Java");
        Student s2 = new Student(102, "Aman", 21, "Python");
        Student s3 = new Student(103, "Priya", 17, "Web Development");

        // Student 1
        s1.display();
        s1.study();
        System.out.println("Adult: " + s1.isAdult());

        System.out.println("----------------");

        // Student 2
        s2.display();
        s2.study();
        System.out.println("Adult: " + s2.isAdult());

        System.out.println("----------------");

        // Student 3
        s3.display();
        s3.study();
        System.out.println("Adult: " + s3.isAdult());
    }
}
