/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author khale
 */
@Named(value = "addTripBean")
@ViewScoped
public class AddTripBean implements  Serializable{

    /**
     * Creates a new instance of AddTripBean
     */
    private String branch_name ;
    private String center_name ;
    private String trip_id;
    private String trip_name;
    private String driver_name;
    
    public AddTripBean() {
    }

    /**
     * @return the branch_name
     */
    public String getBranch_name() {
        return branch_name;
    }

    /**
     * @param branch_name the branch_name to set
     */
    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    /**
     * @return the center_name
     */
    public String getCenter_name() {
        return center_name;
    }

    /**
     * @param center_name the center_name to set
     */
    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

    /**
     * @return the trip_id
     */
    public String getTrip_id() {
        return trip_id;
    }

    /**
     * @param trip_id the trip_id to set
     */
    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    /**
     * @return the trip_name
     */
    public String getTrip_name() {
        return trip_name;
    }

    /**
     * @param trip_name the trip_name to set
     */
    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    /**
     * @return the driver_name
     */
    public String getDriver_name() {
        return driver_name;
    }

    /**
     * @param driver_name the driver_name to set
     */
    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }
    
}
