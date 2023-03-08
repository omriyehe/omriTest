<%@ page import="model.Event" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String logedInUser;%>

<html>
<link rel="stylesheet" href="Ou.css">

<head>
    <title>result search</title>
</head>
<body>

<h1>Welcome Guest <%= logedInUser=session.getId()%> her the result: </h1>
    <%List<Event> list_of_event= (List<Event>)session.getAttribute("events") ;%>
    <%System.out.println(list_of_event);%>
    <%if(list_of_event != null)%>
<h1>Result :</h1>
    <%
    for (Event e : list_of_event){
%>
description-<%= e.getDescription()%>,user:<%=e.getUser()%>,day:<%=e.getDay()%>
,hour:<%=e.getHour()%>,type:<%=e.getType()%>



    <%
    }
%>

<form action="optionPage.jsp" class="a" >
    <input type="submit" value="return to home" ><br><br>
</form>


