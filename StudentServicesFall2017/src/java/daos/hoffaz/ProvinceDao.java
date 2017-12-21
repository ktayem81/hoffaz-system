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
import models.hoffaz.Province;

/**
 *
 * @author khale
 */
public class ProvinceDao extends ConnectionDao{
    
    public ArrayList<Province> getProvinceList() throws Exception {
        
            ArrayList<Province> provinceList = new ArrayList<>();
                        
            Connection conn = getConnection();
        
        try {   
            String sql = "SELECT * FROM Province";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                provinceList.add(populateProvince(rs)); 
            }

            rs.close();
            ps.close();
            
            return provinceList;  
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
  private Province populateProvince(ResultSet rs) throws SQLException {
      
        Province province = new Province();
        
        province.setProvince_Id(rs.getInt("province_Id"));
        province.setProvince_Name(rs.getString("province_Name"));                   
        
        return province;
    }   
    
    
}
