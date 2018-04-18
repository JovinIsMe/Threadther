
package dao;

import java.util.ArrayList;
import model.Cashier;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/* @author Jovin Angelico */
public class CashierDAO extends AbstractDAOClass<Cashier>{
    
    @Override
    public boolean create(Cashier newObj) {
        //new user
        //new cashier??
        return true;
    }

    @Override
    public boolean update(Cashier updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Cashier cashier = (Cashier) session.get(
                    Cashier.class,
                    updObj.getUserId());
            cashier.setAddress(updObj.getAddress());
            cashier.setHireDate(updObj.getHireDate());
            cashier.setStatus(updObj.getStatus());
            
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
            Cashier admin = (Cashier) session.get(Cashier.class, Integer.parseInt(objId));
            session.delete(admin);
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
    public ArrayList<Cashier> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Cashier> result;

        try {
            Query q = session.createQuery("FROM Cashier");
            result = (ArrayList<Cashier>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public Cashier findById(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cashier result;

        try {
            Query q = session.createQuery("FROM Cashier"
                    + "WHERE userId = :u_id");
            q.setParameter("u_id", Integer.parseInt(objId));
            result = (Cashier) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

}
