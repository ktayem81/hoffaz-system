/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.BranchDao;
import daos.hoffaz.GovernorateDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Branch;
import models.hoffaz.Governorate;

/**
 *
 * @author khale
 */
@Named(value = "addEditBranchBean")
@ViewScoped
public class AddEditBranchBean implements Serializable {

    /**
     * Creates a new instance of AddEditBranchBean
     */
    private final BranchDao branchDao = new BranchDao();
    private final GovernorateDao governorateDao = new GovernorateDao();
    private ArrayList<Governorate> governorateList = new ArrayList<Governorate>();

    private int branchId;
    private String branchName;
    private String description;
    private String phone;
    private int governorateId;
    private String governorateDesc;

    @Inject
    SessionBean sessionBean;

    public ArrayList<Governorate> getGovernorateList() {
        return governorateList;
    }

    public void setGovernorateList(ArrayList<Governorate> governorateList) {
        this.governorateList = governorateList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGovernorateId() {
        return governorateId;
    }

    public void setGovernorateId(int governorateId) {
        this.governorateId = governorateId;
    }

    public String getGovernorateDesc() {
        return governorateDesc;
    }

    public void setGovernorateDesc(String governorateDesc) {
        this.governorateDesc = governorateDesc;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    @PostConstruct
    public void init() {

        branchId = sessionBean.getSelectedItemId();

        try {
            if (branchId > 0) {
                //get selected branch fro DB
                Branch branch = branchDao.getBranch(branchId);

                this.branchId = branch.getBranchId();
                this.branchName = branch.getBranchName();
                this.description = branch.getDescription();
                this.phone = branch.getPhone();
                this.governorateId = branch.getGovernorateId();
                this.governorateDesc = branch.getGovernorateDesc();

            }

            governorateList = governorateDao.getGovernorateList();

        } catch (Exception ex) {
            Logger.getLogger(AddEditClassDefBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saveBranch() {

        Branch branch = new Branch();

        try {
            branch.setBranchId(branchId);
            branch.setBranchName(branchName);
            branch.setDescription(description);
            branch.setGovernorateDesc(governorateDesc);
            branch.setGovernorateId(governorateId);
            branch.setPhone(phone);

            if (sessionBean.getSelectedItemId() > 0) {

                branchDao.updateBranch(branch);
            } else {

                branchDao.insertBranch(branch);
            }

        } catch (Exception ex) {
            Logger.getLogger(AddEditBranchBean.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

        sessionBean.navigate("/hoffaz/admin/manage_branch.xhtml");

    }

}
