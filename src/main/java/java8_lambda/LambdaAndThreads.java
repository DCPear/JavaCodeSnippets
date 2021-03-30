package java8_lambda;

public class LambdaAndThreads {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + ": RunnableTest");
        /**
         * 1.Create a Java thread via Runnable using Classic Code
         * Before Java 8, we create and start a thread by creating an anonymous class that implements the Runnable
         * Anonymous Inner Class: Runnable
         */

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run 1");

            }
        };

        // Lambda version of Runnable (no arguments)
        Runnable r2 = () -> System.out.println("run 2");

        // Start both threads
        r1.run();
        r2.run();


        Runnable task1 = new Runnable(){

            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        };

        // Passing a Runnable when creating a new thread
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        });

        // Lambda Runnable
        Runnable task3 = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        };

        Thread thread1 = new Thread(task1);
        thread1.start();

        thread2.start();
        new Thread(r2).start();
        new Thread(task3).start();

    }
}
