<%@page import="controller.ScheduleCtrl"%>
<%@page import="model.Schedule"%>
<%@page import="WS.WSAdmin"%>
<%@page import="model.Movie"%>
<%@page import="model.Studio"%>
<%@page import="model.Cinema"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Buy Ticket</h1>
        Select Movie
        <%
            List<Movie> movies = new WSAdmin().getShowingMovies();
            for (Movie m : movies) {
                int count = 0;
                out.println("<form action='SelectSeat' method='post'><table>");
                out.println("<tr><td><h2>" + m.getTitle() + "</h2></td></tr>");
                List<Schedule> schedules = new ScheduleCtrl().getAllScheduleByMovieId(m.getMovieId());
                for (Schedule s : schedules) {
                    out.println("<input name='movieId' type='hidden' value='" + m.getMovieId() + "'/>");
                    out.println("<tr><td><input name='movieStart' value='" + s.getId().getMovieStart() + "'/></td>");
                    out.println("<input name='studioNumber' type='hidden' value='" + s.getId().getStudioNumber() + "'/>");
                    out.println("<input name='price' type='hidden' value='" + s.getPrice() + "'/>");
                    out.println("<td><button type='submit' name='count' value='" + count + "'>Select</button></td></tr>");
                    count++;
                }
                out.println("</table></form>");
            }
        %>
    </body>
</html>
