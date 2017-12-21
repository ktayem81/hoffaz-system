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
public class Branch {
    
   private int branch_Id;
   private String branch_Name;
   private String description;
   private String phone;
   
   public Branch(int branch_Id,String branch_Name,String description,String phone){
   this.branch_Id=branch_Id;
   this.branch_Name=branch_Name;
   this.description=description;
   this.phone=phone;   
   }

    public Branch() {
    }
   

    /**
     * @return the branch_Id
     */
    public int getBranch_Id() {
        return branch_Id;
    }

    /**
     * @param branch_Id the branch_Id to set
     */
    public void setBranch_Id(int branch_Id) {
        this.branch_Id = branch_Id;
    }

    /**
     * @return the branch_Name
     */
    public String getBranch_Name() {
        return branch_Name;
    }

    /**
     * @param branch_Name the branch_Name to set
     */
    public void setBranch_Name(String branch_Name) {
        this.branch_Name = branch_Name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
   
}
