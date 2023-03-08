package controller;

import DB.DAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "afteEditEventServlet", value = "/afteEditEventServlet")
public class afteEditEventServlet extends HttpServlet {
    private DAO db;
    public afteEditEventServlet() {
        db = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String desc , type,user;
        int day , hour;
        int day_to_edit;
        int hour_to_edit;


        HttpSession session= request.getSession();
        User u = (User)session.getAttribute("logedInUser");;

        user=u.getUser();
        desc=request.getParameter("desc");
        type=request.getParameter("type");
        day=Integer.parseInt(request.getParameter("day"));
        hour=Integer.parseInt(request.getParameter("hour"));
        day_to_edit=Integer.parseInt(request.getParameter("day_to_edit"));
        hour_to_edit=Integer.parseInt(request.getParameter("hour_to_edit"));


        if(db.cheackIfHourExist(day,hour,user)){
            request.setAttribute("error", "the hour  is not available");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        else {
         db.editEvent(hour_to_edit,day_to_edit,day,hour,desc,type,user);
        request.getRequestDispatcher("sucsses.jsp").forward(request, response);
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
