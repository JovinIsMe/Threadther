package dao;

import java.util.ArrayList;
import model.Movie;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MovieDAO {
    
    public static ArrayList<Movie> getAllMovie(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Movie> result = null;
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("from Movie");
        result = (ArrayList<Movie>) q.list();
        tx.commit();
        session.close();
        return result;
    }
    
    public static boolean insertMovie(Movie m){
        boolean result=true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(m);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        }
        session.close();
        return result;
    }
    
    public static boolean updateMovie(Movie _movie){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("Update Movie set title = :ttl, synopsis = :syn, rating = :rtg, "
                + "duration = :dr, poster = :pst, status = :st where movieId = :m_id");
        q.setParameter("ttl", _movie.getTitle());
        q.setParameter("syn", _movie.getSynopsis());
        q.setParameter("rtg", _movie.getRating());
        q.setParameter("dr", _movie.getDuration());
        q.setParameter("pst", _movie.getPoster());
        q.setParameter("st", _movie.getStatus());
        q.setParameter("m_id", _movie.getMovieId());
        
        int result = q.executeUpdate();
        tx.commit();
        session.close();
        return result > 0;
    }
    
    public static boolean deleteMovie(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Movie WHERE movieId = :m_id");
        q.setParameter("m_id", id);
        int result = q.executeUpdate();
        tx.commit();
        session.close();
        return result > 0;
    }
    
    public static Movie getMovie(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Movie _movie = null;
        Query q = session.createQuery("from Movie WHERE movieId = :m_id");
        q.setParameter("m_id", id);
        _movie = (Movie) q.uniqueResult();
        tx.commit();
        session.close();
        return _movie;
    }
}
