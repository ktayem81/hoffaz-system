/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import java.io.Serializable;
import javax.inject.Named;

import javax.faces.view.ViewScoped;

/**
 *
 * @author khale
 */
@Named(value = "addSectionBean")
@ViewScoped
public class AddSectionBean implements Serializable{

    /**
     * Creates a new instance of AddSectionBean
     */
    private String semaster;
    private String section_year;
    private String section_class;
    private String section_level;
    private String instructor;
    
    public AddSectionBean() {
    }

    /**
     * @return the semaster
     */
    public String getSemaster() {
        return semaster;
    }

    /**
     * @param semaster the semaster to set
     */
    public void setSemaster(String semaster) {
        this.semaster = semaster;
    }

    /**
     * @return the section_year
     */
    public String getSection_year() {
        return section_year;
    }

    /**
     * @param section_year the section_year to set
     */
    public void setSection_year(String section_year) {
        this.section_year = section_year;
    }

    /**
     * @return the section_class
     */
    public String getSection_class() {
        return section_class;
    }

    /**
     * @param section_class the section_class to set
     */
    public void setSection_class(String section_class) {
        this.section_class = section_class;
    }

    /**
     * @return the section_level
     */
    public String getSection_level() {
        return section_level;
    }

    /**
     * @param section_level the section_level to set
     */
    public void setSection_level(String section_level) {
        this.section_level = section_level;
    }

    /**
     * @return the instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
}
