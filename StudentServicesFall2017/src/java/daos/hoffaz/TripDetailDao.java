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
public class TripDetailDao extends ConnectionDao {

    public ArrayList<TripDetail> buildTripDetails(int branchId, int centerId)
            throws Exception {

        ArrayList<TripDetail> tripDetailList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT T.ROWID,T.BRANCHID,B.BRANCHNAME,T.CENTERID,C.CENTERNAME,T.TRIPID,TR.TRIPDESCRIPTION,T.STOPID,T.STOPDESCRIPTION  "
                    + " FROM TRIPDETAIL T  "
                    + "                      LEFT JOIN BRANCH B ON T.BRANCHID=B.BRANCHID  "
                    + "                      LEFT JOIN CENTER C ON T.BRANCHID=C.BRANCHID AND T.CENTERID=C.CENTERID  "
                    + "                      LEFT JOIN TRIP TR ON T.BRANCHID=TR.BRANCHID AND T.CENTERID=TR.CENTERID AND T.TRIPID=TR.TRIPID  "
                    + "                      WHERE T.BRANCHID=? AND T.CENTERID=? "
                    + "                      ORDER BY T.TRIPID,T.STOPID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    tripDetailList.add(populateTripDetail(rs));
                }

                rs.close();
            }

            return tripDetailList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
     private TripDetail populateTripDetail(ResultSet rs) throws SQLException {

        TripDetail tripDetail = new TripDetail();

        tripDetail.setRowId(rs.getString("ROWID"));
        tripDetail.setBranchId(rs.getInt("BRANCHID"));
        tripDetail.setBranchName(rs.getString("BRANCHNAME"));
        tripDetail.setCenterId(rs.getInt("CENTERID"));
        tripDetail.setCenterName(rs.getString("CENTERNAME"));
        
        tripDetail.setTripId(rs.getByte("TRIPID"));
        tripDetail.setTripDesc(rs.getString("TRIPDESCRIPTION"));
        
        tripDetail.setStopId(rs.getInt("STOPID"));
        tripDetail.setStopDescription(rs.getString("STOPDESCRIPTION"));

        return tripDetail;
    }

    public ArrayList<TripDetail> getTripList(int branchId, int centerId, int tripId) throws Exception {

        ArrayList<TripDetail> tripDetailList = new ArrayList<>();

        Connection conn = getConnection();

        try {
            String sql = "SELECT T.ROWID,T.BRANCHID,B.BRANCHNAME,T.CENTERID,C.CENTERNAME,T.TRIPID,TR.TRIPDESCRIPTION,T.STOPID,T.STOPDESCRIPTION FROM TRIPDETAIL T "
                    + " LEFT JOIN BRANCH B ON T.BRANCHID=B.BRANCHID "
                    + " LEFT JOIN CENTER C ON T.CENTERID=C.CENTERID "
                    + " LEFT JOIN TRIP TR ON T.TRIPID=TR.TRIPID "
                    + " WHERE T.BRANCHID=? AND T.CENTERID=? AND T.TRIPID=?"
                    + " ORDER BY T.TRIPID,T.STOPID ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, tripId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tripDetailList.add(populateTripDetail(rs));
            }

            rs.close();
            ps.close();

            return tripDetailList;

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

   

    public void insertTripDteail(TripDetail tripDetail) throws Exception {

        Connection conn = getConnection();

        String sqlTripDetailNo = "SELECT NVL(MAX(STOPID),0)+1 AS stopId FROM TRIPDETAIL WHERE BRANCHID=? AND CENTERID=? AND TRIPID=? ";

        PreparedStatement ps1 = conn.prepareStatement(sqlTripDetailNo);

        try {
            ps1.setInt(1, tripDetail.getBranchId());
            ps1.setInt(2, tripDetail.getCenterId());
            ps1.setInt(3, tripDetail.getTripId());

            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                tripDetail.setStopId(rs.getInt("stopId"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO TRIPDETAIL T "
                + "       (T.BRANCHID, T.CENTERID,T.TRIPID,T.STOPID,T.STOPDESCRIPTION) "
                + "           VALUES (?,?,?,?,?) ";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setInt(1, tripDetail.getBranchId());
            ps.setInt(2, tripDetail.getCenterId());
            ps.setInt(3, tripDetail.getTripId());
            ps.setInt(4, tripDetail.getStopId());
            ps.setString(5, tripDetail.getStopDescription());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateTripDetail(TripDetail tripDetail) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE TRIPDETAIL T "
                    + "SET T.STOPDESCRIPTION=? "
                    + "    WHERE  T.BRANCHID=? "
                    + "      AND  T.CENTERID=? "
                    + "      AND  T.TRIPID=? "
                    + "      AND T.STOPID=? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, tripDetail.getStopDescription());
            ps.setInt(2, tripDetail.getBranchId());
            ps.setInt(3, tripDetail.getCenterId());
            ps.setInt(4, tripDetail.getTripId());
            ps.setInt(5, tripDetail.getStopId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteTripDetail(int branchId, int centerId,int tripId, int stopId) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM TRIPDETAIL WHERE BRANCHID=? AND CENTERID=? AND TRIPID=? AND STOPID=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, tripId);
            ps.setInt(4, stopId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public TripDetail getTripDetail(String rowId)//int branchId, int centerId,int tripId, int stopId) 
            throws Exception {
        try {
            TripDetail tripDetail = null;
            Connection conn = getConnection();

            String sql = "SELECT T.ROWID,T.BRANCHID,B.BRANCHNAME,T.CENTERID,C.CENTERNAME,T.TRIPID,TR.TRIPDESCRIPTION,T.STOPID,T.STOPDESCRIPTION  "
                    + " FROM TRIPDETAIL T  "
                    + "                      LEFT JOIN BRANCH B ON T.BRANCHID=B.BRANCHID  "
                    + "                      LEFT JOIN CENTER C ON T.BRANCHID=C.BRANCHID AND T.CENTERID=C.CENTERID  "
                    + "                      LEFT JOIN TRIP TR ON T.BRANCHID=TR.BRANCHID AND T.CENTERID=TR.CENTERID AND T.TRIPID=TR.TRIPID  "
                    + "                      WHERE T.ROWID=?"
                    //+ "T.BRANCHID=? AND T.CENTERID=? AND T.TRIPID=? AND T.STOPID=?"
                    + "                      ORDER BY T.TRIPID,T.STOPID";

            PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, rowId);
//            ps.setInt(1, branchId);
//            ps.setInt(2, centerId);
//            ps.setInt(3, tripId);
//            ps.setInt(4, stopId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tripDetail = populateTripDetail(rs);
            }

            rs.close();
            ps.close();

            return tripDetail;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
