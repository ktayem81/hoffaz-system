/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.ClassDefDao;
import daos.hoffaz.ClassLevelDao;
import daos.hoffaz.ClassRoomDao;
import daos.hoffaz.EmployeesDao;
import daos.hoffaz.SemesterDao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.ClassDef;
import models.hoffaz.ClassLevel;
import models.hoffaz.ClassRoom;
import models.hoffaz.Employees;
import models.hoffaz.Semester;

/**
 *
 * @author khaled
 */
@Named(value = "addEditClassRoomBean")
@ViewScoped
public class AddEditClassRoomBean implements Serializable {

    private final ClassRoomDao classRoomDao = new ClassRoomDao();

    private final ClassDefDao classDefDao = new ClassDefDao();
    private final ClassLevelDao classLevelDao = new ClassLevelDao();
    private final SemesterDao semesterDao = new SemesterDao();
    private final EmployeesDao employeesDao = new EmployeesDao();
    //Teacher Gatagory
    private final int employeeCatagory = 3;

    private ArrayList<ClassDef> classDefList = new ArrayList<>();
    private ArrayList<ClassLevel> classLevelList = new ArrayList<>();
    private ArrayList semesterYearList = new ArrayList<>();
    private ArrayList<Semester> semesterIdList = new ArrayList<>();
    private ArrayList<Employees> employeesList = new ArrayList<>();

    private int branchId;
    private String branchName;
    private int centerId;
    private String centerName;
    private int classId;
    private String className;
    private int levelId;
    private String levelName;
    private int semesterId;
    private String semesterIdLookUp;
    private int semesterYear;
    private int classRoomId;
    private int teacherEmployeeId;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String familyName;
    private double cost;
    private int insertEmployeeId;
    private String insertHostIp;
    private Timestamp insertDate;
    private String insertHostOS;
    private int updatEmployeeId;
    private Timestamp updateDate;
    private String updateHostIp;
    private String updateHostOS;

    /**
     * Creates a new instance of AddEditClassRoomBean
     */
    public AddEditClassRoomBean() {
    }

    public ArrayList<ClassDef> getClassDefList() {
        return classDefList;
    }

    public void setClassDefList(ArrayList<ClassDef> classDefList) {
        this.classDefList = classDefList;
    }

    public ArrayList<ClassLevel> getClassLevelList() {
        return classLevelList;
    }

    public void setClassLevelList(ArrayList<ClassLevel> classLevelList) {
        this.classLevelList = classLevelList;
    }

    public ArrayList<Semester> getSemesterYearList() {
        return semesterYearList;
    }

    public void setSemesterYearList(ArrayList<Semester> semesterYearList) {
        this.semesterYearList = semesterYearList;
    }

    public ArrayList<Semester> getSemesterIdList() {
        return semesterIdList;
    }

    public void setSemesterIdList(ArrayList<Semester> semesterIdList) {
        this.semesterIdList = semesterIdList;
    }

    public ArrayList<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(ArrayList<Employees> employeesList) {
        this.employeesList = employeesList;
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

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
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

    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }

    public int getTeacherEmployeeId() {
        return teacherEmployeeId;
    }

    public void setTeacherEmployeeId(int teacherEmployeeId) {
        this.teacherEmployeeId = teacherEmployeeId;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    @Inject
    private SessionBean sessionBean;

    @PostConstruct
    public void init() {

        branchId = sessionBean.getBranchId();
        centerId = sessionBean.getCenterId();
        insertEmployeeId = Integer.parseInt(sessionBean.getUsername());

        classRoomId = sessionBean.getSelectedItemId();

        try {
            if (classRoomId > 0) {
                ClassRoom classRoom = sessionBean.getSelectedClassRoom();//semesterDao.getSemester(branchId, centerId, semesterId, semesterYear);

                this.branchId = classRoom.getBranchId();
                this.branchName = classRoom.getBranchName();
                this.centerId = classRoom.getCenterId();
                this.centerName = classRoom.getCenterName();
                
                this.classId = classRoom.getClassId();
                this.className = classRoom.getClassName();
                this.levelId = classRoom.getLevelId();
                this.levelName = classRoom.getLevelName();
                
                this.semesterId = classRoom.getSemesterId();
                this.semesterIdLookUp = classRoom.getSemesterIdLookUp();
                
                this.semesterYear = classRoom.getSemesterYear();
                
                this.classRoomId = classRoom.getClassRoomId();
                
                this.teacherEmployeeId = classRoom.getTeacherEmployeeId();
                this.firstName = classRoom.getFirstName();
                this.secondName = classRoom.getSecondName();
                this.thirdName = classRoom.getThirdName();
                this.familyName = classRoom.getFamilyName();
                
                this.cost = classRoom.getCost();
                
                this.insertEmployeeId = classRoom.getInsertEmployeeId();
                this.insertHostIp = classRoom.getInsertHostIp();
                this.insertDate = classRoom.getInsertDate();
                this.insertHostOS = classRoom.getInsertHostOS();
                this.updatEmployeeId = classRoom.getUpdatEmployeeId();
                this.updateDate = classRoom.getUpdateDate();
                this.updateHostIp = classRoom.getUpdateHostIp();
                this.updateHostOS = classRoom.getUpdateHostOS();

            }

            semesterYearList = semesterDao.getSemesterYearList(branchId, centerId);
            classDefList = classDefDao.buildClassDef(branchId, centerId);
            
            //for update semester
            classLevelList = classLevelDao.buildClassLevel(branchId, centerId);
            semesterIdList = semesterDao.getSemesterIdList(branchId, centerId, semesterYear);
            
            employeesList = employeesDao.getEmployees(branchId, centerId, employeeCatagory);

        } catch (Exception ex) {
            Logger.getLogger(AddEditSemesterBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saveClassRoom() {

        int employeeId = Integer.parseInt(sessionBean.getUsername());

        ClassRoom classRoom = new ClassRoom();

        java.util.Date date = new java.util.Date();
        long t = date.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

        try {

            classRoom.setBranchId(branchId);
            classRoom.setBranchName(branchName);
            classRoom.setCenterId(centerId);
            classRoom.setCenterName(centerName);
            
            classRoom.setSemesterId(semesterId);
            classRoom.setSemesterIdLookUp(semesterIdLookUp);
            
            classRoom.setSemesterYear(semesterYear);
            
            classRoom.setClassId(classId);
            classRoom.setClassName(className);
            classRoom.setLevelId(levelId);
            classRoom.setLevelName(levelName);
            
            classRoom.setClassRoomId(classRoomId);
            
            classRoom.setTeacherEmployeeId(teacherEmployeeId);
            classRoom.setFirstName(firstName);
            classRoom.setSecondName(secondName);
            classRoom.setThirdName(thirdName);
            classRoom.setFamilyName(familyName);
            
            classRoom.setCost(cost);

            if (sessionBean.getSelectedItemId() > 0) {
                updateDate = sqlTimestamp;
                classRoom.setUpdatEmployeeId(employeeId);
                classRoom.setUpdateDate(updateDate);
                classRoom.setUpdateHostIp(sessionBean.getRemoteAddress());
                classRoom.setUpdateHostOS(sessionBean.getRemoteHost());
                classRoomDao.updateClassRoom(classRoom);
            } else {
                insertDate = sqlTimestamp;
                classRoom.setInsertEmployeeId(employeeId);
                classRoom.setInsertDate(insertDate);
                classRoom.setInsertHostIp(sessionBean.getRemoteAddress());
                classRoom.setInsertHostOS(sessionBean.getRemoteHost());
                classRoomDao.insertClassRoom(classRoom);
            }

            sessionBean.navigate("/hoffaz/registrar/manage_class_room.xhtml");

        } catch (Exception ex) {
            Logger.getLogger(SemesterDao.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

    }
    
    public void updateClassLevelList(){
        try {    
            classLevelList = classLevelDao.getClassLevelfilter(branchId, centerId, classId);
        } catch (Exception ex) {
            Logger.getLogger(AddEditClassRoomBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSemesterIdList(){
    try {    
            semesterIdList = semesterDao.getSemesterIdList(branchId, centerId, semesterYear);
        } catch (Exception ex) {
            Logger.getLogger(AddEditClassRoomBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
