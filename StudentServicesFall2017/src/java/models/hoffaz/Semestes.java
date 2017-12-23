/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

import java.sql.Timestamp;

/**
 *
 * @author eng_ayman
 */
public class Semestes {
   private int semester_Id;
   private String  comments;
   private String description;
   private Timestamp semester_begin;
   private Timestamp semester_end;

    public Semestes() {
    }

    public Semestes(int semester_Id, String comments, String description, Timestamp semester_begin, Timestamp semester_end) {
        this.semester_Id = semester_Id;
        this.comments = comments;
        this.description = description;
        this.semester_begin = semester_begin;
        this.semester_end = semester_end;
    }

    public int getSemester_Id() {
        return semester_Id;
    }

    public void setSemester_Id(int semester_Id) {
        this.semester_Id = semester_Id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getSemester_begin() {
        return semester_begin;
    }

    public void setSemester_begin(Timestamp semester_begin) {
        this.semester_begin = semester_begin;
    }

    public Timestamp getSemester_end() {
        return semester_end;
    }

    public void setSemester_end(Timestamp semester_end) {
        this.semester_end = semester_end;
    }

   

    

   
   

    
}
