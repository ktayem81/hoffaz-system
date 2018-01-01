/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.hoffaz;

import daos.hoffaz.StudentFeesDao;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import models.hoffaz.Payments;

/**
 *
 * @author eng_ayman
 */
@Named(value = "studentFeesBean")
@Dependent
public class StudentFeesBean {
    private Payments selectedPayment;
private ArrayList<Payments> payments;
private final StudentFeesDao eventsDao = new StudentFeesDao();
    
     @Inject 
    private SessionBean sessionBean;
     
    public StudentFeesBean() {
    }
    public ArrayList<Payments> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payments> payments) {
        this.payments = payments;
    } 

    public Payments getSelectedPayment() {
        return selectedPayment;
    }

    public void setSelectedPayment(Payments selectedPayment) {
        this.selectedPayment = selectedPayment;
    }
    
}
