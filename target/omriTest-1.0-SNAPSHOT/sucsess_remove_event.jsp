<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 17:44
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

<h1 style="color: darkred"> remove event sucssesful <%= logedInUser.getUser()%> </h1>

<form action="optionPage.jsp" class="a" >
    <input type="submit" value="return to home" ><br><br>
</form>



</body>
</html>
