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
import model.Mark;
import model.Student;
import model.Subject;

/**
 *
 * @author asus
 */
public class MarkDBContext extends DBContext<Mark> {

    public Mark getMark(int sid, int subid) {
        try {
            String sql = "select s.scode, s.sname, sub.subcode, sub.subname, m.pt1, m.pt2, m.pt3, m.ws1, m.ws2, m.ws3, m.ass, m.pe, m.fe\n"
                    + "from Student s inner join Mark m on s.sid = m.sid\n"
                    + "inner join [Subject] sub on m.subid = sub.subid\n"
                    + "where s.sid = ? and sub.subid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.setInt(2, subid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Mark m = new Mark();
                m.setPt1(rs.getFloat("pt1"));
                m.setPt2(rs.getFloat("pt2"));
                m.setPt3(rs.getFloat("pt3"));
                m.setWs1(rs.getFloat("ws1"));
                m.setWs2(rs.getFloat("ws2"));
                m.setWs3(rs.getFloat("ws3"));
                m.setAss(rs.getFloat("ass"));
                m.setPe(rs.getFloat("pe"));
                m.setFe(rs.getFloat("fe"));
                Student s = new Student();
                s.setScode(rs.getString("scode"));
                s.setSname(rs.getString("sname"));
                Subject sub = new Subject();
                sub.setSubcode(rs.getString("subcode"));
                sub.setSubname(rs.getString("subname"));
                m.setStu(s);
                m.setSub(sub);
                return m;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Mark> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Mark get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Mark model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Mark model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Mark model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        MarkDBContext db = new MarkDBContext();
        Mark mark = db.getMark(1, 1);
        System.out.println("" + mark);
    }
}
