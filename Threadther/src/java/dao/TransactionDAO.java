package dao;

import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.Transaction;
//import model.Transaction;
import org.hibernate.Query;

/* @author Jovin Angelico */
public class TransactionDAO extends AbstractDAOClass<model.Transaction> {

    @Override
    public boolean update(model.Transaction updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            model.Transaction trans = (model.Transaction) session.get(
                    model.Transaction.class,
                    updObj.getTransactionId());
            //set the other attributes
            trans.setTime(new Date());

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
            model.Transaction trans = (model.Transaction) session.get(model.Transaction.class,
                    Integer.parseInt(objId));
            session.delete(trans);

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
    public ArrayList<model.Transaction> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<model.Transaction> result;

        try {
            Query q = session.createQuery("FROM TRANSACTION");
            result = (ArrayList<model.Transaction>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }
    
    public ArrayList<model.Transaction> getAll(String userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<model.Transaction> result;

        try {
            Query q = session.createQuery("FROM TRANSACTION"
                    + " WHERE user_id = :u_id");
            q.setParameter("u_id", userId);
            result = (ArrayList<model.Transaction>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public model.Transaction findById(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        model.Transaction result;

        try {
            Query q = session.createQuery("FROM TRANSACTION"
                    + "WHERE TRANSACTION_ID = :trans_id");
            q.setParameter("trans_id", Integer.parseInt(objId));
            result = (model.Transaction) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

}
