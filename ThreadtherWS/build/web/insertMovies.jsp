<%-- 
    Document   : insertMovies
    Created on : Mar 17, 2018, 3:42:40 PM
    Author     : Filipus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert Movie</h1>
        <form action="InsertMovie" method="post">
            <table border="1" cellpadding="5">
                <tr><td>Title</td><td><input type="text" name="title" required></td></tr>
                <tr><td>Synopsis</td><td> <textarea rows="4" cols="50" name="synopsis" required></textarea> </td></tr>
                <tr><td>Rating</td><td><input type="text" name="rating" required></td></tr>
                <tr><td>Duration</td><td><input type="text" name="duration" required></td></tr>
                <tr><td>Poster</td><td><input type="text" name="poster" required></td></tr>
                <tr><td>Status</td><td><input type="text" name="status" required></td></tr>
                <tr><td colspan="2"><input type="submit" value="Insert Movie"></td></tr>
            </table>
        </form>
    </body>
</html>
