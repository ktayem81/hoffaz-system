/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

import java.io.Serializable;

/**
 *
 * @author eng_ayman
 */
public class Branch implements Serializable{
    
   private int branchId;
   private String branchName;
   private String description;
   private String phone;
   private int governorateId;
   private String governorateDesc;

    public Branch() {
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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

    public int getGovernorateId() {
        return governorateId;
    }

    public void setGovernorateId(int governorateId) {
        this.governorateId = governorateId;
    }

    public String getGovernorateDesc() {
        return governorateDesc;
    }

    public void setGovernorateDesc(String governorateDesc) {
        this.governorateDesc = governorateDesc;
    }
    
    
    
   
}
