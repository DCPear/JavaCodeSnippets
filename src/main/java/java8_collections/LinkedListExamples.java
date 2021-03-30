package java8_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExamples {
    //Linked Lists
    public static void main(String[] args) {
        LinkedList<String> toDoList = new LinkedList<String>();

        //1. add elements to the list
        toDoList.add("gardening");
        toDoList.add("laundry");
        toDoList.add("make beds");
        toDoList.add("dust");

        //2. adding to the first position and last and to a particular position
        toDoList.addFirst("shower");
        toDoList.addLast("sweep floor");
        toDoList.add(3, "shopping");

        System.out.println("Linked list size " + toDoList.size());
        System.out.println("first item: " + toDoList.getFirst());
        System.out.println("last item: " + toDoList.getLast());
        System.out.println("5th item: "+ toDoList.get(4));

        //print
        System.out.print("\nShopping list: ");
        System.out.println(toDoList);

        //iterating
        //print
        System.out.print("\nShopping list: \n");
        Iterator<String> iterator = toDoList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //remove first, last and from a particular position
        toDoList.removeFirst();
        toDoList.removeLast();
        System.out.println(toDoList);
        toDoList.remove("dust");
        System.out.println("\nAfter removing second elements:" + toDoList);
        toDoList.remove(3); //exception if the element doesn't exist
        System.out.println(toDoList);

        //Iterating LinkedList again
        System.out.println("\nAfter removing second elements:");
        Iterator<String> iterator2=toDoList.iterator();
        while(iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }

        //replace with set
        System.out.println("\n\nusing set before :" + toDoList);
        toDoList.set(0,"spa time");
        System.out.println("this replaces the first item: "+ toDoList.get(0));
        System.out.println("using set after :" + toDoList);

        //addAll
        ArrayList<String>list = new ArrayList<String >(Arrays.asList("jog","write diary","nap"));
        toDoList.addAll(3,list); //exception if the index doesn2t exist
        System.out.println("\nAfter using addall :" + toDoList);

        //index of
        System.out.println("when to nap: " + toDoList.indexOf("nap"));

        toDoList.add(4,"nap");
        System.out.println("\nIndex of :" + toDoList);
        System.out.println(" first Index of nap " + toDoList.indexOf("nap"));
        System.out.println(" last Index of nap " + toDoList.lastIndexOf("nap"));

        System.out.println("\nremove occurrence :" + toDoList);
        toDoList.add(2,"nap");
        System.out.println("\nBefore using remove occurrence :" + toDoList);
        System.out.println(" remove first occurence of nap " + toDoList.removeFirstOccurrence("nap"));
        System.out.println(" remove last occurence of nap " + toDoList.removeLastOccurrence("nap"));
        System.out.println("After using remove occurrence :" + toDoList);

        System.out.println("poll " + toDoList.poll());
        System.out.println(toDoList);
        System.out.println("poll first " + toDoList.pollFirst());
        System.out.println(toDoList);
        System.out.println("poll last " + toDoList.pollLast());
        System.out.println("original " + toDoList);
        System.out.println(toDoList.contains("gardening"));
        System.out.println("are contents matching?" + toDoList.containsAll( list));
        Object clonee = toDoList.clone();
        System.out.println("clone " + clonee);
        toDoList.clear();
        System.out.println("todolist: " + toDoList + "  clonee: "+ clonee);

    }
}
