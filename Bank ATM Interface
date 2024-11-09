// BankAccount class to manage user's account details
class BankAccount {
    private double balance;
    private final String accountNumber;
    private final String pin;

    public BankAccount(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

// ATM class to handle user interface and transactions
class ATM {
    private BankAccount userAccount;
    private boolean isAuthenticated;

    public ATM() {
        this.isAuthenticated = false;
    }

    public boolean authenticate(String accountNumber, String pin) {
        // In a real system, you would look up the account in a database
        // For this example, we'll create a sample account
        BankAccount account = new BankAccount(accountNumber, pin, 1000.00);
        
        if (account.validatePin(pin)) {
            this.userAccount = account;
            this.isAuthenticated = true;
            return true;
        }
        return false;
    }

    public void showMenu() {
        if (!isAuthenticated) {
            System.out.println("Please authenticate first.");
            return;
        }

        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        System.out.println("===============");
    }

    public void checkBalance() {
        if (!isAuthenticated) return;
        System.out.printf("Current Balance: $%.2f%n", userAccount.getBalance());
    }

    public void withdraw(double amount) {
        if (!isAuthenticated) return;

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (userAccount.withdraw(amount)) {
            System.out.printf("Successfully withdrew $%.2f%n", amount);
            System.out.printf("New balance: $%.2f%n", userAccount.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (!isAuthenticated) return;

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (userAccount.deposit(amount)) {
            System.out.printf("Successfully deposited $%.2f%n", amount);
            System.out.printf("New balance: $%.2f%n", userAccount.getBalance());
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }
}

// Main class to demonstrate the ATM system
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ATM atm = new ATM();

        // Authentication
        System.out.println("Welcome to the ATM");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (atm.authenticate(accountNumber, pin)) {
            System.out.println("Authentication successful!");
            
            while (true) {
                atm.showMenu();
                System.out.print("Enter your choice (1-4): ");
                
                int choice;
                try {
                    choice = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear the invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed. Please try again.");
        }
        
        scanner.close();
    }
}
