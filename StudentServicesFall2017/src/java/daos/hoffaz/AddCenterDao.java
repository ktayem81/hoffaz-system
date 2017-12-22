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
import models.hoffaz.Center;

/**
 *
 * @author khale
 */
public class AddCenterDao extends ConnectionDao{
    public void insertCenter(Center center) throws Exception {   
            
            Connection conn = getConnection();
            
                 
            String sql ;
        sql = "";
            
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setInt (1, center.getCenter_Id());
            ps.setString(2, center.getCenter_Name());
            ps.setString(3, center.getDescription());
            ps.setString(4, center.getPhone());
 ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
       
}
