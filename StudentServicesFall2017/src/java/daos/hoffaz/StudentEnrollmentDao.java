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
import java.util.ArrayList;

/**
 *
 * @author khaled
 */
public class StudentEnrollmentDao extends ConnectionDao{
    
    public ArrayList<Student> buildStudents(int branchId, int centerId)
            throws Exception {

        ArrayList<Student> studentList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT S.STUDENTID,S.FIRSTNAME,S.SECONDNAME,S.THIRDNAME,S.FAMILYNAME,S.BIRTHDATE,S.SEXID,SE.DESCRIPTION,S.DATEOFJOIN,S.NATIONALITY,N.NATIONALITYDESC,S.NATIONALITYNUMBER,S.PHONE,S.WHATSUP,S.BRANCHID,B.BRANCHNAME,S.CENTERID,C.CENTERNAME,S.TRIPID,T.TRIPDESCRIPTION,TR.TRANSPORTATIONDESC,S.STOPID,TR.STOPDESCRIPTION,S.ADDRESSDETAILS,S.TRANSPORTATION,S.INSERTEMPLOYEEID,S.INSERTDATE,S.INSERTHOSTIP,S.INSERTHOSTOS,S.UPDATEMPLOYEEID,S.UPDATEDATE,S.UPDATEHOSTIP,S.UPDATEHOSTOS "
                    + " FROM STUDENTS S "
                    + " LEFT JOIN TRIP T ON  S.TRIPID=T.TRIPID "
                    + " LEFT JOIN TRANSPORTATIONDESC TR ON  S.TRANSPORTATION=TR.TRANSPORTATIONID "
                    + " LEFT JOIN SEXDESCRIPTION SE ON  S.SEXID=SE.SEXID "
                    + " LEFT JOIN TRIPDETAIL TR ON  S.TRIPID=TR.TRIPID AND S.STOPID=TR.STOPID " 
                    + " LEFT JOIN NATIONALITY N ON  S.NATIONALITY=N.NATIONALITY "  
                    + " LEFT JOIN BRANCH B ON  S.BRANCHID=B.BRANCHID "  
                    + " LEFT JOIN CENTER C ON  S.BRANCHID=C.BRANCHID AND S.CENTERID=C.CENTERID "
                    + " WHERE S.BRANCHID=? AND S.CENTERID=?"
                    + " ORDER BY S.STUDENTID";
            
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);
                
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    studentList.add(populateStudent(rs));
                }
                
                rs.close();
            }

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
        student.setPhone(rs.getInt("PHONE"));
        student.setWhatsup(rs.getInt("WHATSUP"));
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
        student.setTransportationDesc(rs.getString("TRANSPORTATIONDESC"));
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

    
}
