package controller;

import dao.UserDAO;
import helper.HashHelper;
import model.User;

/* @author Jovin Angelico */
public abstract class UserCtrl {
    
    public static User login(String email, String pass) {
        
        pass = HashHelper.hash(pass);
        return (User) UserDAO.login(email, pass);
        
    }
    
    public abstract Boolean buyTicket();
}
