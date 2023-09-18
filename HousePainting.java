package House;
import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the cost per square foot: ");
        double costPerSqFt = scanner.nextDouble();

        System.out.print("Please enter the length of the house: ");
        double length = scanner.nextDouble();

        System.out.print("Please enter the width of the house: ");
        double width = scanner.nextDouble();

        System.out.print("Please enter the height of the house: ");
        double height = scanner.nextDouble();

        System.out.print("Please enter the number of windows: ");
        int numWindows = scanner.nextInt();

        System.out.print("Please enter the length of a window: ");
        double windowLength = scanner.nextDouble();

        System.out.print("Please enter the width of a window: ");
        double windowWidth = scanner.nextDouble();

        System.out.print("Please enter the number of doors: ");
        int numDoors = scanner.nextInt();

        System.out.print("Please enter the length of a door: ");
        double doorLength = scanner.nextDouble();

        System.out.print("Please enter the width of a door: ");
        double doorWidth = scanner.nextDouble();

        double peakSideSqFt = length * width + 0.5 * (length * (height - width));
        double normalSideSqFt = length * width;
        double totalSqFt = 2 * peakSideSqFt + 2 * normalSideSqFt;
        double windowDoorSqFt = (numWindows * windowLength * windowWidth) + (numDoors * doorLength * doorWidth);
        double paintableSqFt = totalSqFt - windowDoorSqFt;
        double estimate = paintableSqFt * costPerSqFt;

        System.out.println("Your total paintable surface area is " + paintableSqFt + " square feet.");
        System.out.printf("Your estimate is $" + estimate + ".");

        scanner.close();
    }
}
