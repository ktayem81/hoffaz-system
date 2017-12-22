/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

/**
 *
 * @author khale
 */
public class Place {
    private String place_Name;
    private String line_Name;
    private int region_num;

    /**
     * @return the place_Name
     */
    public String getPlace_Name() {
        return place_Name;
    }

    public Place(String place_Name, String line_Name, int region_num) {
        this.place_Name = place_Name;
        this.line_Name = line_Name;
        this.region_num = region_num;
    }

    public Place() {
    }

    /**
     * @param place_Name the place_Name to set
     */
    public void setPlace_Name(String place_Name) {
        this.place_Name = place_Name;
    }

    /**
     * @return the line_Name
     */
    public String getLine_Name() {
        return line_Name;
    }

    /**
     * @param line_Name the line_Name to set
     */
    public void setLine_Name(String line_Name) {
        this.line_Name = line_Name;
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
    
    
}
