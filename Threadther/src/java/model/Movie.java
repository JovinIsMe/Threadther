package model;
// Generated Apr 16, 2018 10:03:05 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Movie generated by hbm2java
 */
public class Movie  implements java.io.Serializable {


     private Integer movieId;
     private String title;
     private String synopsis;
     private Double rating;
     private Integer duration;
     private String poster;
     private Integer status;
     private Set<Schedule> schedules = new HashSet<Schedule>(0);

    public Movie() {
    }

    public Movie(String title, String synopsis, Double rating, Integer duration, String poster, Integer status, Set<Schedule> schedules) {
       this.title = title;
       this.synopsis = synopsis;
       this.rating = rating;
       this.duration = duration;
       this.poster = poster;
       this.status = status;
       this.schedules = schedules;
    }
    
    public Movie(Integer movieId, String title, String synopsis, Double rating, Integer duration, String poster, Integer status) {
        this.movieId = movieId;
        this.title = title;
        this.synopsis = synopsis;
        this.rating = rating;
        this.duration = duration;
        this.poster = poster;
        this.status = status;
    }
    
    public Movie(String title, String synopsis, Double rating, Integer duration, String poster, Integer status) {
        this.title = title;
        this.synopsis = synopsis;
        this.rating = rating;
        this.duration = duration;
        this.poster = poster;
        this.status = status;
    }
   
    public Integer getMovieId() {
        return this.movieId;
    }
    
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSynopsis() {
        return this.synopsis;
    }
    
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public Double getRating() {
        return this.rating;
    }
    
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public Integer getDuration() {
        return this.duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    public String getPoster() {
        return this.poster;
    }
    
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Set<Schedule> getSchedules() {
        return this.schedules;
    }
    
    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }




}


