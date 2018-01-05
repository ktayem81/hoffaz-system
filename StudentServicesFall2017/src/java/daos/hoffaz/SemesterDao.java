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
import models.hoffaz.Semester;

/**
 *
 * @author khale
 */
public class SemesterDao extends ConnectionDao{    
    
    public ArrayList<Semester> buildSemesters(int branchId, int centerId)
            throws Exception {

        ArrayList<Semester> semesterList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT S.BRANCHID,B.BRANCHNAME,S.CENTERID,C.CENTERNAME,S.SEMESTER_ID,SD.SEMESTER_DESC AS LOOKUP,S.SEMESTER_YEAR,S.SEMESTER_DESC,S.SEMESTER_BEGIN,S.SEMESTER_END,S.INSERTEMPLOYEEID,S.INSERTDATE,S.INSERTHOSTIP,S.INSERTHOSTOS,S.UPDATEMPLOYEEID,S.UPDATEDATE,S.UPDATEHOSTIP,S.UPDATEHOSTOS "
                       + " FROM SEMESTERS S "
                       + " LEFT JOIN SEMESTER_DEF SD ON  S.SEMESTER_ID=SD.SEMESTER_ID "
                       + " LEFT JOIN BRANCH B ON  S.BRANCHID=B.BRANCHID "
                       + " LEFT JOIN CENTER C ON  S.BRANCHID=C.BRANCHID AND S.CENTERID=C.CENTERID "
                       + " WHERE S.BRANCHID=? AND S.CENTERID=? "
                       + " ORDER BY S.SEMESTER_YEAR DESC, S.SEMESTER_ID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    semesterList.add(populateSemester(rs));
                }

                rs.close();
            }

            return semesterList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Semester populateSemester(ResultSet rs) throws SQLException {
        Semester semester = new Semester();
        
        semester.setBranchId(rs.getInt("BRANCHID"));
        semester.setBranchName(rs.getString("BRANCHNAME"));
        semester.setCenterId(rs.getInt("CENTERID"));
        semester.setCenterName(rs.getString("CENTERNAME"));
        
        semester.setSemesterId(rs.getInt("SEMESTER_ID"));
        semester.setSemesterIdLookUp(rs.getString("LOOKUP"));
        semester.setSemesterYear(rs.getInt("SEMESTER_YEAR"));
        semester.setSemesterDesc(rs.getString("SEMESTER_DESC"));
        semester.setSemesterBegin(rs.getTimestamp("SEMESTER_BEGIN"));
        semester.setSemesterEnd(rs.getTimestamp("SEMESTER_END"));
        
        semester.setInsertEmployeeId(rs.getInt("INSERTEMPLOYEEID"));
        semester.setInsertDate(rs.getTimestamp("INSERTDATE"));
        semester.setInsertHostIp(rs.getString("INSERTHOSTIP"));
        semester.setInsertHostOS(rs.getString("INSERTHOSTOS"));
        semester.setUpdatEmployeeId(rs.getInt("UPDATEMPLOYEEID"));
        semester.setUpdateDate(rs.getTimestamp("UPDATEDATE"));
        semester.setUpdateHostIp(rs.getString("UPDATEHOSTIP"));
        semester.setUpdateHostOS(rs.getString("UPDATEHOSTOS"));
        
                
        return semester;
    }

    
    public void insertSemester(Semester semester) throws Exception {

        Connection conn = getConnection();

        String sql = "INSERT INTO SEMESTERS S (S.BRANCHID,S.CENTERID,S.SEMESTER_ID,S.SEMESTER_YEAR,S.SEMESTER_DESC,S.SEMESTER_BEGIN,S.SEMESTER_END,"
                   + "S.INSERTEMPLOYEEID,S.INSERTDATE,S.INSERTHOSTIP,S.INSERTHOSTOS) "
                   + " VALUES (?,?,?,?,?,"
                   + "         ?,?,?,?,?,"
                   + "         ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setInt(1, semester.getBranchId());
            ps.setInt(2, semester.getCenterId());
            ps.setInt(3, semester.getSemesterId());
            ps.setInt(4, semester.getSemesterYear());
            ps.setString(5, semester.getSemesterDesc());
            ps.setTimestamp(6,  new java.sql.Timestamp(semester.getSemesterBegin().getTime()));
            ps.setTimestamp(7, new java.sql.Timestamp(semester.getSemesterEnd().getTime()));
            ps.setInt(8, semester.getInsertEmployeeId());
            ps.setTimestamp(9, (Timestamp) semester.getInsertDate());
            ps.setString(10, semester.getInsertHostIp());
            ps.setString(11, semester.getInsertHostOS());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateSemester(Semester semester) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE SEMESTERS  SET SEMESTER_DESC=?,"
                       + "                      SEMESTER_BEGIN=?,"
                       + "                      SEMESTER_END=?,"
                       + "                      UPDATEMPLOYEEID=?,"
                       + "                      UPDATEDATE=?,"
                       + "                      UPDATEHOSTIP=?,"
                       + "                      UPDATEHOSTOS=?"
                       + "                WHERE BRANCHID=? "
                       + "                  AND CENTERID=? "
                       + "                  AND SEMESTER_YEAR=? "
                       + "                  AND SEMESTER_ID=? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, semester.getSemesterDesc());
            ps.setTimestamp(2, new java.sql.Timestamp(semester.getSemesterBegin().getTime()));
            ps.setTimestamp(3, new java.sql.Timestamp(semester.getSemesterEnd().getTime()));
            
            ps.setInt(4, semester.getUpdatEmployeeId());
            ps.setTimestamp(5, (Timestamp)semester.getUpdateDate());
            ps.setString(6, semester.getUpdateHostIp());
            ps.setString(7, semester.getUpdateHostOS());
            
            ps.setInt(8, semester.getBranchId());
            ps.setInt(9, semester.getCenterId());
            ps.setInt(10, semester.getSemesterYear());
            ps.setInt(11, semester.getSemesterId());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
     public void deleteSemester(int branchId, int centerId, int semesterYear, int semesterId) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM SEMESTERS WHERE BRANCHID=? AND CENTERID=? AND SEMESTER_YEAR=? AND SEMESTER_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, semesterYear);
            ps.setInt(4, semesterId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
     
      public Semester getSemester(int branchId, int centerId, int semesterYear, int semesterId) throws Exception {
        try {   
            Semester semester = null;
            Connection conn = getConnection();
            
            String sql = "SELECT S.BRANCHID,B.BRANCHNAME,S.CENTERID,C.CENTERNAME,S.SEMESTER_ID,SD.SEMESTER_DESC AS LOOKUP,S.SEMESTER_YEAR,S.SEMESTER_DESC,S.SEMESTER_BEGIN,S.SEMESTER_END,S.INSERTEMPLOYEEID,S.INSERTDATE,S.INSERTHOSTIP,S.INSERTHOSTOS,S.UPDATEMPLOYEEID,S.UPDATEDATE,S.UPDATEHOSTIP,S.UPDATEHOSTOS "
                       + " FROM SEMESTERS S "
                       + " LEFT JOIN SEMESTER_DEF SD ON  S.SEMESTER_ID=SD.SEMESTER_ID "
                       + " LEFT JOIN BRANCH B ON  S.BRANCHID=B.BRANCHID "
                       + " LEFT JOIN CENTER C ON  S.BRANCHID=C.BRANCHID AND S.CENTERID=C.CENTERID "
                       + " WHERE S.BRANCHID=? AND S.CENTERID=? AND SEMESTER_YEAR=? AND SEMESTER_ID=?";
           
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, semesterId);
            ps.setInt(4, semesterYear);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next())  
                semester = populateSemester(rs);
            

            rs.close();
            ps.close();
            
            return semester;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
      
       public ArrayList getSemesterYearList(int branchId, int centerId)
       throws Exception {
           ArrayList yearList = new ArrayList();

        try {
            Connection conn = getConnection();

            String sql = "SELECT DISTINCT S.SEMESTER_YEAR "
                       + " FROM SEMESTERS S "
                       + " WHERE S.BRANCHID=? AND S.CENTERID=? "
                       + " ORDER BY S.SEMESTER_YEAR DESC";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    yearList.add(rs.getInt("SEMESTER_YEAR"));
                }

                rs.close();
            }

            return yearList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    
    }
       
       public ArrayList<Semester> getSemesterIdList(int branchId, int centerId, int semesterYear)
       throws Exception {
           ArrayList<Semester> semesterList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT S.BRANCHID,B.BRANCHNAME,S.CENTERID,C.CENTERNAME,S.SEMESTER_ID,SD.SEMESTER_DESC AS LOOKUP,S.SEMESTER_YEAR,S.SEMESTER_DESC,S.SEMESTER_BEGIN,S.SEMESTER_END,S.INSERTEMPLOYEEID,S.INSERTDATE,S.INSERTHOSTIP,S.INSERTHOSTOS,S.UPDATEMPLOYEEID,S.UPDATEDATE,S.UPDATEHOSTIP,S.UPDATEHOSTOS "
                       + " FROM SEMESTERS S "
                       + " LEFT JOIN SEMESTER_DEF SD ON  S.SEMESTER_ID=SD.SEMESTER_ID "
                       + " LEFT JOIN BRANCH B ON  S.BRANCHID=B.BRANCHID "
                       + " LEFT JOIN CENTER C ON  S.BRANCHID=C.BRANCHID AND S.CENTERID=C.CENTERID "
                       + " WHERE S.BRANCHID=? AND S.CENTERID=? AND S.SEMESTER_YEAR=? "
                       + " ORDER BY S.SEMESTER_YEAR DESC, S.SEMESTER_ID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);
                ps.setInt(3, semesterYear);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    semesterList.add(populateSemester(rs));
                }

                rs.close();
            }

            return semesterList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

       
}
