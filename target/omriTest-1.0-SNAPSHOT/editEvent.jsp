<%@ page import="model.User" %>
<%@ page import="model.Event" %><%--
  Created by IntelliJ IDEA.
  User: omri
  Date: 02/03/2022
  Time: 16:47
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
<h1>Welcome <%= logedInUser.getUser()%> her the result: </h1>
    <%Event e= (Event) session.getAttribute("event") ;%>

<h1>EDIT YOUR EVENT :</h1>

    description-<%= e.getDescription()%>,user:<%=e.getUser()%>,day:<%=e.getDay()%>
    ,hour:<%=e.getHour()%>,type:<%=e.getType()%>


    <form action="addEventServlet" class="c">
        <br><br>

        Event description <input type="text" name="desc" required><br><br>

        <br><br>
        day<select id="day" name="day" required>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        <option value="31">31</option>
    </select><br><br>

        <br><br>
        hour<select id="hour" name="hour" required>
        <option value="0">0</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>

    </select><br><br>


        type<select id="type" name="type" required>
        <option value="private">private</option>
        <option value="public">public</option>

    </select><br><br>

        <input type="submit" value="edit event" ><br><br>
        <input type="text" name="day_to_edit" value="<%=e.getDay()%>"
               style=" visibility: hidden;"><br><br>
        <input type="text" name="hour_to_edit" value="<%=e.getHour()%>"
               style=" visibility: hidden;"><br><br>
    </form>



</body>
</html>