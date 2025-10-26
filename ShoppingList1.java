import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList1 {
    public static void main(String[] args) {
        ArrayList<String> shoppingList = new ArrayList<>(); // Dynamic array to store items
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose an option (1-5): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                addItem(shoppingList, scanner);
            } else if (choice.equals("2")) {
                removeItem(shoppingList, scanner);
            } else if (choice.equals("3")) {
                viewList(shoppingList);
            } else if (choice.equals("4")) {
                printSummary(shoppingList);
            } else if (choice.equals("5")) {
                System.out.println("Exiting the program. Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice. Please select 1-5.");
            }
        }
        scanner.close();
    }

    // Display the menu
    public static void displayMenu() {
        System.out.println("\n--- Shopping List Menu ---");
        System.out.println("1. Add item");
        System.out.println("2. Remove item");
        System.out.println("3. View list");
        System.out.println("4. Print summary");
        System.out.println("5. Quit");
    }

    // Add an item to the list (prevents duplicates, case-insensitive)
    public static void addItem(ArrayList<String> list, Scanner scanner) {
        System.out.print("Enter item to add: ");
        String item = scanner.nextLine().trim().toLowerCase();
        if (!item.isEmpty()) {
            if (list.contains(item)) {
                System.out.println("'" + item + "' is already in the list.");
            } else {
                list.add(item);
                System.out.println("'" + item + "' added to the list.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid item.");
        }
    }

    // Remove an item from the list
    public static void removeItem(ArrayList<String> list, Scanner scanner) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to remove.");
            return;
        }
        System.out.print("Enter item to remove: ");
        String item = scanner.nextLine().trim().toLowerCase();
        if (list.contains(item)) {
            list.remove(item);
            System.out.println("'" + item + "' removed from the list.");
        } else {
            System.out.println("'" + item + "' not found in the list.");
        }
    }

    // View the current list
    public static void viewList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The shopping list is empty.");
        } else {
            System.out.println("\nCurrent Shopping List:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + capitalize(list.get(i)));
            }
        }
    }

    // Print a summary of the list
    public static void printSummary(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The shopping list is empty. No summary to print.");
        } else {
            System.out.println("\n--- Shopping List Summary ---");
            System.out.println("Total items: " + list.size());
            for (String item : list) {
                System.out.println("- " + capitalize(item));
            }
            System.out.println("Happy shopping!");
        }
    }

    // Helper method to capitalize the first letter of a string
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

