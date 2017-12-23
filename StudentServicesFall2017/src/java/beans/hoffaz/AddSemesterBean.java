/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.AddSemesterDao;
import java.sql.Timestamp;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;

/**
 *
 * @author khale
 */
@Named(value = "addSemesterBean")
@ViewScoped
public class AddSemesterBean {

    /**
     * Creates a new instance of AddSemesterBean
     */
     private final AddSemesterDao addSemestertDao = new AddSemesterDao();
   private int semester_Id;
   private String  comments;
   private String description;

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
   private Timestamp semester_begin;
   private Timestamp semester_end;
    public AddSemesterBean() {
    }
    
}
