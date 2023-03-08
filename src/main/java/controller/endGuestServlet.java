package controller;

import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "endGuestServlet", value = "/endGuestServlet")
public class endGuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user;

        HttpSession session= request.getSession();
        String u =(String) session.getAttribute("logedInUser");;


        request.getRequestDispatcher("endGuest.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
