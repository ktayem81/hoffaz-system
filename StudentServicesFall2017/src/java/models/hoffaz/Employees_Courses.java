/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 *
 * @author eng_ayman
 */
public class Employees_Courses implements Serializable{
   private int employeeId;
   private int courseId;
   private Date dateOf;
   private int duration;
   private String description;
   private String place;
   private String certficatNumber;
  private Timestamp updateDate; 

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
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

    public Date getDateOf() {
        return dateOf;
    }

    public void setDateOf(Date dateOf) {
        this.dateOf = dateOf;
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

    public void setDate(Timestamp timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
}
