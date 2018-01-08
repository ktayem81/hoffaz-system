/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

import java.sql.Timestamp;

/**
 *
 * @author eng_ayman
 */
public class StudentGrades {

   private int branchid;
private int centerid;
private int class_id;
private int level_id;
private int insertemployeeid;
private String inserthostip;
private Timestamp insertdate;
private int inserthostos;
private int updatemployeeid;
private Timestamp updatedate;
private String updatehostip;
private String updatehostos;
    private int studentId;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String familyName;
    private int classroom_Id;
    private int grade;
    private int result;
    private int semesterId;
    private int semesterYear;

    public StudentGrades() {
    }

    public int getBranchid() {
        return branchid;
    }

    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }

    public int getCenterid() {
        return centerid;
    }

    public void setCenterid(int centerid) {
        this.centerid = centerid;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public int getInsertemployeeid() {
        return insertemployeeid;
    }

    public void setInsertemployeeid(int insertemployeeid) {
        this.insertemployeeid = insertemployeeid;
    }

    public String getInserthostip() {
        return inserthostip;
    }

    public void setInserthostip(String inserthostip) {
        this.inserthostip = inserthostip;
    }

    public Timestamp getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Timestamp insertdate) {
        this.insertdate = insertdate;
    }

    public int getInserthostos() {
        return inserthostos;
    }

    public void setInserthostos(int inserthostos) {
        this.inserthostos = inserthostos;
    }

    public int getUpdatemployeeid() {
        return updatemployeeid;
    }

    public void setUpdatemployeeid(int updatemployeeid) {
        this.updatemployeeid = updatemployeeid;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdatehostip() {
        return updatehostip;
    }

    public void setUpdatehostip(String updatehostip) {
        this.updatehostip = updatehostip;
    }

    public String getUpdatehostos() {
        return updatehostos;
    }

    public void setUpdatehostos(String updatehostos) {
        this.updatehostos = updatehostos;
    }

    
    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public int getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(int semesterYear) {
        this.semesterYear = semesterYear;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getClassroom_Id() {
        return classroom_Id;
    }

    public void setClassroom_Id(int classroom_Id) {
        this.classroom_Id = classroom_Id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getResult() {
        if(result==1)
        return "pass";
        else if (result==0)
            return "fail";
        return "fail";
    }

    public void setResult(int result) {
        this.result = result;
    }

}
