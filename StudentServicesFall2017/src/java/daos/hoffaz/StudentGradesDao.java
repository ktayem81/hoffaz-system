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
import models.hoffaz.StudentGrades;

/**
 *
 * @author eng_ayman
 */
public class StudentGradesDao extends ConnectionDao {

    public ArrayList<StudentGrades> buildStudentsGrades(int classroomid, int branchId, int centerId,int class_id,int level_id, int semester_id , int semester_year) throws Exception {

        ArrayList<StudentGrades> studentGrade = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "select E.BRANCHID, E.CENTERID, E.CLASS_ID, E.LEVEL_ID, E.SEMESTER_ID, E.SEMESTER_YEAR, E.CLASS_ROOM_ID, E.STUDENTID, E.GRADE, E.RESULTT, S.FIRSTNAME,S.SECONDNAME,S.THIRDNAME,S.FAMILYNAME "
                    + "                     FROM STUDENTENROLLMENT E"
                    + "                     LEFT JOIN CLASS_ROOM R ON E.CLASS_ROOM_ID=R.CLASS_ROOM_ID "
                    + "                     LEFT JOIN STUDENTS S ON E.STUDENTID=S.STUDENTID "
                    + "                     WHERE E.CLASS_ROOM_ID=? AND E.BRANCHID=? AND E.CENTERID=? AND E.CLASS_ID=? AND E.LEVEL_ID=? AND E.SEMESTER_ID =? AND E.SEMESTER_YEAR =? ";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, classroomid);
                ps.setInt(2, branchId);
                ps.setInt(3, centerId);
                ps.setInt(4, class_id);
                ps.setInt(5, level_id);
                ps.setInt(6, semester_id);
                ps.setInt(7, semester_year);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    studentGrade.add(populateStudent(rs));
                }

                rs.close();
            }

            return studentGrade;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private StudentGrades populateStudent(ResultSet rs) throws SQLException {
        StudentGrades studentGrade = new StudentGrades();
        studentGrade.setStudentId(rs.getInt("STUDENTID"));
        studentGrade.setFirstName(rs.getString("FIRSTNAME"));
        studentGrade.setSecondName(rs.getString("SECONDNAME"));
        studentGrade.setThirdName(rs.getString("THIRDNAME"));
        studentGrade.setFamilyName(rs.getString("FAMILYNAME"));
        studentGrade.setClassroom_Id(rs.getInt("CLASS_ROOM_ID"));
        studentGrade.setGrade(rs.getInt("GRADE"));
        studentGrade.setResult(rs.getInt("RESULTT"));
        studentGrade.setSemesterId(rs.getInt("SEMESTER_ID"));
        studentGrade.setSemesterYear(rs.getInt("SEMESTER_YEAR"));
        studentGrade.setBranchid(rs.getInt("BRANCHID"));
        studentGrade.setCenterid(rs.getInt("CENTERID"));
        studentGrade.setClass_id(rs.getInt("CLASS_ID"));
        studentGrade.setLevel_id(rs.getInt("LEVEL_ID"));

        return studentGrade;
    }

   
    public StudentGrades getStudentgrade(int studentid,int classroomid, int branchId, int centerId,int class_id,int level_id, int semester_id , int semester_year) throws Exception {
        try {
            StudentGrades student = null;
            Connection conn = getConnection();

            String sql = "select E.BRANCHID, E.CENTERID, E.CLASS_ID, E.LEVEL_ID, E.SEMESTER_ID, E.SEMESTER_YEAR, E.CLASS_ROOM_ID, E.STUDENTID, E.GRADE, E.RESULTT, S.FIRSTNAME,S.SECONDNAME,S.THIRDNAME,S.FAMILYNAME "
                    + "                     FROM STUDENTENROLLMENT E"
                    + "                     LEFT JOIN CLASS_ROOM R ON E.CLASS_ROOM_ID=R.CLASS_ROOM_ID "
                    + "                     LEFT JOIN STUDENTS S ON E.STUDENTID=S.STUDENTID "
                    + "                     WHERE E.CLASS_ROOM_ID=? AND E.BRANCHID=? AND E.CENTERID=? AND E.CLASS_ID=? AND E.LEVEL_ID=? AND E.SEMESTER_ID =? AND E.SEMESTER_YEAR =? AND STUDENTID=? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1, classroomid);
                ps.setInt(2, branchId);
                ps.setInt(3, centerId);
                ps.setInt(4, class_id);
                ps.setInt(5, level_id);
                ps.setInt(6, semester_id);
                ps.setInt(7, semester_year);
                ps.setInt(8, studentid);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                student = populateStudent(rs);
            }

            rs.close();
            ps.close();

            return student;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateStudentGrades(StudentGrades selectedStudentGrade) throws Exception {
       try {
            Connection conn = getConnection();

            String sql = " UPDATE CLASS_ROOM  SET GRADE=?"
                    + " WHERE BRANCHID=? AND=? AND CENTERID =? AND CLASS_ID=? AND LEVEL_ID=? AND SEMESTER_ID =? AND SEMESTER_YEAR =? AND CLASS_ROOM_ID=? AND STUDENTID ";

           try (PreparedStatement ps = conn.prepareStatement(sql)) {
               ps.setInt(1, selectedStudentGrade.getGrade());
               ps.setInt(2, selectedStudentGrade.getBranchid());
               ps.setInt(3, selectedStudentGrade.getCenterid());
               ps.setInt(4, selectedStudentGrade.getClass_id());
               ps.setInt(5, selectedStudentGrade.getLevel_id());
               ps.setInt(6, selectedStudentGrade.getSemesterId());
               ps.setInt(7, selectedStudentGrade.getSemesterYear());
               ps.setInt(8, selectedStudentGrade.getClassroom_Id());
               ps.setInt(9, selectedStudentGrade.getStudentId());
               ps.executeUpdate();
           }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
