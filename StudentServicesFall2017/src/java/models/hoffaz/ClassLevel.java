/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

import java.util.Date;

/**
 *
 * @author eng_ayman
 */
public class ClassLevel {

    private int branchId;
    private String branchName;
    private int centerId;
    private String centerName;
    private int classID;
    private String className;
    private int gradeIdFrom;
    private String gradeIdFromDesc;
    private int gradeIdTo;
    private String gradeIdToDesc;
    private String classDefDesc;
    private int levelId;
    private String levelName;
    private String description;
    private int insertEmployeeId;
    private String insertHostIp;    
    private Date insertDate;      
    private String insertHostOS;    
    private int updatEmployeeId; 
    private Date updateDate;      
    private String updateHostIp;    
    private String updateHostOS;
    

    public ClassLevel() {
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

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getGradeIdFrom() {
        return gradeIdFrom;
    }

    public void setGradeIdFrom(int gradeIdFrom) {
        this.gradeIdFrom = gradeIdFrom;
    }

    public String getGradeIdFromDesc() {
        return gradeIdFromDesc;
    }

    public void setGradeIdFromDesc(String gradeIdFromDesc) {
        this.gradeIdFromDesc = gradeIdFromDesc;
    }

    public int getGradeIdTo() {
        return gradeIdTo;
    }

    public void setGradeIdTo(int gradeIdTo) {
        this.gradeIdTo = gradeIdTo;
    }

    public String getGradeIdToDesc() {
        return gradeIdToDesc;
    }

    public void setGradeIdToDesc(String gradeIdToDesc) {
        this.gradeIdToDesc = gradeIdToDesc;
    }

    public String getClassDefDesc() {
        return classDefDesc;
    }

    public void setClassDefDesc(String classDefDesc) {
        this.classDefDesc = classDefDesc;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
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
