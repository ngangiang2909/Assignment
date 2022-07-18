/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.teacher;

import dal.AssessmentDBContext;
import dal.ExamDBContext;
import dal.GroupDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Assessment;
import model.Exam;
import model.Group;
import model.Student;

/**
 *
 * @author asus
 */
public class ManageController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int lid = 1;
        int subid = 1;
        int gid = 1;
        
        GroupDBContext dbgro = new GroupDBContext();
        ArrayList<Group> groupLecCour = dbgro.searchLecCour(lid, subid);
        
        AssessmentDBContext dbass = new AssessmentDBContext();
        ArrayList<Assessment> assessment = dbass.search(subid);
        
        StudentDBContext dbstu = new StudentDBContext();
        ArrayList<Student> student = dbstu.getStu(gid);
        
        ExamDBContext dbexam = new ExamDBContext();
        ArrayList<Exam> listMark = dbexam.listMark(subid);
        
        request.setAttribute("student", student);
        request.setAttribute("assessment", assessment);
        request.setAttribute("listMark", listMark);
        request.setAttribute("groupLecCour", groupLecCour);
        request.setAttribute("lid", lid);
        request.setAttribute("subid", subid);
        request.setAttribute("gid", gid);
        request.getRequestDispatcher("teacher/manage.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

}
