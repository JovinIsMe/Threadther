package controller;

import dao.MovieDAO;
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

    public ArrayList<Schedule> showScheduleByMovie() {

        // Add here
        // Get schedule by specific movie
        return null;

    }

    public ArrayList<Seat> showSeatBySchedule() {

        // Add here
        // Check from table ticket by available schedule
        return null;

    }
}
