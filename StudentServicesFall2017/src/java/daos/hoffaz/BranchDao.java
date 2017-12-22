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
import models.hoffaz.center_data;

/**
 *
 * @author khaled
 */
public class BranchDao extends ConnectionDao{
    
    public ArrayList<center_data> getCenterList() throws Exception {
        
            ArrayList<center_data> centerList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT * FROM Center";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                centerList.add(populateNationality(rs)); 
            }

            rs.close();
            ps.close();
            
            return centerList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
  private center_data populateNationality(ResultSet rs) throws SQLException {
      
        center_data center = new center_data();
        
        center.setBranch_id(rs.getInt("Center"));
        center.setBranch_name(rs.getString("CenterDescription"));                   
        
        return center;
    }   
    
}
