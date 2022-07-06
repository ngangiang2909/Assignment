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

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select sid,code,smember,sname,sgender,sdob,simg,saddress FROM Student";
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
                Group group = new Group();
                group.setGid(rs.getInt("gid"));
                group.setGname(rs.getString("gname"));
                s.setGroup(group);
                students.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public ArrayList<Student> getStu(int gid) {
        ArrayList<Student> stu = new ArrayList<>();
        try {
            String sql = "select *\n"
                    + "from [Group] g \n"
                    + "inner join Enroll e on g.gid=e.gid\n"
                    + "inner join Student s on e.sid=s.sid\n"
                    + "where g.gid = ?";
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
                stu.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stu;
    }

    @Override
    public Student get(int gid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
