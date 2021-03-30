
package java8_lambda;
/**
 * https://www.baeldung.com/java-8-lambda-expressions-tips
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * //Syntax of lambda expression
 * (parameter_list) -> {function_body}
 */

@FunctionalInterface
interface MyFunctionalInterface1 {

    //A method with no parameter
    public String sayHello();
}

@FunctionalInterface
interface MyFunctionalInterface2 {

    //A method with single parameter
    public int incrementByFive(int a);
}

@FunctionalInterface
interface GreetingFunction {
    void sayMessage(String message);
}

interface StringConcat {
    //A method with multiple parameters
    public String sconcat(String a, String b);
}

//interface as parameter
@FunctionalInterface
 interface Foo {
    String method(String string);
}

class UseFoo{
    // takes Foo interface as a parameter:
    public String add(String string, Foo foo) {
        return foo.method(string);
    }
}

// Look closer and you will see that Foo is nothing more than a function that accepts one argument and produces a result. Java 8 already provides such an interface in Function<T,R> from the java.util.function package.// Now we can remove interface Foo completely and change our code to:
class UseFooNoInterface {
    public String add(String string, Function<String, String> fn) {
        return fn.apply(string);
    }
}

public class LambdaSyntax {

    public static void main(String args[]) {
        /// Java Lambda Expression with no parameter
        MyFunctionalInterface1 msg = () -> {
            return "Hello";
        };
        System.out.println(msg.sayHello());

       //Java Lambda Expression with single parameter
        MyFunctionalInterface2 func = (num) -> {
            return num + 5;
        };
        System.out.println(func.incrementByFive(45));

        //example of passing one value
        GreetingFunction greeting = message ->
                System.out.println("Java Programming " + message);
        greeting.sayMessage("Rocks with lambda expressions");

        //Java Lambda Expression with Multiple Parameters
        StringConcat s = (str1, str2)-> str1 + str2;
        System.out.println("Result:"+s.sconcat("I am " , "crazy"));

        //Iterating collections using foreach loop
        List<String> list=new ArrayList<String>();
        list.add("Apples");
        list.add("Banana");
        list.add("Grapes");
        list.add("Orange");
        list.add("Mango");
        list.forEach(
                // lambda expression
                (names)->System.out.println(names)
        );

        //Use Java's Consumer interface to store a lambda expression in a variable
        List<String> fruits=new ArrayList<String>();
        fruits.add("Apples");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Mango");
        Consumer<String> method = (n) -> { System.out.println(n); };
        fruits.forEach(method);

        //example of the Consumer functional interface
        Consumer<String> hello = name -> System.out.println("Hello, " + name);
        for (String name : Arrays.asList("Duke", "Mickey", "Minnie")) {
            hello.accept(name);
        }

        //take interface as parameter
        Foo foo = parameter -> parameter + " from lambda";
        UseFoo uf =new UseFoo();
        String result = uf.add("Message ", foo);
        System.out.println(result);

        //Now we can remove interface Foo completely and change our code to:
        Function<String, String> fn =
                parameter -> parameter + " from lambda no interface";
        UseFooNoInterface ufno = new UseFooNoInterface();
        String result2 = ufno.add("Message ", fn);
        System.out.println(result2);

       //******************************************************
        //Using external functional interface
        Calculate add =(a,b)-> a + b;
        Calculate difference = (a,b) -> Math.abs(a-b);
        Calculate divide =(a,b)-> (b != 0 ? a/b : 0);
        Calculate mult =(c,b)-> (Math.multiplyExact(c,b)); //doesn2t matter what the letters are

        System.out.println("Add :" + add.calc(3,2));
        System.out.println("difference:" + difference.calc(5,10));
        System.out.println("divide:" + divide.calc(5, 0));
        System.out.println("Multiply:" + mult.calc(5, 305));

        /**
         * Tips and Best practices from baeldung
         * https://www.baeldung.com/java-8-lambda-expressions-tips
         */

        /**
         * 1. Use the @FunctionalInterface Annotation
         * 2.Just as with regular interfaces, extending different functional interfaces with the same default method
         * can be problematic.
         * 3.Instantiate Functional Interfaces With Lambda Expressions
         * 4. Avoid Overloading Methods With Functional Interfaces as Parameters
         * 5.Don’t Treat Lambda Expressions as Inner Classes
         * 6.Avoid Blocks of Code in Lambda's Body
         * 7.Avoid Specifying Parameter Types
         * 8.Avoid Parentheses Around a Single Parameter
         * 9. Use Method References
         * 10.Use “Effectively Final” Variables
         * 11.Protect Object Variables from Mutation
         */
    }

}

