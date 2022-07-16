/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.GroupDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Group;
import model.Student;

/**
 *
 * @author asus
 */
public class ListController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDBContext dbs = new StudentDBContext();
//        ArrayList<Student> stu = dbs.search(id);

        String raw_code = request.getParameter("code");
        String code = (raw_code != null && raw_code.length() > 0) ? raw_code : null;
        ArrayList<Student> students = dbs.getList(code, id);
        int count = 1;
        GroupDBContext db = new GroupDBContext();
        ArrayList<Group> group = db.list();
        request.setAttribute("group", group);
        request.setAttribute("count", count);
        request.setAttribute("id", id);
        request.setAttribute("student", students);
        request.getRequestDispatcher("student/list.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("gid"));
//        StudentDBContext db = new StudentDBContext();
//        ArrayList<Student> student = db.getStu(id);
//        request.setAttribute("student", student);
//        request.getRequestDispatcher("student/list.jsp").forward(request, response);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
