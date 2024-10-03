//programmer:Carlos Miguel B perez 
//project:Grocery Store Discount Calculator (Using if-else)
import java.util.Scanner;

public class GroceryStoreDiscountCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the total purchase amount
        System.out.print("Enter the total purchase amount (PHP): ");
        double totalAmount = scanner.nextDouble();

        double discount = 0;
        double finalPrice;

        // Determine the discount based on the total purchase amount
        if (totalAmount < 1000) {
            discount = 0;
        } else if (totalAmount >= 1000 && totalAmount <= 5000) {
            discount = 0.05; // 5%
        } else if (totalAmount >= 5001 && totalAmount <= 10000) {
            discount = 0.10; // 10%
        } else {
            discount = 0.15; // 15%
        }

        // Calculate the final price after discount
        finalPrice = totalAmount - (totalAmount * discount);

        // Display the discount and the final price
        System.out.printf("Discount applied: %.0f%%%n", discount * 100);
        System.out.printf("Final price after discount: PHP %.2f%n", finalPrice);

        // Close the scanner
        scanner.close();
    }
}
