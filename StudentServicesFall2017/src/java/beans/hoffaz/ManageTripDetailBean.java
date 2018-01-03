/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.TripDetailDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.TripDetail;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khale
 */
@Named(value = "manageTripDetailBean")
@ViewScoped
public class ManageTripDetailBean {

    /**
     * Creates a new instance of ManageTripDetailBean
     */
    private TripDetail selectedTripDetail;
    private ArrayList<TripDetail> tripDetails;
    private final TripDetailDao tripDetailDao = new TripDetailDao();
    
    @Inject 
    private SessionBean sessionBean;
    public ManageTripDetailBean() {
    }
    public void init(){
        try {
            this.tripDetails = tripDetailDao.buildTripDetails(sessionBean.getBranchId(), sessionBean.getCenterId());
        } catch (Exception ex) {
            Logger.getLogger(ManageTripDetailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    public TripDetail getSelectedTripDetail() {
        return selectedTripDetail;
    }

    public void setSelectedTripDetail(TripDetail selectedTripDetail) {
        this.selectedTripDetail = selectedTripDetail;
    }

    public ArrayList<TripDetail> getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(ArrayList<TripDetail> tripDetails) {
        this.tripDetails = tripDetails;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedTripDetail.getStopId());
    }
    public void onRowSelect(SelectEvent tripDetail) {
        FacesMessage msg = new FacesMessage("tripDetail Selected", ((TripDetail) tripDetail.getObject()).getTripDesc());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteSelectedTripDetail() {
        try {
            tripDetailDao.deleteTripDetail(sessionBean.getBranchId(), sessionBean.getCenterId(), selectedTripDetail.getStopId());

        } catch (Exception ex) {
            Logger.getLogger(ManageTripDetailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
