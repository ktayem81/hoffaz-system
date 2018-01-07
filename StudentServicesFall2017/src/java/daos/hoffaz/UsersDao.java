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
import models.hoffaz.Users;

/**
 *
 * @author khale
 */
public class UsersDao extends ConnectionDao{
    
    public ArrayList<Users> buildUsers()
            throws Exception {

        ArrayList<Users> userList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT U.EMPLOYEEID,U.USERNAME,U.PASSWORD,U.FIRSTNAME,U.SECONDNAME,U.THIRDNAME,U.FAMILYNAME "
                    + "FROM USERS U "
                    + "LEFT JOIN EMPLOYEES E  ON U.EMPLOYEEID=E.EMPLOYEEID "
                    + "ORDER BY U.EMPLOYEEID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                // ps.setInt(1, branchId);
                // ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    
                    userList.add(populateUser(rs));
                }

                rs.close();
            }

            return userList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Users populateUser(ResultSet rs) throws SQLException {
        Users user = new Users();

        user.setEmployeeId(rs.getInt("EMPLOYEEID"));
        user.setUserName(rs.getString("USERNAME"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setFirstName(rs.getString("FIRSTNAME"));
        user.setSecondName(rs.getString("SECONDNAME"));
        user.setThirdName(rs.getString("THIRDNAME"));
        user.setFamilyName("FAMILYNAME");
        return user;
    }

    public void insertUser(Users user) throws Exception {

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
