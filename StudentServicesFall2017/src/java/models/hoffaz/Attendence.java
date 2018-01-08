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
public class Attendence {
    private int enrollmenId;
    private int studentId;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String familyName;
    private int classroom_Id;
    private int semesterId;
    private int semesterYear;
    private int attendenceId;
private Timestamp date_r;
private int state_s;

    public Attendence() {
    }

    public int getEnrollmenId() {
        return enrollmenId;
    }

    public void setEnrollmenId(int enrollmenId) {
        this.enrollmenId = enrollmenId;
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

    public int getAttendenceId() {
        return attendenceId;
    }

    public void setAttendenceId(int attendenceId) {
        this.attendenceId = attendenceId;
    }

    public Timestamp getDate_r() {
        return date_r;
    }

    public void setDate_r(Timestamp date_r) {
        this.date_r = date_r;
    }

    public int getState_s() {
        return state_s;
    }

    public void setState_s(int state_s) {
        this.state_s = state_s;
    }

}
