<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! User logedInUser;%>

<html>
<link rel="stylesheet" href="Ou.css">

<head>
    <title>Title</title>
</head>
<body>
<%
    logedInUser=(User) session.getAttribute("logedInUser");
    if(logedInUser == null){
        request.setAttribute("error","close area without login");
        request.getRequestDispatcher("error.jsp").forward(request,response);
        return;
    }
%>
<h1>GOOD BYE <%= logedInUser.getUser()%> her your events: </h1>

<%
    session.invalidate();
%>


</body>
</html>