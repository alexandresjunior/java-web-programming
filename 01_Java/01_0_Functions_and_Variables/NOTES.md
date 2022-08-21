# Lecture #01.0 - Functions and Variables - Notes

## Summary 

Through the work of this lecture, you will learn abilities that you will use countless times in your own programs, such as…

* Creating your first programs in Java language;
* Functions;
* Bugs;
* Variables;
* Comments;
* Pseudocode;
* Strings;
* Parameters;
* Formatted Strings;
* Integers;
* Principles of readability;
* Floats and Doubles;
* Creating your own functions; and
* Return values.

## Creating Code with Java

* [Visual Studio Code](https://code.visualstudio.com/download) is a special type of text editor that is called a **compiler**. At the top, you’ll notice a text editor and, at the bottom you will see a terminal where you can execute commands.
* In the terminal, you can execute `code hello.java` to start coding.
* In the text editor, you can type:
    ```
    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello, world!");
        }
    }
    ``` 
    This is a famous canonical program that nearly all coders write during their learning process.
* In the terminal window, you can execute commands. To run this program, you are going to need to move your cursor to the bottom of the screen, clicking in the terminal window. You can now type a second command in the terminal window. Next to the dollar sign, type `javac hello.java` and press the enter key on your keyboard.
* Recall, computers really only understand zeros and ones. Therefore, when you run `javac hello.java`, java will compile the text that you created in `hello.java` and translate it into the zeros and ones that the computer can understand (**bytecode**).
* A **compiler** is an application that translates programs from the Java language to a language more suitable for executing on the computer. It takes a text file with the `.java` extension as **input** (your program) and produces a file with a `.class` extension (the computer-language version). 
* Once you compile your program, you can execute it. This is the exciting part, where the computer follows your instructions. To run the `HelloWorld` program, type the following in the terminal window: `java HelloWorld`. If all goes well, you should see the following response `Hello, World`.
* Congrats! You just created your first program.

## Functions

* Functions are verbs or **actions** that the computer or computer language will already know how to perform.
* In your `hello.java` program, the `System.out.println` function knows how to print to the terminal window.
* The `System.out.println()` function takes arguments. In this case, `"Hello, world!"` are the arguments that the `System.out.println()` function takes.

## Bugs

* Bugs are a natural part of coding. These are mistakes, problems for you to solve! Don’t get discouraged! This is part of the process of becoming a great programmer.
* Imagine in our `hello.java` program that accidentally typed `System.out.println("Hello, world"` notice that we missed the final `)` required by the compiler. If I purposefully make this mistake, you’ll the compiler will output an error in the terminal window!
* Often, the error messages will inform you of your mistake and provide you clues on how to fix them. However, there will be many times that the compiler is not this kind.

## Improving Your First Java Program

* We can personalize your first Java program.
* In our text editor in `hello.java` we can call another function inside the `main` method:

    ```
    public class HelloWorld {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Enter your name: ");
            System.out.println("Hello, world!");
            
            sc.close();
        }
    }
    ```

    `sc` is an object (more details in the [Object-Oriented Programming](../02_Object_Oriented_Programming/) section) that takes a **prompt** as an argument.
* This edit alone, however, will not allow your program to output what your user inputs. For that, we will need to introduce you to **variables**.

## Variables

* A variable is just a container for a value within your own program.
* In your program, you can introduce your own variable in your program by editing it to read:
    
    ```
    public class HelloWorld {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.println("Hello, world!");
            
            sc.close();
        }
    }
    ```

* Notice that this equal `=` sign in the middle of `String name = sc.nextLine();` has a special role in programming. This equal sign literally **assigns** what is on the right to what is on the left. Therefore, the value returned by `sc.nextLine()` is assigned to `name`.
* If you edit your code as follows, you will notice an error. The program will return `Hello, world!` in the terminal window regardless of what the user types.
* Further editing our code, you could type:
    
    ```
    public class HelloWorld {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.println("Hello, " + name);
            
            sc.close();
        }
    }
    ```

    The result in the terminal window would be
    
    ```
    What's your name? Alexandre
    Hello, Alexandre
    ```

* It turns out that some functions take many arguments.
* We can use a comma `,` to pass in multiple arguments.
* You can learn more in Java’s documentation on [data types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html).

## Comments

* Comments are a way for programmers to track what they are doing in their programs and even inform others about their intentions for a block of code. In short, they are notes for yourself and others that will see your code!
* You can add comments to your program to be able to see what it is that your program is doing. You might edit your code as follows:

    ```
    public class HelloWorld {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            // Ask the user for their name
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            // Say hello to that user
            System.out.println("Hello, " + name);
            
            sc.close();
        }
    }
    ```

* Comments can also serve as to-do list for you.

## Pseudocode

* Pseudocode is an important type of comment that becomes a special type of to-do list, especially when you don’t understand how to accomplish a coding task. For example, in your code, you might edit your code to say:

    ```
    BEGIN
        INPUT NAME
        OUTPUT "HELLO, " + NAME
    END
    ```

## Strings and Paremeters

* A `String` is a sequence of characters, known as `char` in Java.
* Parameters, therefore, are arguments that can be taken by a function.
* You can learn more about [Strings](https://docs.oracle.com/javase/tutorial/java/data/strings.html) in Java's documentation.

## int

* In Java, an integer is referred to as an 'int'.
* In the world of mathematics, we are familiar with +, -, *, /, and % operators. That last operator % or modulo operator may not be very familiar to you.
* Opening up VS Code again, we can type 'code Calculator.java' in the terminal. This will create a new file in which we will create our own calculator.
* First, we can declare a few variables.

    ```
    public class Calculator {
        public static void main(String[] args) {
            int x = 1;
            int y = 2;

            int z = x + y;

            System.out.println(z);

            sc.close();
        }
    }
    ```

* Naturally, when we run the code above we get the result in the terminal window of 3. We can make this more interactive using the `Scanner` class.

    ```
    public class Calculator {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("What's x? ");
            int x = sc.nextInt();

            System.out.println("What's y? ");
            int y = sc.nextInt();

            int z = x + y;

            System.out.println(z);

            sc.close();
        }
    }
    ```

* This illustrates that you can call `nextInt()` function to get an `int` input from the user.

## Readability Wins

* When deciding on your approach to a coding task, remember that one could make a reasonable argument for many approaches to the same problem.
* Regardless of what approach you take to a programming task, remember that your code must be readable. You should use comments to give yourself and others clues about what your code is doing. Further, you should create code in a way that is readable.

## Float / Double

* A floating point value is a real number that has a decimal point in it, such as 0.52.
* You can change your code to support `float`s as follows:

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

* This change allows your user to enter 1.2 and 3.4 to present a total of 4.6.
* Alternatively, that can be done using `double` type and `nextDouble` function.

## Creating your own functions

* Wouldn’t it be nice to create our own functions?
* Let’s bring back our final code of `HelloWorld` by typing `code HelloWorld.java` into the terminal window. We can better our code to create our own special function that says “hello” for us as follows:

    ```
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
    ```
*  Here, you are creating your `sayHello` function, and you are telling the compiler that this function takes a single parameter: a local variable called `name`. Therefore, when you call `sayHello(name)` the computer passes `name` into the `sayHello` function as a parameter. This is how we pass values into functions. Very useful!

## Returning Values

* You can imagine many scenarios where you don’t just want a function to perform an action, but also to return a value back to the main function. For example, rather than simply printing the calculation of `x + y`, you may want a function to return the value of this calculation back to another part of your program. This “passing back” of a value we call a return value.
* Returning to our `Calculator` code by typing `code Calculator.java`. Erase all code there. Rework the code as follows:

    ```
    public class Calculator {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("What's x? ");
            int x = sc.nextInt();

            System.out.println("x squared is: " + square(x));

            sc.close();
        }

        public static int square(int x) {
            return x * x;
        }
    }
    ```

* Effectively, `x` is passed to `square` function. Then, the calculation of `x * x` is returned back to the `main` function.