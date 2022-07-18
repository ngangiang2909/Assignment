/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.teacher;

import dal.AssessmentDBContext;
import dal.ExamDBContext;
import dal.GroupDBContext;
import dal.StudentDBContext;
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
import model.Group;
import model.Student;
import model.Subject;

/**
 *
 * @author asus
 */
public class ListStuController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int lid = Integer.parseInt(request.getParameter("lid"));
        int subid = Integer.parseInt(request.getParameter("subid"));
        int gid = Integer.parseInt(request.getParameter("gid"));

        GroupDBContext dbgro = new GroupDBContext();
        ArrayList<Group> groLecCour = dbgro.searchLecCour(lid, subid);

        AssessmentDBContext dbass = new AssessmentDBContext();
        ArrayList<Assessment> assessment = dbass.search(subid);

        StudentDBContext dbstu = new StudentDBContext();
        ArrayList<Student> student = dbstu.getStu(gid);

        ExamDBContext dbexam = new ExamDBContext();
        ArrayList<Exam> listMark = dbexam.listMark(subid);

        SubjectDBContext db = new SubjectDBContext();
        ArrayList<Subject> lecsub = db.searchLect(lid);

        request.setAttribute("lecsub", lecsub);
        request.setAttribute("lid", lid);
        request.setAttribute("subid", subid);
        request.setAttribute("listMark", listMark);
        request.setAttribute("groLecCour", groLecCour);
        request.setAttribute("assessment", assessment);
        request.setAttribute("student", student);
        request.getRequestDispatcher("teacher/manage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] components = request.getParameterValues("component");
        ArrayList<Exam> exams = new ArrayList<>();
        ExamDBContext dbexam = new ExamDBContext();
        for (String component : components) {
            int sid = Integer.parseInt(component.split("_")[0]);
            int aid = Integer.parseInt(component.split("_")[1]);
            int subid = Integer.parseInt(component.split("_")[2]);
            Exam e = new Exam();
            Student s = new Student();
            s.setSid(sid);
            Assessment a = new Assessment();
            a.setAid(aid);
            a.setSubid(subid);
            e.setAssessment(a);
            e.setStudent(s);
            String score = request.getParameter("score" + sid + "_" + aid);
            if (score.length() > 0) {
                {
                    e.setScore(Float.parseFloat(score));
                }
            } else {
                {
                    e.setScore(-1);
                }
            }
            String eid = request.getParameter("eid" + sid + "_" + aid);
            if (eid.length() > 0) {
                {
                    e.setEid(Integer.parseInt(eid));
                }
            } else {
                {
                    e.setEid(-1);
                }
            }
            exams.add(e);
        }
        dbexam.saveChanges(exams);

        response.sendRedirect("home");
    }

}
