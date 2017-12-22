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
import models.hoffaz.Place;

/**
 *
 * @author khale
 */
public class AddPlaceDao extends ConnectionDao{
    public void insertPlace(Place place) throws Exception {   
            
            Connection conn = getConnection();
            
                 
            String sql ;
        sql = "";
            
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setString (1, place.getPlace_Name());
            ps.setString(2, place.getLine_Name());
            ps.setInt(3, place.getRegion_num());
            
 ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
       
}
