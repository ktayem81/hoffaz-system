/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.BranchDao;
import daos.hoffaz.CenterDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Branch;
import models.hoffaz.Center;


/**
 *
 * @author khale
 */
@Named(value = "addEditCenterBean")
@ViewScoped
public class AddEditCenterBean implements Serializable {
    private final CenterDao centerDao = new CenterDao();
    private final BranchDao branchDao = new BranchDao();
    private ArrayList<Branch> branchList = new ArrayList<Branch>();
    private int centerId;
    private String centerName;
    private String description;
    private String phone;

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(ArrayList<Branch> branchList) {
        this.branchList = branchList;
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

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchDesc() {
        return branchDesc;
    }

    public void setBranchDesc(String branchDesc) {
        this.branchDesc = branchDesc;
    }
@Inject
    SessionBean sessionBean;
    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    private int branchId;
    private String branchDesc;

    
    public AddEditCenterBean() {
    }
    @PostConstruct
    public void init() {

        centerId = sessionBean.getSelectedItemId();

        try {
            if (centerId > 0) {
                //get selected branch fro DB
                Center center = centerDao.getCenter(centerId);

                this.centerId = center.getCenterId();
                this.centerName = center.getCenterName();
                this.description = center.getDescription();
                this.phone = center.getPhone();
                this.branchId = center.getBranchId();
                this.branchDesc = center.getBranchDesc();

            }

            branchList =branchDao.buildBranches();

        } catch (Exception ex) {
            Logger.getLogger(AddEditCenterBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void saveCenter() {

        Center center = new Center();

        try {
            center.setCenterId(centerId);
            center.setCenterName(centerName);
            center.setDescription(description);
            center.setBranchDesc(branchDesc);
            center.setBranchId(branchId);
            center.setPhone(phone);

            if (sessionBean.getSelectedItemId() > 0) {

                centerDao.updateCenter(center);
            } else {

                centerDao.insertCenter(center);
            }

        } catch (Exception ex) {
            Logger.getLogger(AddEditCenterBean.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

        sessionBean.navigate("/hoffaz/admin/manage_center.xhtml");

    }
    
}
