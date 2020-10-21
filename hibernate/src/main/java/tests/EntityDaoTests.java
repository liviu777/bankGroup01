package tests;

import hibernate.account_type.AccountType;
import hibernate.account_type.AccountTypeDao;
import hibernate.bank_account.BankAccount;
import hibernate.bank_account.BankAccountDao;
import hibernate.customer.Customer;
import hibernate.customer.CustomerDao;

public class EntityDaoTests {
    public static void test(){

      /*  AccountTypeDao accountTypeDao = new AccountTypeDao();
        AccountType creditAccount = new AccountType();
        creditAccount.setAccountType("credit");
        AccountType debitAccount = new AccountType();
        debitAccount.setAccountType("debit");
        accountTypeDao.create(creditAccount);
        accountTypeDao.create(debitAccount);
*/

        Customer customer = new Customer();
        customer.setFirstName("Daniel");
        customer.setCNP("1900209274477");
        customer.setLastName("Goran");
        customer.setPassword("cucubau");
        customer.setUsername("ninonino");
        customer.setEmail("cucubau@gmail.com");

        CustomerDao customerDao = new CustomerDao();
        customerDao.createCustomer(customer);


        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(667788);
        bankAccount.setIBAN("RO49 AAAA 1B31 0075 9384 0000");
        bankAccount.setCurrency("RON");
        bankAccount.setAccountBalance(2500);
        bankAccount.setCustomerId(1133);
        bankAccount.setFriendlyName("Savings");

        BankAccountDao bankAccountDao = new BankAccountDao();
        bankAccountDao.create(bankAccount);



        AccountType accountType2 = new AccountType();
        accountType2.setAccountType("debit");
        AccountTypeDao accountTypeDao = new AccountTypeDao();
        //verificare create dao
        accountTypeDao.create(accountType2);
        AccountType accountTypeCredit= new AccountType();
        //verificare update dao
        //accountTypeCredit.setAccountType("update");
        //accountTypeDao.update(1L,accountTypeCredit);
        //verificare delete dao
        //accountTypeDao.delete(3L);
        //verificare readAll dao
        accountTypeDao.findAll().forEach(acc-> System.out.println(acc.toString()));
    }
}
