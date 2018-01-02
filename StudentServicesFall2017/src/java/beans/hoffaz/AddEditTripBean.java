/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.BranchDao;
import daos.hoffaz.CenterDao;
import daos.hoffaz.EmployeesDao;
import daos.hoffaz.TripDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Branch;
import models.hoffaz.Center;
import models.hoffaz.Employees;
import models.hoffaz.Trip;

/**
 *
 * @author khale
 */
@Named(value = "addEditTripBean")
@ViewScoped
public class AddEditTripBean {

    /**
     * Creates a new instance of AddEditTripBean
     * 
     */
    private final TripDao tripDao = new TripDao();
    private final BranchDao branchDao = new BranchDao();
    private final CenterDao centerDao = new CenterDao();
    private final EmployeesDao employeesDao = new EmployeesDao ();
   
    
    private ArrayList<Branch> branchList = new ArrayList<>();
    private ArrayList<Center> centerList = new ArrayList<>();
    private ArrayList<Employees> employeesList = new ArrayList<>();
    private int branchId; 
    private String branchName;
    private int centerId; 
    private String centerName;
    private int tripId; 
    private String tripDescription; 
    private int employeeId;

    public int getInsertEmployeeId() {
        return insertEmployeeId;
    }

    public void setInsertEmployeeId(int insertEmployeeId) {
        this.insertEmployeeId = insertEmployeeId;
    }
    private String firstName;
    private String secondName;
    private String thirdName;
    private int insertEmployeeId;
    
    @Inject
    private SessionBean sessionBean;

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(ArrayList<Branch> branchList) {
        this.branchList = branchList;
    }

    public ArrayList<Center> getCenterList() {
        return centerList;
    }

    public void setCenterList(ArrayList<Center> centerList) {
        this.centerList = centerList;
    }

    public ArrayList<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(ArrayList<Employees> employeesList) {
        this.employeesList = employeesList;
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

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    
    public AddEditTripBean() {
    }
     @PostConstruct
    public void init() {

        branchId = sessionBean.getBranchId();
        centerId = sessionBean.getCenterId();
        insertEmployeeId = Integer.parseInt(sessionBean.getUsername());

        tripId = sessionBean.getSelectedItemId();

        try {
            if (tripId > 0) {
                Trip trip = tripDao.getTrip(branchId, centerId, tripId);
               
                this.branchId = trip.getBranchId();
                this.branchName = trip.getBranchName();
                this.centerId = trip.getCenterId();
                this.centerName = trip.getCenterName();
                this.employeeId=trip.getEmployeeId();
                this.firstName=trip.getFirstName();
                this.secondName=trip.getSecondName();
                this.thirdName=trip.getThirdName();
                this.tripId = trip.getTripId();
                this.tripDescription=trip.getTripDescription();

            }
            branchList = branchDao.branchList();
            centerList = centerDao.buildCenters();
            //employeesList=employeesDao.buildEmployees();

        } catch (Exception ex) {
            Logger.getLogger(AddEditTripBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveTrip() {

        Trip trip = new Trip();

        try {
            trip.setTripDescription(tripDescription);
            trip.setEmployeeId(employeeId);
            

            if (sessionBean.getSelectedItemId() > 0) {

                tripDao.updateTrip(trip);
            } else {

                tripDao.insertTrip(trip);
            }

        } catch (Exception ex) {
            Logger.getLogger(AddEditTripBean.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

        sessionBean.navigate("/hoffaz/admin/manage_trip.xhtml");

    }
    
}
