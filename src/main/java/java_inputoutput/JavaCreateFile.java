package java_inputoutput;

import java.io.File;
import java.io.IOException;

public class JavaCreateFile {

    public static void main(String[] args) {

        try {
            //this creates a file object
            File file = new File("src/main/resources/filename.txt");
            //create an empty text file. file.createdNewFile returns a boolean
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
