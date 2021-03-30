package java8_collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue interface in Java collections has two implementation: LinkedList and PriorityQueue, these two classes
 * implements Queue interface. Queue is an interface so we cannot instantiate it, rather we create instance of
 * LinkedList or PriorityQueue and assign it to the Queue like this:
 *
 * Queue q1 = new LinkedList();
 * Queue q2 = new PriorityQueue();
 *
 */
 class Customer {

    private boolean hasBeenServed;
    private String name;


    public Customer(String name) {
        hasBeenServed = false;
        this.name = name;
    }

    public void serve() {
        hasBeenServed = true;
        System.out.println(name + " has been served");
    }

    @Override
    public String toString(){
        return name;
    }

}

public class QueueExample {

    public static void main(String[] args) {
        /*
         * We cannot create instance of a Queue as it is an
         * interface, we can create instance of LinkedList or
         * PriorityQueue and assign it to Queue
         */
        Queue<Customer> q= new LinkedList<Customer>();
        q.add(new Customer("Sally"));
        q.add(new Customer("Ben"));
        q.add(new Customer("Emma"));
        q.add(new Customer("Fred"));
        System.out.println("Elements in Queue:"+q);
        System.out.println("Head: "+q.element());
        System.out.println("peek(): "+q.peek()); //same as element. returns null if the queue is empty.
        System.out.println("poll(): "+q.poll());
        System.out.println("Elements in Queue:"+q);
        q.add(new Customer("Katy"));
        serveCustomer(q);
        System.out.println("Queue status" + q);

    }

    static void serveCustomer(Queue<Customer> queue) {
        Customer c = queue.poll();
        c.serve();
    }

}
