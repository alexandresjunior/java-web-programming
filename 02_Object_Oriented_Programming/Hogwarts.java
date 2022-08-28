import java.util.Scanner;

public class Hogwarts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = sc.nextLine();

        System.out.println("What's your house?");
        String house = sc.nextLine();

        sc.close();

        Student student = new Student(name, house);

        System.out.println("Hello, " + student.getName() + " from " + student.getHouse() + "!");

        Student student2 = new Student("Hermione", "Gryffindor");

        System.out.println("Hello, " + student2.getName() + " from " + student2.getHouse() + "!");

        System.out.println("Number of students: " + Student.getNumberOfStudents());

    }
    
}
