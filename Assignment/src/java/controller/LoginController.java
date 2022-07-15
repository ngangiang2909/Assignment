/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author asus
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        AccountDBContext db = new AccountDBContext();
//        ArrayList<Account> acc = db.list();
//        request.setAttribute("acc", acc);

        request.getRequestDispatcher("view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountDBContext db = new AccountDBContext();
        Account acc = db.getT(username, password);
        if (acc == null) {
            request.getSession().setAttribute("acc", null);
            request.setAttribute("mess", "Login failed!!! Please double check your username or password!");
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        } else {
            HttpSession ses = request.getSession();
            ses.setAttribute("acc", acc);
            request.getSession().setAttribute("acc", acc);
            request.setAttribute("name", acc.getDisplayName());
            response.sendRedirect("home.jsp");
        }
    }
}
