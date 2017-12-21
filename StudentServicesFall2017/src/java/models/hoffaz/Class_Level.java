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
public class Class_Level {
 private int class_ID;
  private int level_ID;
  private String level_Name;  
  private String description;
  public Class_Level() {
    }

    public Class_Level(int class_ID, int level_ID, String level_Name, String description) {
        this.class_ID = class_ID;
        this.level_ID = level_ID;
        this.level_Name = level_Name;
        this.description = description;
    }

    public int getClass_ID() {
        return class_ID;
    }

    public void setClass_ID(int class_ID) {
        this.class_ID = class_ID;
    }

    public int getLevel_ID() {
        return level_ID;
    }

    public void setLevel_ID(int level_ID) {
        this.level_ID = level_ID;
    }

    public String getLevel_Name() {
        return level_Name;
    }

    public void setLevel_Name(String level_Name) {
        this.level_Name = level_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
