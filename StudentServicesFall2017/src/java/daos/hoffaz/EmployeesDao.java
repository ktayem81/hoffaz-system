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
public class EmployeesDao extends ConnectionDao{
    
     public ArrayList<Employees> buildEmployees(int branchId, int centerId)
            throws Exception {

        ArrayList<Employees> employeesList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT E.EMPLOYEEID,E.FIRSTNAME,E.SECONDNAME,E.THIRDNAME,E.FAMILYNAME,E.BRANCHID,B.BRANCHNAME,E.CENTERID,C.CENTERNAME,E.PHONE,E.WHATSUP,E.ADDRESSDETIALS,E.NATIONALITY,N.NATIONALITYDESC,E.NATIONALITYID,E.EMPLOYEECATEGORYID,EC.CATEGORYDESCRIPTION,E.SALARY "
                    + " FROM EMPLOYEES E "
                    + " LEFT JOIN BRANCH B ON  E.BRANCHID=B.BRANCHID "
                    + " LEFT JOIN CENTER C ON  E.BRANCHID=C.BRANCHID AND E.CENTERID=C.CENTERID "                  
                    + " LEFT JOIN NATIONALITY N ON  E.NATIONALITY=N.NATIONALITY "  
                    + " LEFT JOIN EMPLOYEECATEGORIES EC ON  E.EMPLOYEECATEGORYID=EC.EMPLOYEECATEGORYID " 
                    + " ORDER BY E.EMPLOYEEID ";
            
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                //ps.setInt(1, branchId);
                //ps.setInt(2, centerId);
                
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    employeesList.add(populateEmployees(rs));
                }
                
                rs.close();
            }

            return employeesList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
     private Employees populateEmployees(ResultSet rs) throws SQLException {
        Employees employee = new Employees();
 //E.,E.,E.,E.,
 //E.BRANCHID,B.BRANCHNAME,E.CENTERID,C.CENTERNAME,
 //E.PHONE,E.WHATSUP,E.ADDRESSDETIALS,
 //E.NATIONALITY,N.NATIONALITYDESC,E.NATIONALITYID,E.EMPLOYEECATEGORYID,EC.CATEGORYDESCRIPTION,E.SALARY "       
        employee.setEmployeeId(rs.getInt("EMPLOYEEID"));
        employee.setFirstName(rs.getString("FIRSTNAME"));
        employee.setSecondName(rs.getString("SECONDNAME"));
        employee.setThirdName(rs.getString("THIRDNAME"));
        employee.setFamilyName(rs.getString("FAMILYNAME"));
        employee.setBranchId(rs.getInt("BRANCHID"));
        employee.setBranchDesc(rs.getString("BRANCHNAME"));
        employee.setCenterId(rs.getInt("CENTERID"));
        employee.setCenterDesc(rs.getString("CENTERNAME"));
        employee.setPhone(rs.getInt("PHONE"));
        employee.setWhatsup(rs.getInt("WHATSUP"));
        employee.setAddressDetials(rs.getString("ADDRESSDETIALS"));
        employee.setNationalityId(rs.getInt("NATIONALITY"));
        employee.setNationalityDesc(rs.getString("NATIONALITYDESC"));
        employee.setNationalityId(rs.getInt("NATIONALITYID"));
        employee.setEmployeeCategoryId(rs.getInt("EMPLOYEECATEGORYID"));
        employee.setEmployeeCategoryDesc(rs.getString("CATEGORYDESCRIPTION"));
        employee.setSalary(rs.getInt("SALARY"));
        
        
                
        return employee;
    }
       public void insertEmployee(Employees employee) throws Exception {

        Connection conn = getConnection();

        String sqlEmployeeNo = "SELECT NVL(MAX(EMPLOYEEID),0)+1 AS employeetId FROM EMPLOYEES WHERE BRANCHID=? AND CENTERID=?";

        PreparedStatement ps1 = conn.prepareStatement(sqlEmployeeNo);

        try {
            ps1.setInt(1, employee.getBranchId());
            ps1.setInt(2, employee.getCenterId());
            
            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                employee.setEmployeeId(rs.getInt("employeetId"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO EMPLOYEES ("
                + "EMPLOYEEID,"
                + "FIRSTNAME,SECONDNAME,THIRDNAME,FAMILYNAME,"
                + "BRANCHID,CENTERID,"
                + "PHONE,WHATSUP,ADDRESSDETIALS,"
                + "NATIONALITY,NATIONALITYID,"
                + "EMPLOYEECATEGORYID,SALARY) "                 
                + " VALUES ((SELECT NVL(MAX(EMPLOYEEID),0)+1 AS employeetId FROM EMPLOYEES), "
                + "?,?,?,?,?, "
                + "?,?,?,?,?, "
                + "?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
//            java.util.Date date = new java.util.Date();
//            long t = date.getTime();
//            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
//            student.setInsertDate(sqlTimestamp);
            
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getSecondName());
            ps.setString(3, employee.getThirdName());
            ps.setString(4, employee.getFamilyName());
            ps.setInt(5, employee.getBranchId());
            ps.setInt(6, employee.getCenterId());
            ps.setInt(7,employee.getPhone() );
            ps.setInt(8, employee.getWhatsup());
            ps.setString(9,employee.getAddressDetials());
            ps.setInt(10, employee.getNationality());
            ps.setInt(11, employee.getNationalityId());
            ps.setInt(12, employee.getEmployeeCategoryId());
            ps.setInt(13, employee.getSalary());
            

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
       public void updateEmployee(Employees employee) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE EMPLOYEES E "
                    + "SET E.FIRSTNAME=?,"
                    + "    E.SECONDNAME=?, "
                    + "    E.THIRDNAME=?, "
                    + "    E.FAMILYNAME=?, "
                    + "    E.PHONE=?, "
                    + "    E.WHATSUP=?, "
                    + "    E.ADDRESSDETIALS=?, "
                    + "    E.NATIONALITY=?, "
                    + "    E.NATIONALITYID=?, "
                    + "    E.EMPLOYEECATEGORYID=?, "
                    + "    E.SALARY=? "
                    + "    WHERE E.EMPLOYEEID=? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            
//            java.util.Date date = new java.util.Date();
//            long t = date.getTime();
//            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
//            student.setUpdateDate(sqlTimestamp);
            
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getSecondName());
            ps.setString(3, employee.getThirdName());
            ps.setString(4, employee.getFamilyName());
            ps.setInt(5,employee.getPhone() );
            ps.setInt(6, employee.getWhatsup());
            ps.setString(7,employee.getAddressDetials() );
             ps.setInt(8, employee.getNationality());
            ps.setInt(9, employee.getNationalityId());
            ps.setInt(10, employee.getEmployeeCategoryId());
            ps.setInt(11, employee.getSalary());
            ps.setInt(12, employee.getEmployeeId());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
       public void deleteEmployee(int branchId, int centerId, int employeetId) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEEID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setInt(1, branchId);
           // ps.setInt(2, centerId);
            ps.setInt(1, employeetId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
         public Employees getEmployee( int employeetId) throws Exception {
        try {   
            Employees employee = null;
            Connection conn = getConnection();
                        
            String sql = "SELECT E.EMPLOYEEID,E.FIRSTNAME,E.SECONDNAME,E.THIRDNAME,E.FAMILYNAME,E.BRANCHID,B.BRANCHNAME,E.CENTERID,C.CENTERNAME,E.PHONE,E.WHATSUP,E.ADDRESSDETIALS,E.NATIONALITY,N.NATIONALITYDESC,E.NATIONALITYID,E.EMPLOYEECATEGORYID,EC.CATEGORYDESCRIPTION,E.SALARY "
                    + " FROM EMPLOYEES E "
                    + " LEFT JOIN BRANCH B ON  E.BRANCHID=B.BRANCHID "
                    + " LEFT JOIN CENTER C ON  E.BRANCHID=C.BRANCHID AND E.CENTERID=C.CENTERID "                  
                    + " LEFT JOIN NATIONALITY N ON  E.NATIONALITY=N.NATIONALITY "  
                    + " LEFT JOIN EMPLOYEECATEGORIES EC ON  E.EMPLOYEECATEGORYID=EC.EMPLOYEECATEGORYID " 
                    + " WHERE  E.EMPLOYEEID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
           // ps.setInt(1, branchId);
           // ps.setInt(2, centerId);
            ps.setInt(1, employeetId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next())  
                employee = populateEmployees(rs);
            

            rs.close();
            ps.close();
            
            return employee;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
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
