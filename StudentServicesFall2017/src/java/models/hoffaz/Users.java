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
public class Users {
    private int employee_Id;
private String user_Name;
private String password;
 private int password_Hash;
private String salt;
private String hash_Function;
 private int lock;

    public Users() {
    }

    public Users(int employee_Id, String user_Name, String password, int password_Hash, String salt, String hash_Function, int lock) {
        this.employee_Id = employee_Id;
        this.user_Name = user_Name;
        this.password = password;
        this.password_Hash = password_Hash;
        this.salt = salt;
        this.hash_Function = hash_Function;
        this.lock = lock;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPassword_Hash() {
        return password_Hash;
    }

    public void setPassword_Hash(int password_Hash) {
        this.password_Hash = password_Hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash_Function() {
        return hash_Function;
    }

    public void setHash_Function(String hash_Function) {
        this.hash_Function = hash_Function;
    }

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }

}
