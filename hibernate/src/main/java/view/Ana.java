package view;

import java.util.Scanner;

public class Ana {
    private int accountBalance;
    private int customerId;
    private String accountNumber;
    private String IBAN;
    private String currency;
    //private int accountBalance;
    private String friendlyName;

    Scanner input = new Scanner(System.in);
    private Ana bankAccount;

    public Ana() {
    }

    //void viewPortofolio(int customerId, String accountNumber, String IBAN, String currency, String friendlyName){
        // System.out.println( customerId + "," + accountNumber + "," + IBAN + "," + currency + "," + accountBalance + "," + friendlyName );
         //bankAccount.viewPortofolio();
    //}

    //void viewPortofolio() {
    //}
    //bankAccount.viewPortofolio();
    //bankAccount.viewBalance();

    void viewBalance(){ }
    //bankAccount.viewBalance();

    void depositATM(int depositAmount){
         System.out.println("Enter an amount to deposit");
         depositAmount =input.nextInt();
         if (depositAmount < 0){
             System.out.println("Invalid amount!");
         }
         accountBalance = accountBalance + depositAmount; 
    }
      
      
      void createCreditAccount(){
         System.out.println("Enter account number");

    }
}
