/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

import java.util.Date;


/**
 *
 * @author khaled
 */
public class Student {
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
    private String phone;
    private String whatsup;
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

    public Student() {
    }

    public Student(int studentId, String firstName, String secondName, String thirdName, String familyName, Date birthDate, int sexId, Date dateOfJoin, int nationalityId, int nationalityNumber, String phone, String whatsup, int branchId, int centerId, int tripId, int stopId, String addressDetails, boolean transportation, int insertEmployeeId, String insertHostIp, Date insertDate, String insertHostOS, int updatEmployeeId, Date updateDate, String updateHostIp, String updateHostOS) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.sexId = sexId;
        this.dateOfJoin = dateOfJoin;
        this.nationality = nationalityId;
        this.nationalityNumber = nationalityNumber;
        this.phone = phone;
        this.whatsup = whatsup;
        this.branchId = branchId;
        this.centerId = centerId;
        this.tripId = tripId;
        this.stopId = stopId;
        this.addressDetails = addressDetails;
        this.transportation = transportation;
        this.insertEmployeeId = insertEmployeeId;
        this.insertHostIp = insertHostIp;
        this.insertDate = insertDate;
        this.insertHostOS = insertHostOS;
        this.updatEmployeeId = updatEmployeeId;
        this.updateDate = updateDate;
        this.updateHostIp = updateHostIp;
        this.updateHostOS = updateHostOS;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWhatsup() {
        return whatsup;
    }

    public void setWhatsup(String whatsup) {
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
    
    
}
