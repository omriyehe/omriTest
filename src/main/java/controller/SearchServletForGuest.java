package controller;

import DB.DAO;
import model.Event;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServletForGuest", value = "/SearchServletForGuest")
public class SearchServletForGuest extends HttpServlet {
    private DAO db
            ;
    public SearchServletForGuest() {
        db = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user;
        int day=33,hour=33;
        HttpSession session= request.getSession();
        String u =(String) session.getAttribute("logedInUser");;

        day=Integer.parseInt(request.getParameter("day"));
        hour=Integer.parseInt(request.getParameter("hour"));

        List<Event> EventListByeDay = db.getEventListByeDay(day);
        List<Event> EventListByeHour = db.getEventListByeHour(hour);
        List<Event> EventListByeHourAndDay = db.getEventListByeHourAndDay(hour,day);

        if(day ==33 &&hour ==33 ){
            request.setAttribute("error","you must fill hour/day ");
            request.getRequestDispatcher("error.jsp").forward(request,response);
            return;
        }

        if(day !=33 && hour ==33){
            session.setAttribute("events",EventListByeDay);
            request.getRequestDispatcher("resultSearchForGuest.jsp").forward(request, response);
        }

        if(day ==33 && hour !=33){
            session.setAttribute("events",EventListByeHour);
            request.getRequestDispatcher("resultSearchForGuest.jsp").forward(request, response);
        }

        if(day !=33 && hour !=33){
            session.setAttribute("events",EventListByeHourAndDay);
            request.getRequestDispatcher("resultSearchForGuest.jsp").forward(request, response);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
