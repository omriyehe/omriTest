<%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String logedInUser;%>

<html>
<link rel="stylesheet" href="Ou.css">

<head>
    <title>Title</title>
</head>
<body>

<h1>GOOD BYE Guest <%= logedInUser=session.getId()%> her your events: </h1>

<%
    session.invalidate();
%>


</body>
</html>