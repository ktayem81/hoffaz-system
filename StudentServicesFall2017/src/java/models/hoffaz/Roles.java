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
public class Roles {
    private int role_Id;
   private String role_Description;

    public Roles() {
    }

    public Roles(int role_Id, String role_Description) {
        this.role_Id = role_Id;
        this.role_Description = role_Description;
    }

    public int getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(int role_Id) {
        this.role_Id = role_Id;
    }

    public String getRole_Description() {
        return role_Description;
    }

    public void setRole_Description(String role_Description) {
        this.role_Description = role_Description;
    }

    
}
