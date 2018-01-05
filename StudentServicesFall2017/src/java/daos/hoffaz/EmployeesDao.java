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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.hoffaz.Employees;

/**
 *
 * @author khale
 */
public class EmployeesDao extends ConnectionDao {

    public int buildEmployees() {
        return 1;
    }

    public ArrayList<Employees> getEmployees(int branchId, int centerId, int employeeCategoryId) {

        ArrayList<Employees> employeesList = new ArrayList<>();
        
        try {
            Connection conn = getConnection();

            String sql = " SELECT EMPLOYEEID,FIRSTNAME,SECONDNAME,THIRDNAME,FAMILYNAME "
                    + " FROM EMPLOYEES "
                    + " WHERE BRANCHID=? AND CENTERID=? AND EMPLOYEECATEGORYID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, employeeCategoryId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployeeId(rs.getInt("EMPLOYEEID"));
                employee.setFirstName(rs.getString("FIRSTNAME"));
                employee.setSecondName(rs.getString("SECONDNAME"));
                employee.setThirdName(rs.getString("THIRDNAME"));
                employee.setFamilyName(rs.getString("FAMILYNAME"));

                employeesList.add(employee);
            }

            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(EmployeesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeesList;

    }
}
