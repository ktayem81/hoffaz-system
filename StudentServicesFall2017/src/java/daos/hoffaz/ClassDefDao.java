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
import models.hoffaz.ClassDef;

/**
 *
 * @author khaled
 */
public class ClassDefDao extends ConnectionDao{
    
     public ArrayList<ClassDef> buildClassDef(int branchId, int centerId)
            throws Exception {

        ArrayList<ClassDef> ClassDefList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT C.BRANCHID,C.CENTERID,C.CLASS_ID,C.CLASS_NAME,C.CLASS_DEF_DESC,C.GRADE_ID_FROM,C.GRADE_ID_TO,C.INSERTEMPLOYEEID,C.INSERTDATE,C.INSERTHOSTIP,C.INSERTHOSTOS,C.UPDATEMPLOYEEID,C.UPDATEDATE,C.UPDATEHOSTIP,C.UPDATEHOSTOS "
                    + "FROM CLASS_DEF C "
                    + "WHERE C.BRANCHID=? "
                    + "AND C.CENTERID=?";
            
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);
                
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    ClassDefList.add(populateClassDef(rs));
                }
                
                rs.close();
            }

            return ClassDefList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private ClassDef populateClassDef(ResultSet rs) throws SQLException {
        ClassDef classDef = new ClassDef();
        
        classDef.setBranchId(rs.getInt("BRANCHID"));
        classDef.setCenterId(rs.getInt("CENTERID"));
        classDef.setClassID(rs.getInt("CLASS_ID"));
        classDef.setClassName(rs.getString("CLASS_NAME"));
        classDef.setClassDefDesc(rs.getString("CLASS_DEF_DESC"));
        classDef.setGradeIdFrom(rs.getInt("GRADE_ID_FROM"));
        classDef.setGradeIdTo(rs.getInt("GRADE_ID_TO"));
        classDef.setInsertEmployeeId(rs.getInt("INSERTEMPLOYEEID"));
        classDef.setInsertDate(rs.getTimestamp("INSERTDATE"));
        classDef.setInsertHostIp(rs.getString("INSERTHOSTIP"));
        classDef.setInsertHostOS(rs.getString("INSERTHOSTOS"));
        classDef.setUpdatEmployeeId(rs.getInt("UPDATEMPLOYEEID"));
        classDef.setUpdateDate(rs.getTimestamp("UPDATEDATE"));
        classDef.setUpdateHostIp(rs.getString("UPDATEHOSTIP"));
        classDef.setUpdateHostOS(rs.getString("UPDATEHOSTOS"));
        
        return classDef;
    }

    public void insertClassDef(ClassDef classDef) throws Exception {

        Connection conn = getConnection();

        java.util.Date date = new java.util.Date();
        long t = date.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

        String sqlClassId = "SELECT NVL(MAX(CLASS_ID),0)+1 AS classId FROM CLASS_DEF WHERE BRANCHID=? AND CENTERID=?";

        PreparedStatement ps1 = conn.prepareStatement(sqlClassId);

        try {
            ps1.setInt(1, classDef.getBranchId());
            ps1.setInt(2, classDef.getCenterId());
            
            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                classDef.setClassID(rs.getInt("CLASS_ID"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO CLASS_DEF C "
                + "(C.BRANCHID,C.CENTERID,C.CLASS_ID,C.CLASS_NAME,C.CLASS_DEF_DESC,C.GRADE_ID_FROM,C.GRADE_ID_TO,"
                + "INSERTEMPLOYEEID,INSERTDATE,INSERTHOSTIP,INSERTHOSTOS)"
                + //"UPDATEMPLOYEEID,UPDATEDATE,UPDATEHOSTIP,UPDATEHOSTOS) "                    
                "VALUES ((SELECT NVL(MAX(CLASS_ID),0)+1 AS classId FROM CLASS_DEF WHERE BRANCHID=? AND CENTERID=?)+1,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setInt(1, classDef.getBranchId());
            ps.setInt(2, classDef.getCenterId());
            ps.setInt(3, classDef.getClassID());
            ps.setString(4, classDef.getClassName());
            ps.setString(5, classDef.getClassDefDesc());
            ps.setInt(6, classDef.getGradeIdFrom());
            ps.setInt(7, classDef.getGradeIdTo());
            ps.setInt(8, classDef.getInsertEmployeeId());
            ps.setTimestamp(9, sqlTimestamp);
            ps.setString(10, classDef.getInsertHostIp());
            ps.setString(11, classDef.getInsertHostOS());
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
    
    public void updateClassDef(ClassDef classDef) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE CLASS_DEF C "
                    + " SET C.CLASS_NAME=?, "
                    + "     C.CLASS_DEF_DESC=?, "
                    + "     C.GRADE_ID_FROM=?, "
                    + "     C.GRADE_ID_TO=?, "
                    + "     C.UPDATEMPLOYEEID=?, "
                    + "     C.UPDATEDATE=?, "
                    + "     C.UPDATEHOSTIP=?, "
                    + "     C.UPDATEHOSTOS=? "
                    + "     WHERE S.BRANCHID=? "
                    + "       AND S.CENTERID=? "
                    + "       AND C.CLASS_ID=? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, classDef.getClassName());
            ps.setString(2, classDef.getClassDefDesc() );
            ps.setInt(3, classDef.getGradeIdFrom());
            ps.setInt(4, classDef.getGradeIdTo());
            ps.setInt(5, classDef.getUpdatEmployeeId());
            ps.setTimestamp(6,  sqlTimestamp);
            ps.setString(7, classDef.getUpdateHostIp());
            ps.setString(8, classDef.getUpdateHostOS());
            ps.setInt(9,classDef.getBranchId());
            ps.setInt(10, classDef.getCenterId());
            ps.setInt(11, classDef.getClassID());
            //ps.setInt      (24, );
            //ps.setTimestamp(25, (Timestamp) student.getUpdateDate());
            //ps.setString   (26, );
            //ps.setString   (27, );

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
     
      public Student getStudent(int branchId, int centerId, int studentId) throws Exception {
        try {   
            Student student = null;
            Connection conn = getConnection();
            
            String sql = "SELECT S.STUDENTID,S.FIRSTNAME,S.SECONDNAME,S.THIRDNAME,S.FAMILYNAME,S.BIRTHDATE,S.SEXID,SE.DESCRIPTION,S.DATEOFJOIN,S.NATIONALITY,N.NATIONALITYDESC,S.NATIONALITYNUMBER,S.PHONE,S.WHATSUP,S.BRANCHID,B.BRANCHNAME,S.CENTERID,C.CENTERNAME,S.TRIPID,T.TRIPDESCRIPTION,S.STOPID,TR.STOPDESCRIPTION,S.ADDRESSDETAILS,S.TRANSPORTATION,S.INSERTEMPLOYEEID,S.INSERTDATE,S.INSERTHOSTIP,S.INSERTHOSTOS,S.UPDATEMPLOYEEID,S.UPDATEDATE,S.UPDATEHOSTIP,S.UPDATEHOSTOS "
                    + " FROM STUDENTS S "
                    + " LEFT JOIN TRIP T ON  S.TRIPID=T.TRIPID "
                    + " LEFT JOIN SEXDESCRIPTION SE ON  S.SEXID=SE.SEXID "
                    + " LEFT JOIN TRIPDETAIL TR ON  S.TRIPID=TR.TRIPID AND S.STOPID=TR.STOPID " 
                    + " LEFT JOIN NATIONALITY N ON  S.NATIONALITY=N.NATIONALITY "  
                    + " LEFT JOIN BRANCH B ON  S.BRANCHID=B.BRANCHID "  
                    + " LEFT JOIN CENTER C ON  S.BRANCHID=C.BRANCHID AND S.CENTERID=C.CENTERID AND S.BRANCHID=? AND S.CENTERID=?  AND S.STUDENTID=?";
                                           
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, studentId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next())  
                student = populateStudent(rs);
            

            rs.close();
            ps.close();
            
            return student;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
}
