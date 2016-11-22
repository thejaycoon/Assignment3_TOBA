/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.business.shared;

import com.toba.business.transactions.transaction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Jason
 */
@Entity
public class account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountID;
     private String accountType;
      private double startingBal;//attribute
      private User me;
      @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
      private List<transaction> transactions;
      
      public account(){
          accountType = "";
          startingBal = 0.0;
          me = new User();
          
      }
      
      //constuctor
      public account(String accntType, double startingBal, User acctOwner) {
          accountType = accntType;
          this.startingBal = startingBal;
          me = acctOwner;
          transactions = new ArrayList<>();
      }
      
      //method
      public double credit (double amount){
          startingBal = startingBal + amount;
          return startingBal;
      }
      public double debit (double amount){
           startingBal = startingBal - amount;
          return startingBal;
      }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getStartingBal() {
        return startingBal;
    }

    public void setStartingBal(double startingBal) {
        this.startingBal = startingBal;
    }

    public User getMe() {
        return me;
    }

    public void setMe(User me) {
        this.me = me;
    }

    public List<transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<transaction> transactions) {
        this.transactions = transactions;
    }
      
    public void addTransactions(transaction t){
        transactions.add(t);
    }  
}
