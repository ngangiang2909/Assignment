/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AssessmentDBContext;
import dal.ExamDBContext;
import dal.SubjectDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Assessment;
import model.Exam;
import model.Subject;

/**
 *
 * @author asus
 */
public class AssessmentController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        int subid = Integer.parseInt(request.getParameter("subid"));
        
        SubjectDBContext dbsub = new SubjectDBContext();
        ArrayList<Subject> subject = dbsub.search(sid);
        
        
        AssessmentDBContext dbass = new AssessmentDBContext();
        ArrayList<Assessment> assessment = dbass.search(subid);
        
        ExamDBContext dbexam = new ExamDBContext();
        ArrayList<Exam> exam = dbexam.search(sid, subid);
        
        float average = 0;
        for (Exam e : exam) {
            average = average + e.getScore()/100*e.getAssessment().getWeight();
        }
        
        request.setAttribute("assessment", assessment);
        request.setAttribute("exam", exam);
        request.setAttribute("average", average);
        request.setAttribute("subject", subject);
        request.setAttribute("sid", sid);
        request.getRequestDispatcher("student/viewmark.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
