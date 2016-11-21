/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.business.transactions;

import com.toba.business.shared.User;
import com.toba.business.shared.account;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jason
 */
@Entity
public class transaction implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionID;
    private double startingBal;
    private double amountTransferred;
    private double finalBalance;
    private String function;
    
    public transaction(){
        
    }
    public transaction(double startBal, double amntTrans, double fBal, String func){
        startingBal = startBal;
        amountTransferred = amntTrans;
        finalBalance = fBal;
        function = func;
    }

    public double getStartingBal() {
        return startingBal;
    }

    public void setStartingBal(double startingBal) {
        this.startingBal = startingBal;
    }

    public double getAmountTransferred() {
        return amountTransferred;
    }

    public void setAmountTransferred(double amountTransferred) {
        this.amountTransferred = amountTransferred;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
    
}
