<%@ page import="model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="LOGIN.css">

<head>
    <title>LOGIN</title>
</head>
<body>

<%! User logedInUser;%>
<%logedInUser=(User) session.getAttribute("logedInUser");%>

<%String username="";%>

<%  if(logedInUser!= null){
    username =logedInUser.getUser();
}

%>

<form action="LoginServlet" class="c" >
    User name:<input type="text" name="user" value="<%=username%>"><br><br>
    Password<input type="password" name="pass"><br><br>
    <input type="submit" value="Login"><br><br>
</form>
</body>
</html>