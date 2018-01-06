/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.ClassRoomDao;
import daos.hoffaz.SemesterDao;
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
import models.hoffaz.ClassRoom;
import models.hoffaz.Semester;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khaled
 */
@Named(value = "manageClassRoomBean")
@ViewScoped
public class ManageClassRoomBean implements Serializable{
    
    private ClassRoom selectedClassRoom;
    private final ClassRoomDao classRoomDao = new ClassRoomDao();
    private ArrayList<ClassRoom> classRooms;
    private final SemesterDao semesterDao = new SemesterDao();
    
    private ArrayList<Semester> semesterIdList = new ArrayList<>();
    
    private String rowId;
    private int semesterId;
    private int semesterYear;

    /**
     * Creates a new instance of ManageClassRoomBean
     */
    @Inject
    private SessionBean sessionBean;
    
    public ManageClassRoomBean() {
    }
    

    public ClassRoom getSelectedClassRoom() {
        return selectedClassRoom;
    }

    public void setSelectedClassRoom(ClassRoom selectedClassRoom) {
        this.selectedClassRoom = selectedClassRoom;
    }

    public ArrayList<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(ArrayList<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public int getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(int semesterYear) {
        this.semesterYear = semesterYear;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public ArrayList<Semester> getSemesterIdList() {
        return semesterIdList;
    }

    public void setSemesterIdList(ArrayList<Semester> semesterIdList) {
        this.semesterIdList = semesterIdList;
    }
    
    
    
    @PostConstruct
    public void init() {
        try {
            this.classRooms = classRoomDao.buildClassRooms(sessionBean.getBranchId(), sessionBean.getCenterId());
        } catch (Exception ex) {
            Logger.getLogger(ManageClassRoomBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowSelect(SelectEvent classRoom) {
        FacesMessage msg = new FacesMessage("classRoom Selected", ((ClassRoom) classRoom.getObject()).getSemesterIdLookUp());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedClassRoom.getClassRoomId());
        sessionBean.setSelectedClassRoom(selectedClassRoom);
    }
    

    public void deleteSelectedClassRoom() {
        try {
            classRoomDao.deleteClassRoom(sessionBean.getBranchId(), sessionBean.getCenterId(), selectedClassRoom.getClassId(), selectedClassRoom.getLevelId(),  selectedClassRoom.getSemesterYear(), selectedClassRoom.getSemesterId(), selectedClassRoom.getClassRoomId());

        } catch (Exception ex) {
            Logger.getLogger(ManageClassRoomBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSemesterIdList(){
    try {    
            semesterIdList = semesterDao.getSemesterIdList(sessionBean.getBranchId(), sessionBean.getCenterId(), semesterYear);
        } catch (Exception ex) {
            Logger.getLogger(AddEditClassRoomBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateClassRoomFilter(){
    try {    
            this.classRooms = classRoomDao.getClassRoomsfilter(sessionBean.getBranchId(), sessionBean.getCenterId(), semesterYear, semesterId);
        } catch (Exception ex) {
            Logger.getLogger(AddEditClassRoomBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
