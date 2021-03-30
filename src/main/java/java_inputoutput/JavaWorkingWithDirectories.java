package java_inputoutput;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */

public class JavaWorkingWithDirectories {
    public static void main(String[] args) throws IOException {
        getWorkingDirectory();

        //create directory
        new File("src/main/resources/myDirectory").mkdir();

        //using path class
        createDirectory();

        listFilesInDirectory();

    }

    /**
     * https://www.baeldung.com/java-current-directory
     */
    private static void getWorkingDirectory() {
        //getting current working directory
        String userDirectory1 = System.getProperty("user.dir");
        System.out.println("user dir " + userDirectory1);

        String userDirectory2 = new File("").getAbsolutePath();
        System.out.println(" absolute path " + userDirectory2);

        String userDirectory3 = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
        System.out.println(" file system " + userDirectory3);

        String userDirectory4 = Paths.get("")
                .toAbsolutePath()
                .toString();
        System.out.println(" simpler solution " + userDirectory4);
    }

    private static void createDirectory() throws IOException {
        String fileName = "src/main/resources/tmp";

        Path path = Paths.get(fileName);

        if (!Files.exists(path)) {

            Files.createDirectory(path);
            System.out.println(path.getFileName() + " Directory created");
        } else {

            System.out.println(path.getFileName() + " Directory already exists");
        }
        Path path2 = Paths.get("D:\\Projects_Java\\JavaCodeSinippets\\pom.xml");
        //printout information
        System.out.println("get parent: " + path2.getParent());
        System.out.println("get root: " + path2.getRoot());

        //delete
        try {
            Files.deleteIfExists((path));
            System.out.println("Directory deleted");
        } catch (IOException ex) {

        }
    }

    private static void listFilesInDirectory() {
        //create a filter only to print out files not the directories
        FilenameFilter filter = (file, fileName) -> {
            return fileName.contains(".");
        };

        //list everything in a directory to an array;
        String[] contents = new File("src/main/resources/").list(filter);
        for (String file : contents) {
            System.out.println(file);
        }
    }
}
