/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.CenterDao;
import daos.hoffaz.CourseDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Center;
import models.hoffaz.Courses;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khale
 */
@Named(value = "ManageCoursesBean")
@ViewScoped
public class ManageCoursesBean implements Serializable {

    /**
     * Creates a new instance of ManageCourses
     */
     private Courses selectedCourse;
    private ArrayList<Courses> courses;
    private final CourseDao courseDao = new CourseDao();
    
    @Inject 
    private SessionBean sessionBean;
    
    public ManageCoursesBean() {
    }
     @PostConstruct
    public void init(){
        try {
            this.courses = courseDao.buildCourses();
        } catch (Exception ex) {
            Logger.getLogger(ManageCoursesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Courses getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Courses selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public ArrayList<Courses> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Courses> courses) {
        this.courses = courses;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
   

    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedCourse.getCourseId());
    }
    public void onRowSelect(SelectEvent course) {
        FacesMessage msg = new FacesMessage("course Selected", ((Courses) course.getObject()).getCourseName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void deleteSelectedCourse(){
        try {
            courseDao.deleteCourse(selectedCourse.getCourseId());
            
        } catch (Exception ex) {
            Logger.getLogger(ManageCoursesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
