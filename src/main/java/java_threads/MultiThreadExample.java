package java_threads;

/**
 * multi threaded application
 */
public class MultiThreadExample {

    public static class ThreadRun extends Thread {

        @Override
        public void run() {
            int i = 1;
            while(i <= 10) {
                System.out.println(i + " " + this.getName());
                i++;
            }
        }
    }

    public static void main(String[] args) {

        ThreadRun thread1 = new ThreadRun();
        thread1.setName("1st thread");
        thread1.start();

        ThreadRun thread2 = new ThreadRun();
        thread2.setName("2nd thread");
        thread2.start();

    }
}
