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
public class Center {
    private int branch_Id;
    private int center_Id;
private String center_Name;
   private String description;
 private String phone;
    public Center(int branch_Id, int center_Id, String center_Name, String description, String phone) {
        this.branch_Id = branch_Id;
        this.center_Id = center_Id;
        this.center_Name = center_Name;
        this.description = description;
        this.phone = phone;
    }

    public Center() {
    }

    public int getBranch_Id() {
        return branch_Id;
    }

    public void setBranch_Id(int branch_Id) {
        this.branch_Id = branch_Id;
    }

    public int getCenter_Id() {
        return center_Id;
    }

    public void setCenter_Id(int center_Id) {
        this.center_Id = center_Id;
    }

    public String getCenter_Name() {
        return center_Name;
    }

    public void setCenter_Name(String center_Name) {
        this.center_Name = center_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
  

}
