/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.BranchDao;
import daos.hoffaz.CenterDao;
import daos.hoffaz.EmployeesCategoriesDao;
import daos.hoffaz.EmployeesDao;
import daos.hoffaz.NationalityDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Branch;
import models.hoffaz.Center;
import models.hoffaz.Employee_Category;
import models.hoffaz.Employees;
import models.hoffaz.Nationality;
import models.hoffaz.Student;

/**
 *
 * @author khale
 */
@Named(value = "addEditEmployeesBean")
@ViewScoped
public class AddEditEmployeesBean implements Serializable {

    /**
     * Creates a new instance of AddEditEmployeesBean
     *
     */
    private final EmployeesDao employeeDao = new EmployeesDao();
    private final NationalityDao nationalityDao = new NationalityDao();
    private final BranchDao branchDao = new BranchDao();
    private final CenterDao centerDao = new CenterDao();
    private final EmployeesCategoriesDao employeeCategoriesDao = new EmployeesCategoriesDao();

    private ArrayList<Nationality> nationalityList = new ArrayList<>();
    private ArrayList<Branch> branchList = new ArrayList<>();
    private ArrayList<Center> centerList = new ArrayList<>();
    private ArrayList<Employee_Category> employeescategoriesList = new ArrayList<>();

    @Inject
    private SessionBean sessionBean;
    private int employeeId;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String familyName;
    private int branchId;
    private String branchDesc;
    private int centerId;
    private String centerDesc;
    private int phone;
    private int whatsup;
    private String addressDetials;
    private int nationality;
    private String nationalityDesc;
    private int nationalityId;
    private int employeeCategoryId;
    private String employeeCategoryDesc;
    private int salary;

    public int getInsertEmployeeId() {
        return insertEmployeeId;
    }

    public void setInsertEmployeeId(int insertEmployeeId) {
        this.insertEmployeeId = insertEmployeeId;
    }
    private int insertEmployeeId;

    public ArrayList<Nationality> getNationalityList() {
        return nationalityList;
    }

    public void setNationalityList(ArrayList<Nationality> nationalityList) {
        this.nationalityList = nationalityList;
    }

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

    public ArrayList<Employee_Category> getEmployeescategoriesList() {
        return employeescategoriesList;
    }

    public void setEmployeescategoriesList(ArrayList<Employee_Category> employeescategoriesList) {
        this.employeescategoriesList = employeescategoriesList;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchDesc() {
        return branchDesc;
    }

    public void setBranchDesc(String branchDesc) {
        this.branchDesc = branchDesc;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterDesc() {
        return centerDesc;
    }

    public void setCenterDesc(String centerDesc) {
        this.centerDesc = centerDesc;
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

    public String getAddressDetials() {
        return addressDetials;
    }

    public void setAddressDetials(String addressDetials) {
        this.addressDetials = addressDetials;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public String getNationalityDesc() {
        return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc) {
        this.nationalityDesc = nationalityDesc;
    }

    public int getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(int nationalityId) {
        this.nationalityId = nationalityId;
    }

    public int getEmployeeCategoryId() {
        return employeeCategoryId;
    }

    public void setEmployeeCategoryId(int employeeCategoryId) {
        this.employeeCategoryId = employeeCategoryId;
    }

    public String getEmployeeCategoryDesc() {
        return employeeCategoryDesc;
    }

    public void setEmployeeCategoryDesc(String employeeCategoryDesc) {
        this.employeeCategoryDesc = employeeCategoryDesc;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public AddEditEmployeesBean() {
    }
    @PostConstruct
    public void init() {

        branchId = sessionBean.getBranchId();
        centerId = sessionBean.getCenterId();
        insertEmployeeId = Integer.parseInt(sessionBean.getUsername());

        employeeId = sessionBean.getSelectedItemId();

        try {
            if (employeeId > 0) {
                Employees employee = employeeDao.getEmployee(branchId, centerId, employeeId);
                
                this.firstName = employee.getFirstName();
                this.secondName = employee.getSecondName();
                this.thirdName = employee.getThirdName();
                this.familyName = employee.getFamilyName();
                this.branchId = employee.getBranchId();
                this.centerId = employee.getCenterId();
                this.phone = employee.getPhone();
                this.whatsup = employee.getWhatsup();
                this.addressDetials = employee.getAddressDetials();
                this.nationality = employee.getNationality();
                this.nationalityId = employee.getNationalityId();
                this.employeeCategoryId = employee.getEmployeeCategoryId();
                this.salary = employee.getSalary();
                
            }
            nationalityList = nationalityDao.getNationalityList();
            branchList=branchDao.buildBranches();
            centerList=centerDao.buildCenters();
          //  employeescategoriesList =;

        } catch (Exception ex) {
            Logger.getLogger(AddEditEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveEmployee() {
        
        int employeeId = Integer.parseInt(sessionBean.getUsername());
       
        Employees employee = new Employees();
        
        try {
            employee.setEmployeeId(employeeId);
            employee.setFirstName(firstName);
            employee.setSecondName(secondName);
            employee.setThirdName(thirdName);
            employee.setFamilyName(familyName);
            employee.setBranchId(branchId);
            employee.setCenterId(centerId);
            employee.setPhone(phone);
            employee.setWhatsup(whatsup);
            employee.setAddressDetials(addressDetials);
            employee.setNationality(nationality);
            employee.setNationalityId(nationalityId);
            employee.setEmployeeCategoryId(employeeCategoryId);
            employee.setSalary(salary);
           
            if (sessionBean.getSelectedItemId() > 0) {
                employeeDao.updateEmployee(employee);
            } else {
                employeeDao.insertEmployee(employee);
            }
            
            sessionBean.setEmployee(employee);
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeesDao.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

        sessionBean.navigate("/hoffaz/admin/manage_employees.xhtml");
    }

}
