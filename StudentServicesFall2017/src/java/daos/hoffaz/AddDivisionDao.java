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
import models.hoffaz.Division;

/**
 *
 * @author khale
 */
public class AddDivisionDao extends ConnectionDao{
    public void insertStudent(Division division) throws Exception {   
            
            Connection conn = getConnection();
            
                 
            String sql ;
        sql = "";
            
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setInt (1, division.getSemester_id());
            ps.setString(2, division.getYear());
            ps.setInt(3, division.getDivision_id());
            ps.setString(4, division.getClass_name());
            ps.setString(5, division.getLevel_name());
            ps.setString(6, division.getInstructer_name());
            ps.setString(7, division.getComments());
 ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
       
}
