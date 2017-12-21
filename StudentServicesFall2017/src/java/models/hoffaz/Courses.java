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
public class Courses {
    private int course_Id;
    private String course_Name;
    private String course_description;

    public Courses() {
    }

    public Courses(int course_Id, String course_Name, String course_description) {
        this.course_Id = course_Id;
        this.course_Name = course_Name;
        this.course_description = course_description;
    }

    public int getCourse_Id() {
        return course_Id;
    }

    public void setCourse_Id(int course_Id) {
        this.course_Id = course_Id;
    }

    public String getCourse_Name() {
        return course_Name;
    }

    public void setCourse_Name(String course_Name) {
        this.course_Name = course_Name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }
    
}
