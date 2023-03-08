package controller;

import DB.DAO;
import model.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "editServlet", value = "/editServlet")
public class editServlet extends HttpServlet {
    private DAO db
            ;
    public editServlet() {
        db = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        int day=Integer.parseInt(request.getParameter("day"));
        int hour=Integer.parseInt(request.getParameter("hour"));

        Event e= db.getEventFromHourAndDay(day,hour);


        session.setAttribute("event",e);
        request.getRequestDispatcher("editEvent.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
