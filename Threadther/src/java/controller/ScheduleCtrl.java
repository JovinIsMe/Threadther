package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Schedule;

/* @author Jovin Angelico */
/*
// Assign a movie with a few 
// schedules and studios
*/
public class ScheduleCtrl {

    private int movieId, price;
    private List<Integer> listStudioNumber;
    private List<Date> listSchedule;

    public ScheduleCtrl(int movieId, int price, List<Integer> listStudioNumber, List<Date> listSchedule) {
        this.movieId = movieId;
        this.price = price;
        this.listStudioNumber = listStudioNumber;
        this.listSchedule = listSchedule;
    }
    
    public void commit() {
        //add to database (table schedule)
        /*
        PK schedule, studio number
        FK movie_id
        price
        */
    }

    public static class ScheduleBuilder {

        private int movieId, price;
        private List<Integer> listStudioNumber;
        private List<Date> listSchedule;

        public ScheduleBuilder(int movieId, int price) {
            this.movieId = movieId;
            this.price = price;
        }

        public ScheduleBuilder addSchedule(Integer studioNumber, Date schedule) {
            listStudioNumber.add(studioNumber);
            listSchedule.add(schedule);
            return this;
        }

        public ScheduleCtrl build() {
            return new ScheduleCtrl(movieId, price, listStudioNumber, listSchedule);
        }
    }
    
    public void commit(Schedule schedule) {
        //add to database (table schedule)
        /*
        PK schedule, studio number
        FK movie_id
        price
        */
    }
}
