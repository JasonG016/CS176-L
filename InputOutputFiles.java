package inputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class InputOutputFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath;

        do {
            System.out.print("Please enter the path to open the input file (e.g., C:\\Downloads\\lines.txt): ");
            filePath = scanner.nextLine();

            try {
                File inputFile = new File(filePath);
                Scanner fileScanner = new Scanner(inputFile);
                PrintWriter outputFile = new PrintWriter("C:\\Users\\geckert\\Downloads\\e02\\student\\outlines.txt");

                while (fileScanner.hasNext()) {
                    String what = fileScanner.next();
                    outputFile.println(what);
                }

                fileScanner.close();
                outputFile.close();
                System.out.println("File processed successfully.");
                break; // Break out of the loop if the file is processed successfully
            } catch (FileNotFoundException e) {
                System.out.println("File is not found, please try again.");
            }
        } while (true); // Continue prompting until a valid file path is provided

        scanner.close();
    }
}
