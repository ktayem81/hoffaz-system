/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;


import daos.hoffaz.BranchDao;
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
    private Branch selectedBranch;
    private final BranchDao branchDao = new BranchDao();
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
            this.branches = branchDao.buildBranches();
        } catch (Exception ex) {
            Logger.getLogger(ManageBranchBean.class.getName()).log(Level.SEVERE, null, ex);
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
        sessionBean.setSelectedItemId(selectedBranch.getBranchId());
    }

    public void onRowSelect(SelectEvent branch) {
        FacesMessage msg = new FacesMessage("branch Selected", ((Branch) branch.getObject()).getBranchName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void deleteSelectedBranch(){
        try {
            branchDao.deleteBranch(selectedBranch.getBranchId());
            
        } catch (Exception ex) {
            Logger.getLogger(ManageBranchBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
