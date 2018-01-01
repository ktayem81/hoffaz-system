/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.hoffaz;

import daos.ConnectionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import models.hoffaz.Donates;

/**
 *
 * @author eng_ayman
 */
public class AddDonateDao extends ConnectionDao {

    public ArrayList<Donates> buildDonates(int branchId, int centerId) throws Exception {

        ArrayList<Donates> donateList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM DONATES WHERE BRANCHID=? AND CENTERID=? ";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);
               

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    donateList.add(populateDonate(rs));
                }

                rs.close();
            }

            return donateList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Donates populateDonate(ResultSet rs) throws SQLException {
        Donates donate = new Donates();
        donate.setDonateid(rs.getInt("DONATEID"));
        donate.setDonatername(rs.getString("DONATERNAME"));
            donate.setAmount(rs.getInt("AMOUNT"));
          donate.setInsertdate(rs.getTimestamp("INSERTDATE"));
        donate.setInsertemployeeid(rs.getInt("INSERTEMPLOYEEID"));
        donate.setInserthostip(rs.getString("INSERTHOSTIP"));
        donate.setInserthostos(rs.getString("INSERTHOSTOS"));
        donate.setBranchID(rs.getInt("BRANCHID"));
        donate.setCenterID(rs.getInt("CENTERID"));

        return donate;
    }

    public void insertDonate(Donates donate) throws Exception {

        Connection conn = getConnection();

        java.util.Date date = new java.util.Date();
        long t = date.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
       donate.setInsertdate(sqlTimestamp);
        String sqlDonateNo = "SELECT NVL(MAX(DONATEID),0)+1 AS DONATEID FROM DONATES WHERE BRANCHID=? AND CENTERID=? ";

        PreparedStatement ps1 = conn.prepareStatement(sqlDonateNo);

        try {
            ps1.setInt(1, donate.getBranchID());
             ps1.setInt(2, donate.getCenterID());
            
            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                donate.setDonateid(rs.getInt("DONATEID"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        String sql = "INSERT INTO DONATES (DONATEID, DONATERNAME, AMOUNT, INSERTEMPLOYEEID,INSERTHOSTIP, INSERTDATE, INSERTHOSTOS, BRANCHID, CENTERID)"
                +"VALUES (?,?,?,?,?,?,?,?,?) ";
              PreparedStatement ps = conn.prepareStatement(sql);
             try {
            ps.setInt(1, donate.getDonateid());
            ps.setString(2, donate.getDonatername());
            ps.setInt(3, donate.getAmount());
            ps.setInt(4, donate.getInsertemployeeid()); 
            ps.setString(5, donate.getInserthostip());
            ps.setTimestamp(6, donate.getInsertdate());
            ps.setString(7, donate.getInserthostos());
            ps.setInt(8, donate.getBranchID());
            ps.setInt(9, donate.getCenterID());
            
            
            
            ps.executeUpdate();
           
            ps.close();
             }  
        catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
/*
    public Donates getDonate(int insertEmployeeId) throws Exception {
        try {   
            Donates donate = null;
            Connection conn = getConnection();
            
            String sql = "?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, insertEmployeeId);
                        
            ResultSet rs = ps.executeQuery();           

            while (rs.next())  
                donate = populateDonate(rs);
            

            rs.close();
            ps.close();
            
            return donate;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    */    
}
