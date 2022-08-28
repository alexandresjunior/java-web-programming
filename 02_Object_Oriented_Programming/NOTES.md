# Lecture #02 - Object-Oriented Programming - Notes

## Summary

Now, you will learn a whole new level of capability through object-oriented programming.

* Classes vs. Objects
* Attributes and Methods
* Static Methods
* Inheritance
* Override vs Overload
* Abstract classes
* Interfaces

## Classes vs. Objects

* There are different paradigms of programming. As you learn other languages, you will start recognizing patterns like these.
* Up until this point, you have worked procedurally step-by-step.
* Object-oriented programming (OOP) is a compelling solution to programming-related problems.
* To begin, type code `Student.java` in the terminal window and code as follows:

    ```
    import java.util.Scanner;

    public class Student {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("What's your name?");
            String name = sc.nextLine();

            System.out.println("What's your house?");
            String house = sc.nextLine();

            sc.close();

            System.out.println("Hello, " + name + " from " + house + "!");
        }

    }
    ```

* Notice that this program follows a procedural, step-by-step paradigm: Much like you have seen in prior parts of this course so far.
* Drawing on our work from previous weeks, we can create functions to abstract away parts of this program.

    ```
    import java.util.Scanner;

    public class Student {

        public String name;
        public String house;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Hello, " + getName(sc) + " from " + getHouse(sc) + "!");

            sc.close();
        }

        public static String getName(Scanner sc) {
            System.out.println("What's your name?");
            String nameInput = sc.nextLine();

            return nameInput;
        }

        public static String getHouse(Scanner sc) {
            System.out.println("What's your house?");
            String houseInput = sc.nextLine();

            return houseInput;
        }

        public static Student getStudent(Scanner sc) {
            Student student = new Student();

            student.name = getName(sc);
            student.house = getHouse(sc);

            return student;
        }

    }
    ```

* Notice by convention that `Student` is capitalized. Further, notice that in `getStudent`, we can create a student of class `Student` using the syntax `Studente student = new Student()`. Further, notice that we utilize “dot notation” to access attributes of this variable student of class `Student`.
* Object-oriented program encourages you to encapusulate all the functionality of a class within the class definition. 
* Any time you create a class and you utilize that blueprint to create something, you create what is called an “object” or an “instance”. In the case of our code, student is an `object`.
Further, we can lay some groundwork for the attributes that are expected inside an object whose class is `Student`. We can modify our code as follows:

    ```
    public class Student {

        private String name;
        private String house;

        public Student(String name, String house) {
            this.name = name;
            this.house = house;
        }

        public String getName() {
            return this.name;
        }

        public String getHouse() {
            return this.house;
        }
        
    }
    ```

## Attributes and Methods

* Notice that within `Student`, we standardize the **attributes** of this class. We can create a function within class `Student`, called a **method**, that determines the behavior of an object of class `Student`. Within this function, it takes the `name` and `house` passed to it and assigns these variables to this object. 
* Further, notice how the constructor `Student student = new Student(String name, String house)` calls this function within the `Student` class and creates a `student` object. This can be done in another class as follows:

    ```
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
        }
        
    }
    ```

## Static Methods

* It turns out that besides the class methods, there are other types of methods as well.
* Using `static` may be something you might wish to explore, as it is related to a whole class instead an object itself.
    
    ```
    public class Student {

        private String name;
        private String house;
        private static int number = 0;

        public Student(String name, String house) {
            this.name = name;
            this.house = house;
            number++;
        }

        public String getName() {
            return this.name;
        }

        public String getHouse() {
            return this.house;
        }

        public static int getNumberOfStudents() {
            return number;
        }
        
    }
    ```

* Notice that `number` is a static attribute, whose value will be incremented by 1 once a new `Student` object is created. The `getNumberOfStudents()` in turn will return the number of `Student` objects created, which can be called in `Hogwarts` class, as the following:
    
    ```
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
    ```

## Inheritance

* Inheritance is, perhaps, the most powerful feature of object-oriented programming.
* It just so happens that you can create a class that “inherits” methods, variables, and attributes from another class.
* In the terminal, execute `code Wizard.java`. Code as follows:

    ```
    public class Wizard {

        private String name;

        public String getName() {
            return this.name;
        }
        
    }
    ```

* Idem for `Professor` class:

    ```
    public class Professor {
    
        private String name;
        private String subject;

        public String getName() {
            return this.name;
        }

        public String getSubject() {
            return this.subject;
        }

    }
    ```

* Notice that there is a class above called `Wizard` and a class called `Student`. Further, notice that there is a class called `Professor`. Both students and professors have names. Also, both students and professors are wizards. Therefore, both `Student` and `Professor` inherit the characteristics of `Wizard`. 
* This can be expressed by the `extends` statement, as it follows:
    
    ```
    public class Professor extends Wizard {
    
        private String subject;

        public String getSubject() {
            return this.subject;
        }

    }
    ```
    ```
    public class Student extends Wizard {

        private String house;
        private static int number = 0;

        public Student(String name, String house) {
            Wizard wizard = new Wizard();
            wizard.setName(name);
            
            this.house = house;
            number++;
        }

        public String getHouse() {
            return this.house;
        }

        public static int getNumberOfStudents() {
            return number;
        }
        
    }
    ```

## Override vs Overload

* Some class methods from inherited class can be “overrided” such that they can have other behaior.
* For example, let's include a `castSpell()` method, as follows:

    ```
    public class Wizard {

        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String castSpell() {
            return "Expelliarmus!";
        }
        
    }
    ```

* Notice how this method returns the `Expelliarmus` spell. 
* Let's override this methos within the children classes, such as:
    
    ```
    public class Student extends Wizard {

        private String house;
        private static int number = 0;

        public Student(String name, String house) {
            Wizard wizard = new Wizard();
            wizard.setName(name);

            this.house = house;
            number++;
        }

        public String getHouse() {
            return this.house;
        }

        public static int getNumberOfStudents() {
            return number;
        }

        @Override
        public String castSpell() {
            return "Expecto Patronum!";
        }
        
    }
    ```
    ```
    public class Professor extends Wizard {
        
        private String subject;

        public String getSubject() {
            return this.subject;
        }

        @Override
        public String castSpell() {
            return "Stupefy!";
        }

    }
    ```

* Notice that the expected spells for `Student` and `Professor` objects mush be `Expecto Patronum` and `Stupefy`, respectively.
* In other hand, we can "overload" a method within a same class, which mean we can have a same method name but with different parameters, so it has different behavior.
* For instance, we can create another `castSpell` method but now with a `String spell` input, as the following:
    
    ```
    public class Wizard {

        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String castSpell() {
            return "Expelliarmus!";
        }

        public String castSpell(String spell) {
            return spell;
        }
        
    }
    ```

* It means that `castSpell(String spell)` when a `spell` input is passed in as a parameter. Otherwise, `castSpell()` will be called.

## Abstract Classes
* An abstract class is a class that is declared `abstract` — it may or may not include abstract methods. 
* Abstract classes cannot be instantiated, but they can be subclassed. 
* When an abstract class is subclassed, the subclass usually provides implementations for all of the abstract methods in its parent class.
* Let's modify `Wizard` class to be an abstract class and include a abstract `preparePotion()` method within it, as it follows:

    ```
    public abstract class Wizard {

        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String castSpell() {
            return "Expelliarmus!";
        }

        public String castSpell(String spell) {
            return spell;
        }

        public abstract void preparePotion();
        
    }
    ```

* `Wizard`'s children classes must then implement the `preparePotion()` method, such as:

    ```
    public class Student extends Wizard {

        private String house;
        private static int number = 0;

        public Student(String name, String house) {
            this.house = house;
            number++;
        }

        public String getHouse() {
            return this.house;
        }

        public static int getNumberOfStudents() {
            return number;
        }

        @Override
        public String castSpell() {
            return "Expecto Patronum!";
        }

        @Override
        public void preparePotion() {
            System.out.println("Amortentia prepared!");
        }
        
    }
    ```

    ```
    public class Professor extends Wizard {
        
        private String subject;

        public String getSubject() {
            return this.subject;
        }

        @Override
        public String castSpell() {
            return "Stupefy!";
        }

        @Override
        public void preparePotion() {
            System.out.println("Veritaserum prepared!");        
        }

    }
    ```

## Interface
* Interfaces are similar to abstract classes. However, it does not contains attributes but only abstract methods, which must be implemented by other classes.
* Let's create a `MagicalCreature.java` interface, as if follows:
    
    ```
    public interface MagicalCreatute {

        public String describeItsMagicalFeature();
        
    }
    ```

* Once we create new classes such as `Dragon` and `Elf`, which are magical creatures, we must include `implements` Java reserved word. This means than `describeItsMagicalFeature()` method must be implemented by those classes.
    
    ```
    public class Dragon implements MagicalCreatute {

        @Override
        public String describeItsMagicalFeature() {
            return "A dragon breathes fire.";
        }
        
    }
    ```
    ```
    public class Elf implements MagicalCreatute {

        @Override
        public String describeItsMagicalFeature() {
            return "An elf protects your gold.";
        }
        
    }
    ```