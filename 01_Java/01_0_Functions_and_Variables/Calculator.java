import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What's x? ");
        float x = sc.nextFloat();

        System.out.println("What's y? ");
        float y = sc.nextFloat();

        double z = x + y;

        System.out.println(z);

        sc.close();
    }

    public static int square(int x) {
        return x * x;
    }
}
