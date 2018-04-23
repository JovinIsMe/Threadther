package controller;

import dao.CustomerDAO;
import dao.TransactionDAO;
import dao.UserDAO;
import helper.HashHelper;
import java.util.ArrayList;
import model.Customer;
import model.Schedule;
import model.Transaction;
import model.User;

/* @author Jovin Angelico */
public class CustomerCtrl extends UserCtrl {
    
    public Customer getUser(int userId) {
        
        return (Customer) new CustomerDAO().findById(userId + "");
        
    }

    public Boolean register(User _user) {
        
        _user.setPassword(HashHelper.hash(_user.getPassword()));
        return (Boolean) new UserDAO().create(_user);
        
    }
    
    public Boolean editProfile(Customer _user) {
        
        return (Boolean) new CustomerDAO().update(_user);
        
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
    public Boolean buyTicket(Schedule schedule, Customer customer, String[] seats) {
        return new TransactionCtrl().createTransaction(schedule, customer, new TransactionCtrl().NOT_PRINTED_STATUS, seats);
    }
    
    public Boolean printTicket(Transaction _transaction) {
        _transaction.setStatus(1); //printed
        return new TransactionDAO().update(_transaction);
    }
}
