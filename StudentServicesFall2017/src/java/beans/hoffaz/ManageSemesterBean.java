/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.SemesterDao;
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
import models.hoffaz.Semester;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khaled
 */
@Named(value = "manageSemesterBean")
@ViewScoped
public class ManageSemesterBean implements Serializable{
    
    private Semester selectedSemester;
    
    private final SemesterDao semesterDao = new SemesterDao();
    private ArrayList<Semester> semesters;

    public Semester getSelectedSemester() {
        return selectedSemester;
    }

    public void setSelectedSemester(Semester selectedSemester) {
        this.selectedSemester = selectedSemester;
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(ArrayList<Semester> semesters) {
        this.semesters = semesters;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    
    @Inject
    private SessionBean sessionBean;

    /**
     * Creates a new instance of ManageSemesterBean
     */
    public ManageSemesterBean() {
    }
    
    @PostConstruct
    public void init() {
        try {
            this.semesters = semesterDao.buildSemesters(sessionBean.getBranchId(), sessionBean.getCenterId());
        } catch (Exception ex) {
            Logger.getLogger(ManageSemesterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowSelect(SelectEvent semester) {
        FacesMessage msg = new FacesMessage("semester Selected", ((Semester) semester.getObject()).getSemesterDesc());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedSemester.getSemesterId());
        sessionBean.setSelectedSemester(selectedSemester);
    }
    

    public void deleteSelectedSemester() {
        try {
            semesterDao.deleteSemester(sessionBean.getBranchId(), sessionBean.getCenterId(), selectedSemester.getSemesterYear(), selectedSemester.getSemesterId());

        } catch (Exception ex) {
            Logger.getLogger(ManageSemesterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
