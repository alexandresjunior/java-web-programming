import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user for their name
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Say hello to that user
        sayHello(name);

        sc.close();
    }

    public static void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}
