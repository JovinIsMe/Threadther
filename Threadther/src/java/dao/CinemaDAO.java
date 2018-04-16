package dao;

import java.util.ArrayList;
import model.Cinema;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/* @author Jovin Angelico */
public class CinemaDAO extends AbstractDAOClass<Cinema> {

    @Override
    public boolean update(Cinema updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Cinema cinema = (Cinema) session.get(
                    Cinema.class,
                    updObj.getCinemaName());
            cinema.setAddress(updObj.getAddress());
            cinema.setCity(updObj.getCity());
            cinema.setProvince(updObj.getProvince());
            
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
            Cinema cinema = (Cinema) session.get(Cinema.class, objId);
            session.delete(cinema);
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
    public ArrayList<Cinema> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Cinema> result;

        try {
            Query q = session.createQuery("FROM CINEMA");
            result = (ArrayList<Cinema>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public Cinema findById(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cinema result;

        try {
            Query q = session.createQuery("FROM CINEMA"
                    + "WHERE CINEMA_NAME = :cinema_name");
            q.setParameter("cinema_name", objId);
            result = (Cinema) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

}
