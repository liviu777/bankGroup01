package hibernate.bank_account;

import hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
    //find by CustomerId
//    public BankAccount findByCustomerId(){
//        BankAccount result = null;
//
//        try(Session session = getSession()) {
//            String findByCustomerId = "FROM BankAccount p WHERE p.customerId = :customerId";
//            Query<BankAccount> query = session.createQuery(findByCustomerId);
//            query.setParameter("customerId", customerId);
//
//            List<BankAccount> foundBankAccount = query.getResultList();
//
//            if(foundBankAccount.isEmpty()) {
//                return result;
//            }else {
//                result = foundBankAccount.get(1);
//            }
//        }catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }

    //update //change account type of a customer??
    //input cerintele exercitiului??
    //public void update(int id,) {
//        BankAccount result = null;
//        Transaction transaction = null;
//        try (Session session = getSession()) {
//            BankAccount bankAccountToBeUpdated = session.find();
//
//            transaction = session.beginTransaction();
//
//            bankAcountToBeUpdated.setAccountBalance(bankAccount.getAccountBalance());
//            bankAccountToBeUpdated.setCurrency(bankAccount.getCurrency());
//
//            session.update(bankAccountToBeUpdated);
//
//            transaction.commit();
//            result = session.find();
//        } catch (HibernateException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }

        // delete
//    public void delete(Long id) {
//        Transaction transaction = null;
//        try (Session session = getSession()) {
//            BankAccount bankAccountToBeDeleted = session.find();
//
//            transaction = session.beginTransaction();
//
//            session.delete(bankAccountToBeDeleted);
//
//            transaction.commit();
//        } catch (HibernateException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private Session getSession() {
//        return HibernateUtil.getSessionFactory().openSession();
        // }
//}
}
