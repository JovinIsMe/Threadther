package controller;

import dao.CinemaDAO;
import dao.MovieDAO;
import dao.ScheduleDAO;
import dao.StudioDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import model.Cinema;
import model.Movie;
import model.Schedule;
import model.ScheduleId;
import model.Studio;

/* @author Jovin Angelico */
public class AdminCtrl {

    public Movie getMovie(int id) {
        //no lazy, so separate it
        Movie res = new MovieDAO().findById(id + "");

        return new Movie(res.getMovieId(), res.getTitle(), res.getSynopsis(), res.getRating(), res.getDuration(), res.getPoster(), res.getStatus());
    }
    
    public ArrayList<Movie> getAllMovie() {
        return new MovieDAO().getAll();
    }
    public ArrayList<Movie> getAllMoviePlayingNow() {
        return new MovieDAO().getAll();
    }
    public ArrayList<Movie> getAllMovieComingSoon() {
        return new MovieDAO().getAll();
    }

    public Boolean addMovie(Movie _movie) {
        return new MovieDAO().create(_movie);
    }

    public Boolean editMovie(Movie _movie) {
        return new MovieDAO().update(_movie);
    }

    public Boolean deleteMovie(int id) {
        return new MovieDAO().delete(id + "");
    }

    public Boolean assignMovie(int studioNumber, int movieId, String date, String time, int price) {

        // Add here
        Date dob = null;
        GregorianCalendar gc = new GregorianCalendar();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            dob = sdf.parse(date + " " + time);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        gc.setTime(dob);
        
        ScheduleId schedId = new ScheduleId(dob, studioNumber);
        Movie movie = new MovieDAO().findById(movieId + "");
        Studio studio = new StudioDAO().findById(studioNumber + "");
        Schedule sched = new Schedule(schedId, movie, studio, price);
        new ScheduleDAO().create(sched);
        
        return true;

    }

    public Boolean addCinema(Cinema _cinema) {
        return new CinemaDAO().create(_cinema);
    }

    public Boolean editCinema(Cinema _cinema) {
        return new CinemaDAO().update(_cinema);
    }
    
    public ArrayList<Cinema> getAllCinema(){
        return new CinemaDAO().getAll();
    }
    
}