/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.ContestDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import models.hoffaz.Branch;
import models.hoffaz.Contest;

/**
 *
 * @author eng_ayman
 */
@Named(value = "manageContestBean")
@Dependent
public class ManageContestBean implements Serializable {

    private int branchId;
   private Contest selectedStudent;
    private final ContestDao contestDao = new ContestDao();
    private ArrayList<Contest> contest;

    @Inject
    private SessionBean sessionBean;

    /**
     * Creates a new instance of ManageContestBean
     */
    public ManageContestBean() {
    }

    @PostConstruct
    public void init() {
        try {
            this.branchId = sessionBean.getBranchId();
            this.contest = contestDao.buildContest(branchId);
        } catch (Exception ex) {
            Logger.getLogger(ManageCenterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Contest> getContest() {
        return contest;
    }

    public Contest getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Contest selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public void setContest(ArrayList<Contest> contest) {
        this.contest = contest;
    }
    public void  deleteSelectedStudent(){}
    public void  saveSelectedStudentId(){}
    
}
