package controller;

import dao.MovieDAO;
import dao.ScheduleDAO;
import dao.SeatDAO;
import java.util.ArrayList;
import model.Movie;
import model.Schedule;
import model.Seat;

/* @author Jovin Angelico */
public class MovieCtrl {

    private final int EXPIRED_MOVIE = 0;
    private final int SHOWING_MOVIE = 1;
    private final int COMING_SOON_MOVIE = 2;

    public ArrayList<Movie> showShowingMovies() {

        ArrayList<Movie> allMovies = new MovieDAO().getAll();
        ArrayList<Movie> showingMovie = new ArrayList();

        for (Movie movie : allMovies) {
            if (movie.getStatus() == SHOWING_MOVIE) {
                showingMovie.add(movie);
            }
        }
        return showingMovie;
    }

    public ArrayList<Movie> showComingSoonMovies() {

        ArrayList<Movie> allMovies = new MovieDAO().getAll();
        ArrayList<Movie> comingSoonMovie = new ArrayList();

        for (Movie movie : allMovies) {
            if (movie.getStatus() == COMING_SOON_MOVIE) {
                comingSoonMovie.add(movie);
            }
        }
        return comingSoonMovie;

    }
    
    public Movie getMovie(String movieId){
        return new MovieDAO().findById(movieId);
    }
    
    public ArrayList<Schedule> showScheduleByMovie(int movieId) {
        return new ScheduleDAO().getAllScheduleByMovieId(movieId);
    }

    public ArrayList<Seat> showSeatByStudioNumber(int studioNumber) {
        return new SeatDAO().getSeatByStudioNumber(studioNumber);
    }
}