package hibernate.account_type;

import hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AccountTypeDao {
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
            System.out.println("Account type added");

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

    // update
    // change the username of a accountType


    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
