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
import models.hoffaz.Nationality;

/**
 *
 * @author khaled
 */
public class NationalityDao extends ConnectionDao{
    
    public ArrayList<Nationality> getNationalityList() throws Exception {
        
            ArrayList<Nationality> nationalityList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT * FROM NATIONALITY";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                nationalityList.add(populateNationality(rs)); 
            }

            rs.close();
            ps.close();
            
            return nationalityList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
  private Nationality populateNationality(ResultSet rs) throws SQLException {
      
        Nationality nationality = new Nationality();
        
        nationality.setNationality(rs.getInt("NATIONALITY"));
        nationality.setNationalityDesc(rs.getString("NATIONALITYDESC"));                   
        
        return nationality;
    }   
    
}
