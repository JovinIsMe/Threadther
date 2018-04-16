package dao;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/* @author Jovin Angelico */
abstract class AbstractDAOClass<T> {
    
    public boolean create(T newObj){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        try {
            session.save(newObj);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }

        return true;
    };
    public abstract boolean update(T updObj);
    public abstract boolean delete(String objId);
    public abstract ArrayList<T> getAll();
    public abstract T findById(String objId);
    public int count(String objId) {
        return this.getAll().size();
    };

}
