package controller;

import DB.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private DAO db;
    public LoginServlet() { db = new DAO();}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user,password;

        user=request.getParameter("user");
        password=request.getParameter("pass");


        if(!db.checkUser(user,password) ){
            request.setAttribute("error","Hello guest want to login ?");
            request.getRequestDispatcher("guest.jsp").forward(request,response);
            return;
        }
        else{
            HttpSession session = request.getSession();

            session.setAttribute("logedInUser",db.getUserFromUser(user,password));
            request.getRequestDispatcher("optionPage.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
