package controller;

import dao.CustomerDAO;
import dao.TicketDAO;
import dao.TransactionDAO;
import dao.UserDAO;
import helper.HashHelper;
import java.util.ArrayList;
import model.Customer;
import model.Seat;
import model.Ticket;
import model.TicketId;
import model.Transaction;
import model.User;

/* @author Jovin Angelico */
public class CustomerCtrl extends UserCtrl {

    public Boolean register(User _user) {
        
        _user.setPassword(HashHelper.hash(_user.getPassword()));
        return (Boolean) new UserDAO().create(_user);
        
    }
    
    public Boolean editProfile(User _user) {
        
        return (Boolean) new UserDAO().update(_user);
        
    }
    
    public Boolean topUp(String _customerId, Integer _balance) {
     
        Customer customer = new CustomerDAO().findById(_customerId);
        customer.setBalance(_balance);
        return new CustomerDAO().update(customer);
        
    }
    
    public ArrayList<Transaction> seeHistory(String _customerId) {
        
        // Find from table ticket where user_id = customer id
        return new TransactionDAO().getAll(_customerId);
        
    }

    @Override
    public Boolean buyTicket(User _user, Transaction _transaction, ArrayList<Seat> _seat) {
        
        /* 
        1. Add transaction with user_id is customer id, status = 0 (not printed, will be 1 printed) 
        2. Add ticket(s) to table ticket
        */
        
        _transaction.setUser(_user);
        _transaction.setStatus(0);
        new TransactionDAO().create(_transaction);
        for (Seat seat : _seat) {
            TicketId ticketId = new TicketId(_transaction.getTransactionId(), seat.getId().getSeatPosition());
            Ticket ticket = new Ticket(ticketId, _transaction);
            new TicketDAO().create(ticket);
        }
        return true;
        
    }
    
    public Boolean printTicket(Transaction _transaction) {
        _transaction.setStatus(1); //printed
        return new TransactionDAO().update(_transaction);
    }
}
