package controller;

import dao.UserDAO;
import helper.HashHelper;
import java.util.ArrayList;
import model.Seat;
import model.Transaction;
import model.User;

/* @author Jovin Angelico */
public abstract class UserCtrl {
    
    public boolean login(String email, String pass) {
        
        pass = HashHelper.hash(pass);
        return new UserDAO().login(email, pass);
        
    }
    
    public abstract Boolean buyTicket(User _user, Transaction _transaction, ArrayList<Seat> _seat);
}
