/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.ClassDefDao;
import daos.hoffaz.ClassLevelDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.ClassDef;
import models.hoffaz.ClassLevel;

/**
 *
 * @author khale
 */
@Named(value = "addEditClassLevelBean")
@ViewScoped
public class AddEditClassLevelBean implements Serializable{

    /**
     * Creates a new instance of AddLevelClassBean
     */
    private final ClassLevelDao classLevelDao = new ClassLevelDao();
    private final ClassDefDao classDefDao = new ClassDefDao();

    private ArrayList<ClassDef> classDefList = new ArrayList<>();

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
    private String levelDesc;
    private Date insertDate;
    private int insertEmployeeId;
    private String insertHostIp;
    private String insertHostOS;
    private Date updateDate;
    private int updatEmployeeId;
    private String updateHostIp;
    private String updateHostOS;

    @Inject
    private SessionBean sessionBean;

    public AddEditClassLevelBean() {
    }

    public ArrayList<ClassDef> getClassDefList() {
        return classDefList;
    }

    public void setClassDefList(ArrayList<ClassDef> classDefList) {
        this.classDefList = classDefList;
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

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
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

    public String getInsertHostOS() {
        return insertHostOS;
    }

    public void setInsertHostOS(String insertHostOS) {
        this.insertHostOS = insertHostOS;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getUpdatEmployeeId() {
        return updatEmployeeId;
    }

    public void setUpdatEmployeeId(int updatEmployeeId) {
        this.updatEmployeeId = updatEmployeeId;
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
    
    

    @PostConstruct
    public void init() {

        branchId = sessionBean.getBranchId();
        centerId = sessionBean.getCenterId();
        insertEmployeeId = Integer.parseInt(sessionBean.getUsername());

        levelId = sessionBean.getSelectedItemId();

        try {
            if (levelId > 0) {
                ClassLevel classLevel = classLevelDao.getClassLevel(branchId, centerId, classID, levelId);

                this.branchId = classLevel.getBranchId();
                this.branchName = classLevel.getBranchName();
                this.centerId = classLevel.getCenterId();
                this.centerName = classLevel.getCenterName();
                this.classID = classLevel.getClassID();
                this.className = classLevel.getClassName();
                this.gradeIdFrom = classLevel.getGradeIdFrom();
                this.gradeIdFromDesc = classLevel.getGradeIdFromDesc();
                this.gradeIdTo = classLevel.getGradeIdTo();
                this.gradeIdToDesc = classLevel.getGradeIdToDesc();
                this.classDefDesc = classLevel.getClassDefDesc();
                this.levelId = classLevel.getLevelId();
                this.levelName = classLevel.getLevelName();
                this.levelDesc = classLevel.getLevelDesc();
                this.insertDate = classLevel.getInsertDate();
                this.insertEmployeeId = classLevel.getInsertEmployeeId();
                this.insertHostIp = classLevel.getInsertHostIp();
                this.insertHostOS = classLevel.getInsertHostOS();
                this.updateDate = classLevel.getUpdateDate();
                this.updatEmployeeId = classLevel.getUpdatEmployeeId();
                this.updateHostIp = classLevel.getUpdateHostIp();
                this.updateHostOS = classLevel.getUpdateHostOS();

            }

            classDefList = classDefDao.buildClassDef(branchId, centerId);

        } catch (Exception ex) {
            Logger.getLogger(AddEditClassDefBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveClassLevel() {

        int employeeId = Integer.parseInt(sessionBean.getUsername());

        //ClassDef classDef = new ClassDef();
        ClassLevel classLevel = new ClassLevel();

        try {

            classLevel.setClassID(classID);
            classLevel.setClassName(className);
            classLevel.setGradeIdFrom(gradeIdFrom);
            classLevel.setGradeIdFromDesc(gradeIdFromDesc);
            classLevel.setGradeIdTo(gradeIdTo);
            classLevel.setGradeIdToDesc(gradeIdToDesc);
            classLevel.setClassDefDesc(classDefDesc);

            classLevel.setLevelId(levelId);
            classLevel.setLevelName(levelName);
            classLevel.setLevelDesc(levelDesc);

            classLevel.setBranchId(branchId);
            classLevel.setCenterId(centerId);

            if (sessionBean.getSelectedclassID() > 0) {
                classLevel.setUpdatEmployeeId(employeeId);
                classLevel.setUpdateDate(updateDate);
                classLevel.setUpdateHostIp(sessionBean.getRemoteAddress());
                classLevel.setUpdateHostOS(sessionBean.getRemoteHost());
                classLevelDao.updateClassLevel(classLevel);
            } else {
                classLevel.setInsertEmployeeId(employeeId);
                classLevel.setInsertDate(insertDate);
                classLevel.setInsertHostIp(sessionBean.getRemoteAddress());
                classLevel.setInsertHostOS(sessionBean.getRemoteHost());
                classLevelDao.insertClassLevel(classLevel);
            }

            //sessionBean.setClassDef(classDef);
            //sessionBean.navigate("/hoffaz/registrar/studentreport");
            sessionBean.navigate("/hoffaz/registrar/manage_class_level.xhtml");

        } catch (Exception ex) {
            Logger.getLogger(ClassDefDao.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

    }

}
