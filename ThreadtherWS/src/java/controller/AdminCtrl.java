package controller;

import dao.MovieDAO;
import model.Movie;

/* @author Jovin Angelico */
public class AdminCtrl {

    public static Boolean addMovie(Movie _movie) {
        return MovieDAO.insertMovie(_movie);
    }
    
    public static Boolean editMovie(Movie _movie) {
        return MovieDAO.updateMovie(_movie);
    }
    
    public static Movie getMovie(int id) {
        //no lazy, so separate it
        Movie res = MovieDAO.getMovie(id);
        return new Movie(res.getMovieId(), res.getTitle(), res.getSynopsis(), res.getRating(), res.getDuration(), res.getPoster(), res.getStatus());
    }
    
    public static Boolean deleteMovie(int id) {
        return MovieDAO.deleteMovie(id);
    }
    
    public static Boolean assignMovie() {
        
        // Add here
        return true;
        
    }
    
    public static Boolean addCinema() {
        
        // Add here
        return true;
        
    }
    
    public static Boolean editCinema() {
        
        // Add here
        return true;
        
    }
}
