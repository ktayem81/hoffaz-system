/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.EmployeesDao;
import daos.hoffaz.StudentsDao;
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
import models.hoffaz.Employees;
import models.hoffaz.Student;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khale
 */
@Named(value = "manageEmployees")
@ViewScoped
public class ManageEmployeesBean implements Serializable {

    /**
     * Creates a new instance of ManageEmployees
     * 
     */
    private Employees selectedEmployee;
    
    private final EmployeesDao employeesDao = new EmployeesDao();
    private ArrayList<Employees> employees;

    @Inject
    private SessionBean sessionBean;
    public ManageEmployeesBean() {
    }
    @PostConstruct
    public void init() {
        try {
            this.employees = employeesDao.buildEmployees(sessionBean.getBranchId(), sessionBean.getCenterId());
        } catch (Exception ex) {
            Logger.getLogger(ManageEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Employees getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employees selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public ArrayList<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employees> employees) {
        this.employees = employees;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedEmployee.getEmployeeId());
    }
    public void onRowSelect(SelectEvent employee) {
        FacesMessage msg = new FacesMessage("employee Selected", ((Employees) employee.getObject()).getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteSelectedEmployee() {
        try {
            employeesDao.deleteEmployee(sessionBean.getBranchId(), sessionBean.getCenterId(), selectedEmployee.getEmployeeId());

        } catch (Exception ex) {
            Logger.getLogger(ManageEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
