/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.EmployeesDao;
import daos.hoffaz.UsersDao;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.hoffaz.Users;


/**
 *
 * @author khale
 */
@Named(value = "addEdiitUsersBean")
@ViewScoped
public class AddEdiitUsersBean implements  Serializable{

    /**
     * Creates a new instance of AddEdiitUsersBean
     */
    private final UsersDao userDao = new UsersDao();
    private final EmployeesDao emopDao = new EmployeesDao();
    private int insertUserId;
    private int employeeId;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String familyName;
    private String userName;
    private String password;
     
    public AddEdiitUsersBean() {
        
      
    }

    public int getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(int insertUserId) {
        this.insertUserId = insertUserId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     @Inject
    private SessionBean sessionBean;

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    @PostConstruct
    public void init() {

        
        
        

        employeeId = sessionBean.getSelectedItemId();
        
        

        try {
            //branchList = branchDao.branchList();
            //centerList = centerDao.buildCenters();
            //employeesList=employeesDao.getEmployees(branchId, centerId,5 );
        
            if (employeeId > 0) {
                Users user = userDao.getUser(employeeId);
               
                this.employeeId = user.getEmployeeId();
                this.firstName = user.getFirstName();
                this.secondName = user.getSecondName();
                this.thirdName = user.getThirdName();
                this.familyName=user.getFamilyName();
                this.userName=user.getUserName();
                this.password=user.getPassword();
                

            }

        } catch (Exception ex) {
            Logger.getLogger(AddEdiitUsersBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveUser() {

        Users user = new Users();

        try {
            user.setEmployeeId(employeeId);
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setThirdName(thirdName);
            user.setFamilyName(familyName);
            user.setUserName(userName);
            user.setPassword(password);
            

            if (sessionBean.getSelectedItemId() > 0) {

                userDao.updateUser(user);
            } else {

                userDao.insertUser(user);
            }

        } catch (Exception ex) {
            Logger.getLogger(AddEdiitUsersBean.class.getName()).log(Level.SEVERE, null, ex);
            sessionBean.navigate("/hoffaz/sql_exception.xhtml");
        }

        sessionBean.navigate("/hoffaz/admin/manage_users.xhtml");

    }
    

    
    
}
