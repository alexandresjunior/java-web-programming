# Lecture #01.5 - Unit Tests - Notes

## Summary

Testing your code is a natural part of the programming process. Unit tests allow you to test specific aspects of your code. You can create your own programs that test your code. Alternatively, you can utilize frameworks like [Junit](https://junit.org/junit5/) to run your unit tests for you.

## Unit Tests
* Up until now, you have been likely testing your own code using print statements.
* It’s most common in industry to write code to test your own programs.
* In VS Code (or any other IDE of your preference), create a simple Maven project with `Calculator.java` as the main class. Let's make sure that your code appears as follows:
    
    ```
    public class Calculator {

        public static int square(int number) {
            return number * number;
        }

    }
    ```

* Notice that you could plausibly test the above code on your own using some obvious numbers such as 2. However, consider why you might want to create a test that ensures that the above code functions appropriately.
* Following convention, let’s create a new test program `CalculatorTest.java` and modify your code in the text editor as follows:

    ```
    import org.junit.Assert;
    import org.junit.Test;

    public class CalcultatorTest {

        @Test
        public void testSquareFunction() {
            Assert.assertEquals(4, Calculator.square(2));
        }

    }
    ```

* Notice that, by convention, we are creating a function called `testSquare()`. Inside that function, we define some conditions to test.
* In VS Code, you can that test just by clicking on `run` button, and you’ll notice that nothing is being outputted. It could be that everything is running fine! Alternatively, it could be that our test function did not discover one of the “corner cases” that could produce an error.
* Right now, our code tests one single condition. If we wanted to test many more conditions, our test code could easily become bloated. How could we expand our test capabilities without expanding our test code?

## Assert

* Java `Assert` class allows us to tell us that something, some assertion, is true. We can apply this to our test code by the following line, where the first attribute is the `expected` value and the second one is the `actual` value.

    ```
    Assert.assertEquals(4, Calculator.square(2));
    ```