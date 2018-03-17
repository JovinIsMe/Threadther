/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import controller.AdminCtrl;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Movie;

/**
 *
 * @author Jovin Angelico
 */
@WebService(serviceName = "WSAdmin")
public class WSAdmin {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMovie")
    public Boolean addMovie(@WebParam(name = "title") String title, @WebParam(name = "synopsis") String synopsis, @WebParam(name = "rating") double rating, @WebParam(name = "duration") int duration, @WebParam(name = "poster") String poster, @WebParam(name = "status") int status) {
        return AdminCtrl.addMovie(new Movie(title, synopsis, rating, duration, poster, status));
    }
    
    @WebMethod(operationName = "editMovie")
    public Boolean editMovie(@WebParam(name = "movie_id") int movie_id, @WebParam(name = "title") String title, @WebParam(name = "synopsis") String synopsis, @WebParam(name = "rating") double rating, @WebParam(name = "duration") int duration, @WebParam(name = "poster") String poster, @WebParam(name = "status") int status) {
        return AdminCtrl.editMovie(new Movie(movie_id, title, synopsis, rating, duration, poster, status));
    }
    
    @WebMethod(operationName = "getMovie")
    public Movie getMovie(@WebParam(name = "movie_id") int movie_id) {
        return AdminCtrl.getMovie(movie_id);
    }
    
    @WebMethod(operationName = "deleteMovie")
    public Boolean deleteMovie(@WebParam(name = "movie_id") int movie_id) {
        return AdminCtrl.deleteMovie(movie_id);
    }
}
