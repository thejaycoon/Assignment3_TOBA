/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.data;

import com.toba.business.shared.User;
import com.toba.business.shared.account;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jason
 */
public class AccountDB {
    public static void insert(account accou) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(accou);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
     public static void update(account accou) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(accou);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
//Method
public static account selectAccount(User user, String account){
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
    String qString = "SELECT a FROM account a " + 
            "WHERE a.me = :user AND a.accountType = :ACCOUNT";
    TypedQuery<account> q = em.createQuery(qString, account.class);
    q.setParameter("user", user);
    q.setParameter("ACCOUNT", account);
    try {
        account a = q.getSingleResult();
        return a;
    } catch (NoResultException e){
        return null;
    } finally {
        em.close();
    }
    
}
}
