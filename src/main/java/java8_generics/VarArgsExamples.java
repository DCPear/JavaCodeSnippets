package java8_generics;

/**
 * Varargs help us avoid writing boilerplate code by introducing the new syntax that can handle an arbitrary number
 * of parameters automatically – using an array under the hood.
 * We can define them using a standard type declaration, followed by an ellipsis:
 * varargs are arrays so we need to work with them just like we'd work with a normal array.
 *
 * Rules:
 * Varargs are straightforward to use. But there're a few rules we have to keep in mind:
 * Each method can only have one varargs parameter
 * The varargs argument must be the last parameter
 * ***Understanding Heap pollution
 * https://arbitrary-but-fixed.net/teaching/java/2018/02/01/java-generic-arrays-varargs.html
 * https://www.baeldung.com/java-varargs *
 */

public class VarArgsExamples {

    // A method that takes variable number of integer
    // arguments.
    static void fun(int ...a)
    {
        System.out.println("Number of arguments: " + a.length);

        // using for each loop to display contents of a
        for (int i: a)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void printShoppingList(String... items) {
        System.out.println("SHOPPING LIST");
        int j = 1;
        //for (int i = 0; i < items.length; i++) {
        for (String i: items)
           // System.out.println(i + 1 + ": " + items[i]);
            System.out.println(j++ + ": " + i);

        System.out.println();
    }

        public static void main(String[] args) {
        fun(100);         // one parameter
        fun(1, 2, 3, 4);  // four parameters
        fun();            // no parameter

       printShoppingList("Apples","Banana", "Cherries");
       printShoppingList("Bread", "Milk", "Eggs", "Bananas");
    }
}
