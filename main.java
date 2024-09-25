/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carloscc2.lab.pkg3.challenge;

/**
 *
 * @author CARLOS
 */
//programmer:Carlos Miguel B Perez
//activity:create a 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    String name;
    double price;
    int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }
}

public class GroceryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();
        double totalAmount = 0;
        boolean moreItems = true;

        // Input items from the user
        while (moreItems) {
            System.out.println("Enter item name: ");
            String itemName = scanner.nextLine();

            System.out.println("Enter item price: ");
            double itemPrice = getValidDouble(scanner);

            System.out.println("Enter item quantity: ");
            int itemQuantity = getValidInt(scanner);

            items.add(new Item(itemName, itemPrice, itemQuantity));
            totalAmount += itemPrice * itemQuantity;

            System.out.println("Do you want to add more items? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                moreItems = false;
            }
        }

        // Input discount and tax
        System.out.println("Enter discount percentage (0 if no discount): ");
        double discount = getValidDouble(scanner);

        System.out.println("Enter sales tax percentage: ");
        double taxRate = getValidDouble(scanner);

        // Calculate final amount
        double discountAmount = (discount / 100) * totalAmount;
        double discountedTotal = totalAmount - discountAmount;
        double taxAmount = (taxRate / 100) * discountedTotal;
        double finalTotal = discountedTotal + taxAmount;

        // Output results
        System.out.printf("Subtotal: $%.2f%n", totalAmount);
        System.out.printf("Discount: -$%.2f%n", discountAmount);
        System.out.printf("Total after discount: $%.2f%n", discountedTotal);
        System.out.printf("Sales tax: $%.2f%n", taxAmount);
        System.out.printf("Final total amount: $%.2f%n", finalTotal);

        scanner.close();
    }

    private static double getValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number: ");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextDouble();
    }

    private static int getValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer: ");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt();
    }
}



