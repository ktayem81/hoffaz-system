/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;


import daos.hoffaz.CenterDao;
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
import models.hoffaz.Center;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khale
 */
@Named(value = "manageCenterBean")
@ViewScoped
public class ManageCenterBean  implements Serializable{
    private Center selectedCenter;
    private ArrayList<Center> centers;
    private final CenterDao centerDao = new CenterDao();
    
    @Inject 
    private SessionBean sessionBean;
    
    public ManageCenterBean() {
    }
     @PostConstruct
    public void init(){
        try {
            this.centers = centerDao.buildCenters();
        } catch (Exception ex) {
            Logger.getLogger(ManageCenterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Center getSelectedCenter() {
        return selectedCenter;
    }

    public void setSelectedCenter(Center selectedCenter) {
        this.selectedCenter = selectedCenter;
    }

    public ArrayList<Center> getCenters() {
        return centers;
    }

    public void setCenters(ArrayList<Center> centers) {
        this.centers = centers;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedCenter.getCenterId());
    }
    public void onRowSelect(SelectEvent center) {
        FacesMessage msg = new FacesMessage("ceneter Selected", ((Center) center.getObject()).getCenterName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void deleteSelectedCenter(){
        try {
            centerDao.deleteCenter(selectedCenter.getCenterId());
            
        } catch (Exception ex) {
            Logger.getLogger(ManageCenterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
