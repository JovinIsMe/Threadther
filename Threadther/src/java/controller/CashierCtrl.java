package controller;

import dao.TicketDAO;
import dao.TransactionDAO;
import java.util.ArrayList;
import model.Seat;
import model.Ticket;
import model.TicketId;
import model.Transaction;
import model.User;

/* @author Jovin Angelico */
public class CashierCtrl extends UserCtrl {

    @Override
    public Boolean buyTicket(User _user, Transaction _transaction, ArrayList<Seat> _seat) {

        /* 
        1. Add transaction with user_id is cashier id, status = 1 (printed) 
        2. Add ticket(s) to table ticket
         */
        
        _transaction.setUser(_user);
        _transaction.setStatus(1);
        new TransactionDAO().create(_transaction);
        for (Seat seat : _seat) {
            TicketId ticketId = new TicketId(_transaction.getTransactionId(), seat.getId().getSeatPosition());
            Ticket ticket = new Ticket(ticketId, _transaction);
            new TicketDAO().create(ticket);
        }
        
        return true;
    }

}
