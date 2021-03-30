package java8_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * The BiFunction interface allows us to use parameters of different types, with a return value of a third type.
 * @FunctionalInterface
 * public interface BiFunction<T, U, R> {
 *
 *       R apply(T t, U u);
 * https://www.baeldung.com/java-bifunction-interface
 * https://stackoverflow.com/questions/43873721/what-do-we-need-the-bifunction-interface-for
 */
public class BiFuncExamples {

    //generalized using Lambda
    private static <T, U, R> List<R> listCombiner(
            List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }

    private static <T, U, R> BiFunction<T, U, R> asBiFunction(BiFunction<T, U, R> function) {
        return function;
    }

    public static void main(String[] args) {

        // takes two Integers and return an Integer
        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
        Integer result = func.apply(2, 3);
        System.out.println(result); // 5

        // take two Integers and return an Double
        BiFunction<Integer, Integer, Double> func2 = (x1, x2) -> Math.pow(x1, x2);
        Double result2 = func2.apply(2, 4);
        System.out.println(result2);    // 16.0

        // take two Integers and return a List<Integer>
        BiFunction<Integer, Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1 + x2);
        List<Integer> result3 = func3.apply(2, 3);
        System.out.println(result3);

        //take two strings and return a string
        BiFunction<String, String, String> concat = (a, b) -> a + b;
        String sentence = concat.apply("Hello ", "world");
        System.out.println(sentence);

        // Using addThen() method
        BiFunction<Integer, Integer, Integer> composite1 = (a, b) -> a + b;
        composite1 = composite1.andThen(a -> 2 * a);
        // Printing the results
        System.out.println("Composite1 = " + composite1.apply(2, 3));

        BiFunction<String, String, String> concat2 = (a, b) -> a + b;
        concat2 = concat2.andThen(a-> a+"!!!!!");
        System.out.println(concat2.apply("Hello ","world"));

        //combine Arrays -old way
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        List<String> combined = new ArrayList<>();
        for (int i=0; i < list1.size(); i++) {
            combined.add(list1.get(i) + list2.get(i));
            System.out.print(combined.get(i) + ",");
        }

        //calling the Generalized function
        System.out.println();
        List<String> combined2 = listCombiner(list1, list2, (a, b) -> a + b);
        System.out.print(combined + ",");

        // A BiFunction Method Reference
        System.out.println();
        List<Float> list3 = Arrays.asList(0.1f, 0.2f, 4f);
        List<Float> list4 = Arrays.asList(0.1f, 0.2f, 4f);
       // List<Boolean> combined3 = listCombiner(list3, list4, (a, b) -> a.equals(b));
        List<Boolean> combined3 = listCombiner(list3, list4, Float::equals);
        System.out.print(combined3 + ",");

        //Composing BiFunctions
        System.out.println();
        List<Double> list5 = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Double> list6 = Arrays.asList(0.1d, 0.2d, 4d);
        List<Integer> compose = listCombiner(list5, list6, Double::compareTo);
        System.out.print(compose + ",");

        List<Double> list7 = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Double> list8 = Arrays.asList(0.1d, 0.2d, 4d);

        System.out.println();
        List<Boolean> compose2 = listCombiner(list7, list8,
                asBiFunction(Double::compareTo).andThen(i -> i > 0));
        System.out.print(compose2 + ",");
        }
    }

