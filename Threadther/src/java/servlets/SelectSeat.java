package servlets;

import controller.TransactionCtrl;
import dao.SeatDAO;
import dao.StudioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Seat;
import model.Studio;
import model.Transaction;

/**
 *
 * @author Jovin Angelico
 */
@WebServlet(name = "SelectSeat", urlPatterns = {"/SelectSeat"})
public class SelectSeat extends HttpServlet {

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        int count = Integer.parseInt(request.getParameter("count"));
        String time = request.getParameterValues("movieStart")[count];
        int price = Integer.parseInt(request.getParameterValues("price")[count]);
        int studioNumber = Integer.parseInt(request.getParameterValues("studioNumber")[count]);
        Studio studio = new StudioDAO().findById(studioNumber + "");

        out.println(movieId);
        out.println(time);
        out.println(studioNumber);
        
        List<String> bookedSeat = new TransactionCtrl().getBookedSeats(time, studioNumber);
        
        List<Seat> seats = new SeatDAO().getSeatByStudioNumber(studioNumber);
        out.println("<!DOCTYPE html><html><head></head><body><form action='buy' method='post'>");
        int i = 0;
        out.println("<input type='hidden' name='movieId' value='" + movieId + "'/>");
        out.println("<input type='hidden' name='studioNumber' value='" + studioNumber + "'/>");
        out.println("<input type='hidden' name='price' value='" + price + "'/>");
        out.println("<input type='hidden' name='movieStart' value='" + time + "'/>");
        out.println("<table border='1'><tr><td align='center' colspan='" + studio.getColCapacity() + "'> SCREEN </td></tr>");
        for (Seat seat : seats) {
            if (i % studio.getColCapacity() == 0) {
                out.println("<tr>");
            }
            if (bookedSeat.contains(seat.getId().getSeatPosition())) {
                out.print("<td><input type='checkbox' name='seat' value='" + seat.getId().getSeatPosition() + "' checked disabled>" + seat.getId().getSeatPosition() + "</button></td>");
            } else {
                out.print("<td><input type='checkbox' name='seat' value='" + seat.getId().getSeatPosition() + "'>" + seat.getId().getSeatPosition() + "</button></td>");
            }
            i++;
            if (i % studio.getColCapacity() == 0) {
                out.println("</tr>");
            }
        }
        out.println("<tr><td align='center' colspan='" + studio.getColCapacity() + "'><button type='submit' value='Buy'>Buy</button></td></tr>");
        out.println("</table></form></body></html>");
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
