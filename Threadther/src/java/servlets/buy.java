/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.CustomerCtrl;
import controller.MovieCtrl;
import controller.TransactionCtrl;
import controller.UserCtrl;
import dao.ScheduleDAO;
import dao.StudioDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Movie;
import model.Schedule;
import model.ScheduleId;
import model.Studio;
import model.Ticket;
import model.TicketId;
import model.User;

/**
 *
 * @author Jovin Angelico
 */
@WebServlet(name = "buy", urlPatterns = {"/buy"})
public class buy extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        int price = Integer.parseInt(request.getParameter("price"));
        String time = request.getParameter("movieStart");
        int studioNumber = Integer.parseInt(request.getParameter("studioNumber"));
        String[] seat = request.getParameterValues("seat");
        for (String string : seat) {
            out.println(string);
        }
        Date dob = null;
        GregorianCalendar gc = new GregorianCalendar();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            dob = sdf.parse(time);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        gc.setTime(dob);

        ScheduleId id = new ScheduleId(dob, studioNumber);
        Movie movie = new MovieCtrl().getMovie(movieId + "");
        Studio studio = new StudioDAO().findById(studioNumber + "");
        Schedule sched = new Schedule(id, movie, studio, price);
        User user = new UserDAO().findById("customer1@mail.com");
        Customer customer = new CustomerCtrl().getUser(user.getUserId());
        customer.setUser(user);
        user.setCustomer(customer);
        if(new TransactionCtrl().createTransaction(sched, customer, new TransactionCtrl().NOT_PRINTED_STATUS, seat)) {
            out.println("Success");
        } else {
            out.println("Failed");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
