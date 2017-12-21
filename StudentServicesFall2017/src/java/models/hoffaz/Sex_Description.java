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
public class Sex_Description {
    private int sex_Id;
private String description;

    public Sex_Description() {
    }

    public Sex_Description(int sex_Id, String description) {
        this.sex_Id = sex_Id;
        this.description = description;
    }

    public int getSex_Id() {
        return sex_Id;
    }

    public void setSex_Id(int sex_Id) {
        this.sex_Id = sex_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
