/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import controller.AdminCtrl;
import controller.CustomerCtrl;
import controller.MovieCtrl;
import dao.MovieDAO;
import dao.StudioDAO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Cinema;
import model.Movie;
import model.Schedule;
import model.Studio;
import model.User;

/**
 *
 * @author Jovin Angelico
 */
@WebService(serviceName = "WSAdmin")
public class WSAdmin {
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        return new CustomerCtrl().login(email, password);
    }
    
//    @WebMethod(operationName = "getUser")
//    public User getUser(@WebParam(name = "email") String email) {
//        return new CustomerCtrl().getUser(email);
//    }
    
    @WebMethod(operationName = "addMovie")
    public Boolean addMovie(@WebParam(name = "title") String title, @WebParam(name = "synopsis") String synopsis, @WebParam(name = "rating") double rating, @WebParam(name = "duration") int duration, @WebParam(name = "poster") String poster, @WebParam(name = "status") int status) {
        return new AdminCtrl().addMovie(new Movie(title, synopsis, rating, duration, poster, status));
    }
    
    @WebMethod(operationName = "editMovie")
    public Boolean editMovie(@WebParam(name = "movie_id") int movie_id, @WebParam(name = "title") String title, @WebParam(name = "synopsis") String synopsis, @WebParam(name = "rating") double rating, @WebParam(name = "duration") int duration, @WebParam(name = "poster") String poster, @WebParam(name = "status") int status) {
        return new AdminCtrl().editMovie(new Movie(movie_id, title, synopsis, rating, duration, poster, status));
    }
    
    @WebMethod(operationName = "getMovie")
    public Movie getMovie(@WebParam(name = "movie_id") int movie_id) {
        return new AdminCtrl().getMovie(movie_id);
    }
    
    @WebMethod(operationName = "getShowingMovies")
    public ArrayList<Movie> getShowingMovies() {
        return new MovieCtrl().showShowingMovies();
    }
    
    @WebMethod(operationName = "getComingSoonMovies")
    public ArrayList<Movie> getComingSoonMovies() {
        return new MovieCtrl().showComingSoonMovies();
    }
    
    @WebMethod(operationName = "getAllMovie")
    public ArrayList<Movie> getAllMovie() {
        return new MovieDAO().getAll();
    }
    
    @WebMethod(operationName = "deleteMovie")
    public Boolean deleteMovie(@WebParam(name = "movie_id") int movie_id) {
        return new AdminCtrl().deleteMovie(movie_id);
    }
    
    @WebMethod(operationName = "addCinema")
    public Boolean addCinema(@WebParam(name = "cinema_name") String cinema_name, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "province") String province) {
        Cinema _cinema = new Cinema(cinema_name, address, city, province);
        return new AdminCtrl().addCinema(_cinema);
    }
    
    @WebMethod(operationName = "editCinema")
    public Boolean editCinema(@WebParam(name = "cinema_name") String cinema_name, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "province") String province) {
        Cinema _cinema = new Cinema(cinema_name, address, city, province);
        return new AdminCtrl().editCinema(_cinema);
    }
    
    @WebMethod(operationName = "getAllCinema")
    public ArrayList<Cinema> getAllCinema() {
        return new AdminCtrl().getAllCinema();
    }
    
//    @WebMethod(operationName = "getStudiosByCinemaName")
//    public ArrayList<Studio> getStudiosByCinemaName(@WebParam(name="cinemaName") String cinemaName) {
//        return new StudioDAO().getStudioByCinema(cinemaName);
//    }
    
    @WebMethod(operationName = "getAllStudio")
    public ArrayList<Studio> getAllStudio() {
        return new StudioDAO().getAll();
    }
     @WebMethod(operationName = "getAllScheduleByMovieId")
    public ArrayList<Schedule> getAllScheduleByMovieId(@WebParam(name = "movieId") int movieId) {
        return new MovieCtrl().showScheduleByMovie(movieId);
    }
}
