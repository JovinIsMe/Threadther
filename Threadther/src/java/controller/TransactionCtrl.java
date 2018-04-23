package controller;

import dao.TicketDAO;
import dao.TransactionDAO;
import model.Transaction;
import model.Schedule;
import model.Ticket;
import java.util.Date;
import model.Customer;
import model.TicketId;

/* @author Jovin Angelico */
public class TransactionCtrl {

    public final int NOT_PRINTED_STATUS = 0;
    public final int PRINTED_STATUS = 1;

    public Boolean checkBalance(int userId, int price) {
        return new CustomerCtrl().getUser(userId).getBalance() >= price;
    }

    public Boolean createTransaction(Schedule schedule, Customer customer, int status, String[] tickets) {

        if (customer.getUserId() > 100) { //customer
            if (!checkBalance(customer.getUserId(), (schedule.getPrice() * tickets.length))) {
                return false;
            } else {
                customer.setBalance(customer.getBalance() - (schedule.getPrice() * tickets.length));
                new CustomerCtrl().editProfile(customer);
            }
        }

        Transaction trans = new Transaction(schedule, customer.getUser(), status, new Date());
        new TransactionDAO().create(trans);
        addTicket(trans, tickets);

        return true;
    }

    public Boolean addTicket(Transaction transaction, String[] tickets) {

        for (String ticket : tickets) {
            TicketId id = new TicketId(transaction.getTransactionId(), ticket);
            new TicketDAO().create(new Ticket(id, transaction));
        }
        return true;

    }
}
