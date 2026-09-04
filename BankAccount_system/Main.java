package BankAccount_system;
class BankAccount {
    int accountNumber;
    String holderName;
    double balance;
BankAccount(int accountNumber, String holderName,double balance){
    this.accountNumber = accountNumber;
    this.holderName = holderName;
    this.balance = balance;
}
void displayAccount(){
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Holder Name: " + holderName);
    System.out.println("Balance: " + balance);
    System.out.println();
}
void deposit(double amount){
    balance += amount;
    System.out.println(amount + "deposited successfully");
    System.out.println();
}
}


public class Main {

    public static void main(String[] args) {

        BankAccount a1 = new BankAccount(101, "Rahul", 5000);

        a1.displayAccount();

        a1.deposit(2000);

        a1.displayAccount();

    }
}
    

