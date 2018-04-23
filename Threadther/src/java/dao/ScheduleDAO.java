package dao;

import java.util.ArrayList;
import model.Schedule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/* @author Jovin Angelico */
public class ScheduleDAO extends AbstractDAOClass<Schedule> {

    @Override
    public boolean update(Schedule updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Schedule schedule = (Schedule) session.get(
                    Schedule.class,
                    updObj.getId());
//            change scheduleId (movie_start, studio_number) high risk??
//            schedule.getId().setMovieStart(updObj.getId().getMovieStart());
//            schedule.getId().setStudioNumber(updObj.getId().getStudioNumber());
            schedule.setMovie(updObj.getMovie());
            schedule.setPrice(updObj.getPrice());

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
        System.out.println("DELETE SCHEDULE: you are not allowed.");
        return false;
    }

    @Override
    public ArrayList<Schedule> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Schedule> result;

        try {
            Query q = session.createQuery("FROM Schedule");
            result = (ArrayList<Schedule>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

//    public ArrayList<Schedule> getAll(String movieId) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        ArrayList<Schedule> result;
//
//        try {
//            Query q = session.createQuery("FROM Schedule"
//                    + "WHERE movieId = :m_id");
//            q.setParameter("m_id", movieId);
//            result = (ArrayList<Schedule>) q.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            session.close();
//        }
//
//        return result;
//    }
    
    public ArrayList<Schedule> getAllScheduleByMovieId(int movieId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Schedule> tmp = getAll();
        ArrayList<Schedule> result = new ArrayList<>();
        for (Schedule schedule : tmp) {
            if(schedule.getMovie().getMovieId()==movieId){
                result.add(schedule);
            }
        }
        return result;
    }

    @Override
    public Schedule findById(String objId) {
        System.out.println("FIND BY ID SCHEDULE: this function is not used.");
        return null;
    }

}