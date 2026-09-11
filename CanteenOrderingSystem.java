import java.util.Scanner;
 
public class CanteenOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== M E N U ====");
        System.out.println("1. Sisig       - $80.00");
        System.out.println("2. Caldereta   - $60.00");
        System.out.println("3. Dinuguan    - $70.00");
        System.out.println("4. Menudo      - $60.00");
        System.out.println("5. Afritada    - $55.00");
        System.out.println();

        int totalQuantityPurchased = 0;
        double totalAmountBeforeDeductions = 0.0;
        double totalDeductions = 0.0;

        char orderAgain = 'Y';

        while (orderAgain == 'Y' || orderAgain == 'y') {
            System.out.print("Enter item number: ");
            int itemNumber = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (itemNumber < 1 || itemNumber > 5 || quantity < 1 || quantity > 10 ) {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = scanner.next().charAt(0);
                System.out.println();
                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char studentStatus = scanner.next().charAt(0);
            boolean isStudent = (studentStatus == 'Y' || studentStatus == 'y');

            double unitPrice = 0.0;
            switch (itemNumber) {
                case 1:
                    unitPrice = 80.00;
                    break;
                case 2:
                    unitPrice = 60.00;
                    break;
                case 3:
                    unitPrice = 70.00;
                    break;
                case 4:
                    unitPrice = 60.00;
                    break;
                case 5:
                    unitPrice = 55.00;
                    break;
            }

            double subTotal = unitPrice * quantity;
            double discountRate = 0.0;

            if (isStudent && subTotal >= 500.0) {
                discountRate = 0.15;
            } else if (isStudent) {
                discountRate = 0.10;
            } else if (subTotal >= 500.0) {
                discountRate = 0.05;
            } else {
                discountRate = 0.0;
            }

            double discount = subTotal * discountRate;
            double orderTotal = subTotal - discount;

            totalQuantityPurchased += quantity;
            totalAmountBeforeDeductions += subTotal;
            totalDeductions += discount;

            System.out.println();
            System.out.printf("Subtotal: $%.2f%n", subTotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);
            System.out.println();

            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = scanner.next().charAt(0);
            System.out.println();
        } 
        
        double finalAmountToPay = totalAmountBeforeDeductions - totalDeductions;

        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalQuantityPurchased);
        System.out.printf("Total before discount: $%.2f%n", totalAmountBeforeDeductions);
        System.out.printf("Total discount: $%.2f%n", totalDeductions);
        System.out.printf("Final amount: $%.2f%n", finalAmountToPay);
        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}