# Exceptions

An exception represents an error that occurs at runtime.

Throwing an exception: the process involves both the creation of an exception object and the hand off of that object to the JVM to trickle down the call stack and find a method that can handle the exception.

Handling Exceptions:

```java
try {
    statement(s);
}
catch (ExceptionType1 identifier) {  
    statement(s);
}
catch (ExceptionType2 identifier) {  
    statement(s);
}
catch (ExceptionType3 identifier) {  
    statement(s);
}
```

When an exception occurs in the try block, a reference to its object is passed into a catch block, only if the declared type matches the object's type. Within the catch block, we can use the reference to get information about the exception if needed as part of our handler statements.

Each catch block handles a different type of exception. If an exception is thrown, the JVM will execute the first catch block with a parameter type that matches the object's type.

Exception Controlled Loop:

```java
Scanner input = new Scanner(System.in);
boolean success = false;
int hoursWorked = 0;

while (!success) {
    try {
        System.out.print("Enter the number of hours worked this week: ");
        hoursWorked = input.nextInt();
        success = true;
    }
    catch (InputMismatchException e) {
        input.nextLine();
        System.out.println("Sorry, that wasn't an int.");
        System.out.println("Please try again");
    }
}

double income = 16.25 * hoursWorked;
System.out.print("Weekly income: ", income);
```

Defining an exception:

We can write our own kind of exception by simply extending the Exception class or any of its descendants that may represent an appropriate parent.

```java
public class DivideByZeroException extends ArithmeticException
{
    public DivideByZeroException()
    {
        super("Divide by zero.");  // message returned by e.getMessage()
    }
}
```

Since there are multiple kinds of arithmetic errors that could result in an ArithmeticException object being thrown (besides a division by zero), we can use this more specific class to represent only divide by zero errors. 

```java
throw new DivideByZeroException();
```

The above example also serves as an example of how to throw an exception.
