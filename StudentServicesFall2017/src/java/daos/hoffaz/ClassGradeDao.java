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
import models.hoffaz.ClassGrade;

/**
 *
 * @author khaled
 */
public class ClassGradeDao extends ConnectionDao{
    
    public ArrayList<ClassGrade> getClassGradeList() throws Exception {
        
            ArrayList<ClassGrade> classGradeList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT * FROM CLASS_GRADE";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                classGradeList.add(populateClassGrade(rs)); 
            }

            rs.close();
            ps.close();
            
            return classGradeList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
  private ClassGrade populateClassGrade(ResultSet rs) throws SQLException {
      
        ClassGrade classGrade = new ClassGrade();
        
        classGrade.setGradeId(rs.getInt("GRADE_ID"));
        classGrade.setGradeDesc(rs.getString("GRADE_DESC"));                   
        
        return classGrade;
    }   
    
    
}
