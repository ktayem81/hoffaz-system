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
import models.hoffaz.ClassLevel;

/**
 *
 * @author khale
 */
public class ClassLevelDao extends ConnectionDao {

    public ArrayList<ClassLevel> buildClassLevel(int branchId, int centerId, int classID)
            throws Exception {

        ArrayList<ClassLevel> classLevelList = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT CLV.BRANCHID,B.BRANCHNAME,CLV.CENTERID,C.CENTERNAME,CLV.CLASS_ID,CD.CLASS_NAME,CD.CLASS_DEF_DESC,CD.GRADE_ID_FROM,CGF.GRADE_DESC AS GRADE_DESC_FROM,CD.GRADE_ID_TO,CGT.GRADE_DESC  AS GRADE_DESC_TO,CLV.LEVEL_ID,CLV.LEVEL_NAME,CLV.LEVEL_DESC,CLV.INSERTEMPLOYEEID,CLV.INSERTDATE,CLV.INSERTHOSTIP,CLV.INSERTHOSTOS,CLV.UPDATEMPLOYEEID,CLV.UPDATEDATE,CLV.UPDATEHOSTIP,CLV.UPDATEHOSTOS "
                    + "  FROM CLASS_LEVEL CLV "
                    + "  LEFT JOIN CLASS_DEF CD  ON CLV.CLASS_ID=CD.CLASS_ID "
                    + "  LEFT JOIN CLASS_GRADE CGF ON  CD.GRADE_ID_FROM=CGF.GRADE_ID "
                    + "  LEFT JOIN CLASS_GRADE CGT ON  CD.GRADE_ID_TO=CGT.GRADE_ID "
                    + "  LEFT JOIN BRANCH B ON  CLV.BRANCHID=B.BRANCHID "
                    + "  LEFT JOIN CENTER C ON  CLV.BRANCHID=C.BRANCHID AND CLV.CENTERID=C.CENTERID "
                    + "  WHERE CLV.BRANCHID=? AND CLV.CENTERID=? AND CLV.CLASS_ID=? "
                    + "  ORDER BY CLV.BRANCHID, CLV.CENTERID, CLV.CLASS_ID, CLV.LEVEL_ID ";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);
                ps.setInt(3, classID);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    classLevelList.add(populateclassLevel(rs));
                }

                rs.close();
            }

            return classLevelList;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private ClassLevel populateclassLevel(ResultSet rs) throws SQLException {

        ClassLevel classLevel = new ClassLevel();

        classLevel.setBranchId(rs.getInt("BRANCHID"));
        classLevel.setBranchName(rs.getString("BRANCHNAME"));
        classLevel.setCenterId(rs.getInt("CENTERID"));
        classLevel.setCenterName(rs.getString("CENTERNAME"));
        classLevel.setClassID(rs.getInt("CLASS_ID"));
        classLevel.setClassName(rs.getString("CLASS_NAME"));
        classLevel.setClassDefDesc(rs.getString("CLASS_DEF_DESC"));
        
        classLevel.setGradeIdFrom(rs.getInt("GRADE_ID_FROM"));
        classLevel.setGradeIdFromDesc(rs.getString("GRADE_DESC_FROM"));
        classLevel.setGradeIdTo(rs.getInt("GRADE_ID_TO"));
        classLevel.setGradeIdToDesc(rs.getString("GRADE_DESC_TO"));
        
        classLevel.setLevelId(rs.getInt("LEVEL_ID"));
        classLevel.setLevelName(rs.getString("LEVEL_NAME"));
        classLevel.setLevelDesc(rs.getString("LEVEL_DESC"));
        
        classLevel.setInsertEmployeeId(rs.getInt("INSERTEMPLOYEEID"));
        classLevel.setInsertDate(rs.getTimestamp("INSERTDATE"));
        classLevel.setInsertHostIp(rs.getString("INSERTHOSTIP"));
        classLevel.setInsertHostOS(rs.getString("INSERTHOSTOS"));
        
        classLevel.setUpdatEmployeeId(rs.getInt("UPDATEMPLOYEEID"));
        classLevel.setUpdateDate(rs.getTimestamp("UPDATEDATE"));
        classLevel.setUpdateHostIp(rs.getString("UPDATEHOSTIP"));
        classLevel.setUpdateHostOS(rs.getString("UPDATEHOSTOS"));

        return classLevel;
    }

    public void insertClassLevel(ClassLevel classLevel) throws Exception {

        Connection conn = getConnection();

        String sqlClassLevel = "SELECT NVL(MAX(LEVEL_ID),0)+1 AS CLASS_LEVEL FROM CLASS_LEVEL WHERE BRANCHID=? AND CENTERID=? AND CLASS_ID=?";

        PreparedStatement ps1 = conn.prepareStatement(sqlClassLevel);

        try {
            ps1.setInt(1, classLevel.getBranchId());
            ps1.setInt(2, classLevel.getCenterId());
            ps1.setInt(3, classLevel.getClassID());

            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                classLevel.setLevelId(rs.getInt("CLASS_LEVEL"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO CLASS_LEVEL "
                + "(BRANCHID, CENTERID, CLASS_ID, LEVEL_ID, LEVEL_NAME, LEVEL_DESC, INSERTEMPLOYEEID, INSERTDATE, INSERTHOSTIP, INSERTHOSTOS) "
                + "VALUES (?,?,?,(SELECT NVL(MAX(LEVEL_ID),0)+1 AS levelId FROM CLASS_LEVEL WHERE BRANCHID=? AND CENTERID=? AND CLASS_ID=?), "
                + "                 ?,?,?,?,?,"
                + "                 ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {

            java.util.Date date = new java.util.Date();
            long t = date.getTime();
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

            //TO SAVE BRANCH AND CENTER
            ps.setInt(1, classLevel.getBranchId());
            ps.setInt(2, classLevel.getCenterId());
            ps.setInt(3, classLevel.getClassID());
            
            //FOR INNER SELECT
            ps.setInt(4, classLevel.getBranchId());
            ps.setInt(5, classLevel.getCenterId());
            ps.setInt(6, classLevel.getClassID());
            
            ps.setString(7,classLevel.getLevelName() );
            ps.setString(8, classLevel.getLevelDesc());

            ps.setInt(9, classLevel.getInsertEmployeeId());
            ps.setTimestamp(10, sqlTimestamp);
            ps.setString(11, classLevel.getInsertHostIp());
            ps.setString(12, classLevel.getInsertHostOS());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateClassLevel(ClassLevel classLevel) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE CLASS_LEVEL "
                    + " SET LEVEL_NAME=?, "
                    + "     LEVEL_DESC=?, "
                    + "     UPDATEMPLOYEEID=?, "
                    + "     UPDATEDATE=?, "
                    + "     UPDATEHOSTIP=?, "
                    + "     UPDATEHOSTOS=? "
                    + "     WHERE BRANCHID=? "
                    + "       AND CENTERID=? "
                    + "       AND CLASS_ID=? "
                    + "       AND LEVEL_ID=? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            java.util.Date date = new java.util.Date();
            long t = date.getTime();
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

            ps.setString(1, classLevel.getLevelName());
            ps.setString(2, classLevel.getLevelDesc());
            ps.setInt(3, classLevel.getUpdatEmployeeId());
            ps.setTimestamp(4, sqlTimestamp);
            ps.setString(5, classLevel.getUpdateHostIp());
            ps.setString(6, classLevel.getUpdateHostOS());
            ps.setInt(7, classLevel.getBranchId());
            ps.setInt(8, classLevel.getCenterId());
            ps.setInt(9, classLevel.getClassID());
            ps.setInt(10, classLevel.getLevelId());


            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteClassLevel(int branchId, int centerId, int classID, int levelId) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM CLASS_LEVEL WHERE BRANCHID=? AND CENTERID=? AND CLASS_ID=? AND LEVEL_ID=? ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, classID);
            ps.setInt(3, levelId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public ClassLevel getClassLevel(int branchId, int centerId, int classID, int levelId) throws Exception {
        try {
            ClassLevel classLevel = null;
            Connection conn = getConnection();

            String sql = "CLV.BRANCHID,B.BRANCHNAME,CLV.CENTERID,C.CENTERNAME,CLV.CLASS_ID,CD.CLASS_NAME,CD.CLASS_DEF_DESC,CD.GRADE_ID_FROM,CGF.GRADE_DESC AS GRADE_DESC_FROM,CD.GRADE_ID_TO,CGT.GRADE_DESC  AS GRADE_DESC_TO,CLV.LEVEL_ID,CLV.LEVEL_NAME,CLV.LEVEL_DESC,CLV.INSERTEMPLOYEEID,CLV.INSERTDATE,CLV.INSERTHOSTIP,CLV.INSERTHOSTOS,CLV.UPDATEMPLOYEEID,CLV.UPDATEDATE,CLV.UPDATEHOSTIP,CLV.UPDATEHOSTOS "
                    + "  FROM CLASS_LEVEL CLV "
                    + "  LEFT JOIN CLASS_DEF CD  ON CLV.CLASS_ID=CD.CLASS_ID "
                    + "  LEFT JOIN CLASS_GRADE CGF ON  CD.GRADE_ID_FROM=CGF.GRADE_ID "
                    + "  LEFT JOIN CLASS_GRADE CGT ON  CD.GRADE_ID_TO=CGT.GRADE_ID "
                    + "  LEFT JOIN BRANCH B ON  CLV.BRANCHID=B.BRANCHID "
                    + "  LEFT JOIN CENTER C ON  CLV.BRANCHID=C.BRANCHID AND CLV.CENTERID=C.CENTERID "
                    + "  WHERE CD.BRANCHID=? AND CLV.CENTERID=? AND CLV.CLASS_ID=? AND CLV.LEVEL_ID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, classID);
            ps.setInt(3, levelId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                classLevel = populateclassLevel(rs);
            }

            rs.close();
            ps.close();

            return classLevel;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
