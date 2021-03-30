package java8_functionalJava;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

public class StreamExample {
    @Getter
    @AllArgsConstructor
    public static class Book {

        private String author;
        private String title;

        @Override
        public String toString() {
            return ("Author: " + author + " Title: " + title);
        }
    }

    //one filter
//    public static void main(String[] args) {
//        ArrayList<Book> books = populateLibrary();
//        books.stream().filter(book -> {
//            return book.getAuthor().startsWith("J");
//        }).forEach(System.out::println);

        //two filter - one more lazy method - As with normal method only one value is returned
    public static void main(String[] args) {
        ArrayList<Book> books = populateLibrary();

        books.stream().filter(book -> {
            return book.getAuthor().startsWith("J");
        }).filter(book -> {
            return book.getTitle().startsWith("E");
        }).forEach(System.out::println);

        System.out.println();
        /**
         * parallelStream
         * One of the advantages of using streams over using for loops, is that you can run iterations in parallel.
         *  use of parallel streams so that multiple cores can be used at the same time to filter the elements
         */
        books.parallelStream().filter(book -> {
            return book.getAuthor().startsWith("J");
        }).forEach(System.out::println);

    }

    static ArrayList<Book> populateLibrary() {
        ArrayList<Book> books = new ArrayList();
        books.add(new Book("Alice Walker", "The Color Purple"));
        books.add(new Book("Alice Walker", "Meridian"));
        books.add(new Book("Toni Morrison", "Beloved"));
        books.add(new Book("Toni Morrison", "Jazz"));
        books.add(new Book("Toni Morrison", "Paradise"));
        books.add(new Book("John Steinbeck", "The Grapes of Wrath"));
        books.add(new Book("John Steinbeck", "East of Eden"));
        books.add(new Book("Kazuo Ishiguro", "The Remains of the Day"));
        books.add(new Book("Kazuo Ishiguro", "Never Let Me Go"));
        books.add(new Book("Kazuo Ishiguro", "The Buried Giant"));
        books.add(new Book("Jane Austen", "Pride and Prejudice"));
        books.add(new Book("Jane Austen", "Emma"));
        books.add(new Book("Jane Austen", "Persuasion"));
        books.add(new Book("Jane Austen", "Mansfield Park"));
        books.add(new Book("Chinua Achebe", "Things Fall Apart"));
        books.add(new Book("Chinua Achebe", "No Longer at Ease"));
        books.add(new Book("Chinua Achebe", "Home and Exile"));
        return books;
    }

}
