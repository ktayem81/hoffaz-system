/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.hoffaz;

import daos.ConnectionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.hoffaz.Branch;

/**
 *
 * @author khale
 */
public class AddBranchDao extends ConnectionDao{
    public void insertStudent(Branch branch) throws Exception {   
            
            Connection conn = getConnection();
            
                 
            String sql ;
        sql = "";
            
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setInt (1, branch.getBranch_Id());
            ps.setString(2, branch.getBranch_Name());
            ps.setString(3, branch.getDescription());
            ps.setString(4, branch.getPhone());
 ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
       
}
