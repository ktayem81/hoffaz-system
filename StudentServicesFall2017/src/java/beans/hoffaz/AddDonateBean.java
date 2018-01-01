/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.AddDonateDao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import models.hoffaz.Donates;

/**
 *
 * @author eng_ayman
 */
@Named(value = "addDonateBean")
@Dependent
public class AddDonateBean implements Serializable {

    private final AddDonateDao donateDao = new AddDonateDao();
private ArrayList<Donates> donates ;
    private int donateid;
    private String donatername;
    private int amount;
    private Timestamp insertdate;
    private int insertemployeeid;
    private String inserthostip;
    private String inserthostos;
    private int branchId;
    private int centerId;

    @Inject
    private SessionBean sessionBean;

    public AddDonateBean() {
    }

    public ArrayList<Donates> getDonates() {
        return donates;
    }

    public void setDonates(ArrayList<Donates> donates) {
        this.donates = donates;
    }

    public int getDonateid() {
        return donateid;
    }

    public void setDonateid(int donateid) {
        this.donateid = donateid;
    }

    public String getDonatername() {
        return donatername;
    }

    public void setDonatername(String donatername) {
        this.donatername = donatername;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Timestamp insertdate) {
        this.insertdate = insertdate;
    }

    public int getInsertemployeeid() {
        return insertemployeeid;
    }

    public void setInsertemployeeid(int insertemployeeid) {
        this.insertemployeeid = insertemployeeid;
    }

    public String getInserthostip() {
        return inserthostip;
    }

    public void setInserthostip(String inserthostip) {
        this.inserthostip = inserthostip;
    }

    public String getInserthostos() {
        return inserthostos;
    }

    public void setInserthostos(String inserthostos) {
        this.inserthostos = inserthostos;
    }
    
    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }
 @PostConstruct
    public void init() {
        
        this.insertemployeeid = Integer.parseInt(sessionBean.getUsername());
      this.branchId=sessionBean.getBranchId();
      this.centerId=sessionBean.getCenterId();
    
         try {
            donates = donateDao.buildDonates(branchId,centerId);
        } catch (Exception ex) {
            Logger.getLogger(AddDonateBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void saveDonate() {
        
    Donates donate=new Donates();
         try {
             donate.setDonateid(donateid);
             donate.setDonatername(donatername);
             donate.setAmount(amount);
             donate.setInsertdate(insertdate);
             donate.setInsertemployeeid(insertemployeeid);
             donate.setInserthostip(inserthostip);
             donate.setInserthostos(inserthostos);
             donate.setBranchID(branchId);
            donate.setCenterID(centerId);
            donateDao.insertDonate(donate);
        } catch (Exception ex) {
            Logger.getLogger(AddDonateBean.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
