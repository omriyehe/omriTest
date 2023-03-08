package controller;

import DB.DAO;
import model.Event;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EndServlet", value = "/EndServlet")
public class EndServlet extends HttpServlet {
    private DAO db;
    public EndServlet() {
        db = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user;

        HttpSession session= request.getSession();
        User u = (User)session.getAttribute("logedInUser");;

        user=u.getUser();

       // List<Event> EventList=
       // session.setAttribute("events",list_event);
        request.getRequestDispatcher("end.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
