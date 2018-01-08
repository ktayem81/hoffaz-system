/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.AttendenceDao;
import daos.hoffaz.StudentGradesDao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import models.hoffaz.Class_Room;
import models.hoffaz.Attendence;

/**
 *
 * @author eng_ayman
 */
@Named(value = "manageStudentAttendenceBean")
@Dependent
public class ManageStudentAttendenceBean implements Serializable {

    private Attendence selectedStudentAttendence;
    private ArrayList<Attendence> studentsAttendence;
    private final AttendenceDao attendenceDao = new AttendenceDao();
     private final StudentGradesDao studentGradesDao = new StudentGradesDao();
    private ArrayList<Class_Room> roomList;
    private int employeeId;
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
      @Inject
    private SessionBean sessionBean;
      

    /**
     * Creates a new instance of ManageStudentAttendenceBean
     */
    public ManageStudentAttendenceBean() {
    }
     @PostConstruct
    public void init() {
        try {
            employeeId = Integer.parseInt(sessionBean.getUsername());
            this.roomList = studentGradesDao.getRoomList(sessionBean.getBranchId(), sessionBean.getCenterId(),employeeId);
            this.studentsAttendence=attendenceDao.buildStudentsAttendence(2);
        } catch (Exception ex) {            
            Logger.getLogger(ManageStudentAttendenceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public Attendence getSelectedStudentAttendence() {
        return selectedStudentAttendence;
    }

    public void setSelectedStudentAttendence(Attendence selectedStudentAttendence) {
        this.selectedStudentAttendence = selectedStudentAttendence;
    }

    public ArrayList<Attendence> getStudentsAttendence() {
        return studentsAttendence;
    }

    public void setStudentsAttendence(ArrayList<Attendence> studentsAttendence) {
        this.studentsAttendence = studentsAttendence;
    }

    public ArrayList<Class_Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<Class_Room> roomList) {
        this.roomList = roomList;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public void insertStudentAttendence() {
        try {
            
            attendenceDao.insertStudentAttendence(selectedStudentAttendence);

        } catch (Exception ex) {
            Logger.getLogger(ManageStudentAttendenceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
