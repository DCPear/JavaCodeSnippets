package java_threads;

/**
 * implements runnable interface instead of extending thread class. (this is beneficial as
 * in Java, you are only allowed to extend one class.)
 */

public class RunnableInterfaceExample implements Runnable{
    @Override
    public void run() {
        int i = 1;
        while(i <= 10) {
            System.out.println(i + " " + Thread.currentThread().getName());
            i++;
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableInterfaceExample());
        thread1.start();

        Thread thread2 = new Thread(() -> {
            int i = 0;
            while (i <= 10) {
                System.out.println(i + " " + Thread.currentThread().getName());
                i++;
            }
        });
        thread2.start();
    }
}
