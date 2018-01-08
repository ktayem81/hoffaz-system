/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.StudentGradesDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.StudentGrades;

/**
 *
 * @author eng_ayman
 */
@Named(value = "manageStudentGradesBean")
@ViewScoped
public class ManageStudentGradesBean implements Serializable {

    private StudentGrades selectedStudentGrade;
    private ArrayList<StudentGrades> studentsGrades;

    private final StudentGradesDao studentGradesDao = new StudentGradesDao();
    
    private int branchId;
    private int centerId;
    private int classroomid=1;

    @Inject
    private SessionBean sessionBean;

    public ManageStudentGradesBean() {
    }

    @PostConstruct
    public void init() {
        try {
           
           // this.studentsGrades = studentGradesDao.buildStudentsGrades(1, 7, 1);

        } catch (Exception ex) {
            Logger.getLogger(ManageStudentGradesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buildStudentsGrade(int semester_year,int semester_id,int class_Id,int class_level_id) {
        try {
            
            branchId = sessionBean.getBranchId();
            centerId = sessionBean.getCenterId();
           this.studentsGrades = studentGradesDao.buildStudentsGrades(1,7,1,1,1,2,2017);//classroomid,branchId, centerId,class_Id,class_level_id, semester_id ,semester_year);

        } catch (Exception ex) {
            Logger.getLogger(ManageStudentGradesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public int getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(int classroomid) {
        this.classroomid = classroomid;
    }

    public StudentGrades getSelectedStudentGrade() {
        return selectedStudentGrade;
    }

    public void setSelectedStudentGrade(StudentGrades selectedStudentGrade) {
        this.selectedStudentGrade = selectedStudentGrade;
    }

    public ArrayList<StudentGrades> getStudentsGrades() {
        return studentsGrades;
    }

    public void setStudentsGrades(ArrayList<StudentGrades> studentsGrades) {
        this.studentsGrades = studentsGrades;
    }

   

}
