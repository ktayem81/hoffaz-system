/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.DonateDao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Donate;

/**
 *
 * @author eng_ayman
 */
@Named(value = "addEditDonateBean")
@ViewScoped
public class AddEditDonateBean implements Serializable {

   
    private final DonateDao donateDao = new DonateDao();
    
    private int branchId;
    private String branchName;
    private int centerId;
    private String centerName;
    private int donateId;
    private String donaterName;
    private double donateAmount;
    private int insertEmployeeId;
    private String insertHostIp;    
    private Timestamp insertDate;      
    private String insertHostOS;  

    @Inject
    private SessionBean sessionBean;



    @PostConstruct
    public void init() {

        this.insertEmployeeId = Integer.parseInt(sessionBean.getUsername());
        
        this.branchId = sessionBean.getBranchId();
        this.centerId = sessionBean.getCenterId();

        
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

    public int getDonateId() {
        return donateId;
    }

    public void setDonateId(int donateId) {
        this.donateId = donateId;
    }

    public String getDonaterName() {
        return donaterName;
    }

    public void setDonaterName(String donaterName) {
        this.donaterName = donaterName;
    }

    public double getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(double donateAmount) {
        this.donateAmount = donateAmount;
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

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    
    

    public void saveDonate() {

        Donate donate = new Donate();

        try {
            
            donate.setBranchId(branchId);
            donate.setBranchName(branchName);
            donate.setCenterId(centerId);
            donate.setCenterName(centerName);
            donate.setDonateAmount(donateAmount);
            donate.setDonateId(donateId);
            donate.setDonaterName(donaterName);
            donate.setInsertDate(insertDate);
            donate.setInsertEmployeeId(insertEmployeeId);
            donate.setInsertHostIp(sessionBean.getRemoteAddress());
            donate.setInsertHostOS(sessionBean.getRemoteHost());
            

            donateDao.insertDonate(donate);

            sessionBean.navigate("/hoffaz/Accountant/manage_donate.xhtml");

        } catch (Exception ex) {
            Logger.getLogger(AddEditDonateBean.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }
    }
}
