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
import models.hoffaz.Courses;

/**
 *
 * @author khale
 */
public class CourseDao extends ConnectionDao{
    public ArrayList<Courses> buildCourses()
            throws Exception {
     ArrayList<Courses> coursesList = new ArrayList<>();
    try {
            Connection conn = getConnection();

            String sql = "SELECT COURSEID,COURSENAME,COURSEDESCRIPTION "
                    + "FROM COURSES "
                    + "ORDER BY COURSEID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                // ps.setInt(1, branchId);
                // ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    
                    coursesList.add(populateCourses(rs));
                }

                rs.close();
            }

            return coursesList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

    
}
    private Courses populateCourses(ResultSet rs) throws SQLException {
        Courses course = new Courses();

        course.setCourseId(rs.getInt("COURSEID"));
        course.setCourseName(rs.getString("COURSENAME"));
        course.setCourseDescription(rs.getString("COURSEDESCRIPTION"));
        

        return course;
    }
    public void insertCourse(Courses course) throws Exception {

        Connection conn = getConnection();

        String sqlCourseNo = "SELECT NVL(MAX(COURSEID),0)+1 AS courseId FROM COURSES";

        PreparedStatement ps1 = conn.prepareStatement(sqlCourseNo);

        try {
            // ps1.setInt(1, student.getBranchId());
            // ps1.setInt(2, student.getCenterId());

            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                course.setCourseId(rs.getInt("courseId"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO COURSES C "
                + "       (C.COURSEID,C.COURSENAME,C.COURSEDESCRIPTION) "
                + "           VALUES ((SELECT NVL(MAX(COURSEID),0)+1 AS courseId FROM COURSES),?,?) ";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getCourseDescription());
            

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    public void updateCourse(Courses course) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE COURSES "
                    + "SET COURSENAME=?,"
                    + " COURSEDESCRIPTION=? "
                    + " WHERE COURSEID=? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getCourseDescription());
            ps.setInt(3, course.getCourseId());
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteCourse(int courseId) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM COURSES WHERE COURSEID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ps.setInt(1, courseId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Courses getCourse(int courseId) throws Exception {
        try {
            Courses course = null;
            Connection conn = getConnection();

            String sql = "SELECT COURSEID,COURSENAME,COURSEDESCRIPTION "
                    + "FROM COURSES "
                    + " WHERE COURSEID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                course = populateCourses(rs);
            }

            rs.close();
            ps.close();

            return course;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
