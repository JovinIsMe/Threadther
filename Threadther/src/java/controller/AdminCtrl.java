package controller;

import dao.CinemaDAO;
import dao.MovieDAO;
import model.Cinema;
import model.Movie;

/* @author Jovin Angelico */
public class AdminCtrl {

    public Movie getMovie(int id) {
        //no lazy, so separate it
        Movie res = new MovieDAO().findById(id + "");

        return new Movie(res.getMovieId(), res.getTitle(), res.getSynopsis(), res.getRating(), res.getDuration(), res.getPoster(), res.getStatus());
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

    public Boolean assignMovie() {

        // Add here
        // get movie id
        // get schedule(s) and studio
        return true;

    }

    public Boolean addCinema(Cinema _cinema) {
        return new CinemaDAO().create(_cinema);
    }

    public Boolean editCinema(Cinema _cinema) {
        return new CinemaDAO().update(_cinema);
    }
}
