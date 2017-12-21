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
public class Payments {
   private int paymentid;
private int semester_Id;
private int type;
private int std_Id;
private int month;
private int year;
Timestamp date;
private int amount;
private int insert_Employee_Id;
private int inserthost_Ip;
Timestamp insert_Date;
private String insert_Host_Os;
private int updat_Employee_Id;
Timestamp update_Date;
private String update_HostIp;
private String update_Host_Os;

    public Payments() {
    }

    public Payments(int paymentid, int semester_Id, int type, int std_Id, int month, int year, Timestamp date, int amount, int insert_Employee_Id, int inserthost_Ip, Timestamp insert_Date, String insert_Host_Os, int updat_Employee_Id, Timestamp update_Date, String update_HostIp, String update_Host_Os) {
        this.paymentid = paymentid;
        this.semester_Id = semester_Id;
        this.type = type;
        this.std_Id = std_Id;
        this.month = month;
        this.year = year;
        this.date = date;
        this.amount = amount;
        this.insert_Employee_Id = insert_Employee_Id;
        this.inserthost_Ip = inserthost_Ip;
        this.insert_Date = insert_Date;
        this.insert_Host_Os = insert_Host_Os;
        this.updat_Employee_Id = updat_Employee_Id;
        this.update_Date = update_Date;
        this.update_HostIp = update_HostIp;
        this.update_Host_Os = update_Host_Os;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public int getSemester_Id() {
        return semester_Id;
    }

    public void setSemester_Id(int semester_Id) {
        this.semester_Id = semester_Id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStd_Id() {
        return std_Id;
    }

    public void setStd_Id(int std_Id) {
        this.std_Id = std_Id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInsert_Employee_Id() {
        return insert_Employee_Id;
    }

    public void setInsert_Employee_Id(int insert_Employee_Id) {
        this.insert_Employee_Id = insert_Employee_Id;
    }

    public int getInserthost_Ip() {
        return inserthost_Ip;
    }

    public void setInserthost_Ip(int inserthost_Ip) {
        this.inserthost_Ip = inserthost_Ip;
    }

    public Timestamp getInsert_Date() {
        return insert_Date;
    }

    public void setInsert_Date(Timestamp insert_Date) {
        this.insert_Date = insert_Date;
    }

    public String getInsert_Host_Os() {
        return insert_Host_Os;
    }

    public void setInsert_Host_Os(String insert_Host_Os) {
        this.insert_Host_Os = insert_Host_Os;
    }

    public int getUpdat_Employee_Id() {
        return updat_Employee_Id;
    }

    public void setUpdat_Employee_Id(int updat_Employee_Id) {
        this.updat_Employee_Id = updat_Employee_Id;
    }

    public Timestamp getUpdate_Date() {
        return update_Date;
    }

    public void setUpdate_Date(Timestamp update_Date) {
        this.update_Date = update_Date;
    }

    public String getUpdate_HostIp() {
        return update_HostIp;
    }

    public void setUpdate_HostIp(String update_HostIp) {
        this.update_HostIp = update_HostIp;
    }

    public String getUpdate_Host_Os() {
        return update_Host_Os;
    }

    public void setUpdate_Host_Os(String update_Host_Os) {
        this.update_Host_Os = update_Host_Os;
    }

    
}
