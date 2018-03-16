package controller;

import dao.UserDAO;
import helper.HashHelper;
import model.User;

/* @author Jovin Angelico */
public class CustomerCtrl extends UserCtrl {

    public Boolean register(User _user) {
        
        _user.setPassword(HashHelper.hash(_user.getPassword()));
        return (Boolean) UserDAO.addUser(_user);
        
    }
    
    public Boolean editProfile(User _user) {
        
        return (Boolean) UserDAO.updateUser(_user);
        
    }
    
    public Boolean topUp() {
     
        // Add here
        return true;
        
    }
    
    public Boolean seeHistory() {
        
        // Add here
        // Find from table ticket where user_id = customer id
        return true;
        
    }

    @Override
    public Boolean buyTicket() {
        
        // Add here
        /* 
        1. Add transaction with user_id is customer id, status = 0 (not printed, will be 1 printed) 
        2. Add ticket(s) to table ticket
        */
        return true;
        
    }
    
    public Boolean printTicket() {
     
        // Add here
        return true;
    }
}
