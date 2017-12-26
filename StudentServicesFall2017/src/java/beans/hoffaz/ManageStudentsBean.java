/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.StudentsDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Student;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khaled
 */
@Named(value = "manageStudentsBean")
@ViewScoped
public class ManageStudentsBean implements Serializable{
    private Student selectedStudent;
    private final StudentsDao studentsDao = new StudentsDao();
    private ArrayList<Student> students; 
    
    @Inject 
    private SessionBean sessionBean;

    /**
     * Creates a new instance of ManageStudentsBean
     */
    public ManageStudentsBean() {
    }
    
    @PostConstruct
    public void init(){
        try {
            this.students = studentsDao.buildStudents(sessionBean.getBranchId(),sessionBean.getCenterId());
        } catch (Exception ex) {
            Logger.getLogger(ManageStudentsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    
    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedStudent.getStudentId());
    }

    public void onRowSelect(SelectEvent student) {
        FacesMessage msg = new FacesMessage("student Selected", ((Student) student.getObject()).getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void deleteSelectedStudent(){
        try {
            studentsDao.deleteStudent(selectedStudent.getStudentId(), sessionBean.getBranchId(), sessionBean.getCenterId());
            
        } catch (Exception ex) {
            Logger.getLogger(ManageStudentsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
