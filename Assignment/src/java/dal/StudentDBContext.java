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
import model.Group;
import model.Student;

/**
 *
 * @author asus
 */
public class StudentDBContext extends DBContext<Student> {

    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select sid, scode, smember, sname, sgender, sdob, simg, saddress\n"
                    + "from Student";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setScode(rs.getString("scode"));
                s.setSmember(rs.getString("smember"));
                s.setSname(rs.getString("sname"));
                s.setSgender(rs.getBoolean("sgender"));
                s.setSdob(rs.getDate("sdob"));
                s.setSimg(rs.getString("simg"));
                s.setSaddress(rs.getString("saddress"));
                students.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }


    public ArrayList get(int gid) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select * from\n"
                    + "[Group] inner join Enroll\n"
                    + "on Enroll.gid = [Group].gid\n"
                    + "inner join Student on Enroll.sid=Student.sid\n"
                    + "where [Group].gid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setScode(rs.getString("scode"));
                s.setSmember(rs.getString("smember"));
                s.setSname(rs.getString("sname"));
                s.setSgender(rs.getBoolean("sgender"));
                s.setSdob(rs.getDate("sdob"));
                s.setSimg(rs.getString("simg"));
                s.setSaddress(rs.getString("saddress"));
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                s.setGroup(g);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }


    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    public Student getT(String a, String b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        StudentDBContext db = new StudentDBContext();
        ArrayList get = db.get(1);
        System.out.println(get);

    }

}
