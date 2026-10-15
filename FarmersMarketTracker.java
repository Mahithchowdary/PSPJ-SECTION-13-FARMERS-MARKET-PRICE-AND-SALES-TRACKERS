
import java.util.*;

class Product {
    String name;
    double price;
    int quantity;
    double sales;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sales = price * quantity;
    }
}

public class FarmersMarketTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("================================");
        System.out.println(" Farmers' Market Sales Tracker");
        System.out.println("================================");

        try {
            System.out.print("Enter number of products: ");
            int n = sc.nextInt();
            sc.nextLine();

            if (n <= 0) {
                System.out.println("Enter a valid number of products.");
                return;
            }

            // Input stage
            for (int i = 1; i <= n; i++) {
                System.out.println("\nProduct " + i);

                System.out.print("Enter product name: ");
                String name = sc.nextLine();

                System.out.print("Enter price per kg: ");
                double price = sc.nextDouble();

                System.out.print("Enter quantity sold (kg): ");
                int quantity = sc.nextInt();
                sc.nextLine();

                if (price < 0 || quantity < 0) {
                    System.out.println("Price and quantity cannot be negative.");
                    i--;
                    continue;
                }

                Product p = new Product(name, price, quantity);
                products.add(p);
            }

            // Data pipeline using Stream
            double totalSales = products.stream()
                    .mapToDouble(p -> p.sales)
                    .sum();

            // Display product details
            System.out.println("\n========== SALES REPORT ==========");

            products.stream()
                    .forEach(p -> {
                        System.out.println("Product: " + p.name);
                        System.out.println("Price per kg: Rs. " + p.price);
                        System.out.println("Quantity sold: " + p.quantity + " kg");
                        System.out.println("Sales: Rs. " + p.sales);
                        System.out.println("--------------------------------");
                    });

            // Filter products with sales above Rs. 100
            System.out.println("\nProducts with sales above Rs. 100:");

            products.stream()
                    .filter(p -> p.sales > 100)
                    .forEach(p -> System.out.println(p.name + " - Rs. " + p.sales));

            // Sort products by sales
            System.out.println("\nProducts sorted by sales:");

            products.stream()
                    .sorted(Comparator.comparingDouble(p -> p.sales))
                    .forEach(p -> System.out.println(p.name + " - Rs. " + p.sales));

            System.out.println("\n================================");
            System.out.println("Total Sales: Rs. " + totalSales);
            System.out.println("================================");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers correctly.");
        } finally {
            sc.close();
        }
    }
}

    
