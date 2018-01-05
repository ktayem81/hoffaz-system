/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author eng_ayman
 */
public class Employees_Courses implements Serializable{
   private int employeeId;
   private int courseId;
   private Timestamp date;
   private int duration;
   private String description;
   private String place;
   private String certficatNumber;

    public Employees_Courses() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCertficatNumber() {
        return certficatNumber;
    }

    public void setCertficatNumber(String certficatNumber) {
        this.certficatNumber = certficatNumber;
    }

   

    
}
