/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.ClassDefDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.ClassDef;



/**
 *
 * @author khale
 */
@Named(value = "addEditClassLevelBean")
@ViewScoped
public class AddEditClassLevelBean {

    /**
     * Creates a new instance of AddLevelClassBean
     */
    private final ClassLevelDao classLevelDao = new ClassLevelDao();
    
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
    private String description;
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
    
    public AddEditClassLevelBean() {
    }
    
    @PostConstruct
    public void init() {

        branchId = sessionBean.getBranchId();
        centerId = sessionBean.getCenterId();
        insertEmployeeId = Integer.parseInt(sessionBean.getUsername());

        classLevelId = sessionBean.getSelectedclassID();

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

            if (sessionBean.getSelectedclassID() > 0) {
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
