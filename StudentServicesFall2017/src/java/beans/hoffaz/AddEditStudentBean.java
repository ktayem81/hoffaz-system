/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.StudentsDao;
import daos.hoffaz.NationalityDao;
import daos.hoffaz.TripDao;
import daos.hoffaz.TripDetailDao;
import java.io.Serializable;
import java.util.Date;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Nationality;
import models.hoffaz.Student;
import models.hoffaz.Trip;
import models.hoffaz.TripDetail;

/**
 *
 * @author khaled
 */
@Named(value = "addEditStudentBean")
@ViewScoped
public class AddEditStudentBean implements Serializable{
    
    private final StudentsDao studentDao = new StudentsDao();
    private final NationalityDao nationalityDao = new NationalityDao();
    private final TripDao tripDao = new TripDao();
    private final TripDetailDao tripDetailDao = new TripDetailDao();
    
    private ArrayList<Nationality> nationalityList = new ArrayList<>();
    private ArrayList<Trip> tripList = new ArrayList<>();
    private ArrayList<TripDetail> tripDetailList = new ArrayList<>();
    
    private int studentId;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String familyName;
    private Date birthDate;
    private int sexId;
    private String sexDescription;
    private Date dateOfJoin;
    private int nationality;
    private String nationalityDesc;
    private int nationalityNumber;
    private int phone;
    private int whatsup;
    private int branchId;
    private String branchName;
    private int centerId;
    private String centerName;
    private int tripId;
    private String tripDesc;
    private int stopId;
    private String stopDesc;
    private String addressDetails;
    private boolean transportation;
    private String transportationDesc; 
    private int insertEmployeeId;
    private String insertHostIp;    
    private Date insertDate;      
    private String insertHostOS;    
    private int updatEmployeeId; 
    private Date updateDate;      
    private String updateHostIp;    
    private String updateHostOS;

    @Inject
    private SessionBean sessionBean;
    
    
        
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    public String getSexDescription() {
        return sexDescription;
    }

    public void setSexDescription(String sexDescription) {
        this.sexDescription = sexDescription;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationalityId) {
        this.nationality = nationalityId;
    }

    public String getNationalityDesc() {
        return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc) {
        this.nationalityDesc = nationalityDesc;
    }

    public int getNationalityNumber() {
        return nationalityNumber;
    }

    public void setNationalityNumber(int nationalityNumber) {
        this.nationalityNumber = nationalityNumber;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getWhatsup() {
        return whatsup;
    }

    public void setWhatsup(int whatsup) {
        this.whatsup = whatsup;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTripDesc() {
        return tripDesc;
    }

    public void setTripDesc(String tripDesc) {
        this.tripDesc = tripDesc;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public boolean getTransportation() {
        return transportation;
    }

    public void setTransportation(boolean transportation) {
        this.transportation = transportation;
    }

    public String getTransportationDesc() {
        return transportationDesc;
    }

    public void setTransportationDesc(String transportationDesc) {
        this.transportationDesc = transportationDesc;
    }

    public int getInsertEmployeeId() {
        return insertEmployeeId;
    }

    public void setInsertEmployeeId(int insertEmployeeId) {
        this.insertEmployeeId = insertEmployeeId;
    }

    public String getInsertHostIp() {
        return insertHostIp;
    }

    public void setInsertHostIp(String insertHostIp) {
        this.insertHostIp = insertHostIp;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getInsertHostOS() {
        return insertHostOS;
    }

    public void setInsertHostOS(String insertHostOS) {
        this.insertHostOS = insertHostOS;
    }

    public int getUpdatEmployeeId() {
        return updatEmployeeId;
    }

    public void setUpdatEmployeeId(int updatEmployeeId) {
        this.updatEmployeeId = updatEmployeeId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateHostIp() {
        return updateHostIp;
    }

    public void setUpdateHostIp(String updateHostIp) {
        this.updateHostIp = updateHostIp;
    }

    public String getUpdateHostOS() {
        return updateHostOS;
    }

    public void setUpdateHostOS(String updateHostOS) {
        this.updateHostOS = updateHostOS;
    }

    public ArrayList<Nationality> getNationalityList() {
        return nationalityList;
    }

    public void setNationalityList(ArrayList<Nationality> nationalityList) {
        this.nationalityList = nationalityList;
    }

    public ArrayList<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(ArrayList<Trip> tripList) {
        this.tripList = tripList;
    }

    public ArrayList<TripDetail> getTripDetailList() {
        return tripDetailList;
    }

    public void setTripDetailList(ArrayList<TripDetail> tripDetailList) {
        this.tripDetailList = tripDetailList;
    }
    
    
    
    /**
     * Creates a new instance of AddStudentBean
     */
    public AddEditStudentBean() {
    }
    
    @PostConstruct
    public void init() {

        branchId = sessionBean.getBranchId();
        centerId = sessionBean.getCenterId();
        insertEmployeeId = Integer.parseInt(sessionBean.getUsername());

        studentId = sessionBean.getSelectedItemId();

        try {
            if (studentId > 0) {
                Student student = studentDao.getStudent(branchId, centerId, studentId);
                this.firstName = student.getFirstName();
                this.secondName = student.getSecondName();
                this.thirdName = student.getThirdName();
                this.familyName = student.getFamilyName();
                this.birthDate = student.getBirthDate();
                this.sexId = student.getSexId();
                this.sexDescription = student.getSexDescription();
                this.dateOfJoin = student.getDateOfJoin();
                this.nationality = student.getNationality();
                this.nationalityDesc = student.getNationalityDesc();
                this.nationalityNumber = student.getNationalityNumber();
                this.phone = student.getPhone();
                this.whatsup = student.getWhatsup();
                this.branchId = student.getBranchId();
                this.branchName = student.getBranchName();
                this.centerId = student.getCenterId();
                this.centerName = student.getCenterName();
                this.tripId = student.getTripId();
                this.tripDesc = student.getTripDesc();
                this.stopId = student.getStopId();
                this.stopDesc = student.getStopDesc();
                this.addressDetails = student.getAddressDetails();
                this.transportation = student.getTransportation();
                this.transportationDesc = student.getTransportationDesc();
                this.insertEmployeeId = student.getInsertEmployeeId();
                this.insertHostIp = student.getInsertHostIp();
                this.insertDate = student.getInsertDate();
                this.insertHostOS = student.getInsertHostOS();
                this.updatEmployeeId = student.getUpdatEmployeeId();
                this.updateDate = student.getUpdateDate();
                this.updateHostIp = student.getUpdateHostIp();
                this.updateHostOS = student.getUpdateHostOS();

            }
            nationalityList = nationalityDao.getNationalityList();
            tripList = tripDao.getTripList(branchId, centerId);

        } catch (Exception ex) {
            Logger.getLogger(AddEditStudentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onTripIdChange() {
        try {
            tripDetailList = tripDetailDao.getTripList(sessionBean.getBranchId(), sessionBean.getCenterId(), this.tripId);
        } catch (Exception ex) {
            Logger.getLogger(AddEditStudentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveStudent() {
        
        int employeeId = Integer.parseInt(sessionBean.getUsername());
       
        Student student = new Student();
        
        try {
            student.setStudentId(studentId);
            student.setFirstName(firstName);
            student.setSecondName(secondName);
            student.setThirdName(thirdName);
            student.setFamilyName(familyName);
            student.setBirthDate(birthDate);
            student.setSexId(sexId);
            student.setDateOfJoin(dateOfJoin);
            student.setNationality(nationality);
            student.setNationalityNumber(nationalityNumber);
            student.setPhone(phone);
            student.setWhatsup(whatsup);
            student.setBranchId(branchId);
            student.setCenterId(centerId);
            student.setTripId(tripId);
            student.setStopId(stopId);
            student.setAddressDetails(addressDetails);
            student.setTransportation(transportation);
       
            if (sessionBean.getSelectedItemId() > 0) {
                student.setUpdatEmployeeId(employeeId);
                student.setUpdateDate(updateDate);
                student.setUpdateHostIp(sessionBean.getRemoteAddress());
                student.setUpdateHostOS(sessionBean.getRemoteHost());                
                studentDao.updateStudent(student);
            } else {
                student.setInsertEmployeeId(employeeId);
                student.setInsertDate(insertDate);
                student.setInsertHostIp(sessionBean.getRemoteAddress());
                student.setInsertHostOS(sessionBean.getRemoteHost());
                studentDao.insertStudent(student);
            }
            
            
            sessionBean.setStudent(student);
            
            sessionBean.navigate("/hoffaz/registrar/studentreport");
            
        } catch (Exception ex) {
            Logger.getLogger(StudentsDao.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

        
    }
}
