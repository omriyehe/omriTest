<%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean scope="request" id="error" class="java.lang.String"/>
<%! String logedInUser;%>
<html>
<link rel="stylesheet" href="Ou.css">

<head>
    <title>guest page</title>
</head>
<body>
<div> Welcome Guest <%= logedInUser=session.getId()%>  </div>

<h1> guest page !  <%= error %></h1>


<form action="SearchGuest.jsp" class="a" >
    <input type="submit" value="search event" ><br><br>
</form>

<form action="endGuestServlet" class="a" >
    <input type="submit" value="End" ><br><br>
</form>



<form action="index.jsp" class="guest" >
    <input type="submit" value="Login" ><br><br>
</form>

</body>
</html>
