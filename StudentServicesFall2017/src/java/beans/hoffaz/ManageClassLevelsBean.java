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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.ClassDef;
import models.hoffaz.ClassLevel;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khaled
 */
@Named(value = "manageClassLevelsBean")
@ViewScoped

public class ManageClassLevelsBean implements Serializable{

    /**
     * Creates a new instance of ManageClassLevelsBean
     */
    //to get the level table
    private ClassLevel selectedClassLevel;
    private final ClassLevelDao classLevelDao = new ClassLevelDao();
    private ArrayList<ClassLevel> classLevels;
    
    //for list of classes
    private final ClassDefDao classDefDao = new ClassDefDao();
    private ArrayList<ClassDef> classDefList = new ArrayList<>();

    private int classID;

    @Inject
    private SessionBean sessionBean;

    public ManageClassLevelsBean() {
    }

    @PostConstruct
    public void init() {
        try {
            //build table
            classLevels = classLevelDao.buildClassLevel(sessionBean.getBranchId(), sessionBean.getCenterId(), classID);
            //get class list
            classDefList = classDefDao.buildClassDef(sessionBean.getBranchId(), sessionBean.getCenterId());
            
        } catch (Exception ex) {
            Logger.getLogger(ManageClassLevelsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    public ArrayList<ClassDef> getClassDefList() {
        return classDefList;
    }

    public void setClassDefList(ArrayList<ClassDef> classDefList) {
        this.classDefList = classDefList;
    }

    public ClassLevel getSelectedClassLevel() {
        return selectedClassLevel;
    }

    public void setSelectedClassLevel(ClassLevel selectedClassLevel) {
        this.selectedClassLevel = selectedClassLevel;
    }

    public ArrayList<ClassLevel> getClassLevels() {
        return classLevels;
    }

    public void setClassLevels(ArrayList<ClassLevel> classLevels) {
        this.classLevels = classLevels;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedClassLevel.getLevelId());
    }

    public void onRowSelect(SelectEvent classLevel) {
        FacesMessage msg = new FacesMessage("ClassLevel Selected", ((ClassLevel) classLevel.getObject()).getClassName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteSelectedClassLevel() {
        try {
            classLevelDao.deleteClassLevel(sessionBean.getBranchId(), sessionBean.getCenterId(), selectedClassLevel.getClassID(), selectedClassLevel.getLevelId());

        } catch (Exception ex) {
            Logger.getLogger(ManageClassLevelsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
