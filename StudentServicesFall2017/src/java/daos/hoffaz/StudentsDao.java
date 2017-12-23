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
import java.sql.Timestamp;
import java.util.ArrayList;
import models.hoffaz.Student;

/**
 *
 * @author khaled
 */
public class StudentsDao extends ConnectionDao {

    public ArrayList<Student> buildStudents(int branchId, int centerId)
            throws Exception {

        ArrayList<Student> studentList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT S.STUDENTID,S.FIRSTNAME,S.SECONDNAME,S.THIRDNAME,S.FAMILYNAME,S.BIRTHDATE,S.SEXID,SE.DESCRIPTION,S.DATEOFJOIN,S.NATIONALITY,N.NATIONALITYDESC,S.NATIONALITYNUMBER,S.PHONE,S.WHATSUP,S.BRANCHID,B.BRANCHNAME,S.CENTERID,C.CENTERNAME,S.TRIPID,T.TRIPDESCRIPTION,S.STOPID,TR.STOPDESCRIPTION,S.ADDRESSDETAILS,S.TRANSPORTATION,S.INSERTEMPLOYEEID,S.INSERTDATE,S.INSERTHOSTIP,S.INSERTHOSTOS,S.UPDATEMPLOYEEID,S.UPDATEDATE,S.UPDATEHOSTIP,S.UPDATEHOSTOS "
                    + " FROM STUDENTS S "
                    + " LEFT JOIN TRIP T ON  S.TRIPID=T.TRIPID "
                    + " LEFT JOIN SEXDESCRIPTION SE ON  S.SEXID=SE.SEXID "
                    + " LEFT JOIN TRIPDETAIL TR ON  S.TRIPID=TR.TRIPID AND S.STOPID=TR.STOPID " 
                    + " LEFT JOIN NATIONALITY N ON  S.NATIONALITY=N.NATIONALITY "  
                    + " LEFT JOIN BRANCH B ON  S.BRANCHID=B.BRANCHID "  
                    + " LEFT JOIN CENTER C ON  S.BRANCHID=C.BRANCHID AND S.CENTERID=C.CENTERID AND S.BRANCHID=? AND S.CENTERID=?"
                    + " ORDER BY S.STUDENTID";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                studentList.add(populateStudent(rs));
            }

            rs.close();
            ps.close();

            return studentList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Student populateStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        
        student.setStudentId(rs.getInt("STUDENTID"));
        student.setFirstName(rs.getString("FIRSTNAME"));
        student.setSecondName(rs.getString("SECONDNAME"));
        student.setThirdName(rs.getString("THIRDNAME"));
        student.setFamilyName(rs.getString("FAMILYNAME"));
        student.setBirthDate(rs.getTimestamp("BIRTHDATE")); 
        student.setSexId(rs.getInt("SEXID"));
        student.setSexDescription(rs.getString("DESCRIPTION"));
        student.setDateOfJoin(rs.getTimestamp("DATEOFJOIN"));
        student.setNationality(rs.getInt("NATIONALITY"));
        student.setNationalityDesc(rs.getString("NATIONALITYDESC"));
        student.setNationalityNumber(rs.getInt("NATIONALITYNUMBER"));
        student.setPhone(rs.getString("PHONE"));
        student.setWhatsup(rs.getString("WHATSUP"));
        student.setBranchId(rs.getInt("BRANCHID"));
        student.setBranchName(rs.getString("BRANCHNAME"));
        student.setCenterId(rs.getInt("CENTERID"));
        student.setCenterName(rs.getString("CENTERNAME"));
        student.setTripId(rs.getInt("TRIPID"));
        student.setTripDesc(rs.getString("TRIPDESCRIPTION"));
        student.setStopId(rs.getInt("STOPID"));
        student.setStopDesc(rs.getString("STOPDESCRIPTION"));
        student.setAddressDetails(rs.getString("ADDRESSDETAILS"));
        student.setTransportation((rs.getInt("TRANSPORTATION") != 0));
        student.setInsertEmployeeId(rs.getInt("INSERTEMPLOYEEID"));
        student.setInsertDate(rs.getTimestamp("INSERTDATE"));
        student.setInsertHostIp(rs.getString("INSERTHOSTIP"));
        student.setInsertHostOS(rs.getString("INSERTHOSTOS"));
        student.setUpdatEmployeeId(rs.getInt("UPDATEMPLOYEEID"));
        student.setUpdateDate(rs.getTimestamp("UPDATEDATE"));
        student.setUpdateHostIp(rs.getString("UPDATEHOSTIP"));
        student.setUpdateHostOS(rs.getString("UPDATEHOSTOS"));
                
        return student;
    }

    public void insertStudent(Student student) throws Exception {

        Connection conn = getConnection();

        java.util.Date date = new java.util.Date();
        long t = date.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

        String sqlStudentNo = "SELECT NVL(MAX(STUDENTID),0)+1 AS studentId FROM STUDENTS WHERE BRANCHID=? AND CENTERID=?";

        PreparedStatement ps1 = conn.prepareStatement(sqlStudentNo);

        try {
            ps1.setInt(1, student.getBranchId());
            ps1.setInt(2, student.getCenterId());
            
            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                student.setStudentId(rs.getInt("studentId"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO STUDENTS (STUDENTID,FIRSTNAME,SECONDNAME,THIRDNAME,FAMILYNAME,"
                + "BIRTHDATE,SEXID,DATEOFJOIN,"
                + "NATIONALITY,NATIONALITYNUMBER,"
                + "PHONE,WHATSUP,BRANCHID,CENTERID,TRIPID,STOPID,"
                + "ADDRESSDETAILS,TRANSPORTATION,"
                + "INSERTEMPLOYEEID,INSERTDATE,INSERTHOSTIP,INSERTHOSTOS)"
                + //"UPDATEMPLOYEEID,UPDATEDATE,UPDATEHOSTIP,UPDATEHOSTOS) " +                   
                "VALUES ((SELECT NVL(MAX(STUDENTID),0) AS MAX FROM STUDENTS WHERE BRANCHID=? AND CENTERID=?)+1,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setInt(1, student.getBranchId());
            ps.setInt(2, student.getCenterId());
            ps.setString(3, student.getFirstName());
            ps.setString(4, student.getSecondName());
            ps.setString(5, student.getThirdName());
            ps.setString(6, student.getFamilyName());
            ps.setTimestamp(7, new java.sql.Timestamp(student.getBirthDate().getTime()));
            ps.setInt(8, student.getSexId());
            ps.setTimestamp(9, (Timestamp) student.getDateOfJoin());
            ps.setInt(10, student.getNationality());
            ps.setInt(11, student.getNationalityNumber());
            ps.setString(12, student.getPhone());
            ps.setString(13, student.getWhatsup());
            ps.setInt(14, student.getBranchId());
            ps.setInt(15, student.getCenterId());
            ps.setInt(16, student.getTripId());
            ps.setInt(17, student.getStopId());
            ps.setString(18, student.getAddressDetails());
            ps.setBoolean(19, student.getTransportation());
            ps.setInt(20, student.getInsertEmployeeId());
            ps.setTimestamp(21, sqlTimestamp);
            ps.setString(22, student.getInsertHostIp());
            ps.setString(23, student.getInsertHostOS());
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
    
     public void deleteStudent(int studentId) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM STUDENTS WHERE STUDENTID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
