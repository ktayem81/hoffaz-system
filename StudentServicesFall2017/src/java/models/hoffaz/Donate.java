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
public class Donate {

    private int branchId;
    private String branchName;
    private int centerId;
    private String centerName;
    private int donateId;
    private String donaterName;
    private double donateAmount;
    private int insertEmployeeId;
    private String insertHostIp;    
    private Timestamp insertDate;      
    private String insertHostOS;  


    public Donate() {
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getDonateId() {
        return donateId;
    }

    public void setDonateId(int donateId) {
        this.donateId = donateId;
    }

    public String getDonaterName() {
        return donaterName;
    }

    public void setDonaterName(String donaterName) {
        this.donaterName = donaterName;
    }

    public double getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(double donateAmount) {
        this.donateAmount = donateAmount;
    }

    public int getInsertEmployeeId() {
        return insertEmployeeId;
    }

    public void setInsertEmployeeId(int insertEmployeeId) {
        this.insertEmployeeId = insertEmployeeId;
    }

    public String getInsertHostIp() {
        return insertHostIp;
    }

    public void setInsertHostIp(String insertHostIp) {
        this.insertHostIp = insertHostIp;
    }

    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    public String getInsertHostOS() {
        return insertHostOS;
    }

    public void setInsertHostOS(String insertHostOS) {
        this.insertHostOS = insertHostOS;
    }

    

}
