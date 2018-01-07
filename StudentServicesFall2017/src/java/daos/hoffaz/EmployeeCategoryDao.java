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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.hoffaz.Employee_Category;

/**
 *
 * @author khale
 */
public class EmployeeCategoryDao extends ConnectionDao{
    public ArrayList<Employee_Category> getEmployeeCategory( int employeeId) {

        ArrayList<Employee_Category> employeeCategoryList = new ArrayList<>();
        
        try {
            Connection conn = getConnection();

            String sql = " SELECT CATEGORYDESCRIPTION "
                    + " FROM EMPLOYEECATEGORIES";
                    

            PreparedStatement ps = conn.prepareStatement(sql);
          //  ps.setInt(1, employeeId);
          
           

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee_Category employeeCategory = new Employee_Category();
                employeeCategory.setEmployeeCategoryId(rs.getInt("EMPLOYEECATEGORYID"));
                employeeCategory.setCategoryDescription(rs.getString("CATEGORYDESCRIPTION"));
                

                employeeCategoryList.add(employeeCategory);
            }

            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeCategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeeCategoryList;

    }
    
}
