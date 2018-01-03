/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author khaled
 */
public class Semester {

    private int branchId;
    private String branchName;
    private int centerId;
    private String centerName;
    private int semesterId;
    private String semesterIdLookUp;
    private int semesterYear;
    private String semesterDesc;
    private Date semesterBegin;
    private Date semesterEnd;
    private int insertEmployeeId;
    private String insertHostIp;
    private Timestamp insertDate;
    private String insertHostOS;
    private int updatEmployeeId;
    private Timestamp updateDate;
    private String updateHostIp;
    private String updateHostOS;

    public Semester() {
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterIdLookUp() {
        return semesterIdLookUp;
    }

    public void setSemesterIdLookUp(String semesterIdLookUp) {
        this.semesterIdLookUp = semesterIdLookUp;
    }
        
    public int getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(int semesterYear) {
        this.semesterYear = semesterYear;
    }

    public String getSemesterDesc() {
        return semesterDesc;
    }

    public void setSemesterDesc(String semesterDesc) {
        this.semesterDesc = semesterDesc;
    }

    public Date getSemesterBegin() {
        return semesterBegin;
    }

    public void setSemesterBegin(Date semesterBegin) {
        this.semesterBegin = semesterBegin;
    }

    public Date getSemesterEnd() {
        return semesterEnd;
    }

    public void setSemesterEnd(Date semesterEnd) {
        this.semesterEnd = semesterEnd;
    }

    public int getInsertEmployeeId() {
        return insertEmployeeId;
    }

    public void setInsertEmployeeId(int insertEmployeeId) {
        this.insertEmployeeId = insertEmployeeId;
    }

    public String getInsertHostIp() {
        return insertHostIp;
    }

    public void setInsertHostIp(String insertHostIp) {
        this.insertHostIp = insertHostIp;
    }

    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    public String getInsertHostOS() {
        return insertHostOS;
    }

    public void setInsertHostOS(String insertHostOS) {
        this.insertHostOS = insertHostOS;
    }

    public int getUpdatEmployeeId() {
        return updatEmployeeId;
    }

    public void setUpdatEmployeeId(int updatEmployeeId) {
        this.updatEmployeeId = updatEmployeeId;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateHostIp() {
        return updateHostIp;
    }

    public void setUpdateHostIp(String updateHostIp) {
        this.updateHostIp = updateHostIp;
    }

    public String getUpdateHostOS() {
        return updateHostOS;
    }

    public void setUpdateHostOS(String updateHostOS) {
        this.updateHostOS = updateHostOS;
    }
    
    
    

}
