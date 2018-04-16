package dao;

import java.util.ArrayList;
import util.HibernateUtil;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/* @author Jovin Angelico */
public class UserDAO extends AbstractDAOClass<User> {

    public static boolean login(String email, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction t = session.beginTransaction();
        Query q = session.createQuery("FROM USER u "
                + "WHERE u.email = :email "
                + "AND u.password = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        t.commit();

        User user = (User) q.uniqueResult();
        session.close();

        return (user != null);

    }

    @Override
    public boolean update(User updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            User user = (User) session.get(
                    User.class,
                    updObj.getUserId());
            user.setFirstName(updObj.getFirstName());
            user.setLastName(updObj.getLastName());
            user.setEmail(updObj.getEmail());
            user.setPassword(updObj.getPassword());
            user.setProfilePicture(updObj.getProfilePicture());

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
            User user = (User) session.get(User.class, Integer.parseInt(objId));
            session.delete(user);
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
    public ArrayList<User> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<User> result;

        try {
            Query q = session.createQuery("FROM USER");
            result = (ArrayList<User>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public User findById(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User result;

        try {
            Query q = session.createQuery("FROM USER"
                    + "WHERE user_id = :u_id");
            q.setParameter("u_id", Integer.parseInt(objId));
            result = (User) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

}
