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
import models.hoffaz.Center;

/**
 *
 * @author khaled
 */
public class CenterDao extends ConnectionDao {

    public ArrayList<Center> buildCenters()
            throws Exception {

        ArrayList<Center> CenterList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT C.CENTERID,C.CENTERNAME,C.DESCRIPTION,C.BRANCHID,B.BRANCHNAME AS BRANCH_DESC,C.PHONE "
                    + "FROM CENTER C "
                    + "LEFT JOIN BRANCH B  ON C.BRANCHID=B.BRANCHID "
                    + "ORDER BY C.CENTERID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                // ps.setInt(1, branchId);
                // ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    
                    CenterList.add(populateCenter(rs));
                }

                rs.close();
            }

            return CenterList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Center populateCenter(ResultSet rs) throws SQLException {
        Center center = new Center();

        center.setCenterId(rs.getInt("CENTERID"));
        center.setCenterName(rs.getString("CENTERNAME"));
        center.setDescription(rs.getString("DESCRIPTION"));
        center.setBranchId(rs.getInt("BRANCHID"));
        center.setBranchDesc(rs.getString("BRANCH_DESC"));
        center.setPhone(rs.getString("PHONE"));

        return center;
    }

    public void insertCenter(Center center) throws Exception {

        Connection conn = getConnection();

        String sqlCenterNo = "SELECT NVL(MAX(CENTERID),0)+1 AS centerId FROM CENTER";

        PreparedStatement ps1 = conn.prepareStatement(sqlCenterNo);

        try {
            // ps1.setInt(1, student.getBranchId());
            // ps1.setInt(2, student.getCenterId());

            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                center.setCenterId(rs.getInt("centerId"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO CENTER C "
                + "       (C.CENTERID,C.CENTERNAME,C.DESCRIPTION,C.BRANCHID,C.PHONE) "
                + "           VALUES ((SELECT NVL(MAX(CENTERID),0)+1 AS centerId FROM CENTER),?,?,?,?) ";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setString(1, center.getCenterName());
            ps.setString(2, center.getDescription());
            ps.setInt(3, center.getBranchId());
            ps.setString(4, center.getPhone());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateCenter(Center center) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE CENTER "
                    + "SET CENTERNAME=?,"
                    + "    DESCRIPTION=?,"
                    + "    BRANCHID=?,"
                    + "    PHONE=?"
                    + "WHERE CENTERID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, center.getCenterName());
            ps.setString(2, center.getDescription());
            ps.setInt(3, center.getBranchId());
            ps.setString(4, center.getPhone());
            ps.setInt(5, center.getCenterId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteCenter(int centerId) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM CENTER WHERE CENTERID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ps.setInt(1, centerId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Center getCenter(int centerId) throws Exception {
        try {
            Center center = null;
            Connection conn = getConnection();

            String sql = "SELECT C.CENTERID,C.CENTERNAME,C.DESCRIPTION,C.BRANCHID,B.BRANCHNAME AS BRANCH_DESC,C.PHONE "
                    + "FROM CENTER C "
                    + "LEFT JOIN BRANCH B  ON C.BRANCHID=B.BRANCHID "
                    + "WHERE C.CENTERID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, centerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                center = populateCenter(rs);
            }

            rs.close();
            ps.close();

            return center;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
