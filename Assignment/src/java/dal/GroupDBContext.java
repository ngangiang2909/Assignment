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
import model.Lecturer;
import model.Subject;

/**
 *
 * @author asus
 */
public class GroupDBContext extends DBContext<Group> {

    public ArrayList<Group> search(int subid) {
        ArrayList<Group> group = new ArrayList<>();
        try {
            String sql = "select *\n"
                    + "from [Group] g \n"
                    + "inner join Sub_Gr sg on g.gid = sg.gid \n"
                    + "inner join [Subject] sub on sg.subid = sub.subid\n"
                    + "where sub.subid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, subid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group gr = new Group();
                gr.setGid(rs.getInt("gid"));
                gr.setGname(rs.getString("gname"));
                Subject sub = new Subject();
                sub.setSubid(rs.getInt("subid"));
                sub.setSubname(rs.getString("subname"));
                sub.setSubcode(rs.getString("subcode"));
                gr.setSub(sub);
                group.add(gr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group;
    }

    @Override
    public ArrayList<Group> list() {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "select gid, gname from [Group]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                groups.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }

    public ArrayList<Group> searchLecCour(int lid, int subid) {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "SELECT [Group].gid,[Group].gname, Lecturer.lid, [Subject].subid, [Subject].subcode\n"
                    + "FROM   [Group] INNER JOIN\n"
                    + "       Lecturer_Group ON [Group].gid = Lecturer_Group.gid INNER JOIN\n"
                    + "       Lecturer ON Lecturer_Group.lid = Lecturer.lid INNER JOIN\n"
                    + "       Lecturer_Sub ON Lecturer.lid = Lecturer_Sub.lid INNER JOIN\n"
                    + "       [Subject] ON Lecturer_Sub.subid = [Subject].subid INNER JOIN\n"
                    + "                  Sub_Gr ON [Group].gid = Sub_Gr.gid AND [Subject].subid = Sub_Gr.subid\n"
                    + "          	  where Lecturer.lid = ? and [Subject].subid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, lid);
            stm.setInt(2, subid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                Subject s = new Subject();
                s.setSubid(rs.getInt("subid"));
                s.setSubcode(rs.getString("subcode"));
                Lecturer lec = new Lecturer();
                lec.setLid(rs.getInt("lid"));
                g.setLecture(lec);
                g.setSub(s);
                groups.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }

    @Override
    public Group get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
