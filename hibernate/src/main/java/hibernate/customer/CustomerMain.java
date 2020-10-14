package hibernate.customer;

import hibernate.HibernateUtil;
import hibernate.account_type.AccountType;
import hibernate.account_type.AccountTypeDao;
import hibernate.bank_account.BankAccount;
import hibernate.bank_account.BankAccountDao;
import org.hibernate.Transaction;
import org.hibernate.Session;

public class CustomerMain {
    public static void main(String[] args) {
       Customer customer = new Customer();
       customer.setFirstName("Daniel");
       customer.setCNP("1900209274477");
       customer.setLastName("Goran");
       customer.setPassword("cucubau");
       customer.setUsername("ninonino");
       customer.setEmail("cucubau@gmail.com");

       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction transaction = session.beginTransaction();

      CustomerDao customerDao = new CustomerDao();
      customerDao.createCustomer(customer);

      BankAccount bankAccount = new BankAccount();
      bankAccount.setAccountNumber("66-77-88");
      bankAccount.setIBAN("RO49 AAAA 1B31 0075 9384 0000");
      bankAccount.setCurrency("RON");
      bankAccount.setAccountBalance(2500);
      bankAccount.setCustomerId(1133);
      bankAccount.setFriendlyName("Savings");

      BankAccountDao bankAccountDao = new BankAccountDao();
      bankAccount.createBankAccount(bankAccount);

      AccountType accountType2 = new AccountType();
      accountType2.setAccountType("debit");

      AccountTypeDao accountTypeDao = new AccountTypeDao();
        //add accountType to database
        accountTypeDao.create(accountType2);
        accountTypeDao.findAll().forEach(acc-> System.out.println(acc.toString()));
    }
}
