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
public class Login_Audit {
   private int employee_Id;
private String host_Ip;
private String host_Os;
private int login_Date;
private int login_Success;

    public Login_Audit() {
    }

    public Login_Audit(int employee_Id, String host_Ip, String host_Os, int login_Date, int login_Success) {
        this.employee_Id = employee_Id;
        this.host_Ip = host_Ip;
        this.host_Os = host_Os;
        this.login_Date = login_Date;
        this.login_Success = login_Success;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getHost_Ip() {
        return host_Ip;
    }

    public void setHost_Ip(String host_Ip) {
        this.host_Ip = host_Ip;
    }

    public String getHost_Os() {
        return host_Os;
    }

    public void setHost_Os(String host_Os) {
        this.host_Os = host_Os;
    }

    public int getLogin_Date() {
        return login_Date;
    }

    public void setLogin_Date(int login_Date) {
        this.login_Date = login_Date;
    }

    public int getLogin_Success() {
        return login_Success;
    }

    public void setLogin_Success(int login_Success) {
        this.login_Success = login_Success;
    }

}
