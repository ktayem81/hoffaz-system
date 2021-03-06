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
import models.hoffaz.Branch;

/**
 *
 * @author khaled
 */
public class BranchDao extends ConnectionDao {
    public ArrayList<Branch> branchList() throws Exception {
        
            ArrayList<Branch> branchList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT B.BRANCHID,B.BRANCHNAME FROM BRANCH B";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                branchList.add(populateBranch(rs)); 
            }

            rs.close();
            ps.close();
            
            return branchList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public ArrayList<Branch> buildBranches()
            throws Exception {

        ArrayList<Branch> BranchList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT B.BRANCHID,B.BRANCHNAME,B.DESCRIPTION,B.GOVERNORATE_ID,G.DESCRIPTION AS GOVER_DESC,B.PHONE "
                    + "FROM BRANCH B "
                    + "LEFT JOIN GOVERNORATE G  ON B.GOVERNORATE_ID=G.GOVERNORATEID "
                    + "ORDER BY B.BRANCHID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                // ps.setInt(1, branchId);
                // ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    
                    BranchList.add(populateBranch(rs));
                }

                rs.close();
            }

            return BranchList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Branch populateBranch(ResultSet rs) throws SQLException {
        Branch branch = new Branch();

        branch.setBranchId(rs.getInt("BRANCHID"));
        branch.setBranchName(rs.getString("BRANCHNAME"));
        branch.setDescription(rs.getString("DESCRIPTION"));
        branch.setGovernorateId(rs.getInt("GOVERNORATE_ID"));
        branch.setGovernorateDesc(rs.getString("GOVER_DESC"));
        branch.setPhone(rs.getString("PHONE"));

        return branch;
    }

    public void insertBranch(Branch branch) throws Exception {

        Connection conn = getConnection();

        String sqlBranchNo = "SELECT NVL(MAX(BRANCHID),0)+1 AS branchId FROM BRANCH";

        PreparedStatement ps1 = conn.prepareStatement(sqlBranchNo);

        try {
            // ps1.setInt(1, student.getBranchId());
            // ps1.setInt(2, student.getCenterId());

            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                branch.setBranchId(rs.getInt("branchId"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO BRANCH B "
                + "       (B.BRANCHID,B.BRANCHNAME,B.DESCRIPTION,B.GOVERNORATE_ID,B.PHONE) "
                + "           VALUES ((SELECT NVL(MAX(BRANCHID),0)+1 AS branchId FROM BRANCH),?,?,?,?) ";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setString(1, branch.getBranchName());
            ps.setString(2, branch.getDescription());
            ps.setInt(3, branch.getGovernorateId());
            ps.setString(4, branch.getPhone());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateBranch(Branch branch) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE BRANCH "
                    + "SET BRANCHNAME=?,"
                    + "    DESCRIPTION=?,"
                    + "    GOVERNORATE_ID=?,"
                    + "    PHONE=?"
                    + "    WHERE BRANCHID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, branch.getBranchName());
            ps.setString(2, branch.getDescription());
            ps.setInt(3, branch.getGovernorateId());
            ps.setString(4, branch.getPhone());
            ps.setInt(5, branch.getBranchId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteBranch(int branchId) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM BRANCH WHERE BRANCHID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ps.setInt(1, branchId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Branch getBranch(int branchId) throws Exception {
        try {
            Branch branch = null;
            Connection conn = getConnection();

            String sql = "SELECT B.BRANCHID,B.BRANCHNAME,B.DESCRIPTION,B.GOVERNORATE_ID,G.DESCRIPTION AS GOVER_DESC,B.PHONE "
                    + "FROM BRANCH B "
                    + "LEFT JOIN GOVERNORATE G  ON B.GOVERNORATE_ID=G.GOVERNORATEID "
                    + "WHERE B.BRANCHID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, branchId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                branch = populateBranch(rs);
            }

            rs.close();
            ps.close();

            return branch;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
