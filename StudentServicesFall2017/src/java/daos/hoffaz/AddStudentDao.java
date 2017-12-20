/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.hoffaz;

import daos.ConnectionDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import models.hoffaz.Student;


/**
 *
 * @author khaled
 */
public class AddStudentDao extends ConnectionDao{
    
        public void insertStudent(Student student) throws Exception {   
            
            Connection conn = getConnection();
            
            java.util.Date date = new java.util.Date();
            long t = date.getTime();
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
            
            java.sql.Date sqlDate = null;  
            
            String sqlStudentNo = "SELECT NVL(MAX(STUDENTID),0)+1 AS studentId FROM STUDENTS WHERE BRANCHID=? AND CENTERID=?";
            
            PreparedStatement ps1 = conn.prepareStatement(sqlStudentNo);
            
            ps1.setInt(1, student.getBranchId());
            ps1.setInt(2, student.getCenterId());
            ResultSet rs = ps1.executeQuery();           

            while (rs.next()) {
                student.setStudentId(rs.getInt("studentId")); 
            }
            
            rs.close();
            ps1.close();
            
            String sql = "INSERT INTO STUDENTS (STUDENTID,FIRSTNAME,SECONDNAME,THIRDNAME,FAMILYNAME,"
                       + "BIRTHDATE,SEXID,DATEOFJOIN," +
                         "NATIONALITY,NATIONALITYNUMBER,"
                       + "PHONE,WHATSUP,BRANCHID,CENTERID,TRIPID,STOPID," +
                         "ADDRESSDETAILS,TRANSPORTATION,"
                       + "INSERTEMPLOYEEID,INSERTDATE,INSERTHOSTIP,INSERTHOSTOS)" +
                         //"UPDATEMPLOYEEID,UPDATEDATE,UPDATEHOSTIP,UPDATEHOSTOS) " +                   
                         "VALUES ((SELECT NVL(MAX(STUDENTID),0) AS MAX FROM STUDENTS WHERE BRANCHID=? AND CENTERID=?)+1,"
                       + "?,?,?,?,?,"
                       + "?,?,?,?,?,"
                       + "?,?,?,?,?,"
                       + "?,?,?,?,?,"
                       + "?)";
            
             PreparedStatement ps = conn.prepareStatement(sql);
            
        try {   
            ps.setInt      (1, student.getBranchId());
            ps.setInt      (2, student.getCenterId());
            ps.setString   (3, student.getFirstName());
            ps.setString   (4, student.getSecondName());
            ps.setString   (5, student.getThirdName());
            ps.setString   (6, student.getFamilyName());
            ps.setTimestamp(7,  new java.sql.Timestamp(student.getBirthDate().getTime()));
            ps.setInt      (8, student.getSexId());
            ps.setTimestamp(9, (Timestamp) student.getDateOfJoin());
            ps.setInt      (10, student.getNationality());
            ps.setInt      (11, student.getNationalityNumber());
            ps.setString   (12, student.getPhone());
            ps.setString   (13, student.getWhatsup());
            ps.setInt      (14, student.getBranchId());
            ps.setInt      (15, student.getCenterId());
            ps.setInt      (16, student.getTripId());
            ps.setInt      (17, student.getStopId());
            ps.setString   (18, student.getAddressDetails());
            ps.setBoolean(19, student.getTransportation());
            ps.setInt      (20, student.getInsertEmployeeId());
            ps.setTimestamp(21, sqlTimestamp);
            ps.setString   (22, student.getInsertHostIp());
            ps.setString   (23, student.getInsertHostOS());
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
    
}
