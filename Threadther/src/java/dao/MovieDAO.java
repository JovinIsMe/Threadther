package dao;

import java.util.ArrayList;
import model.Movie;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MovieDAO extends AbstractDAOClass<Movie> {

    @Override
    public boolean update(Movie updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Movie movie = (Movie) session.get(
                    Movie.class,
                    updObj.getMovieId());
            movie.setTitle(updObj.getTitle());
            movie.setSynopsis(updObj.getSynopsis());
            movie.setRating(updObj.getRating());
            movie.setDuration(updObj.getDuration());
            movie.setPoster(updObj.getPoster());
            movie.setStatus(updObj.getStatus());

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
            Movie movie = (Movie) session.get(Movie.class, Integer.parseInt(objId));
            session.delete(movie);
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
    public ArrayList<Movie> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Movie> result;
        Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery("FROM MOVIE");
            result = (ArrayList<Movie>) q.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public Movie findById(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Movie result = null;
        System.out.println("FIND BY ID MOVIE " + Integer.parseInt(objId));
        try {
            Query q = session.createQuery("FROM MOVIE"
                    + " WHERE movie_id = :m_id");
            Integer movie_id = Integer.parseInt(objId);
            q.setParameter("m_id", movie_id);
            result = (Movie) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (result != null) {
                System.out.println("THIS FUCKING AWEFUCK " + result.toString() + result.getMovieId());
            } else {
                System.out.println("FIND BY ID NULL");
            }
            session.close();
        }

        return result;
    }
}
