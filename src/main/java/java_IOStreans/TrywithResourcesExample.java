package java_IOStreans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class TrywithResourcesExample {
    public static void main(String[] args) {
        trywithoutResources();
        trywithResources();
    }

    //improved
    private static void trywithoutResources() {
        try {
            BufferedReader reader = new BufferedReader(new StringReader("Hello World"));
            //using a reader to read a string and then writing it to a writer
            StringWriter writer = new StringWriter();
            writer.write(reader.readLine());
            System.out.println(writer.toString());
        } catch (IOException ioe) {

        }
    }
    //improved - resource leaks are all handled (If you can use try with resources, then you should uses try with
    // resources. It is a simple, easy, and effective way of preventing resource leaks.
    private static void trywithResources() {
        try(BufferedReader reader = new BufferedReader(new StringReader("Hello Earth"));
            StringWriter writer = new StringWriter();) {

            writer.write(reader.readLine());
            System.out.println(writer.toString());
        } catch (IOException ioe) {

        }
    }
}
