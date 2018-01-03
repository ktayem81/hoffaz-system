/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.ClassDefDao;
import daos.hoffaz.ClassGradeDao;
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
import models.hoffaz.ClassGrade;

/**
 *
 * @author khaled
 */
@Named(value = "addEditClassDefBean")
@ViewScoped
public class AddEditClassDefBean implements Serializable{
    
    private final ClassDefDao classDefDao = new ClassDefDao();
    private final ClassGradeDao classGradeDao = new ClassGradeDao();
    
    private ArrayList<ClassGrade> classGradeList = new ArrayList<>();
    
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
    private int insertEmployeeId;
    private String insertHostIp;    
    private Date insertDate;      
    private String insertHostOS;    
    private int updatEmployeeId; 
    private Date updateDate;      
    private String updateHostIp;    
    private String updateHostOS;
    
     @Inject
    private SessionBean sessionBean;

    /**
     * Creates a new instance of AddEditClassBean
     */
    public AddEditClassDefBean() {
    }

    public ArrayList<ClassGrade> getClassGradeList() {
        return classGradeList;
    }

    public void setClassGradeList(ArrayList<ClassGrade> classGradeList) {
        this.classGradeList = classGradeList;
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

        classID = sessionBean.getSelectedItemId();

        try {
            if (classID > 0) {
                ClassDef classDef = classDefDao.getClassDef(branchId, centerId, classID);

                this.classID = classDef.getClassID();
                this.className = classDef.getClassName();
                this.gradeIdFrom = classDef.getGradeIdFrom();
                this.gradeIdFromDesc = classDef.getGradeIdFromDesc();
                this.gradeIdTo = classDef.getGradeIdTo();
                this.gradeIdToDesc = classDef.getGradeIdToDesc();
                this.classDefDesc = classDef.getClassDefDesc();
                this.branchId = classDef.getBranchId();
                this.branchName = classDef.getBranchName();
                this.centerId = classDef.getCenterId();
                this.centerName = classDef.getCenterName();
                this.insertEmployeeId = classDef.getInsertEmployeeId();
                this.insertHostIp = classDef.getInsertHostIp();
                this.insertDate = classDef.getInsertDate();
                this.insertHostOS = classDef.getInsertHostOS();
                this.updatEmployeeId = classDef.getUpdatEmployeeId();
                this.updateDate = classDef.getUpdateDate();
                this.updateHostIp = classDef.getUpdateHostIp();
                this.updateHostOS = classDef.getUpdateHostOS();

            }
            
            classGradeList = classGradeDao.getClassGradeList();

        } catch (Exception ex) {
            Logger.getLogger(AddEditClassDefBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public void saveClassDef() {

        int employeeId = Integer.parseInt(sessionBean.getUsername());

        ClassDef classDef = new ClassDef();

        try {

            classDef.setClassID(classID);
            classDef.setClassName(className);
            classDef.setGradeIdFrom(gradeIdFrom);
            classDef.setGradeIdFromDesc(gradeIdFromDesc);
            classDef.setGradeIdTo(gradeIdTo);
            classDef.setGradeIdToDesc(gradeIdToDesc);
            classDef.setClassDefDesc(classDefDesc);

            classDef.setBranchId(branchId);
            classDef.setCenterId(centerId);

            if (sessionBean.getSelectedItemId() > 0) {
                classDef.setUpdatEmployeeId(employeeId);
                classDef.setUpdateDate(updateDate);
                classDef.setUpdateHostIp(sessionBean.getRemoteAddress());
                classDef.setUpdateHostOS(sessionBean.getRemoteHost());
                classDefDao.updateClassDef(classDef);
            } else {
                classDef.setInsertEmployeeId(employeeId);
                classDef.setInsertDate(insertDate);
                classDef.setInsertHostIp(sessionBean.getRemoteAddress());
                classDef.setInsertHostOS(sessionBean.getRemoteHost());
                classDefDao.insertClassDef(classDef);
            }

            //sessionBean.setClassDef(classDef);

            //sessionBean.navigate("/hoffaz/registrar/studentreport");
            
            sessionBean.navigate("/hoffaz/registrar/manage_class_def.xhtml");

        } catch (Exception ex) {
            Logger.getLogger(ClassDefDao.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

    }

}
