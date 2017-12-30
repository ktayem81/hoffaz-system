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

            String sql = "SELECT CL.BRANCHID,CL.CENTERID,CL.CLASS_ID,CD.CLASS_NAME,CL.LEVEL_ID,CL.LEVEL_NAME,CL.LEVEL_DESC,CD.CLASS_DEF_DESC,CD.GRADE_ID_FROM,CGF.GRADE_DESC AS GRADE_DESC_FROM,CD.GRADE_ID_TO,CGT.GRADE_DESC  AS GRADE_DESC_TO,CL.INSERTEMPLOYEEID,CL.INSERTDATE,CL.INSERTHOSTIP,CL.INSERTHOSTOS,CL.UPDATEMPLOYEEID,CL.UPDATEDATE,CL.UPDATEHOSTIP,CL.UPDATEHOSTOS "
                    + "                                      FROM CLASS_LEVEL CL "
                    + "                                      LEFT JOIN CLASS_DEF CD  ON CL.CLASS_ID=CD.CLASS_ID "
                    + "                                      LEFT JOIN CLASS_GRADE CGF ON  CD.GRADE_ID_FROM=CGF.GRADE_ID "
                    + "                                      LEFT JOIN CLASS_GRADE CGT ON  CD.GRADE_ID_TO=CGT.GRADE_ID "
                    + "                                      LEFT JOIN BRANCH B ON  CL.BRANCHID=B.BRANCHID "
                    + "                                      LEFT JOIN CENTER C ON  CL.BRANCHID=C.BRANCHID AND CL.CENTERID=C.CENTERID "
                    + "                                      WHERE CD.BRANCHID=? AND CL.CENTERID=? AND CL.CLASS_ID=?"
                    + "                                      ORDER BY CD.BRANCHID,CD.CENTERID,CD.CLASS_ID";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);
                ps.setInt(2, centerId);
                ps.setInt(2, classID);

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
        classDef.setGradeIdFromDesc(rs.getString("GRADE_DESC_FROM"));
        classDef.setGradeIdTo(rs.getInt("GRADE_ID_TO"));
        classDef.setGradeIdToDesc(rs.getString("GRADE_DESC_TO"));
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

        String sqlClassId = "SELECT NVL(MAX(CLASS_ID),0)+1 AS classId FROM CLASS_DEF WHERE BRANCHID=? AND CENTERID=?";

        PreparedStatement ps1 = conn.prepareStatement(sqlClassId);

        try {
            ps1.setInt(1, classDef.getBranchId());
            ps1.setInt(2, classDef.getCenterId());

            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                classDef.setClassID(rs.getInt("classId"));
            }

            rs.close();
            ps1.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        String sql = "INSERT INTO CLASS_DEF C "
                + "(C.CLASS_ID,"
                + " C.BRANCHID,"
                + " C.CENTERID,"
                + " C.CLASS_NAME,"
                + " C.CLASS_DEF_DESC,"
                + " C.GRADE_ID_FROM,"
                + " C.GRADE_ID_TO,"
                + " C.INSERTEMPLOYEEID, "
                + " C.INSERTDATE,"
                + " C.INSERTHOSTIP,"
                + " C.INSERTHOSTOS)"
                + " VALUES ((SELECT NVL(MAX(CLASS_ID),0)+1 FROM CLASS_DEF WHERE BRANCHID=? AND CENTERID=?),"
                + "?,?,?,?,?,"
                + "?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        try {

            java.util.Date date = new java.util.Date();
            long t = date.getTime();
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

            //FOR INNER SELECT
            ps.setInt(1, classDef.getBranchId());
            ps.setInt(2, classDef.getCenterId());
            //TO SAVE BRANCH AND CENTER
            ps.setInt(3, classDef.getBranchId());
            ps.setInt(4, classDef.getCenterId());

            ps.setString(5, classDef.getClassName());
            ps.setString(6, classDef.getClassDefDesc());
            ps.setInt(7, classDef.getGradeIdFrom());
            ps.setInt(8, classDef.getGradeIdTo());

            ps.setInt(9, classDef.getInsertEmployeeId());
            ps.setTimestamp(10, sqlTimestamp);
            ps.setString(11, classDef.getInsertHostIp());
            ps.setString(12, classDef.getInsertHostOS());

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
                    + "     WHERE C.BRANCHID=? "
                    + "       AND C.CENTERID=? "
                    + "       AND C.CLASS_ID=? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            java.util.Date date = new java.util.Date();
            long t = date.getTime();
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

            ps.setString(1, classDef.getClassName());
            ps.setString(2, classDef.getClassDefDesc());
            ps.setInt(3, classDef.getGradeIdFrom());
            ps.setInt(4, classDef.getGradeIdTo());
            ps.setInt(5, classDef.getUpdatEmployeeId());
            ps.setTimestamp(6, sqlTimestamp);
            ps.setString(7, classDef.getUpdateHostIp());
            ps.setString(8, classDef.getUpdateHostOS());
            ps.setInt(9, classDef.getBranchId());
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

    public void deleteClassDef(int branchId, int centerId, int classID) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM CLASS_DEF WHERE BRANCHID=? AND CENTERID=? AND CLASS_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, classID);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public ClassDef getClassDef(int branchId, int centerId, int classID) throws Exception {
        try {
            ClassDef classDef = null;
            Connection conn = getConnection();

            String sql = "SELECT CD.BRANCHID,CD.CENTERID,CD.CLASS_ID,CD.CLASS_NAME,CD.CLASS_DEF_DESC,CD.GRADE_ID_FROM,CGF.GRADE_DESC AS GRADE_DESC_FROM,CD.GRADE_ID_TO,CGT.GRADE_DESC  AS GRADE_DESC_TO,CD.INSERTEMPLOYEEID,CD.INSERTDATE,CD.INSERTHOSTIP,CD.INSERTHOSTOS,CD.UPDATEMPLOYEEID,CD.UPDATEDATE,CD.UPDATEHOSTIP,CD.UPDATEHOSTOS "
                    + "                     FROM CLASS_DEF CD  "
                    + "                     LEFT JOIN CLASS_GRADE CGF ON  CD.GRADE_ID_FROM=CGF.GRADE_ID  "
                    + "                     LEFT JOIN CLASS_GRADE CGT ON  CD.GRADE_ID_TO=CGT.GRADE_ID "
                    + "                     LEFT JOIN BRANCH B ON  CD.BRANCHID=B.BRANCHID "
                    + "                     LEFT JOIN CENTER C ON  CD.BRANCHID=C.BRANCHID AND CD.CENTERID=C.CENTERID  "
                    + "                     WHERE CD.BRANCHID=? AND CD.CENTERID=? AND CD.CLASS_ID=? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, branchId);
            ps.setInt(2, centerId);
            ps.setInt(3, classID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                classDef = populateClassDef(rs);
            }

            rs.close();
            ps.close();

            return classDef;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
