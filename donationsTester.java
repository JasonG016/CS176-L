package DonationsHW;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class donationsTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to process donations now? (enter 'Yes' to continue): ");
        String response = input.nextLine();

        if (response.equalsIgnoreCase("Yes")) {
            Donations giveToMe = new Donations();
            processDonationsFromFile(giveToMe, "Donations.txt");
            giveToMe.getStatistics();
        } else {
            System.out.println("Ending now without processing donations");
        }

        input.close();
    }

    private static void processDonationsFromFile(Donations donations, String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if ("<EOF>".equals(line)) {
                    break;
                }

                String[] parts = line.split(">");
                if (parts.length == 2) {
                    String category = parts[0].substring(1).trim();
                    double donation = Double.parseDouble(parts[1].trim());

                    donations.processDonation(category, donation);
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
