package controller;

import DB.DAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addEventServlet", value = "/addEventServlet")
public class addEventServlet extends HttpServlet {
    private DAO db;
    public addEventServlet() {
        db = new DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String desc , type,user;
       int day , hour;

        HttpSession session= request.getSession();
        User u = (User)session.getAttribute("logedInUser");;

        user=u.getUser();
        desc=request.getParameter("desc");
        type=request.getParameter("type");
        day=Integer.parseInt(request.getParameter("day"));
        hour=Integer.parseInt(request.getParameter("hour"));

        if(db.cheackIfHourExist(day,hour,user)){
            request.setAttribute("error", "the hour  is not available");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        else {
            db.add_event(user,desc,type,day,hour);
            request.getRequestDispatcher("sucsses.jsp").forward(request, response);
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
