package view;

import hibernate.bank_account.BankAccount;
import hibernate.bank_account.BankAccountDao;
import hibernate.customer.Customer;
import java.util.List;
import java.util.Scanner;

public class Ana {

    //private  BankAccount
    //private Object List;
    private double accountBalance;


//    public void viewPortofolio() {
//        Scanner input = new Scanner(System.in);
//        BankAccount bankAccount = new BankAccount();
//        List<BankAccount>bankAccounts;
//
//        //viewPortofolio(List<BankAccount>bankAccounts);
//    }


//    public void depositATM(double depositAmount){
//        accountBalance = accountBalance + depositAmount;
//        List<BankAccount>bankAccounts = new BankAccount();
//        bankAccounts.add("Deposit", null, depositAmount, accountBalance);
//
//        bankAccounts+=1;
//
//        Customer.getBankAccounts()
//
//        System.out.println("Enter an amount to deposit");
//         depositAmount =input.nextInt();
//         if (depositAmount < 0){
//             System.out.println("Invalid amount!");
//         }
//    }


    public void createCreditAccount(){
        BankAccount newCreditAccount = new BankAccount();

        System.out.println("Enter details for the credit account:");
        newCreditAccount.setAccountTypeId(2);

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter currency:");
        String currency = input.nextLine();
        newCreditAccount.setCurrency(currency);

        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter friendly name:");
        String friendlyName = input.nextLine();
        newCreditAccount.setFriendlyName(friendlyName);

        Scanner input2 = new Scanner(System.in);
        System.out.println("Please set the account Balance:");
        double accountBalance = input.nextDouble();
        newCreditAccount.setAccountBalance(accountBalance);

        Scanner input3 = new Scanner(System.in);
        System.out.println("Please enter friendly name:");
        String IBAN = input.nextLine();
        newCreditAccount.setIBAN(IBAN);

        Scanner input4 = new Scanner(System.in);
        System.out.println("Please enter the customer ID:");
        int customerId = input.nextInt();
        newCreditAccount.getCustomerId();

        BankAccountDao bankAccountDao = new BankAccountDao();
        bankAccountDao.create(newCreditAccount);
    }
}
