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
       public ArrayList<Trip> buildTrips(int branchId, int centerId)
            throws Exception {

        ArrayList<Trip> TripList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT T.BRANCHID,B.BRANCHNAME,T.CENTERID,C.CENTERNAME,T.TRIPID,T.EMPLOYEEID,E.FIRSTNAME,E.SECONDNAME,E.THIRDNAME,T.TRIPDESCRIPTION "
                    + " FROM TRIP T "
                    + " LEFT JOIN BRANCH B ON  T.BRANCHID=B.BRANCHID "
                    + " LEFT JOIN CENTER C ON  T.BRANCHID=C.BRANCHID AND T.CENTERID=C.CENTERID "
                    + " LEFT JOIN EMPLOYEES E ON  T.BRANCHID=E.BRANCHID AND T.CENTERID=E.CENTERID AND T.EMPLOYEEID=E.EMPLOYEEID "
                    + " WHERE T.BRANCHID=? AND T.CENTERID=?"
                    + " ORDER BY T.TRIPID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                 ps.setInt(1, branchId);
                 ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    
                    TripList.add(populateTrip(rs));
                }

                rs.close();
            }

            return TripList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    
    public ArrayList<Trip> getTripList(int branchId, int centerId) throws Exception {
        
            ArrayList<Trip> tripList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT T.BRANCHID,B.BRANCHNAME,T.CENTERID,C.CENTERNAME,T.TRIPID,T.EMPLOYEEID,E.FIRSTNAME,E.SECONDNAME,E.THIRDNAME,T.TRIPDESCRIPTION "
                    + " FROM TRIP T "
                    + " LEFT JOIN BRANCH B ON  T.BRANCHID=B.BRANCHID "
                    + " LEFT JOIN CENTER C ON  T.BRANCHID=C.BRANCHID AND T.CENTERID=C.CENTERID "
                    + " LEFT JOIN EMPLOYEES E ON  T.BRANCHID=E.BRANCHID AND T.CENTERID=E.CENTERID AND T.EMPLOYEEID=E.EMPLOYEEID "
                    + " WHERE T.BRANCHID=? AND T.CENTERID=?"
                    + " ORDER BY T.TRIPID";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                tripList.add(populateTrip(rs)); 
            }

            rs.close();
            ps.close();
            
            return tripList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
  private Trip populateTrip(ResultSet rs) throws SQLException {
      
        Trip trip = new Trip();
        
        trip.setBranchId(rs.getInt("BRANCHID"));
        trip.setBranchName(rs.getString("BRANCHNAME"));
        trip.setCenterId(rs.getInt("CENTERID"));
        trip.setCenterName(rs.getString("CENTERNAME"));
        trip.setEmployeeId(rs.getInt("EMPLOYEEID"));
        trip.setFirstName(rs.getString("FIRSTNAME"));
        trip.setSecondName(rs.getString("SECONDNAME"));
        trip.setThirdName(rs.getString("THIRDNAME"));
        trip.setTripId(rs.getInt("TRIPID"));
        trip.setTripDescription(rs.getString("TRIPDESCRIPTION"));
        
        
        return trip;
    }  
  public void insertTrip(Trip trip) throws Exception {

        Connection conn = getConnection();

        String sqlTripNo = "SELECT NVL(MAX(TRIPID),0)+1 AS tripId FROM TRIP WHERE BRANCHID=? AND CENTERID=?";

        PreparedStatement ps1 = conn.prepareStatement(sqlTripNo);

        try {
             ps1.setInt(1, trip.getBranchId());
             ps1.setInt(2, trip.getCenterId());

            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                trip.setTripId(rs.getInt("tripId"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO TRIP T "
                + "       (T.BRANCHID, T.CENTERID,T.TRIPID,T.EMPLOYEEID,T.TRIPDESCRIPTION) "
                + "           VALUES (?,?,?,?,?) ";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            

           
            ps.setInt(1, trip.getBranchId());
            ps.setInt(2, trip.getCenterId());
            ps.setInt(3, trip.getTripId());
            ps.setInt(4, trip.getEmployeeId());
            ps.setString(5, trip.getTripDescription());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateTrip(Trip trip) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE TRIP T "
                    + "SET T.EMPLOYEEID=?,"
                    + "    T.TRIPDESCRIPTION=?"
                    + "    WHERE T.TRIPID=? "
                    + "      AND T.BRANCHID=? "
                    + "      AND T.CENTERID=? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, trip.getEmployeeId());
            ps.setString(2, trip.getTripDescription());
            ps.setInt(3, trip.getTripId());
            ps.setInt(4, trip.getBranchId());
            ps.setInt(5, trip.getCenterId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteTrip(int branchId, int centerId,int tripId) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM TRIP WHERE BRANCHID=? AND CENTERID=? AND TRIPID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, tripId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
     public Trip getTrip(int branchId, int centerId, int tripId) throws Exception {
        try {   
            Trip trip = null;
            Connection conn = getConnection();
            
                    
            String sql = "SELECT T.BRANCHID,B.BRANCHNAME,T.CENTERID,C.CENTERNAME,T.TRIPID,T.EMPLOYEEID,E.FIRSTNAME,E.SECONDNAME,E.THIRDNAME,T.TRIPDESCRIPTION "
                    + " FROM TRIP T "
                    + " LEFT JOIN BRANCH B ON  T.BRANCHID=B.BRANCHID "
                    + " LEFT JOIN CENTER C ON  T.BRANCHID=C.BRANCHID AND T.CENTERID=C.CENTERID "
                    + " LEFT JOIN EMPLOYEES E ON  T.BRANCHID=E.BRANCHID AND T.CENTERID=E.CENTERID AND T.EMPLOYEEID=E.EMPLOYEEID "
                    + " WHERE T.BRANCHID=? AND T.CENTERID=? AND T.TRIPID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, tripId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next())  
                trip = populateTrip(rs);
            

            rs.close();
            ps.close();
            
            return trip;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
}
