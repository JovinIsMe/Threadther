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
        <h1>Assign Movie Schedule</h1>
        <form action="AssignSchedule" method="post">
            <table>
                <tr><td>Select Studio</td><td>
                        <select name="studioNumber">
                            <%
                                List<Studio> studios = new WSAdmin().getAllStudio();

                                for (Studio s : studios) {
                                    out.println("<option value='" + s.getStudioNumber()+ "'>" + s.getStudioName() + 
                                            " "+s.getCinema().getCinemaName()+"</option>");
                                }
                            %>
                        </select>
                    </td></tr>
                <tr><td>Select Movie</td><td>
                        <select name="movieId">
                            <%
                                List<Movie> movies = new WSAdmin().getShowingMovies();

                                for (Movie m : movies) {
                                    out.println("<option value='" + m.getMovieId()+ "'>" + m.getTitle() + "</option>");
                                }
                            %>
                        </select>
                    </td></tr>
                <tr><td>Select Date</td><td><input type="date" name="date"></td></tr>
                <tr><td>Select Time</td><td><input type="time" name="timeSchedule"></td></tr>
                <tr><td>Price</td><td><input type="number" name="price"></td></tr>
                <tr><td colspan="2"><input type="submit" value="Assign"></td></tr>
            </table>
        </form>
    </body>
</html>
