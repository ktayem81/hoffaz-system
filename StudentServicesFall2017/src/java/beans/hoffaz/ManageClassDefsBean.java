/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.ClassDefDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.ClassDef;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khaled
 */
@Named(value = "manageClassDefsBean")
@ViewScoped
public class ManageClassDefsBean implements Serializable {

    private ClassDef selectedClassDef;
    private final ClassDefDao classDefDao = new ClassDefDao();
    private ArrayList<ClassDef> classDefs;

    @Inject
    private SessionBean sessionBean;

    /**
     * Creates a new instance of ManageClassDefsBean
     */
    public ManageClassDefsBean() {
    }

    @PostConstruct
    public void init() {
        try {
            this.classDefs = classDefDao.buildClassDef(sessionBean.getBranchId(), sessionBean.getCenterId());
        } catch (Exception ex) {
            Logger.getLogger(ManageClassDefsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ClassDef getSelectedClassDef() {
        return selectedClassDef;
    }

    public void setSelectedClassDef(ClassDef selectedClassDef) {
        this.selectedClassDef = selectedClassDef;
    }

    public ArrayList<ClassDef> getClassDefs() {
        return classDefs;
    }

    public void setClassDefs(ArrayList<ClassDef> classDefs) {
        this.classDefs = classDefs;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedClassDef.getClassID());
    }

    public void onRowSelect(SelectEvent classDef) {
        FacesMessage msg = new FacesMessage("ClassDef Selected", ((ClassDef) classDef.getObject()).getClassName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteSelectedClassDef() {
        try {
            classDefDao.deleteClassDef(sessionBean.getBranchId(), sessionBean.getCenterId(), selectedClassDef.getClassID());

        } catch (Exception ex) {
            Logger.getLogger(ManageClassDefsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
