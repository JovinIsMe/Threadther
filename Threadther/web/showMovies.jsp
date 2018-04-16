<%-- 
    Document   : showTest
    Created on : Mar 17, 2018, 12:49:25 PM
    Author     : Filipus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Movie"%>
<%@page import="dao.MovieDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="insertMovies.jsp">Insert Movies</a>
        <table border="1" cellpadding="5">
            <tr><td>NO</td><td>Title</td><td>Synopsis</td><td>Rating</td><td>Duration</td><td>Poster</td></tr>
            <%
                MovieDAO _movieDAO = new MovieDAO();
                ArrayList<Movie> movies = _movieDAO.getAll();

                for (int i = 0; i < movies.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + movies.get(i).getMovieId() + "</td>");
                    out.println("<td>" + movies.get(i).getTitle() + "</td>");
                    out.println("<td>" + movies.get(i).getSynopsis() + "</td>");
                    out.println("<td>" + movies.get(i).getRating() + "</td>");
                    out.println("<td>" + movies.get(i).getDuration() + "</td>");
                    out.println("<td><img src='" + movies.get(i).getPoster() + "' width='182px' height='268px'></td>");
                    out.println("<td><a href='updateMovies.jsp?m_id=" + movies.get(i).getMovieId()
                            + "'><button>Update</button></a></td>");
                    out.println("<td><a href='DeleteMovie?m_id=" + movies.get(i).getMovieId()
                            + "'><button>Delete</button></a></td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
