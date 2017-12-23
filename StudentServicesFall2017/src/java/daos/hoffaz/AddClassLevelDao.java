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
import models.hoffaz.Class_Level;

/**
 *
 * @author khale
 */
public class AddClassLevelDao extends ConnectionDao{
    public void insertClassLevel(Class_Level level) throws Exception {   
            
            Connection conn = getConnection();
            
                 
            String sql ;
        sql = "";
            
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setInt (1, level.getClass_ID());
            ps.setInt(2, level.getLevel_ID());
            ps.setString(3, level.getLevel_Name());
            ps.setString(4, level.getDescription());
 ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
       
}
