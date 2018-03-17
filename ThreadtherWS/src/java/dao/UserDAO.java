package dao;

import util.HibernateUtil;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/* @author Jovin Angelico */
public class UserDAO {

    public static User login(String email, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction t = session.beginTransaction();
        Query q = session.createQuery(
                "FROM user u WHERE u.email = :email AND u.password = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        t.commit();

        User user = (User) q.uniqueResult();
        session.close();

        return user;

    }

    public static boolean addUser(User _user) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction t = session.beginTransaction();
        try {
            session.save(_user);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
        
    }

    public static boolean updateUser(User _user) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction t = session.beginTransaction();
        try {
            User user = (User) session.get(User.class, _user.getUserId());
            user.setFirstName(_user.getFirstName());
            user.setLastName(_user.getLastName());
            user.setEmail(_user.getEmail());
            user.setPassword(_user.getPassword());
            user.setProfilePicture(_user.getProfilePicture());
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
        
    }

}
