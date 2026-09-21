import java.util.Scanner;

public class FarmersMarketTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String product;
        double price;
        int quantity;
        double sales;
        double totalSales = 0;

        System.out.println("================================");
        System.out.println(" Farmers' Market Sales Tracker");
        System.out.println("================================");

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nProduct " + i);

            System.out.print("Enter product name: ");
            product = sc.nextLine();

            System.out.print("Enter price per kg: ");
            price = sc.nextDouble();

            System.out.print("Enter quantity sold (kg): ");
            quantity = sc.nextInt();
            sc.nextLine();

            sales = price * quantity;
            totalSales = totalSales + sales;

            System.out.println("Product: " + product);
            System.out.println("Sales: Rs. " + sales);
        }

        System.out.println("\n================================");
        System.out.println("Total Sales: Rs. " + totalSales);
        System.out.println("================================");

        sc.close();
    }
} 
