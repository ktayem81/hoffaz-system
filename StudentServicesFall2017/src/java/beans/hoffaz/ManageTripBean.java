/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.TripDao;
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
import models.hoffaz.Trip;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khale
 */
@Named(value = "manageTripBean")
@ViewScoped
public class ManageTripBean  implements Serializable{

    /**
     * Creates a new instance of ManageTripBean
     */
    private Trip selectedTrip;
    private ArrayList<Trip> trips;
    private final TripDao tripDao = new TripDao();
    
    @Inject 
    private SessionBean sessionBean;
    public ManageTripBean() {
    }
    @PostConstruct
    public void init(){
        try {
            this.trips = tripDao.buildTrips(sessionBean.getBranchId(), sessionBean.getCenterId());
        } catch (Exception ex) {
            Logger.getLogger(ManageTripBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public Trip getSelectedTrip() {
        return selectedTrip;
    }

    public void setSelectedTrip(Trip selectedTrip) {
        this.selectedTrip = selectedTrip;
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
     public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedTrip.getTripId());
    }

  //  public void saveSelectedTripId() {
      //  sessionBean.setSelectedItemId(selectedTrip.getTripId());
    //}

    public void onRowSelect(SelectEvent trip) {
        FacesMessage msg = new FacesMessage("trip Selected", ((Trip) trip.getObject()).getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteSelectedTrip() {
        try {
            tripDao.deleteTrip(sessionBean.getBranchId(), sessionBean.getCenterId(), selectedTrip.getTripId());

        } catch (Exception ex) {
            Logger.getLogger(ManageTripBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
