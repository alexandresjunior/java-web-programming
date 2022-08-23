# Lecture #01.3 - Exceptions - Notes

## Summary

Errors are inevitable in your code. However, you have the opportunity to use what was learned today to help prevent these errors. In this lecture, you will learn about…

* Runtime Errors
* `try/catch`

## Exceptions

* Exceptions are things that go wrong within our coding.
* In our text editor, type `code HelloWorld.java` to create a new file. Type as follows (with the intentional errors included):

    ```
    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello, world);
        }
    }
    ```
    Notice that we intentionally left out a quotation mark.
* Running that code in our terminal window, an error is outputted. The compiler states that it is a “String literal is not properly closed by a double-quote.” Syntax errors are those that require you to double-check that you typed in your code correction.

## Runtime Errors

* Runtime errors refer to those created by unexpected behavior within your code. For example, perhaps you intended for a user to input a number, but they input a character instead. Your program may throw an error because of this unexpected input from the user.
* In your terminal window, run `code Calculator.java`. Code as follows in your text editor:

    ```
    public class Calculator {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("What's x? ");
            float x = sc.nextFloat();

            System.out.println("What's y? ");
            float y = sc.nextFloat();

            float z = x + y;

            System.out.println(z);

            sc.close();
        }
    }
    ```

* Testing out your code, you can imagine how one could easily type in a `String` or a `char` (character) instead of a number. Even still, a user could type nothing at all – simply hitting the enter key.
* As programmers, we should be defensive to ensure that our users are entering what we expected. We might consider “corner cases” such as -1.
* If we run this program and type in “cat”, we’ll suddenly see "InputMismatchException" error, as Java compiler expects a `float` number.
* An effective strategy to fix this potential error would be to create “error handling” to ensure the user behaves as we intend.

## try / catch

* In Java, we can use `try/catch` statements for testing out user input before something goes wrong. Modify your code as follows:

    ```
    public class Calculator {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            try {
                System.out.println("What's x? ");
                float x = sc.nextFloat();
        
                System.out.println("What's y? ");
                float y = sc.nextFloat();
        
                float z = x + y;
        
                System.out.println(z);

                sc.close();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a real number!");
            }
        }
    }
    ```

* Notice how, running this code, inputting 50 will be accepted. However, typing in "cat" will produce an error visible to the user, instructing them why their input was not accepted.
* This is still not the best way to implement this code. For best practice, we should only try the fewest lines of code possible that we are concerned could fail. Adjust your code as follows:

    ```
    public class Calculator {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            float z = 0;
            
            try {
                System.out.println("What's x? ");
                float x = sc.nextFloat();
        
                System.out.println("What's y? ");
                float y = sc.nextFloat();
        
                z = x + y;
            } catch (InputMismatchException e) {
                System.out.println("Input must be a real number!");
            }

            System.out.println(z);

            sc.close();
        }
    }
    ```
