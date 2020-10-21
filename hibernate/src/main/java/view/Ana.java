package view;

import hibernate.bank_account.BankAccount;
import hibernate.bank_account.BankAccountDao;
import hibernate.customer.Customer;
import hibernate.customer.CustomerDao;

import java.util.Scanner;

public class Ana {
    private double accountBalance;
    private String username;
    private Long customerId;
    private String currency;


    public void viewPortofolio() {
        CustomerDao customerDao = new CustomerDao();
        Customer customerData = customerDao.findByUsername(username);

        if (customerData == null) {
            System.out.println("customerData" + accountBalance);
        } else viewPortofolio();
    }

    public void depositATM ( double depositAmount){
            int greeting = 0;

            accountBalance = accountBalance + depositAmount;
            System.out.println("Welcome! Choose your : 1 for debit, 2 for credit");
            Scanner input = new Scanner(System.in);
            int option = Integer.parseInt(input.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Please enter account type: ");
                    Scanner type = new Scanner(System.in);
                    type.nextLine();

                    System.out.println(username + " Please enter the amount you wish to deposit: ");
                    Scanner inital = new Scanner(System.in);
                    inital.nextDouble();

                    BankAccount acct1 = new BankAccount();

                    System.out.println("Your current account balance is: " + depositAmount + accountBalance);

                case 2:
                    System.out.println("Your account is updated. Thank you!");
                    break;
            }
    }


    public void createCreditAccount () {
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

            BankAccountDao bankAccountDao = new BankAccountDao();
            bankAccountDao.create(newCreditAccount);
    }
}