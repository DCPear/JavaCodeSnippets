package java8_generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * For reducing bugs and adding an extra layer of abstraction over types.
 * https://www.baeldung.com/java-generics
 */
public class GenericsInJava {


    // generic method printArray
    public static < E > void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    //In Java, object is a parent type of all other object types, so I can pass in arrays and lists of any types
    // to this method

    //public static List arrayToList(Object[] array, List<Object> list) {
    public static <T> List<T> arrayToList(T[] array, List<T> list) {
        //for (Object object : array) {
        for (T object : array) {
            list.add(object);
        }
        return list;
    }

    //Note:Because T is a generic type, it doesn't matter what type I use, as long as it is the same type every time
    // I use it. The type of the array list can also be a supertype of the type of the element type of the array

    public static void main(String[] args) {

        //Compile but give run time error
//        List list = new ArrayList();
//        list.add("abc");
//        list.add(new Integer(5)); //OK
//
//        for(Object obj : list){
//            //type casting leading to ClassCastException at runtime
//            String str=(String) obj;
//        }
        //No Generics
        List list = new LinkedList();
        list.add(101010);
        Integer i = (Integer) list.iterator().next(); //will require explicit casting
        System.out.println(i);

        //modified with Generics
        List<Integer> list2 = new LinkedList<>();
        list.add(101010);
        System.out.println(list.iterator().next());

        //No Generics
        List names = new
                ArrayList();
        names.add("Kelly");
        String name = (String) names.get(0);
        System.out.println("First name: " + name);
        names.add(7); // compiler does not complain

        //modified with Generics
        List<String> names2 = new ArrayList();
        names2.add("Kelly");
        String name2 = names2.get(0);
        System.out.println("First name: " + name2);
       // names2.add(7); won't compile

        /**
         * Generic methods - those methods that are written with a single method declaration and can be called with
         * arguments of different types.
         * public <T> List<T> fromArrayToList(T[] a) {
         *     return Arrays.stream(a).collect(Collectors.toList());
         * }
         */

        // Create arrays of Integer, Double and Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("Array integerArray contains:");
        printArray(intArray);   // pass an Integer array

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray);   // pass a Double array

        System.out.println("\nArray characterArray contains:");
        printArray(charArray);   // pass a Character array

        Boolean[] boolArray = {true, false, true};

        List<Character> charList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
        List<Integer> intList = arrayToList(intArray, new ArrayList<>());
        System.out.println(intList);

        }
    }

