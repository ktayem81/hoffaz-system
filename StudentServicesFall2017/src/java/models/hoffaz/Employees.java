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
    private int employee_Id;
private String first_Name;
private String second_name;
private String thirdname;
private String family_name;
private int branch_Id;
private int center_Id;
private int phone;
private int whatsup;
private String address_Detials;
private int nationality;
private int nationality_Id;
private int employee_Category_Id;
private int salary;

    public Employees() {
    }

    public Employees(int employee_Id, String first_Name, String second_name, String thirdname, String family_name, int branch_Id, int center_Id, int phone, int whatsup, String address_Detials, int nationality, int nationality_Id, int employee_Category_Id, int salary) {
        this.employee_Id = employee_Id;
        this.first_Name = first_Name;
        this.second_name = second_name;
        this.thirdname = thirdname;
        this.family_name = family_name;
        this.branch_Id = branch_Id;
        this.center_Id = center_Id;
        this.phone = phone;
        this.whatsup = whatsup;
        this.address_Detials = address_Detials;
        this.nationality = nationality;
        this.nationality_Id = nationality_Id;
        this.employee_Category_Id = employee_Category_Id;
        this.salary = salary;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public int getBranch_Id() {
        return branch_Id;
    }

    public void setBranch_Id(int branch_Id) {
        this.branch_Id = branch_Id;
    }

    public int getCenter_Id() {
        return center_Id;
    }

    public void setCenter_Id(int center_Id) {
        this.center_Id = center_Id;
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

    public String getAddress_Detials() {
        return address_Detials;
    }

    public void setAddress_Detials(String address_Detials) {
        this.address_Detials = address_Detials;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public int getNationality_Id() {
        return nationality_Id;
    }

    public void setNationality_Id(int nationality_Id) {
        this.nationality_Id = nationality_Id;
    }

    public int getEmployee_Category_Id() {
        return employee_Category_Id;
    }

    public void setEmployee_Category_Id(int employee_Category_Id) {
        this.employee_Category_Id = employee_Category_Id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}
