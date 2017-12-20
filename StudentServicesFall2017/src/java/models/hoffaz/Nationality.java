/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

/**
 *
 * @author khaled
 */
public class Nationality {
    private int nationality;
    private String nationalityDesc;

    public Nationality(int nationality, String nationalityDesc) {
        this.nationality = nationality;
        this.nationalityDesc = nationalityDesc;
    }

    public Nationality() {
         }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public String getNationalityDesc() {
        return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc) {
        this.nationalityDesc = nationalityDesc;
    }
    
    
}
