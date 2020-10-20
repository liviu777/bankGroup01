package view;


//2 –Transfer money
//4–Createdebit account

import hibernate.bank_account.BankAccount;
import hibernate.bank_account.BankAccountDao;

import java.util.Scanner;

public class Liviu {

    public void transferMoney() {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter transfer amount: ");
        double amountToTransfer = input.nextDouble();

        System.out.println("Please enter source account number: ");
        String sourceAccountNumber = input.nextLine();

        System.out.println("Please enter recipient's account number: ");
        String destinationAccountNumber = input.nextLine();

        BankAccountDao bankAccountDao = new BankAccountDao();

        BankAccount sourceBankAccount = bankAccountDao.findByAccountNumber(sourceAccountNumber);
        BankAccount destinationBankAccount = bankAccountDao.findByAccountNumber(destinationAccountNumber);

        if (sourceBankAccount == null) {
            System.out.println("Source bank account does not exist.");
            return;
        }
        if (destinationBankAccount == null) {
            System.out.println("Source bank account does not exist.");
            return;
        }

        if (sourceBankAccount.getAccountBalance() < amountToTransfer) {
            System.out.println("Insufficient funds.");
            return;
        }

        double newBalanceSourceAccount = sourceBankAccount.getAccountBalance() - amountToTransfer;
        sourceBankAccount.setAccountBalance(newBalanceSourceAccount);

        double newBalanceDestinationAccount = destinationBankAccount.getAccountBalance() + amountToTransfer;
        destinationBankAccount.setAccountBalance(newBalanceDestinationAccount);

        bankAccountDao.update(sourceBankAccount.getId(), sourceBankAccount);
        bankAccountDao.update(destinationBankAccount.getId(), destinationBankAccount);

    }

    public void createDebitAccount() {
        BankAccount newDebitAccount = new BankAccount();

        System.out.println("Enter details for the debit account:");

        newDebitAccount.setAccountTypeId(1);

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter currency:");
        String currency = input.nextLine();
        newDebitAccount.setCurrency(currency);

        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter friendly name:");
        String friendlyName = input.nextLine();
        newDebitAccount.setFriendlyName(friendlyName);

        Scanner input2 = new Scanner(System.in);
        System.out.println("Please set the account Balance:");
        double accountBalance = input.nextDouble();
        newDebitAccount.setAccountBalance(accountBalance);

        Scanner input3 = new Scanner(System.in);
        System.out.println("Please enter friendly name:");
        String IBAN = input.nextLine();
        newDebitAccount.setIBAN(IBAN);

        Scanner input4 = new Scanner(System.in);
        System.out.println("Please enter the customer ID:");
        int customerId = input.nextInt();
        newDebitAccount.getCustomerId();




//        newDebitAccount.setIBAN(generateIBAN());
//        newDebitAccount.setAccountNumber(generateAccountNumber());

        BankAccountDao bankAccountDao = new BankAccountDao();
        bankAccountDao.create(newDebitAccount);
    }
}