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
public class Donates {
   private int  donateid;
private String donatername;
private int amount;
private Timestamp insertdate;
private int insertemployeeid;
private String inserthostip;
private String inserthostos;
 private int  branchID;
private int centerID;
 public Donates() {
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public int getCenterID() {
        return centerID;
    }

    public void setCenterID(int centerID) {
        this.centerID = centerID;
    }
    public int getDonateid() {
        return donateid;
    }

    public void setDonateid(int donateid) {
        this.donateid = donateid;
    }

    public String getDonatername() {
        return donatername;
    }

    public void setDonatername(String donatername) {
        this.donatername = donatername;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInsertemployeeid() {
        return insertemployeeid;
    }

    public void setInsertemployeeid(int insertemployeeid) {
        this.insertemployeeid = insertemployeeid;
    }

    public String getInserthostip() {
        return inserthostip;
    }

    public void setInserthostip(String inserthostip) {
        this.inserthostip = inserthostip;
    }

    public Timestamp getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Timestamp insertdate) {
        this.insertdate = insertdate;
    }

    public String getInserthostos() {
        return inserthostos;
    }

    public void setInserthostos(String inserthostos) {
        this.inserthostos = inserthostos;
    }

}
