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
 * @author khale
 */
public class AddBranchDao extends ConnectionDao{
   public ArrayList<Branch> buildBranches()
            throws Exception {

        ArrayList<Branch> BranchList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "";
            
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
        
        branch.setBranch_Name(rs.getString("branch_Name"));
        branch.setProvince(rs.getInt("province_Id"));
        branch.setBranch_Id(rs.getInt("branch_Id"));
        branch.setPhone(rs.getString("branch_Tele"));
        branch.setDescription(rs.getString("branch_comments"));
        
       
                
        return branch;
    }

    public void insertBranch(Branch branch) throws Exception {

        Connection conn = getConnection();

       // java.util.Date date = new java.util.Date();
      //  long t = date.getTime();
      //  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

        String sqlStudentNo = "";

        PreparedStatement ps1 = conn.prepareStatement(sqlStudentNo);

        try {
           // ps1.setInt(1, student.getBranchId());
           // ps1.setInt(2, student.getCenterId());
            
            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                branch.setBranch_Id(rs.getInt("branchId"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setString(1, branch.getBranch_Name());
            ps.setInt(2, branch.getProvince());
            ps.setInt(3, branch.getBranch_Id());
            ps.setString(4, branch.getPhone());
            ps.setString(5, branch.getDescription());
            
            
            //ps.setInt      (24, student.getUpdatEmployeeId());
            //ps.setTimestamp(25, (Timestamp) student.getUpdateDate());
            //ps.setString   (26, student.getUpdateHostIp());
            //ps.setString   (27, student.getUpdateHostOS());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateBranch(Branch branch) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
     public void deleteBranch(int studentId, int branchId, int centerId) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM STUDENTS WHERE STUDENTID=? AND S.BRANCHID=? AND S.CENTERID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, branchId);
            ps.setInt(3, centerId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
     
      public Branch getStudent(int branchId, int centerId, int studentId) throws Exception {
        try {   
            Branch branch = null;
            Connection conn = getConnection();
            
            String sql1 = "";
                      
            String sql = "";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, branchId);
            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next())  
                branch = populateBranch(rs);
            

            rs.close();
            ps.close();
            
            return branch;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }}
       
