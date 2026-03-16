import java.util.*;

class BankAccount {
    protected String accountHolder;
    protected int accountNumber;
    protected double balance;

    public BankAccount(String name, int accNo, double initialBalance) {
        this.accountHolder = name;
        this.accountNumber = accNo;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void showBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate = 5.0; // 5% yearly

    public SavingsAccount(String name, int accNo, double initialBalance) {
        super(name, accNo, initialBalance);
    }

    public void addInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest added: ₹" + interest);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingsAccount account = null;

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Balance");
            System.out.println("5. Add Interest");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter initial balance: ");
                    double bal = sc.nextDouble();
                    account = new SavingsAccount(name, accNo, bal);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double with = sc.nextDouble();
                        account.withdraw(with);
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;

                case 4:
                    if (account != null) {
                        account.showBalance();
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;

                case 5:
                    if (account != null) {
                        account.addInterest();
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the bank system.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
