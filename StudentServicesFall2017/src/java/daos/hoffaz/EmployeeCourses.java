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
import models.hoffaz.Employees_Courses;

/**
 *
 * @author khale
 */
public class EmployeeCourses  extends ConnectionDao{
    public ArrayList<Employees_Courses> buildEmployees_Courses()
            throws Exception {

        ArrayList<Employees_Courses> employees_Courses_List = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT E.EMPLOYEEID,E.COURSEID,C.COURSENAME,E.DATEOF,E.DURATION,E.DESCRIPTION,E.TOOKPLACEIN,E.CERTFICATNUMBER "
                    + "FROM EMPLOYEESCOURSES E "
                    + "LEFT JOIN COURSES C  ON E.COURSEID=C.COURSEID "
                    + "ORDER BY E.EMPLOYEEID,E.COURSEID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                // ps.setInt(1, branchId);
                // ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    
                    employees_Courses_List.add(populateemployees_Courses(rs));
                }

                rs.close();
            }

            return employees_Courses_List;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    private Employees_Courses populateemployees_Courses(ResultSet rs) throws SQLException {
        Employees_Courses employee_courses = new Employees_Courses();

        employee_courses.setEmployeeId(rs.getInt("EMPLOYEEID"));
        employee_courses.setCourseId(rs.getInt("COURSEID"));
        employee_courses.setDate(rs.getTimestamp("DATEOF"));
        employee_courses.setDuration(rs.getInt("DURATION"));
        employee_courses.setDescription(rs.getString("DESCRIPTION"));
        employee_courses.setPlace(rs.getString("TOOKPLACEIN"));
        employee_courses.setCertficatNumber(rs.getString("CERTFICATNUMBER"));

        return employee_courses;
    }
   public void insertEmployeeCourse(Employees_Courses employees_Courses) throws Exception {

        Connection conn = getConnection();

//       String sqlStudentNo = "SELECT NVL(MAX(STUDENTID),0)+1 AS studentId FROM STUDENTS WHERE BRANCHID=? AND CENTERID=?";
//
//        PreparedStatement ps1 = conn.prepareStatement(sqlStudentNo);
//
//        try {
//            ps1.setInt(1, student.getBranchId());
//            ps1.setInt(2, student.getCenterId());
//            
//            ResultSet rs = ps1.executeQuery();
//
//            while (rs.next()) {
//                student.setStudentId(rs.getInt("studentId"));
//            }
//
//            rs.close();
//            ps1.close();
//        } catch (SQLException e) {
//            throw new SQLException(e.getMessage());
//        }

        String sql = "INSERT INTO EMPLOYEESCOURSES (EMPLOYEEID,COURSEID,DATEOF,DURATION,DESCRIPTION,"
                + "TOOKPLACEIN,CERTFICATNUMBER "
                                 
                + "VALUES(?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            java.util.Date date = new java.util.Date();
            long t = date.getTime();
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
            employees_Courses.setDateOf(sqlTimestamp);
            
            ps.setInt(1, employees_Courses.getEmployeeId());
            ps.setInt(2, employees_Courses.getCourseId());
            ps.setTimestamp(3, new java.sql.Timestamp(employees_Courses.getDateOf().getTime()));
            ps.setInt(4, employees_Courses.getDuration());
            ps.setString(5, employees_Courses.getDescription());
            ps.setString(6, employees_Courses.getPlace());
            ps.setString(7,employees_Courses.getCertficatNumber() );
            
            //ps.setInt      (24, student.getUpdatEmployeeId());
            //ps.setTimestamp(25, (Timestamp) student.getUpdateDate());
            //ps.setString   (26, student.getUpdateHostIp());
            //ps.setString   (27, student.getUpdateHostOS());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
   public void updateEmployeeCourse(Employees_Courses employees_Courses) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE EMPLOYEESCOURSES S "
                    + "SET S.DATEOF=?,"
                    + "    S.DURATION=?, "
                    + "    S.DESCRIPTION=?, "
                    + "    S.TOOKPLACEIN=?, "
                    + "    S.CERTFICATNUMBER=?, "
                    + "    WHERE S.EMPLOYEEID=? "
                    + "      AND S.COURSEID=?";
                   
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            java.util.Date date = new java.util.Date();
            long t = date.getTime();
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
            employees_Courses.setUpdateDate(sqlTimestamp);
            
            ps.setTimestamp(1, new java.sql.Timestamp(employees_Courses.getDateOf().getTime()));
            ps.setInt(2, employees_Courses.getDuration());
            ps.setString(3, employees_Courses.getDescription());
            ps.setString(4, employees_Courses.getPlace());
            ps.setString(5,employees_Courses.getCertficatNumber());
            ps.setInt(6, employees_Courses.getEmployeeId());
            ps.setInt(7, employees_Courses.getCourseId());
            

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
   
   public void deleteEmployeeCourse( int courseId) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM EMPLOYEESCOURSES WHERE  COURSEID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, courseId);
            
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
     
      public Employees_Courses getEmployeeCourse( int courseId) throws Exception {
        try {   
            Employees_Courses employees_Courses = null;
            Connection conn = getConnection();
            
                    
            String sql = "SELECT E.EMPLOYEEID,E.COURSEID,C.COURSENAME,E.DATEOF,E.DURATION,E.DESCRIPTION,E.TOOKPLACEIN,E.CERTFICATNUMBER "
                    + "FROM EMPLOYEESCOURSES E "
                    + "LEFT JOIN COURSES C  ON E.COURSEID=C.COURSEID "
                    + " WHERE E.COURSEID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, courseId);
            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next())  
                employees_Courses = populateemployees_Courses(rs);
            

            rs.close();
            ps.close();
            
            return employees_Courses;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    
}
