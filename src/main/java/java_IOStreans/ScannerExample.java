package java_IOStreans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *        https://www.baeldung.com/java-scanner
 */

public class ScannerExample {

    public static void main(String[] args) {
      try(Scanner scanner = new Scanner(System.in)) {

          System.out.print("Enter your name: ");
          String name = scanner.nextLine();
          System.out.print("Enter your gender: ");
          char gender = scanner.nextLine().charAt(0);
          System.out.print("Enter your age: ");
          int age = scanner.nextInt();
          System.out.print("Enter your mobile number: ");
          long mobileNo = scanner.nextLong();
          System.out.print("Enter your height: ");
          double height = scanner.nextDouble();
          System.out.print("Enter the grade percentage: ");
          float percentage = scanner.nextFloat();
          scanner.close();
          System.out.println("Your details :");
          System.out.println("name : " + name);
          System.out.println("gender : " + gender);
          System.out.println("age : " + age);
          System.out.println("mobile no : " + mobileNo);
          System.out.println("height: " + height);
          System.out.println("percentage: " + percentage);
      }

        String input = "1,2,3,4,5";
        try (Scanner s = new Scanner(input).useDelimiter(",")) {
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }

        try (Scanner sc = new Scanner(new File("/Projects_Java/JavaCodeSinippets/pom.xml"))) {
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
