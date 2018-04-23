package controller;

import model.Customer;
import model.Schedule;

/* @author Jovin Angelico */
public class CashierCtrl extends UserCtrl {

    @Override
    public Boolean buyTicket(Schedule schedule, Customer customer, String[] seats) {
        return new TransactionCtrl().createTransaction(schedule, customer, new TransactionCtrl().PRINTED_STATUS, seats);
    }

}
