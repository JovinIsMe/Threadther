package dao;

import java.util.ArrayList;
import model.Admin;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import util.HibernateUtil;

/* @author Jovin Angelico */
public class AdminDAO extends AbstractDAOClass<Admin> {
    
    @Override
    public boolean create(Admin newObj) {
        //new user
        //new admin??
        return true;
    }

    @Override
    public boolean update(Admin updObj) {
        //update user?
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Admin admin = (Admin) session.get(
                    Admin.class,
                    updObj.getUserId());
            admin.setAddress(updObj.getAddress());

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
            Admin admin = (Admin) session.get(Admin.class, Integer.parseInt(objId));
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
    public ArrayList<Admin> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Admin> result;

        try {
            Query q = session.createQuery("FROM Admin");
            result = (ArrayList<Admin>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public Admin findById(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Admin result;

        try {
            Query q = session.createQuery("FROM Admin"
                    + "WHERE userId = :u_id");
            q.setParameter("u_id", Integer.parseInt(objId));
            result = (Admin) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

}
