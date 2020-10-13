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
    public AccountType findByType(String accountType) {
        AccountType result = null;

        try (Session session = getSession()) {
            // no transaction needed for read operations
            // HQL hibernate query language
            String findByType = "FROM AccountType p WHERE p.accountType = :accountType";
            Query<AccountType> query = session.createQuery(findByType);
            query.setParameter("accountType", accountType);

            List<AccountType> foundAccountTypes = query.getResultList();

            if (foundAccountTypes.isEmpty()) {
                return result;
            } else {
                result = foundAccountTypes.get(0);
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    // update
    // change the username of a accountType


    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
