/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.AddBranchDao;
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
import models.hoffaz.Branch;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khale
 */
@Named(value = "manageBranchBean")
@ViewScoped
public class ManageBranchBean implements Serializable{
    private Branch selectedStudent;
    private final AddBranchDao branchesDao = new AddBranchDao();
    private ArrayList<Branch> branches; 
    
    @Inject 
    private SessionBean sessionBean;

    /**
     * Creates a new instance of ManageBranchBean
     */
    public ManageBranchBean() {
    }
    @PostConstruct
    public void init(){
        try {
            this.branches = AddBranchDao.buildBranches();
        } catch (Exception ex) {
            Logger.getLogger(ManageStudentsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Branch getSelectedBranch() {
        return selectedBranch;
    }

    public void setSelectedBranch(Branch selectedBranch) {
        this.selectedBranch = selectedBranch;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    
    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedStudent.getBranchId());
    }

    public void onRowSelect(SelectEvent branch) {
        FacesMessage msg = new FacesMessage("student Selected", ((Branch) branch.getObject()).getBranch_Name());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void deleteSelectedStudent(){
        try {
            studentsDao.deleteStudent(selectedStudent.getStudentId(), sessionBean.getBranchId(), sessionBean.getCenterId());
            
        } catch (Exception ex) {
            Logger.getLogger(ManageStudentsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
