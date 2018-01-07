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

            String sql = "SELECT U.EMPLOYEEID,U.USERNAME,U.PASSWORD "
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
        
        return user;
    }

    public void insertUser(Users user) throws Exception {

        Connection conn = getConnection();

//        String sqlBranchNo = "SELECT NVL(MAX(BRANCHID),0)+1 AS branchId FROM BRANCH";
//
//        PreparedStatement ps1 = conn.prepareStatement(sqlBranchNo);
//
//        try {
//            // ps1.setInt(1, student.getBranchId());
//            // ps1.setInt(2, student.getCenterId());
//
//            ResultSet rs = ps1.executeQuery();
//
//            while (rs.next()) {
//                branch.setBranchId(rs.getInt("branchId"));
//            }
//
//            rs.close();
//            ps1.close();
//        } catch (SQLException e) {
//            throw new SQLException(e.getMessage());
//        }

        String sql = "INSERT INTO USERS U "
                + "       (U.EMPLOYEEID,U.USERNAME,U.PASSWORD) "
                + "           VALUES (?,?,?) ";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setInt(1, user.getEmployeeId());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
           
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateUser(Users user) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE USERS "
                    + "SET USERNAME=?,"
                    + "    PASSWORD=? "
                    + "    WHERE EMPLOYEEID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getEmployeeId());
            

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteUser(int userId) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM USERS WHERE EMPLOYEEID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ps.setInt(1, userId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Users getUser(int userId) throws Exception {
        try {
            Users user = null;
            Connection conn = getConnection();

            String sql = "SELECT U.EMPLOYEEID,U.USERNAME,U.PASSWORD "
                    + "FROM USERS U "
                    + "LEFT JOIN EMPLOYEES E  ON U.EMPLOYEEID=E.EMPLOYEEID "
                    + " WHERE U.EMPLOYEEID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user = populateUser(rs);
            }

            rs.close();
            ps.close();

            return user;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
}
