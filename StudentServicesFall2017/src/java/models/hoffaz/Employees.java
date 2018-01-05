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
public class Employees {
private int employeeId;
private String firstName;
private String secondName;
private String thirdName;
private String familyName;
private int branchId;
private String branchDesc;
private int centerId;
private String centerDesc;
private int phone;
private int whatsup;
private String addressDetials;

    
private int nationality;
private String nationalityDesc;
private int nationalityId;


    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }
    private int employeeCategoryId;
    private String employeeCategoryDesc;
    private int salary;

    public Employees() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchDesc() {
        return branchDesc;
    }

    public void setBranchDesc(String branchDesc) {
        this.branchDesc = branchDesc;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterDesc() {
        return centerDesc;
    }

    public void setCenterDesc(String centerDesc) {
        this.centerDesc = centerDesc;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getWhatsup() {
        return whatsup;
    }

    public void setWhatsup(int whatsup) {
        this.whatsup = whatsup;
    }

    public String getAddressDetials() {
        return addressDetials;
    }

    public void setAddressDetials(String addressDetials) {
        this.addressDetials = addressDetials;
    }

    public String getNationalityDesc() {
        return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc) {
        this.nationalityDesc = nationalityDesc;
    }

    public int getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(int nationalityId) {
        this.nationalityId = nationalityId;
    }

    public int getEmployeeCategoryId() {
        return employeeCategoryId;
    }

    public void setEmployeeCategoryId(int employeeCategoryId) {
        this.employeeCategoryId = employeeCategoryId;
    }

    public String getEmployeeCategoryDesc() {
        return employeeCategoryDesc;
    }

    public void setEmployeeCategoryDesc(String employeeCategoryDesc) {
        this.employeeCategoryDesc = employeeCategoryDesc;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    

    
}
