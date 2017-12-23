/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import daos.hoffaz.AddClassLevelDao;


/**
 *
 * @author khale
 */
@Named(value = "addLevelClassBean")
@ViewScoped
public class AddClassLevelBean {

    /**
     * Creates a new instance of AddLevelClassBean
     */
    private final AddClassLevelDao addclassleveldaoDao = new AddClassLevelDao();
    
   
    private ArrayList<Class> class_List=new ArrayList<Class>();
    private int class_id;
    private int level_id;
    private String level_Name;
    private String description;
    public AddClassLevelBean() {
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public String getLevel_Name() {
        return level_Name;
    }

    public void setLevel_Name(String level_Name) {
        this.level_Name = level_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
