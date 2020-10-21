package view;

import hibernate.account_type.AccountType;
import hibernate.account_type.AccountTypeDao;
import hibernate.bank_account.BankAccount;
import hibernate.bank_account.BankAccountDao;
import hibernate.customer.Customer;
import hibernate.customer.CustomerDao;

import java.util.List;
import java.util.Scanner;

public class Adian {
    public void viewPortofolio(Customer customerData) {

        customerData.getBankAccounts().forEach(bankAccount -> System.out.println(
                bankAccount.getFriendlyName()+ " " +bankAccount.getAccountType().getAccountTypeAsString() +
                        " "+bankAccount.getCurrency()+" "+ bankAccount.getAccountBalance()));
    }
    public BankAccount bankAccountSelection ( CustomerDao customerDao,Customer customer){

        System.out.println("Select bank account : 1 for " +
                "first account, 2 for the second etc" +
                " ");
        viewPortofolio(customer);
        Scanner input = new Scanner(System.in);
        int option  = input.nextInt();
        List<BankAccount> bankAccounts = customer.getBankAccounts();
        if (option-1 > bankAccounts.size() || (option-1 < 0) ){
            System.out.println("Selected bank account doesn't exist");
            bankAccountSelection(customerDao,customer);
        }
        return bankAccounts.get(option-1);

    }
    public void depositATM(CustomerDao customerDao,Customer customer){
        System.out.println("Select account for deposit: ");
        BankAccount depositBankAccount = bankAccountSelection(customerDao, customer);
        System.out.println("Enter amount to deposit: ");
        Scanner input = new Scanner(System.in);
        int depositAmount = Integer.parseInt(input.nextLine());
        depositBankAccount.setAccountBalance(depositBankAccount.getAccountBalance()+depositAmount);
        BankAccountDao depositBankAccountDao = new BankAccountDao();
        depositBankAccountDao.update(depositBankAccount.getId(),depositBankAccount);
    }
    public void createAccount (CustomerDao customerDao,Customer customer, String accountType) {
        BankAccount newCreditAccount = new BankAccount();
        AccountTypeDao accountTypeDao = new AccountTypeDao();
        BankAccountDao bankAccountDao = new BankAccountDao();
        AccountType accountType1 = accountTypeDao.getAccountType(accountType);

        newCreditAccount.setAccountType(accountType1);

        System.out.println("Enter details for the account:");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter currency:");
        String currency = input.nextLine();
        newCreditAccount.setCurrency(currency);

        System.out.println("Please enter friendly name:");
        String friendlyName = input.nextLine();
        newCreditAccount.setFriendlyName(friendlyName);

        System.out.println("Please set the account Balance:");
        double accountBalance = input.nextDouble();
        newCreditAccount.setAccountBalance(accountBalance);


        System.out.println("Please set the account Number:");
        int accountNumber  = input.nextInt();
        newCreditAccount.setAccountNumber(accountNumber);

       /* System.out.println("Please set the account IBAN:");
        String accountIBAN = input.nextLine();
        newCreditAccount.setIBAN(accountIBAN);*/
        //newCreditAccount.setCustomer(customer);

        customer.addBankAccount(newCreditAccount);
        customerDao.update(customer.getCustomerId(),customer);
        bankAccountDao.create(newCreditAccount);

    }
    public void transferMoney(CustomerDao customerDao,Customer customerData) {
        BankAccountDao bankAccountDao = new BankAccountDao();
        System.out.println("Select bank account from which to transfer money : ");
        BankAccount bankAccountForTransfer = bankAccountSelection(customerDao,customerData);

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter transfer amount: ");
        double amountToTransfer = input.nextDouble();

        System.out.println("Please enter recipient's account number: ");
        int destinationAccountNumber = input.nextInt();

        BankAccount destinationBankAccount = bankAccountDao.findBankAccountByNumber(destinationAccountNumber);

        if (destinationBankAccount == null) {
            System.out.println("Source bank account does not exist.");
            return;
        }else if (!destinationBankAccount.getCurrency().equals(bankAccountForTransfer.getCurrency())){
            System.out.println("Currency of the account you wish to transfer is different");
        }else if (bankAccountForTransfer.getAccountBalance() < amountToTransfer) {
            System.out.println("Insufficient funds.");
            transferMoney(customerDao,customerData);
        }

        double newBalanceSourceAccount = bankAccountForTransfer.getAccountBalance() - amountToTransfer;
        bankAccountForTransfer.setAccountBalance(newBalanceSourceAccount);
        bankAccountDao.update(bankAccountForTransfer.getId(),bankAccountForTransfer);

        double newBalanceDestinationAccount = destinationBankAccount.getAccountBalance() + amountToTransfer;
        destinationBankAccount.setAccountBalance(newBalanceDestinationAccount);
        bankAccountDao.update(destinationBankAccount.getId(),destinationBankAccount);

        viewPortofolio(customerData);

    }
}
