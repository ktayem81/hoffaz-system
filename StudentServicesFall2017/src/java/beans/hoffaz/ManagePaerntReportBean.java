/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.PaerntReportDao;
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
@Named(value = "managePaerntReportBean")
@ViewScoped
public class ManagePaerntReportBean implements Serializable {
@Inject
    private SessionBean sessionBean;
    
private final PaerntReportDao paerntReportDao = new PaerntReportDao();
    public ManagePaerntReportBean() {
    }
     @PostConstruct
    public void init() {
        try {

        } catch (Exception ex) {
            Logger.getLogger(ManageStudentGradesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   private StudentGrades selectedStudentGrade;
    private ArrayList<StudentGrades> studentsGrades;

    
    private int studentIdd;
    private int branchId;
    private int centerId;
    private int classroomid=1;


    public void buildStudentsGrade(int semester_year,int semester_id,int class_Id,int class_level_id,int studentid) {
        try {
            
            branchId = sessionBean.getBranchId();
            centerId = sessionBean.getCenterId();
           this.studentsGrades = paerntReportDao.buildStudentsGrades(1,7,1,1,1,2,2017,9);//classroomid, branchId, centerId, class_Id, class_level_id, semester_id, semester_year, studentid);

        } catch (Exception ex) {
            Logger.getLogger(ManageStudentGradesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getStudentIdd() {
        return studentIdd;
    }

    public void setStudentIdd(int studentIdd) {
        this.studentIdd = studentIdd;
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
