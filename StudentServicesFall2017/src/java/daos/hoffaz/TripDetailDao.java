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
import models.hoffaz.TripDetail;

/**
 *
 * @author khaled
 */
public class TripDetailDao extends ConnectionDao{
    
     public ArrayList<TripDetail> getTripList(int branchId, int centerId, int tripId) throws Exception {
        
            ArrayList<TripDetail> tripDetailList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT * FROM TRIPDETAIL WHERE BRANCHID=? AND CENTERID=? AND TRIPID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, tripId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                tripDetailList.add(populateNationality(rs)); 
            }

            rs.close();
            ps.close();
            
            return tripDetailList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
  private TripDetail populateNationality(ResultSet rs) throws SQLException {
      
        TripDetail tripDetail = new TripDetail();
        
        tripDetail.setBranchId(rs.getInt("BRANCHID"));
        tripDetail.setCenterId(rs.getInt("CENTERID"));
        tripDetail.setTripId(rs.getInt("TRIPID"));
        tripDetail.setStopId(rs.getInt("STOPID"));
        tripDetail.setStopDescription(rs.getString("STOPDESCRIPTION"));
        
        
        return tripDetail;
    }   
    
}
