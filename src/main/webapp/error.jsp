<%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean scope="request" id="error" class="java.lang.String"/>
<html>
<head>
    <title>error</title>
</head>
<body>

<h1>error <%= error %></h1>
<form action="optionPage.jsp" class="guest" >
    <input type="submit" value="back" ><br><br>
</form>

</body>
</html>
