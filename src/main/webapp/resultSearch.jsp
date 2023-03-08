<%@ page import="model.User" %>
<%@ page import="model.Event" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! User logedInUser;%>

<html>
<link rel="stylesheet" href="Ou.css">

<head>
    <title>result search</title>
</head>
<body>
    <%
    logedInUser=(User) session.getAttribute("logedInUser");

%>
<h1>Welcome <%= logedInUser.getUser()%> her the result: </h1>
    <%List<Event> list_of_event= (List<Event>)session.getAttribute("events") ;%>
    <%System.out.println(list_of_event);%>
    <%if(list_of_event != null)%>
<h1>Result :</h1>
    <%
    for (Event e : list_of_event){
%>
description-<%= e.getDescription()%>,user:<%=e.getUser()%>,day:<%=e.getDay()%>
    ,hour:<%=e.getHour()%>,type:<%=e.getType()%>


<form name="action-from" action="editServlet">
     <input type="text" name="day" value="<%=e.getDay()%>" hidden="hidden" ><br><br>
    <input type="text" name="hour" value="<%=e.getHour()%>" hidden="hidden"><br><br>

    <button name="edit" type="submit" value="edit" >edit</button>
        </form>



    <form name="action-from" action="RemoveEventServlet">
        <input type="text" name="day_to_edit" value="<%=e.getDay()%>" hidden="hidden" ><br><br>
        <input type="text" name="hour_to_edit" value="<%=e.getHour()%>" hidden="hidden"><br><br>

        <button name="remove" type="submit" value="remove" >remove</button>
    </form>
    <%
    }
%>

    <form action="optionPage.jsp" class="a" >
        <input type="submit" value="return to home" ><br><br>
    </form>


