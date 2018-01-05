/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.DonateDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Donate;

/**
 *
 * @author khaled
 */
@Named(value = "manageDonateBean")
@ViewScoped
public class ManageDonateBean  implements Serializable{
    
    private final DonateDao donateDao = new DonateDao();
    private ArrayList<Donate> donates;
    private Donate selectedDonate;
    
     @Inject
    private SessionBean sessionBean;

    /**
     * Creates a new instance of ManageDonateBean
     */
    public ManageDonateBean() {
    }

    public ArrayList<Donate> getDonates() {
        return donates;
    }

    public void setDonates(ArrayList<Donate> donates) {
        this.donates = donates;
    }

    public Donate getSelectedDonate() {
        return selectedDonate;
    }

    public void setSelectedDonate(Donate selectedDonate) {
        this.selectedDonate = selectedDonate;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    
    
    
    @PostConstruct
    public void init() {
    try {
            donates = donateDao.buildDonates(sessionBean.getBranchId(), sessionBean.getCenterId());
        } catch (Exception ex) {
            Logger.getLogger(AddEditDonateBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
