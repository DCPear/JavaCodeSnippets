package java_IOStreans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * file inputs
 * read out a file that contains a multiple lines and print out line by line
 * https://www.baeldung.com/java-buffered-reader
 * https://mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
 *  A similar solution could have been achieved using the scanner class, and the code would be
 *  slightly simpler and shorter. But scanners work slightly differently, in that they treat
 *  each section as a token. Buffered reader just returns a continuous stream.
 *  An advantage of buffered reader is that it is synchronized, which means it can safely be
 *  used in a multi-threaded application. It is also faster than a scanner.
 *  better option for  reading in long sections of text.
 */
public class BufferedReaderExample {
    public static void main(String[] args) throws FileNotFoundException {

        int bufferSize = 8 * 1024;
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("src/main/resources/input.txt"), bufferSize);
            //read a line
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
