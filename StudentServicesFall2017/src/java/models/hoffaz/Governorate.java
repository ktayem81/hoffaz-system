/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

/**
 *
 * @author eng_ayman
 */
public class Governorate {
    private int governorate_Id;
private String description;


    public Governorate() {
    }

    public Governorate(int governorate_Id, String description) {
        this.governorate_Id = governorate_Id;
        this.description = description;
    }

    public int getGovernorate_Id() {
        return governorate_Id;
    }

    public void setGovernorate_Id(int governorate_Id) {
        this.governorate_Id = governorate_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
