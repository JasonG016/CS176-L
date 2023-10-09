package HW;

public class Array {
    public static void main(String[] args) {
        double[] values = {25.3, 100, -10, -1.5, 13, 98.6, 17, 123.145, 125.6, 123.146};

        // Task 1: Printing all elements of the array in a single row, separated by spaces
        System.out.print("Elements of the array: ");
        for (double value : values) {
            System.out.print(value + " ");
        }
        System.out.println(); // Print a new line after the elements.

        // Task 2: Computing and printing the largest element in the array
        double largest = values[0];
        for (double value : values) {
            if (value > largest) {
                largest = value;
            }
        }
        System.out.println("Largest element in the array: " + largest);

        // Task 3: Computing and printing a count of elements in the array that are negative
        int negativeCount = 0;
        for (double value : values) {
            if (value < 0) {
                negativeCount++;
            }
        }
        System.out.println("Number of negative elements in the array: " + negativeCount);
    }
}
