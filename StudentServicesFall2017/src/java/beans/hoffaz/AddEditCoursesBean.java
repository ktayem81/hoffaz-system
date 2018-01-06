/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.CourseDao;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Courses;

/**
 *
 * @author khale
 */
@Named(value = "addEditCoursesBean")
@ViewScoped
public class AddEditCoursesBean implements Serializable  {

    /**
     * Creates a new instance of AddEditCoursesBean
     */
     private final CourseDao courseDao = new CourseDao();
      private int courseId;
    private String courseName;
    private String courseDescription;
    @Inject
    SessionBean sessionBean;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    public AddEditCoursesBean() {
    }
    @PostConstruct
    public void init() {

        courseId = sessionBean.getSelectedItemId();

        try {
            if (courseId > 0) {
                //get selected branch fro DB
                Courses course = courseDao.getCourse(courseId);

                this.courseId = course.getCourseId();
                this.courseName = course.getCourseName();
                this.courseDescription = course.getCourseDescription();
                

            }

            

        } catch (Exception ex) {
            Logger.getLogger(AddEditCoursesBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void saveCourse() {

        Courses course = new Courses();

        try {
            course.setCourseId(courseId);
            course.setCourseName(courseName);
            course.setCourseDescription(courseDescription);
            
            if (sessionBean.getSelectedItemId() > 0) {

                courseDao.updateCourse(course);
            } else {

                courseDao.insertCourse(course);
            }

        } catch (Exception ex) {
            Logger.getLogger(AddEditCoursesBean.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

        sessionBean.navigate("/hoffaz/admin/manage_courses.xhtml");

    }
}
