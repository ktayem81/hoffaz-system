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
    
    
}
