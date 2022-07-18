/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.teacher;

import dal.GroupDBContext;
import dal.SubjectDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Group;
import model.Subject;

/**
 *
 * @author asus
 */
public class GroupController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GroupController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GroupController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int lid = Integer.parseInt(request.getParameter("lid"));
        int subid = Integer.parseInt(request.getParameter("subid"));
        
        GroupDBContext dbgro = new GroupDBContext();
        ArrayList<Group> groLecCour = dbgro.searchLecCour(lid, subid);
        
        SubjectDBContext db = new SubjectDBContext();
        ArrayList<Subject> lecsub = db.searchLect(lid);
        
        request.setAttribute("lecsub", lecsub);   
        request.setAttribute("lid", lid);
        request.setAttribute("subid", subid);
        request.setAttribute("groLecCour", groLecCour);
        request.getRequestDispatcher("teacher/manage.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

}
