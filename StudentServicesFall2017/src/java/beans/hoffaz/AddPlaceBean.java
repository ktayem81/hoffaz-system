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
@Named(value = "addPlaceBean")
@ViewScoped
public class AddPlaceBean implements Serializable{

    /**
     * Creates a new instance of AddPlaceBean
     */
    private String line_name;
    private int region_num ;
    private String region_name ;
    public AddPlaceBean() {
    }

    /**
     * @return the line_name
     */
    public String getLine_name() {
        return line_name;
    }

    /**
     * @param line_name the line_name to set
     */
    public void setLine_name(String line_name) {
        this.line_name = line_name;
    }

    /**
     * @return the region_num
     */
    public int getRegion_num() {
        return region_num;
    }

    /**
     * @param region_num the region_num to set
     */
    public void setRegion_num(int region_num) {
        this.region_num = region_num;
    }

    /**
     * @return the region_name
     */
    public String getRegion_name() {
        return region_name;
    }

    /**
     * @param region_name the region_name to set
     */
    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }
    
}
