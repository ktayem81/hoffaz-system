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
import java.util.ArrayList;
import models.hoffaz.Donate;

/**
 *
 * @author eng_ayman
 */
public class DonateDao extends ConnectionDao {

    public ArrayList<Donate> buildDonates(int branchId, int centerId) throws Exception {

        ArrayList<Donate> donateList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = " SELECT BRANCHID,CENTERID,DONATEID,DONATERNAME,AMOUNT,INSERTEMPLOYEEID,INSERTHOSTIP,INSERTDATE,INSERTHOSTOS "
                       + " FROM DONATES "
                       + " WHERE BRANCHID=? AND CENTERID=? "
                       + " ORDER BY BRANCHID,CENTERID,DONATEID,INSERTDATE";
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

    private Donate populateDonate(ResultSet rs) 
            throws SQLException {
        
        Donate donate = new Donate();
        
        donate.setBranchId(rs.getInt("BRANCHID"));
        donate.setCenterId(rs.getInt("CENTERID"));
        donate.setDonateId(rs.getInt("DONATEID"));
        donate.setDonaterName(rs.getString("DONATERNAME"));
        donate.setDonateAmount(rs.getDouble("AMOUNT"));
        donate.setInsertDate(rs.getTimestamp("INSERTDATE"));
        donate.setInsertEmployeeId(rs.getInt("INSERTEMPLOYEEID"));
        donate.setInsertHostIp(rs.getString("INSERTHOSTIP"));
        donate.setInsertHostOS(rs.getString("INSERTHOSTOS"));
        

        return donate;
    }

    public void insertDonate(Donate donate) throws Exception {

        Connection conn = getConnection();

        java.util.Date date = new java.util.Date();
        long t = date.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
        
        donate.setInsertDate(sqlTimestamp);
        
        String sqlDonateNo = "SELECT NVL(MAX(DONATEID),0)+1 AS DONATEID FROM DONATES WHERE BRANCHID=? AND CENTERID=? ";

        PreparedStatement ps1 = conn.prepareStatement(sqlDonateNo);

        try {
            ps1.setInt(1, donate.getBranchId());
            ps1.setInt(2, donate.getCenterId());

            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                donate.setDonateId(rs.getInt("DONATEID"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        String sql = "INSERT INTO DONATES "
                + "(DONATEID, DONATERNAME, AMOUNT, INSERTEMPLOYEEID,INSERTHOSTIP, INSERTDATE, INSERTHOSTOS, BRANCHID, CENTERID)"
                + "VALUES (?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        try {
            ps.setInt(1, donate.getDonateId());
            ps.setString(2, donate.getDonaterName());
            ps.setDouble(3, donate.getDonateAmount());
            ps.setInt(4, donate.getInsertEmployeeId());
            ps.setString(5, donate.getInsertHostIp());
            ps.setTimestamp(6, donate.getInsertDate());
            ps.setString(7, donate.getInsertHostOS());
            ps.setInt(8, donate.getBranchId());
            ps.setInt(9, donate.getCenterId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    /*
    public Donate getDonate(int insertEmployeeId) throws Exception {
        try {   
            Donate donate = null;
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
