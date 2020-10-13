package hibernate.bank_account;

import hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BankAccountDao {
    public void create(BankAccount bankAccount) {
        Session session = null;
        Transaction transaction = null;
        BankAccount result = null;

        try{
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();

        transaction = session.beginTransaction();


            session.save(bankAccount);

            transaction.commit();
            System.out.println("Bank Account added");

        } catch (HibernateException e) {
            System.out.println("Bank Account rollback");
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

    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
