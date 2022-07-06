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
import model.Student;
import model.Subject;

/**
 *
 * @author asus
 */
public class SubjectDBContext extends DBContext<Subject> {

    public ArrayList<Subject> search(int sid) {
        ArrayList<Subject> subject = new ArrayList<>();
        try {
            String sql = "select s.scode, s.sname, sub.subcode, sub.subname\n"
                    + "from Student s inner join Course c on s.sid = c.sid\n"
                    + "inner join [Subject] sub on c.subid = sub.subid\n"
                    + "where s.sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setSubcode(rs.getString("subcode"));
                sub.setSubname(rs.getString("subname"));
                Student s = new Student();
                s.setScode(rs.getString("scode"));
                s.setSname(rs.getString("sname"));
                subject.add(sub);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subject;
    }

    @Override
    public ArrayList<Subject> list() {
        ArrayList<Subject> subject = new ArrayList<>();
        try {
            String sql = "select subid, subcode, subname from [Subject]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setSubid(rs.getInt("subid"));
                sub.setSubcode(rs.getString("subcode"));
                sub.setSubname(rs.getString("subname"));
                subject.add(sub);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subject;
    }

    @Override
    public Subject get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        SubjectDBContext db = new SubjectDBContext();
        ArrayList<Subject> search = db.search(4);
        System.out.println("" + search);
        ArrayList<Subject> list = db.list();
        System.out.println("" + list);
    }
}
