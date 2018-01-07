/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;


import daos.hoffaz.UsersDao;
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
import models.hoffaz.Users;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author khale
 */
@Named(value = "manageUsersBean")
@ViewScoped
public class ManageUsersBean implements  Serializable{

    /**
     * Creates a new instance of ManageUsersBean
     */
    
    
    private Users selectedUser;
    private ArrayList<Users> users;
    private final UsersDao userDao = new UsersDao();
    public ManageUsersBean() {
    }
    @Inject 
    private SessionBean sessionBean;
    
    @PostConstruct
    public void init(){
        try {
            this.users = userDao.buildUsers();
        } catch (Exception ex) {
            Logger.getLogger(ManageUsersBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public Users getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Users selectedUser) {
        this.selectedUser = selectedUser;
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    
    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
     public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedUser.getEmployeeId());
    }

  //  public void saveSelectedTripId() {
      //  sessionBean.setSelectedItemId(selectedTrip.getTripId());
    //}

    public void onRowSelect(SelectEvent user) {
        FacesMessage msg = new FacesMessage("user Selected", ((Users) user.getObject()).getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteSelectedUser() {
        try {
            userDao.deleteUser(selectedUser.getEmployeeId());

        } catch (Exception ex) {
            Logger.getLogger(ManageUsersBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
