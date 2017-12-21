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
public class Class_Room {
    private int class_Room_Id;
    private int semester_Id;
    private int year;
    private int class_ID;
    private int level_ID;
    private int employee_Id;
    private int cost;
    public Class_Room() {
    }

    public Class_Room(int class_Room_Id, int semester_Id, int year, int class_ID, int level_ID, int employee_Id, int cost) {
        this.class_Room_Id = class_Room_Id;
        this.semester_Id = semester_Id;
        this.year = year;
        this.class_ID = class_ID;
        this.level_ID = level_ID;
        this.employee_Id = employee_Id;
        this.cost = cost;
    }

    public int getClass_Room_Id() {
        return class_Room_Id;
    }

    public void setClass_Room_Id(int class_Room_Id) {
        this.class_Room_Id = class_Room_Id;
    }

    public int getSemester_Id() {
        return semester_Id;
    }

    public void setSemester_Id(int semester_Id) {
        this.semester_Id = semester_Id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getClass_ID() {
        return class_ID;
    }

    public void setClass_ID(int class_ID) {
        this.class_ID = class_ID;
    }

    public int getLevel_ID() {
        return level_ID;
    }

    public void setLevel_ID(int level_ID) {
        this.level_ID = level_ID;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        this.employee_Id = employee_Id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
        
}
