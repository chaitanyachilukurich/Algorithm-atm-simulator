import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMM {

    private static double balance = 1000; // Initial balance
    private static Map<String, Double> userAccounts = new HashMap<>(); // Map to store user accounts

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeUserAccounts(); // Initialize user accounts

        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter your account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter your account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(accountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void initializeUserAccounts() {
        // Sample user accounts initialization
        userAccounts.put("123456", 1000.0);
        userAccounts.put("789012", 500.0);
    }

    private static void checkBalance() {
        System.out.print("Enter your account number: ");
        Scanner scanner = new Scanner(System.in);
        String accountNumber = scanner.next();
        if (userAccounts.containsKey(accountNumber)) {
            System.out.println("Your current balance is: $" + userAccounts.get(accountNumber));
        } else {
            System.out.println("Invalid account number");
        }
    }

    private static void deposit(String accountNumber, double amount) {
        if (amount > 0) {
            if (userAccounts.containsKey(accountNumber)) {
                double currentBalance = userAccounts.get(accountNumber);
                userAccounts.put(accountNumber, currentBalance + amount);
                System.out.println("Deposit successful");
            } else {
                System.out.println("Invalid account number");
            }
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    private static void withdraw(String accountNumber, double amount) {
        if (amount > 0) {
            if (userAccounts.containsKey(accountNumber)) {
                double currentBalance = userAccounts.get(accountNumber);
                if (amount <= currentBalance) {
                    userAccounts.put(accountNumber, currentBalance - amount);
                    System.out.println("Withdrawal successful");
                } else {
                    System.out.println("Insufficient funds");
                }
            } else {
                System.out.println("Invalid account number");
            }
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
}