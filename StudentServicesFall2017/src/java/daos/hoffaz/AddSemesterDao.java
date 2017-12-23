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
import java.sql.Timestamp;
import models.hoffaz.Semestes;

/**
 *
 * @author khale
 */
public class AddSemesterDao extends ConnectionDao{
    public void insertSemester(Semestes semester) throws Exception {   
            
            Connection conn = getConnection();
            
                 
            String sql ;
        sql = "";
            
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setInt (1, semester.getSemester_Id());
            ps.setString(2, semester.getDescription());
            ps.setTimestamp(3, semester.getSemester_begin());
            ps.setTimestamp(4, semester.getSemester_end());
            ps.setString(4, semester.getComments());
 ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
       
}
