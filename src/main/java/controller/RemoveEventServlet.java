package controller;

import DB.DAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveEventServlet", value = "/RemoveEventServlet")
public class RemoveEventServlet extends HttpServlet {
    private DAO db;
    public RemoveEventServlet() {
        db = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int day_to_edit;
        int hour_to_edit;


        HttpSession session= request.getSession();
        User u = (User)session.getAttribute("logedInUser");;

        day_to_edit=Integer.parseInt(request.getParameter("day_to_edit"));
        hour_to_edit=Integer.parseInt(request.getParameter("hour_to_edit"));

            db.removeEvent(hour_to_edit,day_to_edit);
            request.getRequestDispatcher("sucsess_remove_event.jsp").forward(request, response);





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
