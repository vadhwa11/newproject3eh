<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Inline Editing: Form Controls</title>
<script type="text/javascript" src="../../lib.js"></script>
<script type="text/javascript" src="inline-editing.js"></script>
<link type="text/css" rel="stylesheet" href="Presidents.css">
</head>
<body>
<%
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn = DriverManager.getConnection("jdbc:odbc:Presidents");

        String sql = "SELECT PresidentID, FirstName, LastName, Bio FROM Presidents";
        stmt = conn.prepareStatement(sql);

        rs = stmt.executeQuery();
        out.write("<h1>Presidents</h1>");
        out.write("<p>Double click on any cell to edit the field. Click off the field to save your change.</p>");
        out.write("<table>");
        while (rs.next()) 
        {
            out.write("<tr id='" + rs.getString("PresidentID") + "'>");
            /*line 31*/         //out.write('<td class="editable" title='FirstName'>" + rs.getString("FirstName") + "</td>');
/*line 32*/         //out.write("<td class="editable" title='LastName'>" + rs.getString("LastName") + "</td>");
/*line 33*/     //out.write("<td class="editable" title='Bio'>" + rs.getString("Bio") + "</td>");
            out.write("</tr>");
        }
        out.write("</table>");
    }
    catch(Exception e)
    {
        out.write("failed: " + e.toString());
    }
    finally 
    {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>
</body>
</html>