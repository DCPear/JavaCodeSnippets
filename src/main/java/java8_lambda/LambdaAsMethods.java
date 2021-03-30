package java8_lambda;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

/**
 * Another feature of Java 8 is we can now take any type of method and convert it into a lambda including
 * static method, instance methods, and even constructors.
 * A method reference is a syntactic shortcut for creating a lambda from an existing method. Instead of providing
 * an implementation body, a method reference refers to an existing class's or object's method. As with a lambda,
 * a method reference requires a target type.
 * https://www.baeldung.com/java-method-references
 */

public class LambdaAsMethods {
    public static void main(String[] args) {

    //Reference to a Static Method
        List<String> messages = Arrays.asList("an apple a day ", "keeps ", "the doctor away");
        System.out.println(messages);
        //lambda
        messages.forEach(word -> System.out.print(word));
        System.out.println();
        messages.forEach(word -> System.out.print(StringUtils.capitalize(word)));
        //method reference. Notice that method references always utilize the :: operator.
        // className::staticMethodName
        messages.forEach(StringUtils::capitalize);
        messages.stream().forEach((System.out::println));

        /**
         * IntFunction is an in-built functional interface in the java.util.Function package. It accepts an argument of
         * int data type, operates on it and produces a result of any data type. It is a specialization of the Function
         * interface. It has an apply method. It applies the logic in this method on the int argument passed in and
         * produces a result of the specified data type.
         * https://learnjava.co.in/intfunction-in-java-8-with-code-sample/
         */
        System.out.println();
        IntFunction<String> intToString = num -> Integer.toString(num);
        System.out.println("expected value 3, actual value: " + intToString.apply(123).length());

        //static method reference using ::
        IntFunction<String> intToString2 = Integer::toString;
        System.out.println("expected value 4, actual value:  " +
                intToString2.apply(4567).length());

        //lambdas made using a constructor
        Function<String, BigInteger> newBigInt = BigInteger::new;
        System.out.println("expected value: 123456789, actual value: "+
                newBigInt.apply("123456789"));

        //example of a lambda made from an instance method
        Consumer<String> print = System.out::println;
        print.accept("Coming to you directly from a lambda...");

        //these two are the same using the static method concat
        UnaryOperator<String> greeting = x -> "Hello, ".concat(x);
        System.out.println(greeting.apply("World!"));

        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        System.out.println(makeGreeting.apply("Earth!"));

    }

}
