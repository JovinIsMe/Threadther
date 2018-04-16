package dao;

import java.util.ArrayList;
import model.Seat;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/* @author Jovin Angelico */
public class SeatDAO extends AbstractDAOClass<Seat>{

    @Override
    public boolean update(Seat updObj) {
        System.out.println("FIND BY ID SEAT: this function is not used");
        return false;
    }

    @Override
    public boolean delete(String objId) {
        System.out.println("FIND BY ID SEAT: this function is not used");
        return false;
    }

    @Override
    public ArrayList<Seat> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Seat> result;

        try {
            Query q = session.createQuery("FROM SEAT");
            result = (ArrayList<Seat>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }
    
    public ArrayList<Seat> getAll(Integer studio_number) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Seat> result;

        try {
            Query q = session.createQuery("FROM SEAT"
                    + "WHERE STUDIO_NUMBER = :studio_number");
            q.setParameter("studio_number", studio_number);
            result = (ArrayList<Seat>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        
        return result;
        
    }

    @Override
    public Seat findById(String objId) {
        System.out.println("FIND BY ID SEAT: this function is not used");
        return null;
    }

}
