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
import models.hoffaz.Trip;

/**
 *
 * @author khaled
 */
public class TripDao extends ConnectionDao{
    
    public ArrayList<Trip> getTripList(int branchId, int centerId) throws Exception {
        
            ArrayList<Trip> tripList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT * FROM TRIP WHERE BRANCHID=? AND CENTERID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                tripList.add(populateNationality(rs)); 
            }

            rs.close();
            ps.close();
            
            return tripList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
  private Trip populateNationality(ResultSet rs) throws SQLException {
      
        Trip trip = new Trip();
        
        trip.setBranchId(rs.getInt("BRANCHID"));
        trip.setCenterId(rs.getInt("CENTERID"));
        trip.setEmployeeId(rs.getInt("EMPLOYEEID"));
        trip.setTripId(rs.getInt("TRIPID"));
        trip.setTripDescription(rs.getString("TRIPDESCRIPTION"));
        
        
        return trip;
    }   
    
}
