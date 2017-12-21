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
public class Province {
    private int province_Id;
    private String province_Name;

    public Province() {
    }

    public Province(int province_Id, String province_Name) {
        this.province_Id = province_Id;
        this.province_Name = province_Name;
    }
    

    public int getProvince_Id() {
        return province_Id;
    }

    public void setProvince_Id(int province_Id) {
        this.province_Id = province_Id;
    }

    public String getProvince_Name() {
        return province_Name;
    }

    public void setProvince_Name(String province_Name) {
        this.province_Name = province_Name;
    }
    
    
}
