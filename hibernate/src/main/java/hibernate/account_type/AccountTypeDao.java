package hibernate.account_type;

import hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AccountTypeDao {
    public AccountType getAccountType(String accountType){
        List<AccountType> accountTypeList = null;

        String hql = "FROM AccountType acc where acc.accountType = : accountType";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // named query with parameters using HQL
            Query<AccountType> query = session.createQuery(hql);
            query.setParameter("accountType", accountType);
            accountTypeList = query.list();
            //System.out.println(accountTypeList.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return accountTypeList.get(0);

    }
    public void create(AccountType accountType) {
        Session session = null;
        Transaction transaction = null;
        AccountType result = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();


            transaction = session.beginTransaction();

            // generate insert into accountType table
            session.save(accountType);

            transaction.commit();
            //System.out.println("Account type added");

            // find by username and return
        } catch (HibernateException e) {
            // if one operation fails, then rollback
            System.out.println("Account type rollback");
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // read
    // find by username
    public List<AccountType> findAll() {
        List<AccountType> accountTypeList = null;

        try (Session session = getSession()) {
            // no transaction needed for read operations
            // HQL hibernate query language
            String hql = "FROM AccountType";
            Query<AccountType> query = session.createQuery(hql);
            accountTypeList = query.getResultList();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return accountTypeList;
    }

    //update
    public void update(Long id, AccountType accountTypeDetails) {
        AccountType result = null;
        Transaction transaction = null;
        try (Session session = getSession()) {
            AccountType accountTypeToBeUpdated = session.find(AccountType.class, id);

            transaction = session.beginTransaction();

            accountTypeToBeUpdated.setAccountType(accountTypeDetails.getAccountTypeAsString());

            session.update(accountTypeToBeUpdated);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    // delete
    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            AccountType accountTypeToBeDeleted = session.find(AccountType.class, id);

            transaction = session.beginTransaction();

            session.delete(accountTypeToBeDeleted);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }
    // update
    // change the username of a accountType


    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
