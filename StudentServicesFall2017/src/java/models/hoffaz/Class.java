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
public class Class {
    private int class_ID;
    private String class_Name;
    private int age_From;
    private int age_to;
    private String description;

    public Class() {
    }

    public Class(int class_ID, String class_Name, int age_From, int age_to, String description) {
        this.class_ID = class_ID;
        this.class_Name = class_Name;
        this.age_From = age_From;
        this.age_to = age_to;
        this.description = description;
    }

    public int getClass_ID() {
        return class_ID;
    }

    public void setClass_ID(int class_ID) {
        this.class_ID = class_ID;
    }

    public String getClass_Name() {
        return class_Name;
    }

    public void setClass_Name(String class_Name) {
        this.class_Name = class_Name;
    }

    public int getAge_From() {
        return age_From;
    }

    public void setAge_From(int age_From) {
        this.age_From = age_From;
    }

    public int getAge_to() {
        return age_to;
    }

    public void setAge_to(int age_to) {
        this.age_to = age_to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
