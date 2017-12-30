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
import models.hoffaz.Governorate;

/**
 *
 * @author khale
 */
public class GovernorateDao extends ConnectionDao{
    
    public ArrayList<Governorate> getGovernorateList() throws Exception {
        
            ArrayList<Governorate> governorateEList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT * FROM GOVERNORATE";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                governorateEList.add(populateGovernorate(rs)); 
            }

            rs.close();
            ps.close();
            
            return governorateEList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
  private Governorate populateGovernorate(ResultSet rs) throws SQLException {
      
        Governorate governorate = new Governorate();
        
        governorate.setGovernorate_Id(rs.getInt("GOVERNORATEID"));
        governorate.setDescription(rs.getString("DESCRIPTION"));                   
        
        return governorate;
    }   
    
    
}
