package dao;

import java.util.ArrayList;
import model.Ticket;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/* @author Jovin Angelico */
public class TicketDAO extends AbstractDAOClass<Ticket>{

    @Override
    public boolean update(Ticket updObj) {
        System.out.println("UPDATE TICKET: no attribute can be updated");
        return false;
    }

    @Override
    public boolean delete(String objId) {
        System.out.println("DELETE TICKET: not allowed");
        return false;
    }

    @Override
    public ArrayList<Ticket> getAll() {
        System.out.println("GET ALL TICKET: call getAll method with parameter");
        return null;
    }
    
    public ArrayList<Ticket> getAll(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Ticket> result;

        try {
            Query q = session.createQuery("FROM TICKET"
                    + "WHERE TRANSACTION_ID = :trans_id");
            q.setParameter("trans_id", Integer.parseInt(objId));
            result = (ArrayList<Ticket>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        
        return result;
    }

    @Override
    public Ticket findById(String objId) {
        System.out.println("FIND BY ID TICKET: this function is not used.");
        return null;
    }
}
