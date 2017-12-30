/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.AddBranchDao;
import daos.hoffaz.ProvinceDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Branch;
import models.hoffaz.Province;
import org.primefaces.event.SelectEvent;

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
    private final AddBranchDao addBranchDao = new AddBranchDao();
    private final ProvinceDao provinceDao = new ProvinceDao();
    private ArrayList<Province> province_List=new ArrayList<Province>();
    private ArrayList<Branch> branches;
    private Branch selectedBranch;
    private int branch_num;
    private String branch_name;
    
    @Inject 
    SessionBean sessionBean;
    
    @PostConstruct
    public void init() {
        
    }
    
    
    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public Branch getSelectedBranch() {
        return selectedBranch;
    }

    public void setSelectedBranch(Branch selectedBranch) {
        this.selectedBranch = selectedBranch;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }
    private String telephone;
    private String comments;
    private int province;
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
    public void saveBranch() {
        
        
        Branch branch = new Branch();
        
        try {
            branch.setBranch_Id(branch_num);
            branch.setBranch_Name(branch_name);
            branch.setDescription(comments);
            branch.setPhone(telephone);
            branch.setProvince(province);
            
            
       
            
            
            
            
            
           
            
        } catch (Exception ex) {
            
            
        }

        
    }
    
    public void onRowSelect(SelectEvent branch) {
        FacesMessage msg = new FacesMessage("student Selected", ((branch) branch.getObject()).getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void deleteSelectedBranch(){
        try {
            AddBranchDao.deleteBranch(selectedBranch.getStudentId(), sessionBean.getBranchId(), sessionBean.getCenterId());
            
        } catch (Exception ex) {
            Logger.getLogger(ManageStudentsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedBranch.getStudentId());
    }
   
}
