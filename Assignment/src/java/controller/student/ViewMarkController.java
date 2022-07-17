/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.student;

import dal.MarkDBContext;
import dal.SubjectDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Mark;
import model.Subject;

/**
 *
 * @author asus
 */
public class ViewMarkController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        int sid = Integer.parseInt(request.getParameter("sid"));
        int subid = Integer.parseInt(request.getParameter("subid"));
        int sid = Integer.parseInt(request.getParameter("sid"));
        MarkDBContext dbmark = new MarkDBContext();
        Mark mark = dbmark.getMark(sid, subid);
        request.setAttribute("mark", mark);
        
        SubjectDBContext dbsubject = new SubjectDBContext();
        ArrayList<Subject> subject = dbsubject.search(sid);
        request.setAttribute("subject", subject);
        request.setAttribute("sid", sid);
        
        request.getRequestDispatcher("student/course.jsp").forward(request, response);
    } 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

}
