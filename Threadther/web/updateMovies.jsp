<%-- 
    Document   : updateMovies
    Created on : Mar 17, 2018, 3:59:24 PM
    Author     : Filipus
--%>

<%@page import="dao.MovieDAO"%>
<%@page import="model.Movie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("m_id"));
            Movie m = new MovieDAO().findById(id);
        %>

        <h1>Update Movie</h1>
        <form action="UpdateMovie" method="post">
            <table border="1" cellpadding="5">
                <input type="hidden" name="movieId" value="<%=m.getMovieId()%>">
                <tr><td>Title</td><td><input type="text" name="title" value="<%=m.getTitle()%>" required></td></tr>
                <tr><td>Synopsis</td><td> <textarea rows="4" cols="50" name="synopsis" required><%=m.getSynopsis()%></textarea> </td></tr>
                <tr><td>Rating</td><td><input type="text" name="rating" value="<%=m.getRating()%>" required></td></tr>
                <tr><td>Duration</td><td><input type="text" name="duration" value="<%=m.getDuration()%>" required></td></tr>
                <tr><td>Poster</td><td><input type="text" name="poster" value="<%=m.getPoster()%>" required></td></tr>
                <tr><td>Status</td><td><input type="text" name="status" value="<%=m.getStatus()%>" required></td></tr>
                <tr><td colspan="2"><input type="submit" value="Update Movie"></td></tr>
            </table>
        </form>
    </body>
</html>
