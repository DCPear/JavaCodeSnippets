package java8_lambda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.*;

/**
 * A Functional Interface is one that contains exactly one abstract method
 * Java 8 added two new packages java.util.function /java.util.stream
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 * https://dzone.com/articles/cheatsheet-java-functional-interfaces
 * https://www.baeldung.com/java-predicate-chain
 * https://www.journaldev.com/17072/java-predicate
 */

public class FunctionalInterfaces {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // PREDICATE - takes one (or two) argument(s) and returns a boolean (5 variants)
    static Boolean checkAge(int age){
        if(age>17)
            return true;
        else return false;
    }
    public static void main(String[] args){
        // Using Predicate interface
        Predicate<Integer> predicate =  FunctionalInterfaces::checkAge;
        // Calling Predicate method
        boolean result = predicate.test(25);
        System.out.println(result);

        //using the test method of Predicate
        Predicate<String> stringLen  = (s)-> s.length() < 10;
        boolean len = stringLen.test("StringerMoney");
        System.out.println(len);
        System.out.println(stringLen.test("Apples") + " - Apples is less than 10");

        //CONSUMER - takes one (or two) arguments and returns no value (8 variants)
        Consumer<String> showThreeTimes = value -> {

            System.out.println(value);
            System.out.println(value);
            System.out.println(value);
        };

        //Consumer example uses accept method
        showThreeTimes.accept("blue sky");
        showThreeTimes.accept("old falcon");
        Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
        consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");

        //Function example- ist value input, 2nd value return
        Function<Integer,String> converter = (num)-> Integer.toString(num);
        System.out.println("length of 2656: " + converter.apply(2656).length());

        // it takes no arguments and returns a result.
        // Supplier example
        // note: must use the empty argument
        Supplier<String> s  = ()-> "Java is fun";
        System.out.println(s.get());

        Supplier<LocalDateTime> ldt = () -> LocalDateTime.now();
        LocalDateTime time = ldt.get();

        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);

        //Binary Operator example
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("add 10 + 25: " + add.apply(10, 25));

        //Unary Operator example
        UnaryOperator<String> str  = (msg)-> msg.toUpperCase();
        System.out.println(str.apply("This is my message in upper case"));
    }
}
