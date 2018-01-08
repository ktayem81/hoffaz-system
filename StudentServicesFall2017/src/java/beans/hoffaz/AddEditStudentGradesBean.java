/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.StudentGradesDao;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.StudentGrades;

/**
 *
 * @author eng_ayman
 */
@Named(value = "addEditStudentGradesBean")
@ViewScoped
public class AddEditStudentGradesBean implements  Serializable{
StudentGradesDao studentGradesDao=new StudentGradesDao();
StudentGrades selectedStudentGrade=new StudentGrades();
 @Inject
    SessionBean sessionBean;
    
    public AddEditStudentGradesBean() {
    }
    
     public void updateStudentGrades() {
        try {
            
            studentGradesDao.updateStudentGrades(selectedStudentGrade);
        } catch (Exception ex) {
            Logger.getLogger(ManageStudentGradesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StudentGrades getSelectedStudentGrade() {
        return selectedStudentGrade;
    }

    public void setSelectedStudentGrade(StudentGrades selectedStudentGrade) {
        this.selectedStudentGrade = selectedStudentGrade;
    }

   
     
}
