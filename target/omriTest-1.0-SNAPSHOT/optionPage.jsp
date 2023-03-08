<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 14:51
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
        request.setAttribute("error","welcome to guest area");
        request.getRequestDispatcher("guest.jsp").forward(request,response);
        return;
    }
%>
<div> Welcome <%= logedInUser.getUser()%>  </div>

<h1 style="color: darkred">welcom to the event  page! </h1>

<form action="addNewEvent.jsp" class="a" >
    <input type="submit" value="ADD" ><br><br>
</form>


<form action="Search.jsp" class="a" >
    <input type="submit" value="search event" ><br><br>
</form>

<form action="EndServlet" class="a" >
    <input type="submit" value="End" ><br><br>
</form>




</body>
</html>
