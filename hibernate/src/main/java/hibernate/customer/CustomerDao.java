package hibernate.customer;
import hibernate.HibernateUtil;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDao {

    public void createCustomer(Customer customer) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();

            session.save(customer);

            transaction.commit();
            System.out.println("Customer is saved");

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Customer findByUsername(String username) {
        Customer result = null;

        try (Session session = getSession()) {
            String findByUsernameHql = "FROM Customer p WHERE p.username = :username";
            Query<Customer> query = session.createQuery(findByUsernameHql);
            query.setParameter("username", username);

            List<Customer> foundCustomers = query.getResultList();

            if (foundCustomers.isEmpty()) {
                return result;
            } else {
                result = foundCustomers.get(0);
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Customer update(Long CustomerId, Customer CustomerDetails) {
        Customer result = null;
        Transaction transaction = null;
        try (Session session = getSession()) {
            Customer CustomerToBeUpdated = session.find(Customer.class, CustomerId);

            transaction = session.beginTransaction();

            CustomerToBeUpdated.setFirstName(CustomerDetails.getFirstName());
            CustomerToBeUpdated.setLastName(CustomerDetails.getLastName());
            CustomerToBeUpdated.setEmail(CustomerDetails.getEmail());
            CustomerToBeUpdated.setCNP(CustomerDetails.getCNP());
            CustomerToBeUpdated.setUsername(CustomerDetails.getUsername());
            CustomerToBeUpdated.setPassword(CustomerDetails.getPassword());

            session.update(CustomerToBeUpdated);

            transaction.commit();
            result = session.find(Customer.class, CustomerId);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void delete(Long CustomerId) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            Customer CustomerToBeDeleted = session.find(Customer.class, CustomerId);

            transaction = session.beginTransaction();

            session.delete(CustomerToBeDeleted);

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
