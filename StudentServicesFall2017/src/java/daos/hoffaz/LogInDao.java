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
import models.hoffaz.LogIn;

/**
 *
 * @author khaled
 */
public class LogInDao extends ConnectionDao {

    private String roleDescription;
    private String fullName;
    private int branchId;
    private String branchName;
    private int centerId;
    private String centerName;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public boolean getEmployee(int username, int password) throws Exception {

        boolean loginSuccess = false;

        try {
            Connection conn = getConnection();
            /* 
            String sql = "select count(*) AS LOGIN_SUCCESS "
                       + "from users "
                       + "where employeeid=? "
                       + "and password=?";  
             */
            String sql = " select e.FIRSTNAME||' '||e.SECONDNAME||' '||e.THIRDNAME||' '||e.FAMILYNAME AS FullName,e.BRANCHID,b.BRANCHNAME,c.CENTERNAME,e.CENTERID,r.ROLEDESCRIPTION "
                    + " FROM users u, USERROLES ur, EMPLOYEES e, Roles r, BRANCH b, CENTER c "
                    + " WHERE u.EMPLOYEEID = ur.EMPLOYEEID "
                    + " AND u.EMPLOYEEID = e.EMPLOYEEID "
                    + " AND ur.EMPLOYEEID=e.EMPLOYEEID "
                    + " AND r.ROLEID = ur.ROLEID "
                    + " AND B.BRANCHID=c.BRANCHID "
                    + " AND e.BRANCHID = c.BRANCHID AND e.CENTERID = c.CENTERID"
                    + " AND u.employeeid=? "
                    + " AND password=? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, username);
            ps.setInt(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                fullName = rs.getString("FullName");
                roleDescription = rs.getString("ROLEDESCRIPTION");
                branchId = rs.getInt("BRANCHID");
                branchName = rs.getString("BRANCHNAME");
                centerId = rs.getInt("CENTERID");
                centerName = rs.getString("CENTERNAME");
                loginSuccess = true;
            }

            rs.close();
            ps.close();

            return loginSuccess;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
