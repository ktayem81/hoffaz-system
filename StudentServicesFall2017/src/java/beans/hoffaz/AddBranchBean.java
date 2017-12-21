/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import models.hoffaz.Province;

/**
 *
 * @author khale
 */
@Named(value = "addBranchBean")
@ViewScoped
public class AddBranchBean implements Serializable{

    /**
     * Creates a new instance of AddBranchBean
     */
    private String branch_name;
    private ArrayList<Province> province_List=new ArrayList<Province>();
    private int branch_num;
    private String telephone;
    private String comments;
    public AddBranchBean() {
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
     * @return the province_List
     */
    public ArrayList<Province> getProvince_List() {
        return province_List;
    }

    /**
     * @param province_List the province_List to set
     */
    public void setProvince_List(ArrayList<Province> province_List) {
        this.province_List = province_List;
    }

    /**
     * @return the branch_num
     */
    public int getBranch_num() {
        return branch_num;
    }

    /**
     * @param branch_num the branch_num to set
     */
    public void setBranch_num(int branch_num) {
        this.branch_num = branch_num;
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

    /**
     * @return the branch_name
     */
   
}
