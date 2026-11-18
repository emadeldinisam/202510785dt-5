package com.mycompany.oldporolproject;

import java.util.Scanner;

public class ja{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Collect information from the user
        System.out.print("Enter customer's name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer's age: ");
        int age = scanner.nextInt();

        System.out.print("Enter price of the meal ($): ");
        double mealPrice = scanner.nextDouble();

        System.out.print("Enter number of drinks ordered: ");
        int drinkCount = scanner.nextInt();

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();

        System.out.print("Enter service rating from 1 to 5: ");
        int serviceRating = scanner.nextInt();

        // Validate service rating (must be between 1 and 5)
        if (serviceRating < 1 || serviceRating > 5) {
            System.out.println("Error: Service rating must be between 1 and 5!");
            scanner.close();
            return; // Terminate the program if rating is invalid
        }

        // 2. Constants and basic calculations
        final double DRINK_PRICE = 15.50;
        double drinksCost = drinkCount * DRINK_PRICE;
        double subtotal = mealPrice + drinksCost;

        // 3. Apply discount rules (Student: 10%, Senior: 5%, only the larger discount applies)
        double discountPercentage = 0.0;
        if (isStudent) {
            discountPercentage = 0.10; // 10%
        }
        
        if (age >= 60) {
            if (0.05 > discountPercentage) {
                discountPercentage = 0.05; // 5% if not a student or if senior discount is larger
            }
        }

        double discountAmount = subtotal * discountPercentage;
        double priceAfterDiscount = subtotal - discountAmount;

        // 4. Apply tip rule (Add 10% tip when service rating is 4 or 5)
        double tipAmount = 0.0;
        if (serviceRating == 4 || serviceRating == 5) {
            tipAmount = priceAfterDiscount * 0.10; // 10% tip
        }

        // 5. Calculate exact final bill
        double finalBill = priceAfterDiscount + tipAmount;

        // 6. Cast the final bill to an int to show the amount without cents
        int wholeAmount = (int) finalBill;

        // 7. Display the required receipt
        System.out.println("\n==================================");
        System.out.println("         SMART RESTAURANT         ");
        System.out.println("==================================");
        System.out.println("Customer: " + customerName);
        System.out.printf("Meal: $%.2f\n", mealPrice);
        System.out.printf("Drinks: $%.2f\n", drinksCost);
        System.out.printf("Discount: $%.2f\n", discountAmount);
        System.out.printf("Tip: $%.2f\n", tipAmount);
        System.out.printf("Final bill: $%.2f\n", finalBill);
        System.out.println("Whole amount: $" + wholeAmount);
        System.out.println("==================================");

        scanner.close();
    }
}