/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author khale
 */
@Named(value = "addEmployeeTutorialBean")
@ViewScoped
public class AddEmployeeTutorialBean implements Serializable{

    /**
     * Creates a new instance of AddEmployeeTutorialBean
     */
    private int course_id;
     private String course_name;
      private String course_Description;
    
    public AddEmployeeTutorialBean() {
    }

    /**
     * @return the course_id
     */
    public int getCourse_id() {
        return course_id;
    }

    /**
     * @param course_id the course_id to set
     */
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    /**
     * @return the course_name
     */
    public String getCourse_name() {
        return course_name;
    }

    /**
     * @param course_name the course_name to set
     */
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    /**
     * @return the course_Description
     */
    public String getCourse_Description() {
        return course_Description;
    }

    /**
     * @param course_Description the course_Description to set
     */
    public void setCourse_Description(String course_Description) {
        this.course_Description = course_Description;
    }
    
}
