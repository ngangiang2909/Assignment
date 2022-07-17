/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.student;

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
public class SubjectController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        SubjectDBContext dbsub = new SubjectDBContext();
        ArrayList<Subject> subject = dbsub.list();
        request.setAttribute("subject", subject);
        
        GroupDBContext dbgroup = new GroupDBContext();
        ArrayList<Group> groups = dbgroup.search(1);
        request.setAttribute("groups", groups);
        
        request.getRequestDispatcher("student/group.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

}
