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
import models.hoffaz.ClassRoom;

/**
 *
 * @author khaled
 */
public class ClassRoomDao extends ConnectionDao {

    public ArrayList<ClassRoom> buildClassRooms(int branchId, int centerId)
            throws Exception {

        ArrayList<ClassRoom> classRoomList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT CR.BRANCHID,B.BRANCHNAME,CR.CENTERID,C.CENTERNAME, "
                    + " CR.CLASS_ROOM_ID,CR.EMPLOYEEID,E.FIRSTNAME,E.SECONDNAME,E.THIRDNAME,E.FAMILYNAME, "
                    + " CR.COST, "
                    + " CR.CLASS_ID,CR.LEVEL_ID,CD.CLASS_NAME,CL.LEVEL_NAME,CR.SEMESTER_ID,SD.SEMESTER_DESC AS LOOKUP,CR.SEMESTER_YEAR, "
                    + " CR.INSERTEMPLOYEEID,CR.INSERTHOSTIP,CR.INSERTDATE,CR.INSERTHOSTOS, "
                    + " CR.UPDATEMPLOYEEID,CR.UPDATEDATE,CR.UPDATEHOSTIP,CR.UPDATEHOSTOS   "
                    + " FROM CLASS_ROOM CR  "
                    + " LEFT JOIN CLASS_DEF CD ON CR.CLASS_ID=CD.CLASS_ID "
                    + " LEFT JOIN CLASS_LEVEL CL ON CR.CLASS_ID=CL.CLASS_ID AND CR.LEVEL_ID=CL.LEVEL_ID  "
                    + " LEFT JOIN SEMESTER_DEF SD ON  CR.SEMESTER_ID=SD.SEMESTER_ID "
                    + " LEFT JOIN SEMESTERS S ON  CR.BRANCHID=S.BRANCHID AND CR.CENTERID=S.CENTERID AND CR.SEMESTER_ID=S.SEMESTER_ID AND CR.SEMESTER_YEAR=S.SEMESTER_YEAR "
                    + " LEFT JOIN EMPLOYEES E ON  CR.EMPLOYEEID=E.EMPLOYEEID "
                    + " LEFT JOIN BRANCH B ON  CR.BRANCHID=B.BRANCHID "
                    + " LEFT JOIN CENTER C ON  CR.BRANCHID=C.BRANCHID AND CR.CENTERID=C.CENTERID "
                    + " WHERE CR.BRANCHID=? AND CR.CENTERID=?"
                    + " ORDER BY CR.BRANCHID,CR.CENTERID,CR.SEMESTER_YEAR DESC,CR.SEMESTER_ID,CR.CLASS_ROOM_ID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    classRoomList.add(populateClassRoom(rs));
                }

                rs.close();
            }

            return classRoomList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private ClassRoom populateClassRoom(ResultSet rs) throws SQLException {
        ClassRoom classRoom = new ClassRoom();

        classRoom.setBranchId(rs.getInt("BRANCHID"));
        classRoom.setBranchName(rs.getString("BRANCHNAME"));
        classRoom.setCenterId(rs.getInt("CENTERID"));
        classRoom.setCenterName(rs.getString("CENTERNAME"));

        classRoom.setClassRoomId(rs.getInt("CLASS_ROOM_ID"));
        classRoom.setTeacherEmployeeId(rs.getInt("EMPLOYEEID"));
        classRoom.setFirstName(rs.getString("FIRSTNAME"));
        classRoom.setSecondName(rs.getString("SECONDNAME"));
        classRoom.setThirdName(rs.getString("THIRDNAME"));
        classRoom.setFamilyName(rs.getString("FAMILYNAME"));

        classRoom.setCost(rs.getDouble("COST"));

        classRoom.setClassId(rs.getInt("CLASS_ID"));
        classRoom.setClassName(rs.getString("CLASS_NAME"));
        classRoom.setLevelId(rs.getInt("LEVEL_ID"));
        classRoom.setLevelName(rs.getString("LEVEL_NAME"));
        classRoom.setSemesterId(rs.getInt("SEMESTER_ID"));
        classRoom.setSemesterIdLookUp(rs.getString("LOOKUP"));
        classRoom.setSemesterYear(rs.getInt("SEMESTER_YEAR"));

        classRoom.setInsertEmployeeId(rs.getInt("INSERTEMPLOYEEID"));
        classRoom.setInsertDate(rs.getTimestamp("INSERTDATE"));
        classRoom.setInsertHostIp(rs.getString("INSERTHOSTIP"));
        classRoom.setInsertHostOS(rs.getString("INSERTHOSTOS"));
        classRoom.setUpdatEmployeeId(rs.getInt("UPDATEMPLOYEEID"));
        classRoom.setUpdateDate(rs.getTimestamp("UPDATEDATE"));
        classRoom.setUpdateHostIp(rs.getString("UPDATEHOSTIP"));
        classRoom.setUpdateHostOS(rs.getString("UPDATEHOSTOS"));

        return classRoom;
    }

    public void insertClassRoom(ClassRoom classRoom) throws Exception {

        Connection conn = getConnection();
        
        String sqlClassId = "SELECT NVL(MAX(CLASS_ROOM_ID),0)+1 AS CLASS_ROOM_ID FROM CLASS_ROOM "
                          + "WHERE BRANCHID=? AND CENTERID=? "
                            + "AND CLASS_ID=? AND LEVEL_ID=? AND SEMESTER_YEAR=? AND SEMESTER_ID=? ";

        PreparedStatement ps1 = conn.prepareStatement(sqlClassId);

        try {
            ps1.setInt(1, classRoom.getBranchId());
            ps1.setInt(2, classRoom.getCenterId());
            ps1.setInt(3, classRoom.getClassId());
            ps1.setInt(4, classRoom.getLevelId());
            ps1.setInt(5, classRoom.getSemesterYear());
            ps1.setInt(6, classRoom.getSemesterId());
            
            
            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                classRoom.setClassRoomId(rs.getInt("CLASS_ROOM_ID"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO CLASS_ROOM (BRANCHID,CENTERID,"
                                          + " CLASS_ID,LEVEL_ID,"
                                          + " SEMESTER_ID,SEMESTER_YEAR,CLASS_ROOM_ID,"
                                          + " EMPLOYEEID,COST,"
                                          + " INSERTEMPLOYEEID,INSERTDATE,INSERTHOSTIP,INSERTHOSTOS)"
                                          + " VALUES (?,?,?,?,?,"
                                          + "         ?,?,?,?,?,"
                                          + "         ?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {
            ps.setInt(1, classRoom.getBranchId());
            ps.setInt(2, classRoom.getCenterId());

            ps.setInt(3, classRoom.getClassId());
            ps.setInt(4, classRoom.getLevelId());

            ps.setInt(5, classRoom.getSemesterId());
            ps.setInt(6, classRoom.getSemesterYear());
            ps.setInt(7, classRoom.getClassRoomId());

            ps.setInt(8, classRoom.getTeacherEmployeeId());
            ps.setDouble(9, classRoom.getCost());

            ps.setInt(10, classRoom.getInsertEmployeeId());
            ps.setTimestamp(11, (Timestamp) classRoom.getInsertDate());
            ps.setString(12, classRoom.getInsertHostIp());
            ps.setString(13, classRoom.getInsertHostOS());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateClassRoom(ClassRoom classRoom) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = " UPDATE CLASS_ROOM  SET EMPLOYEEID=?,"
                    + " COST=?,"
                    + " UPDATEMPLOYEEID=?,"
                    + " UPDATEDATE=?,"
                    + " UPDATEHOSTIP=?,"
                    + " UPDATEHOSTOS=?"
                    + " WHERE BRANCHID =? AND CENTERID=? AND CLASS_ID=? AND LEVEL_ID=? AND SEMESTER_ID=? AND SEMESTER_YEAR=? AND CLASS_ROOM_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, classRoom.getTeacherEmployeeId());
            ps.setDouble(2, classRoom.getCost());

            ps.setInt(3, classRoom.getUpdatEmployeeId());
            ps.setTimestamp(4, (Timestamp) classRoom.getUpdateDate());
            ps.setString(5, classRoom.getUpdateHostIp());
            ps.setString(6, classRoom.getUpdateHostOS());

            ps.setInt(7, classRoom.getBranchId());
            ps.setInt(8, classRoom.getCenterId());
            ps.setInt(9, classRoom.getClassId());
            ps.setInt(10, classRoom.getLevelId());

            ps.setInt(11, classRoom.getSemesterId());
            ps.setInt(12, classRoom.getSemesterYear());
            ps.setInt(13, classRoom.getClassRoomId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteClassRoom(int branchId, int centerId, int classId, int levelId, int semesterYear, int semesterId, int classRoomId) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM CLASS_ROOM "
                    + "WHERE BRANCHID =? AND CENTERID=? AND CLASS_ID=? AND LEVEL_ID=? AND SEMESTER_YEAR=? AND SEMESTER_ID=? AND CLASS_ROOM_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, classId);
            ps.setInt(4, levelId);
            ps.setInt(5, semesterYear);
            ps.setInt(6, semesterId);
            ps.setInt(7, classRoomId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public ClassRoom getClassRoom(int branchId, int centerId, int classId, int levelId, int semesterYear, int semesterId, int classRoomId) throws Exception {
        try {
            ClassRoom classRoom = null;
            Connection conn = getConnection();

            String sql = "SELECT CR.BRANCHID,B.BRANCHNAME,CR.CENTERID,C.CENTERNAME, "
                    + " CR.CLASS_ROOM_ID,CR.EMPLOYEEID,E.FIRSTNAME,E.SECONDNAME,E.THIRDNAME,E.FAMILYNAME, "
                    + " CR.COST, "
                    + " CR.CLASS_ID,CR.LEVEL_ID,CD.CLASS_NAME,CL.LEVEL_NAME,CR.SEMESTER_ID,SD.SEMESTER_DESC AS LOOKUP,CR.SEMESTER_YEAR, "
                    + " CR.INSERTEMPLOYEEID,CR.INSERTHOSTIP,CR.INSERTDATE,CR.INSERTHOSTOS, "
                    + " CR.UPDATEMPLOYEEID,CR.UPDATEDATE,CR.UPDATEHOSTIP,CR.UPDATEHOSTOS   "
                    + " FROM CLASS_ROOM CR  "
                    + " LEFT JOIN SEMESTER_DEF SD ON  CR.SEMESTER_ID=SD.SEMESTER_ID "
                    + " LEFT JOIN SEMESTERS S ON  CR.BRANCHID=S.BRANCHID AND CR.CENTERID=S.CENTERID AND CR.SEMESTER_ID=S.SEMESTER_ID AND CR.SEMESTER_YEAR=S.SEMESTER_YEAR "
                    + " LEFT JOIN EMPLOYEES E ON  CR.EMPLOYEEID=E.EMPLOYEEID "
                    + " LEFT JOIN BRANCH B ON  CR.BRANCHID=B.BRANCHID "
                    + " LEFT JOIN CENTER C ON  CR.BRANCHID=C.BRANCHID AND CR.CENTERID=C.CENTERID "
                    + " WHERE CR.BRANCHID =? AND CR.CENTERID=? AND CR.CLASS_ID=? AND CR.LEVEL_ID=? AND CR.SEMESTER_YEAR=? AND CR.SEMESTER_ID=? AND CR.CLASS_ROOM_ID=?"
                    + " ORDER BY CR.BRANCHID,CR.CENTERID,CR.SEMESTER_YEAR,CR.SEMESTER_ID,CR.CLASS_ROOM_ID";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, classId);
            ps.setInt(4, levelId);
            ps.setInt(5, semesterYear);
            ps.setInt(6, semesterId);
            ps.setInt(7, classRoomId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                classRoom = populateClassRoom(rs);
            }

            rs.close();
            ps.close();

            return classRoom;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
public ArrayList<ClassRoom> getClassRoomsfilter(int branchId, int centerId, int semesterYear, int semesterId)
            throws Exception {

        ArrayList<ClassRoom> classRoomList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT CR.BRANCHID,B.BRANCHNAME,CR.CENTERID,C.CENTERNAME, "
                    + " CR.CLASS_ROOM_ID,CR.EMPLOYEEID,E.FIRSTNAME,E.SECONDNAME,E.THIRDNAME,E.FAMILYNAME, "
                    + " CR.COST, "
                    + " CR.CLASS_ID,CR.LEVEL_ID,CD.CLASS_NAME,CL.LEVEL_NAME,CR.SEMESTER_ID,SD.SEMESTER_DESC AS LOOKUP,CR.SEMESTER_YEAR, "
                    + " CR.INSERTEMPLOYEEID,CR.INSERTHOSTIP,CR.INSERTDATE,CR.INSERTHOSTOS, "
                    + " CR.UPDATEMPLOYEEID,CR.UPDATEDATE,CR.UPDATEHOSTIP,CR.UPDATEHOSTOS   "
                    + " FROM CLASS_ROOM CR  "
                    + " LEFT JOIN CLASS_DEF CD ON CR.CLASS_ID=CD.CLASS_ID "
                    + " LEFT JOIN CLASS_LEVEL CL ON CR.CLASS_ID=CL.CLASS_ID AND CR.LEVEL_ID=CL.LEVEL_ID  "
                    + " LEFT JOIN SEMESTER_DEF SD ON  CR.SEMESTER_ID=SD.SEMESTER_ID "
                    + " LEFT JOIN SEMESTERS S ON  CR.BRANCHID=S.BRANCHID AND CR.CENTERID=S.CENTERID AND CR.SEMESTER_ID=S.SEMESTER_ID AND CR.SEMESTER_YEAR=S.SEMESTER_YEAR "
                    + " LEFT JOIN EMPLOYEES E ON  CR.EMPLOYEEID=E.EMPLOYEEID "
                    + " LEFT JOIN BRANCH B ON  CR.BRANCHID=B.BRANCHID "
                    + " LEFT JOIN CENTER C ON  CR.BRANCHID=C.BRANCHID AND CR.CENTERID=C.CENTERID "
                    + " WHERE CR.BRANCHID=? AND CR.CENTERID=? AND CR.SEMESTER_YEAR=? AND CR.SEMESTER_ID=?"
                    + " ORDER BY CR.BRANCHID,CR.CENTERID,CR.SEMESTER_YEAR,CR.SEMESTER_ID,CR.CLASS_ROOM_ID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);
                ps.setInt(3, semesterYear);
                ps.setInt(4, semesterId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    classRoomList.add(populateClassRoom(rs));
                }

                rs.close();
            }

            return classRoomList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
