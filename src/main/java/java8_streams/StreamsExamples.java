package java8_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * java.util.stream package
 * not related to Java IO streams
 * represents sequence of elements, help traverse collections
 * Most stream operations take a lambda expression.
 * Stream operations are categorized as either intermediate or terminal.
 * Elements in a stream cannot be changed or mutated, but it can be saved to a new collection.
 */

public class StreamsExamples {
    public static void main(String[] args) {

        Arrays.asList("red", "green", "blue")
                .stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println); //print blue

        //example of Stream.of with a filter
        Stream.of("apple", "pear", "banana", "cherry", "apricot") //another way to create a collection
                .filter(fruit -> {
                    System.out.println(" before filter: " + fruit);
                    return fruit.startsWith("a"); //predicate
                })
                //if the foreach is removed, nothing will print,
                //the foreach makes it a terminal event
                .forEach(fruit -> System.out.println("Starts with A: " + fruit));

        //using a stream and map operation to create a list of words in caps
        List<String> collected = Stream.of("Java", " Rocks")
                .map(string -> string.toUpperCase())
                .collect(toList());
        System.out.println(collected.toString());

        /**
         *  special streams for some of the primitive data types, specifically int, long, and double.
         *  They are int stream, long stream, and double stream.
         */


        IntStream.range(1, 4)
                .forEach(System.out::println);

        //find the average of the numbers squared
        Arrays.stream(new int[]{1, 2, 3, 4})
                .map(n -> n * n)
                .average()
                .ifPresent(System.out::println);

        //map doubles to ints
        Stream.of(1.5, 2.3, 3.7)
                .mapToInt(Double::intValue)
                .forEach(System.out::println);
    }
}
