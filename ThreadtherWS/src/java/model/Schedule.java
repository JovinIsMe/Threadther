package model;
// Generated Mar 17, 2018 8:17:21 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Schedule generated by hbm2java
 */
public class Schedule implements java.io.Serializable {

    private ScheduleId id;
    private Movie movie;
    private Studio studio;
    private Integer price;
    private Set<Transaction> transactions = new HashSet<Transaction>(0);

    public Schedule() {
    }

    public Schedule(ScheduleId id, Studio studio) {
        this.id = id;
        this.studio = studio;
    }

    public Schedule(ScheduleId id, Movie movie, Studio studio, Integer price, Set<Transaction> transactions) {
        this.id = id;
        this.movie = movie;
        this.studio = studio;
        this.price = price;
        this.transactions = transactions;
    }

    public Schedule(ScheduleId id, Movie movie, Studio studio, Integer price) {
        this.id = id;
        this.movie = movie;
        this.studio = studio;
        this.price = price;
    }

    public ScheduleId getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Studio getStudio() {
        return studio;
    }

    public Integer getPrice() {
        return price;
    }
    
    public Set<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public static class ScheduleBuilder {

        private ScheduleId id;
        private Movie movie;
        private Studio studio;
        private Integer price;

        public ScheduleBuilder(Movie movie, Integer price) {
            this.movie = movie;
            this.price = price;
        }

        public ScheduleBuilder setId(ScheduleId id) {
            this.id = id;
            return this;
        }

        public ScheduleBuilder setStudio(Studio studio) {
            this.studio = studio;
            return this;
        }

        public Schedule build() {
            return new Schedule(id, movie, studio, price);
        }
        
    }

}