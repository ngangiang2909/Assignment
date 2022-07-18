/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assessment;
import model.Exam;
import model.Student;
import model.Subject;

/**
 *
 * @author asus
 */
public class ExamDBContext extends DBContext<Exam> {

    public void saveChanges(ArrayList<Exam> exams) {
        try {
            connection.setAutoCommit(false);
            for (Exam exam : exams) {
                //INSERT
                if (exam.getEid() == -1 && exam.getScore() != -1) {
                    String sql_insert_exam = "INSERT INTO [Exam]\n"
                            + "           ([score]\n"
                            + "           ,[date]\n"
                            + "           ,[sid]\n"
                            + "           ,[subid]\n"
                            + "           ,[aid])\n"
                            + "     VALUES\n"
                            + "           (?\n"
                            + "           ,GETDATE()\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?)";
                    PreparedStatement stm = connection.prepareStatement(sql_insert_exam);
                    stm.setInt(2, exam.getStudent().getSid());
                    stm.setInt(4, exam.getAssessment().getAid());
                    stm.setFloat(1, exam.getScore());
                    stm.setFloat(3, exam.getAssessment().getSubid());
                    stm.executeUpdate();
                } //UPDATE
                else if (exam.getEid() != -1 && exam.getScore() != -1) {
                    String sql_update_exam = "UPDATE Exam SET score = ? WHERE eid = ?";
                    PreparedStatement stm = connection.prepareStatement(sql_update_exam);
                    stm.setInt(2, exam.getEid());
                    stm.setFloat(1, exam.getScore());
                    stm.executeUpdate();
                } //DELETE
                else if (exam.getEid() != -1 && exam.getScore() == -1) {
                    String sql_delete_exam = "DELETE Exam WHERE eid = ?";
                    PreparedStatement stm = connection.prepareStatement(sql_delete_exam);
                    stm.setInt(1, exam.getEid());
                    stm.executeUpdate();
                }
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ExamDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ExamDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Exam> search(int sid, int subid) {
        ArrayList<Exam> exam = new ArrayList<>();
        try {
            String sql = "SELECT Exam.eid, Exam.score, Assessment.aname,Assessment.aid, Assessment.weight , Student.sid, [Subject].subid\n"
                    + "FROM   Assessment INNER JOIN\n"
                    + "       Exam ON Assessment.aid = Exam.aid INNER JOIN\n"
                    + "       Student ON Exam.sid = Student.sid INNER JOIN\n"
                    + "       [Subject] ON Assessment.subid = [Subject].subid AND Exam.subid = [Subject].subid\n"
                    + "       where Student.sid = ? and [Subject].subid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.setInt(2, subid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Exam e = new Exam();
                e.setEid(rs.getInt("eid"));
                e.setScore(rs.getFloat("score"));
                Assessment a = new Assessment();
                a.setAid(rs.getInt("aid"));
                a.setAname(rs.getString("aname"));
                a.setWeight(rs.getFloat("weight"));
                Student stu = new Student();
                stu.setSid(rs.getInt("sid"));
                Subject sub = new Subject();
                sub.setSubid(rs.getInt("subid"));
                e.setAssessment(a);
                e.setStudent(stu);
                e.setSubject(sub);
                exam.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exam;
    }

    public ArrayList<Exam> listMark(int subid) {
        ArrayList<Exam> exams = new ArrayList<>();
        try {
            String sql = "SELECT A.* FROM\n"
                    + "(SELECT eid,sid,aid,score,subid,date FROM Exam) A\n"
                    + "INNER JOIN\n"
                    + "(SELECT sid,aid,MAX(date) as date FROM Exam\n"
                    + "GROUP BY sid,aid) B\n"
                    + "ON A.aid = B.aid AND A.sid = B.sid AND A.date = B.date\n"
                    + "where subid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, subid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Exam e = new Exam();
                e.setEid(rs.getInt("eid"));

                Assessment a = new Assessment();
                a.setAid(rs.getInt("aid"));
                a.setSubid(rs.getInt("subid"));

                Student s = new Student();
                s.setSid(rs.getInt("sid"));

                e.setScore(rs.getFloat("score"));
                e.setDate(rs.getDate("date"));

                e.setAssessment(a);
                e.setStudent(s);

                exams.add(e);

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exams;
    }

    @Override
    public Exam get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Exam model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Exam model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Exam model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Exam> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        ExamDBContext db = new ExamDBContext();
        System.out.println("");
    }
}
