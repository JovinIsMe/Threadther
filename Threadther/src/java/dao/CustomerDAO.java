package dao;

import java.util.ArrayList;
import model.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/* @author Jovin Angelico */
public class CustomerDAO extends AbstractDAOClass<Customer> {
    
    @Override
    public boolean create(Customer newObj) {
        //new user
        //new customer??
        return true;
    }
    
    @Override
    public boolean update(Customer updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        try {
            Customer customer = (Customer) session.get(
                    Customer.class,
                    updObj.getUserId());
            customer.setBalance(updObj.getBalance());
            customer.setPhoneNumber(updObj.getPhoneNumber());
            customer.setBirthDate(updObj.getBirthDate());
            
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        
        return true;
    }
    
    @Override
    public boolean delete(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        try {
            Customer customer = (Customer) session.get(Customer.class, Integer.parseInt(objId));
            session.delete(customer);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        
        return true;
    }
    
    @Override
    public ArrayList<Customer> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Customer> result;
        
        try {
            Query q = session.createQuery("FROM Customer");
            result = (ArrayList<Customer>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        
        return result;
    }
    
    @Override
    public Customer findById(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer result;
        
        try {
            Query q = session.createQuery("FROM Customer"
                    + "WHERE userId = :u_id");
            q.setParameter("u_id", Integer.parseInt(objId));
            result = (Customer) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        
        return result;
    }
    
}
