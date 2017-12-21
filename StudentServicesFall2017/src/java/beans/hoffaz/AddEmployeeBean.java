/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author khale
 */
@Named(value = "addEmployeeBean")
@ViewScoped
public class AddEmployeeBean implements  Serializable{

    /**
     * Creates a new instance of AddEmployeeBean
     */
    private int employee_Num;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String familyName;
    private String  branch_Name;
    private String  center_Name;
    private String phone;
    private String whatsup;
    private String address;
    private String nationalityDesc;
    private int nationality;
    private String Role;
    private double salary;
    private int course_id;
    private String course_name;
    private Timestamp dateOfcourse;
    private String duration;
    private String course_place;
    private String certificate_num;
    private String comments;
    
     
    
    
    
    public AddEmployeeBean() {
    }

    /**
     * @return the employee_Num
     */
    public int getEmployee_Num() {
        return employee_Num;
    }

    /**
     * @param employee_Num the employee_Num to set
     */
    public void setEmployee_Num(int employee_Num) {
        this.employee_Num = employee_Num;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the secondName
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @param secondName the secondName to set
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * @return the thirdName
     */
    public String getThirdName() {
        return thirdName;
    }

    /**
     * @param thirdName the thirdName to set
     */
    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    /**
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * @param familyName the familyName to set
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * @return the branch_Name
     */
    public String getBranch_Name() {
        return branch_Name;
    }

    /**
     * @param branch_Name the branch_Name to set
     */
    public void setBranch_Name(String branch_Name) {
        this.branch_Name = branch_Name;
    }

    /**
     * @return the center_Name
     */
    public String getCenter_Name() {
        return center_Name;
    }

    /**
     * @param center_Name the center_Name to set
     */
    public void setCenter_Name(String center_Name) {
        this.center_Name = center_Name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the whatsup
     */
    public String getWhatsup() {
        return whatsup;
    }

    /**
     * @param whatsup the whatsup to set
     */
    public void setWhatsup(String whatsup) {
        this.whatsup = whatsup;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the nationalityDesc
     */
    public String getNationalityDesc() {
        return nationalityDesc;
    }

    /**
     * @param nationalityDesc the nationalityDesc to set
     */
    public void setNationalityDesc(String nationalityDesc) {
        this.nationalityDesc = nationalityDesc;
    }

    /**
     * @return the nationality
     */
    public int getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the Role
     */
    public String getRole() {
        return Role;
    }

    /**
     * @param Role the Role to set
     */
    public void setRole(String Role) {
        this.Role = Role;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
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
     * @return the dateOfcourse
     */
    public Timestamp getDateOfcourse() {
        return dateOfcourse;
    }

    /**
     * @param dateOfcourse the dateOfcourse to set
     */
    public void setDateOfcourse(Timestamp dateOfcourse) {
        this.dateOfcourse = dateOfcourse;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the course_place
     */
    public String getCourse_place() {
        return course_place;
    }

    /**
     * @param course_place the course_place to set
     */
    public void setCourse_place(String course_place) {
        this.course_place = course_place;
    }

    /**
     * @return the certificate_num
     */
    public String getCertificate_num() {
        return certificate_num;
    }

    /**
     * @param certificate_num the certificate_num to set
     */
    public void setCertificate_num(String certificate_num) {
        this.certificate_num = certificate_num;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
