package hibernate.bank_account;

import hibernate.HibernateUtil;
import hibernate.account_type.AccountType;
import hibernate.customer.Customer;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDao {
    //create
    public BankAccount create(BankAccount bankAccount) {
        Session session = null;
        Transaction transaction = null;
        BankAccount result = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            session.save(bankAccount);

            transaction.commit();
            System.out.println("Bank Account added");

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    //read
    public List<BankAccount> findBankAccountsOfCustomer(Customer customerData){
        List<BankAccount> bankAccountList = new ArrayList<>();

        try (Session session = getSession()) {
            String hql = "FROM BankAccount b where b.customer = : customerData";
            Query<BankAccount> query = session.createQuery(hql);
            query.setParameter("customerData", customerData);
            bankAccountList = query.list();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return bankAccountList;
    }
    public List<BankAccount> findAll() {
        List<BankAccount> bankAccountList = null;

        try (Session session = getSession()) {
            String hql = "FROM BankAccount";
            Query<BankAccount> query = session.createQuery(hql);

            bankAccountList = query.getResultList();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return bankAccountList;
    }

    public BankAccount findByAccountNumber(String accountNumber) {

        CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
        CriteriaQuery<BankAccount> criteria = criteriaBuilder.createQuery(BankAccount.class);

        Root<BankAccount> bankAccount = criteria.from(BankAccount.class);

        return (BankAccount) criteria.where(criteriaBuilder.equal(bankAccount.get("accountNumber"), accountNumber));
    }
    public BankAccount findBankAccountByNumber(int accountNumber) {
        BankAccount bankAccount = null;

        String hql = "FROM BankAccount bb where bb.accountNumber = : accountNumber";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // named query with parameters using HQL
            Query<BankAccount> query = session.createQuery(hql);
            query.setParameter("accountNumber", accountNumber);
            bankAccount = query.list().get(0);
            //System.out.println(accountTypeList.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return bankAccount;

    }


    //update
    public BankAccount update(int id, BankAccount BankAccountDetails) {
        BankAccount result = null;
        Transaction transaction = null;
        try (Session session = getSession()) {
            BankAccount bankAccountToBeUpdated = session.find(BankAccount.class, id);

            transaction = session.beginTransaction();

            bankAccountToBeUpdated.setAccountNumber(BankAccountDetails.getAccountNumber());
            bankAccountToBeUpdated.setIBAN(BankAccountDetails.getIBAN());
            bankAccountToBeUpdated.setAccountTypeId(BankAccountDetails.getAccountTypeId());
            bankAccountToBeUpdated.setCurrency(BankAccountDetails.getCurrency());
            bankAccountToBeUpdated.setAccountBalance(BankAccountDetails.getAccountBalance());
            bankAccountToBeUpdated.setFriendlyName(BankAccountDetails.getFriendlyName());
            bankAccountToBeUpdated.setCustomerId(BankAccountDetails.getCustomerId());

            session.update(bankAccountToBeUpdated);

            transaction.commit();
            result = session.find(BankAccount.class, id);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            BankAccount bankAccountToBeDeleted = session.find(BankAccount.class, id);

            transaction = session.beginTransaction();

            session.delete(bankAccountToBeDeleted);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}