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
public class Employee_Category {
    private int employee_Category_Id;
    private int category_Description;

    public Employee_Category() {
    }

    public Employee_Category(int employee_Category_Id, int category_Description) {
        this.employee_Category_Id = employee_Category_Id;
        this.category_Description = category_Description;
    }

    public int getEmployee_Category_Id() {
        return employee_Category_Id;
    }

    public void setEmployee_Category_Id(int employee_Category_Id) {
        this.employee_Category_Id = employee_Category_Id;
    }

    public int getCategory_Description() {
        return category_Description;
    }

    public void setCategory_Description(int category_Description) {
        this.category_Description = category_Description;
    }
    

}
