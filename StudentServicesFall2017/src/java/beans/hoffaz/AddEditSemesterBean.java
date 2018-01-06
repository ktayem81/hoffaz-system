/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.SemesterDao;
import daos.hoffaz.SemesterDefDao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Semester;
import models.hoffaz.SemesterDef;

/**
 *
 * @author khaled
 */
@Named(value = "addEditSemesterBean")
@ViewScoped
public class AddEditSemesterBean implements Serializable{

    private final SemesterDao semesterDao = new SemesterDao();
    
    private final SemesterDefDao semesterDefDao = new SemesterDefDao();
    
    private ArrayList<SemesterDef> semesterDefList = new ArrayList<>();

    private String rowId;
    private int branchId;
    private String branchName;
    private int centerId;
    private String centerName;
    private int semesterId;
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

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
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

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public ArrayList<SemesterDef> getSemesterDefList() {
        return semesterDefList;
    }

    public void setSemesterDefList(ArrayList<SemesterDef> semesterDefList) {
        this.semesterDefList = semesterDefList;
    }
    
    

    /**
     * Creates a new instance of AddEditSemesterBean
     */
    @Inject
    private SessionBean sessionBean;

    @PostConstruct
    public void init() {

        branchId = sessionBean.getBranchId();
        centerId = sessionBean.getCenterId();
        insertEmployeeId = Integer.parseInt(sessionBean.getUsername());

        semesterId = sessionBean.getSelectedItemId();

        try {
            if (semesterId > 0) {
                Semester semester = sessionBean.getSelectedSemester();//semesterDao.getSemester(branchId, centerId, semesterId, semesterYear);

                this.rowId = semester.getRowId();
                
                this.branchId = semester.getBranchId();
                this.branchName = semester.getBranchName();
                this.centerId = semester.getCenterId();
                this.centerName = semester.getCenterName();
                this.semesterId = semester.getSemesterId();
                this.semesterYear = semester.getSemesterYear();
                this.semesterDesc = semester.getSemesterDesc();
                this.semesterBegin = semester.getSemesterBegin();
                this.semesterEnd = semester.getSemesterEnd();
                this.insertEmployeeId = semester.getInsertEmployeeId();
                this.insertHostIp = semester.getInsertHostIp();
                this.insertDate = semester.getInsertDate();
                this.insertHostOS = semester.getInsertHostOS();
                this.updatEmployeeId = semester.getUpdatEmployeeId();
                this.updateDate = semester.getUpdateDate();
                this.updateHostIp = semester.getUpdateHostIp();
                this.updateHostOS = semester.getUpdateHostOS();

            }
            
            semesterDefList = semesterDefDao.getSemesterDefList();

        } catch (Exception ex) {
            Logger.getLogger(AddEditSemesterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void saveSemester() {

        int employeeId = Integer.parseInt(sessionBean.getUsername());

        Semester semester = new Semester();
        
        java.util.Date date = new java.util.Date();
        long t = date.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
        

        try {

            semester.setRowId(rowId);
            
            semester.setBranchId(branchId);
            semester.setBranchName(branchName);
            semester.setCenterId(centerId);
            semester.setCenterName(centerName);
            semester.setSemesterYear(semesterYear);
            semester.setSemesterId(semesterId);
            semester.setSemesterBegin(semesterBegin);
            semester.setSemesterEnd(semesterEnd);
            semester.setSemesterDesc(semesterDesc);

            if (sessionBean.getSelectedItemId()> 0) {
                updateDate= sqlTimestamp ;
                semester.setUpdatEmployeeId(employeeId);
                semester.setUpdateDate(updateDate);
                semester.setUpdateHostIp(sessionBean.getRemoteAddress());
                semester.setUpdateHostOS(sessionBean.getRemoteHost());
                semesterDao.updateSemester(semester);
            } else {
                insertDate= sqlTimestamp ;
                semester.setInsertEmployeeId(employeeId);
                semester.setInsertDate(insertDate);
                semester.setInsertHostIp(sessionBean.getRemoteAddress());
                semester.setInsertHostOS(sessionBean.getRemoteHost());
                semesterDao.insertSemester(semester);
            }

            sessionBean.navigate("/hoffaz/registrar/manage_semesters.xhtml");

        } catch (Exception ex) {
            Logger.getLogger(SemesterDao.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

    }

}
