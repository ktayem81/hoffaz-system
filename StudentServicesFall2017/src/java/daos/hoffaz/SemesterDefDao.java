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
import models.hoffaz.SemesterDef;

/**
 *
 * @author khaled
 */
public class SemesterDefDao extends ConnectionDao{
    
    public ArrayList<SemesterDef> getSemesterDefList() throws Exception {
        
            ArrayList<SemesterDef> semesterDefList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT * FROM SEMESTER_DEF ORDER BY SEMESTER_ID";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                semesterDefList.add(populateSemesterDef(rs)); 
            }

            rs.close();
            ps.close();
            
            return semesterDefList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
  private SemesterDef populateSemesterDef(ResultSet rs) throws SQLException {
      
        SemesterDef semesterDef = new SemesterDef();
        
        semesterDef.setSemesterId(rs.getInt("SEMESTER_ID"));
        semesterDef.setSemesterDesc(rs.getString("SEMESTER_DESC"));                   
        
        return semesterDef;
    }   
}
