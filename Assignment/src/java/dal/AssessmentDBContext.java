/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assessment;

/**
 *
 * @author asus
 */
public class AssessmentDBContext extends DBContext<Assessment>{

    public ArrayList<Assessment> search(int subid) {
        ArrayList<Assessment> assesments = new ArrayList<>();
        try {
            String sql = "SELECT [aid]\n"
                    + "      ,[aname]\n"
                    + "      ,[weight], subid\n"
                    + "  FROM [Assessment] where subid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, subid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assessment a = new Assessment();
                a.setAid(rs.getInt("aid"));
                a.setAname(rs.getString("aname"));
                a.setWeight(rs.getFloat("weight"));
                a.setSubid(subid);
                assesments.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assesments;
    }
    
    @Override
    public ArrayList<Assessment> list() {
        ArrayList<Assessment> assesments = new ArrayList<>();
        try {
            String sql = "SELECT [aid]\n"
                    + "      ,[aname]\n"
                    + "      ,[weight]\n"
                    + "  FROM [Assessment]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assessment a = new Assessment();
                a.setAid(rs.getInt("aid"));
                a.setAname(rs.getString("aname"));
                a.setWeight(rs.getFloat("weight"));
                assesments.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assesments;
    }

    @Override
    public Assessment get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Assessment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Assessment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Assessment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void main(String[] args) {
        AssessmentDBContext db = new AssessmentDBContext();
        ArrayList<Assessment> ass = db.search(1);
        System.out.println(ass);
    }
}
