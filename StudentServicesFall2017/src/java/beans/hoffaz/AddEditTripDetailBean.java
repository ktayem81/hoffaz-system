/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.BranchDao;
import daos.hoffaz.CenterDao;
import daos.hoffaz.TripDao;
import daos.hoffaz.TripDetailDao;
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
import models.hoffaz.Trip;
import models.hoffaz.TripDetail;

/**
 *
 * @author khale
 */
@Named(value = "addEditTripDetailBean")
@ViewScoped
public class AddEditTripDetailBean  implements Serializable{

    /**
     * Creates a new instance of AddEditTripdetailBean
     */ 
    private final TripDetailDao tripDetailDao = new TripDetailDao();
    private final TripDao tripDao = new TripDao();
    private final BranchDao branchDao = new BranchDao();
    private final CenterDao centerDao = new CenterDao();
    private ArrayList<Branch> branchList = new ArrayList<>();
    private ArrayList<Center> centerList = new ArrayList<>();
    private ArrayList<Trip> tripList = new ArrayList<>();
    
    private String rowId;
    private int branchId; 
    private String branchDesc;
    private int centerId;
    private String centerDesc;
    private int stopId;
    private String stopDescription;
    private int tripId; 
    private String tripDesc;
    private int insertTripId;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public int getInsertTripId() {
        return insertTripId;
    }

    public void setInsertTripId(int insertTripId) {
        this.insertTripId = insertTripId;
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(ArrayList<Branch> branchList) {
        this.branchList = branchList;
    }

    public ArrayList<Center> getCenterList() {
        return centerList;
    }

    public void setCenterList(ArrayList<Center> centerList) {
        this.centerList = centerList;
    }

    public ArrayList<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(ArrayList<Trip> tripList) {
        this.tripList = tripList;
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

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterDesc() {
        return centerDesc;
    }

    public void setCenterDesc(String centerDesc) {
        this.centerDesc = centerDesc;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getStopDescription() {
        return stopDescription;
    }

    public void setStopDescription(String stopDescription) {
        this.stopDescription = stopDescription;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTripDesc() {
        return tripDesc;
    }

    public void setTripDesc(String tripDesc) {
        this.tripDesc = tripDesc;
    }
    
   
   
    public AddEditTripDetailBean() {
    }
    @Inject
    private SessionBean sessionBean;

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    
     @PostConstruct
    public void init() {

        branchId = sessionBean.getBranchId();
        centerId = sessionBean.getCenterId();
        insertTripId = Integer.parseInt(sessionBean.getUsername());

        stopId = sessionBean.getSelectedItemId();

        try {
            if (stopId > 0) {
                
                TripDetail tripDetail = tripDetailDao.getTripDetail(rowId);//branchId, centerId,tripId, stopId);
               
                this.branchId = tripDetail.getBranchId();
                this.branchDesc = tripDetail.getBranchName();
                this.centerId = tripDetail.getCenterId();
                this.centerDesc = tripDetail.getCenterName();
                this.tripId=tripDetail.getTripId();
                this.tripDesc=tripDetail.getTripDesc();
                this.stopId=tripDetail.getStopId();
                this.stopDescription=tripDetail.getStopDescription();
                

            }
            //branchList = branchDao.branchList();
            //centerList = centerDao.buildCenters();
            tripList=tripDao.buildTrips(branchId, centerId);

        } catch (Exception ex) {
            Logger.getLogger(AddEditTripDetailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveTripDetail() {

        TripDetail tripDetail = new TripDetail();

        try {
            tripDetail.setBranchId(branchId);
            tripDetail.setBranchName(branchDesc);
            tripDetail.setCenterId(centerId);
            tripDetail.setCenterName(centerDesc);
            tripDetail.setStopDescription(stopDescription);
            tripDetail.setStopId(stopId);
            tripDetail.setTripDesc(tripDesc);
            tripDetail.setTripId(tripId);
                    

            if (sessionBean.getSelectedItemId() > 0) {

                tripDetailDao.updateTripDetail(tripDetail);
            } else {

                tripDetailDao.insertTripDteail(tripDetail);
            }

        } catch (Exception ex) {
            Logger.getLogger(AddEditTripDetailBean.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

        sessionBean.navigate("/hoffaz/admin/manage_tripDetail.xhtml");

    }
    
}
