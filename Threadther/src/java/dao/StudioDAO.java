package dao;

import java.util.ArrayList;
import model.Studio;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/* @author Jovin Angelico */
public class StudioDAO extends AbstractDAOClass<Studio>{

    @Override
    public boolean update(Studio updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Studio studio = (Studio) session.get(
                    Studio.class,
                    updObj.getStudioNumber());
            studio.setStudioName(updObj.getStudioName());
            studio.setRowCapacity(updObj.getRowCapacity());
            studio.setColCapacity(updObj.getColCapacity());
            
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
            Studio studio = (Studio) session.get(Studio.class, Integer.parseInt(objId));
            session.delete(studio);
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
    public ArrayList<Studio> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Studio> result;

        try {
            Query q = session.createQuery("FROM Studio");
            result = (ArrayList<Studio>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }
    
    public ArrayList<Studio> getAll(String cinema_name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Studio> result;

        try {
            Query q = session.createQuery("FROM Studio"
                    + "WHERE cinemaName = :cinema_name");
            q.setParameter("cinema_name", cinema_name);
            result = (ArrayList<Studio>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public Studio findById(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Studio result;

        try {
            Query q = session.createQuery("FROM Studio"
                    + "WHERE studioNumber = :studio_number");
            q.setParameter("studio_number", Integer.parseInt(objId));
            result = (Studio) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

}
