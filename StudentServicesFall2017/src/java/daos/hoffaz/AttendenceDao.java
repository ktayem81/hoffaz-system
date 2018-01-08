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
import models.hoffaz.Attendence;

/**
 *
 * @author eng_ayman
 */
public class AttendenceDao extends ConnectionDao {

    public ArrayList<Attendence> buildStudentsAttendence(int classroomid) throws Exception {

        ArrayList<Attendence> studentAttendence = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT A.ATTENDENCEID, A.ENROLLMENID, E.STUDENTID, E.CLASSROOMID, A.DATE_R, A.STATE_S, R.SEMESTER_ID, R.SEMESTER_YEAR, S.FIRSTNAME,S.SECONDNAME,S.THIRDNAME,S.FAMILYNAME "
                    + " FROM ATTENDENCE A"
                    + " LEFT JOIN STUDENTENROLLMENT E ON E.ENROLLMENID=A.ENROLLMENID "
                    + " LEFT JOIN CLASS_ROOM R ON E.CLASSROOMID=R.CLASS_ROOM_ID "
                    + " LEFT JOIN STUDENTS S ON E.STUDENTID=S.STUDENTID "
                    + " WHERE E.CLASSROOMID=? "
                    + " ORDER BY A.ATTENDENCEID ";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, classroomid);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    studentAttendence.add(populateStudent(rs));
                }

                rs.close();
            }

            return studentAttendence;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Attendence populateStudent(ResultSet rs) throws SQLException {
        Attendence studentAttendence = new Attendence();
        studentAttendence.setEnrollmenId(rs.getInt("ENROLLMENID"));
        studentAttendence.setStudentId(rs.getInt("STUDENTID"));
        studentAttendence.setFirstName(rs.getString("FIRSTNAME"));
        studentAttendence.setSecondName(rs.getString("SECONDNAME"));
        studentAttendence.setThirdName(rs.getString("THIRDNAME"));
        studentAttendence.setFamilyName(rs.getString("FAMILYNAME"));
        studentAttendence.setClassroom_Id(rs.getInt("CLASS_ROOM_ID"));
        studentAttendence.setAttendenceId(rs.getInt("ATTENDENCEID"));
        studentAttendence.setState_s(rs.getInt("STATE_S"));
        studentAttendence.setDate_r(rs.getTimestamp("DATE_R"));
        studentAttendence.setSemesterId(rs.getInt("SEMESTER_ID"));
        studentAttendence.setSemesterYear(rs.getInt("SEMESTER_YEAR"));

        return studentAttendence;
    }

    public void insertStudentAttendence(Attendence studentAttendence) throws Exception {

        Connection conn = getConnection();

        String sqlStudentNo = "SELECT NVL(MAX(ATTENDENCEID),0)+1 AS ATTENDENCEID FROM ATTENDENCE";

        PreparedStatement ps1 = conn.prepareStatement(sqlStudentNo);

        try {
            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                studentAttendence.setAttendenceId(rs.getInt("ATTENDENCEID"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO ATTENDENCE (ATTENDENCEID,ENROLLMENID,DATE_R, STATE_S)"
                + "VALUES(?,?,?,?); ";
        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setInt(1, studentAttendence.getAttendenceId());
            ps.setInt(2, studentAttendence.getEnrollmenId());
            ps.setTimestamp(3, studentAttendence.getDate_r());
            ps.setInt(4, studentAttendence.getState_s());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Attendence getStudentAttendence(int ENROLLMENID) throws Exception {
        try {
            Attendence student = null;
            Connection conn = getConnection();

            String sql = "SELECT E.STUDENTID, E.CLASSROOMID, E.GRADE, E.ENROLLMENID, E.RESULTT, R.SEMESTER_ID, R.SEMESTER_YEAR, S.FIRSTNAME,S.SECONDNAME,S.THIRDNAME,S.FAMILYNAME"
                    + " FROM STUDENTENROLLMENT E"
                    + " LEFT JOIN CLASS_ROOM R ON E.CLASSROOMID=R.CLASS_ROOM_ID"
                    + " LEFT JOIN STUDENTS S ON E.STUDENTID=S.STUDENTID"
                    + " WHERE E.ENROLLMENID=? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ENROLLMENID);

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

}
