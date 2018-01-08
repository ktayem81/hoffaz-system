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
import models.hoffaz.Contest;


/**
 *
 * @author eng_ayman
 */
public class ContestDao extends ConnectionDao {

    public ArrayList<Contest> buildContest(int branchId)
            throws Exception {

        ArrayList<Contest> contest = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT C.CONTESTID,C.SEMESTERID,C.PARTNUMBERS,C.GRADE,C.ORDERNO "
                    + "FROM CONTESTS C,SEMESTERS S "
                    + "WHERE C.SEMESTERID=S.SEMESTER_ID AND S.BRANCHID=? ";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, branchId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    contest.add(populateContest(rs));
                }

                rs.close();
            }

            return contest;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Contest populateContest(ResultSet rs) throws SQLException {
        Contest contest = new Contest();
        contest.setContestId(rs.getInt("CONTESTID"));
        contest.setSemesterId(rs.getInt("SEMESTERID"));
        contest.setPartNumbers(rs.getInt("PARTNUMBERS"));
        contest.setGrade(rs.getInt("GRADE"));
        contest.setOrderNo(rs.getInt("ORDERNO"));
        contest.setStudentId(rs.getInt("STUDENTID"));
        return contest;
    }

    public void insertContest(Contest contest) throws Exception {

        Connection conn = getConnection();
        String sql = "INSERT INTO CONTESTS(CONTESTID,SEMESTERID,PARTNUMBERS,GRADE,ORDERNO) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        try {
            ps.setInt(1, contest.getContestId());
            ps.setInt(2, contest.getSemesterId());
            ps.setInt(3, contest.getPartNumbers());
            ps.setInt(4, contest.getGrade());
            ps.setInt(5, contest.getOrderNo());
            ps.setInt(6, contest.getStudentId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
