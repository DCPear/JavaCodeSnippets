package java_inputoutput;
/**
 * https://www.baeldung.com/java-copy-file
 * https://zetcode.com/java/copyfile/
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class javaCopyFileContent {
    public static void main(String[] args) {

        Path source = Paths.get("src/main/resources/input.txt");
        Path dest = Paths.get("src/main/resources/filename.txt");

        try {
            Files.copy(source, dest, REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
