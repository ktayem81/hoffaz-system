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
public class Employees_Courses {
   private int employee_Id;
   private int courseId;
   private Timestamp date;
   private int duration;
   private String description;
   private String took_Place_In;
   private String certficat_Number;

    public Employees_Courses() {
    }

    public Employees_Courses(int employee_Id, int courseId, Timestamp date, int duration, String description, String took_Place_In, String certficat_Number) {
        this.employee_Id = employee_Id;
        this.courseId = courseId;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.took_Place_In = took_Place_In;
        this.certficat_Number = certficat_Number;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        this.employee_Id = employee_Id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTook_Place_In() {
        return took_Place_In;
    }

    public void setTook_Place_In(String took_Place_In) {
        this.took_Place_In = took_Place_In;
    }

    public String getCertficat_Number() {
        return certficat_Number;
    }

    public void setCertficat_Number(String certficat_Number) {
        this.certficat_Number = certficat_Number;
    }


    
}
