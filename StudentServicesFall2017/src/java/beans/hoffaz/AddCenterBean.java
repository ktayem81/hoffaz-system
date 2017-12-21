/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author khale
 */
@Named(value = "addCenterBean")
@ViewScoped
public class AddCenterBean {

    /**
     * Creates a new instance of AddCenterBean
     */
    private String branch_Name;
    private int center_Num;
    private String center_Name;
     private String telephone;
    private String comments;
    public AddCenterBean() {
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
     * @return the center_Num
     */
    public int getCenter_Num() {
        return center_Num;
    }

    /**
     * @param center_Num the center_Num to set
     */
    public void setCenter_Num(int center_Num) {
        this.center_Num = center_Num;
    }

    /**
     * @return the center_Name
     */
    public String getCenter_Name() {
        return center_Name;
    }

    /**
     * @param center_Name the center_Name to set
     */
    public void setCenter_Name(String center_Name) {
        this.center_Name = center_Name;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
