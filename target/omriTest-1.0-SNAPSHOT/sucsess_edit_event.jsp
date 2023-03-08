<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 16:51
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
        request.getRequestDispatcher("guest.jsp").forward(request,response);
        return;
    }
%>
<div> Welcome <%= logedInUser.getUser()%>  </div>

<h1 style="color: darkred"> edit event sucssesful see you soon in your event <%= logedInUser.getUser()%> </h1>

<form action="optionPage.jsp" class="a" >
    <input type="submit" value="return to home" ><br><br>
</form>



</body>
</html>
