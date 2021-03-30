package java8_collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Collections API introduced in Java 7 is heavily used in Lamda notations
 * A collection is an object that groups multiple elements into a single unit.
 * Collections are used to store, retrieve, manipulate, and communicate aggregate data.
 * Interfaces provided : Set -collection that does not contain duplicates.
 *                       List -  an ordered collection based on the way the user entered the data.
 *                       map-object that maps keys to values
 *  methods: https://www.javatpoint.com/collections-in-java
 *           https://www.tutorialspoint.com/java/java_collection_interface.htm
 *
 *           https://www.baeldung.com/java-8-collectors
 *
 *           For more information on collections, check out the Oracle tutorial here
 *           at https://docs.oracle.com/javase/tutorial /collections/interfaces/collection.html
 */

public class CollectionsExamples {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Book {
        private String title;
        private String authorFName;
        private String authorLName;
        private int pages;

        public String toString()
        {
            return getTitle()+" Written By: "+getAuthorFName()+" " +getAuthorLName()+"\n";
        }
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Paul", "Jane", "Michaela", "Sam");

        //sort-old way
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        //first iteration with lambda
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //now remove the return statement
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        //now remove the data types and allow the compile to infer the type
        Collections.sort(names, (a, b) -> b.compareTo(a));

        //****************
        //total pages in your book collection
        Book book1 = new Book("Miss Peregrine's Home for Peculiar Children",
                "Ranson", "Riggs", 382);
        Book book2 = new Book("Harry Potter and The Sorcerers Stone",
                "JK", "Rowling", 411);
        Book book3 = new Book("The Cat in the Hat",
                "Dr", "Seuss", 45);

        //use collect to aggregate values
        List<Book> books = Arrays.asList(book1, book2, book3);
        int total = books.stream()
                .collect(Collectors.summingInt(Book::getPages));
        System.out.println(total);

        //create a list with duplicates
        List<Book> dupBooks = Arrays.asList(book1, book2, book3, book1, book2);
        System.out.println("Before removing duplicates: ");
        System.out.println(dupBooks.toString());

        Collection<Book> noDups = new HashSet<>(dupBooks);
        System.out.println("After removing duplicates: ");
        System.out.println(noDups.toString());

        //aggregate author first names into a list
        List<String> list = books.stream()
                .map(Book::getAuthorLName)
                .collect(Collectors.toList());
        System.out.println(list);

        //example of using Set to eliminate dups and sort automatically
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 3, 3, 2, 1, 1, 1));
        System.out.println(numbers.toString());
    }
}
