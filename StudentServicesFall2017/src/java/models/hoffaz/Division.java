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
 

public class Division {
    private int semester_id;
    private String year;
    private int division_id; 
    private String class_name;
    private String level_name;
    private String instructer_name;
    private String comments;

    public Division() {
    }

    public Division(int semester_id, String year, int division_id, String class_name, String level_name, String instructer_name, String comments) {
        this.semester_id = semester_id;
        this.year = year;
        this.division_id = division_id;
        this.class_name = class_name;
        this.level_name = level_name;
        this.instructer_name = instructer_name;
        this.comments = comments;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getInstructer_name() {
        return instructer_name;
    }

    public void setInstructer_name(String instructer_name) {
        this.instructer_name = instructer_name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
}
