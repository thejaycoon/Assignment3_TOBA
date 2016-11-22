/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import com.toba.business.shared.User;

/**
 *
 * @author Jason
 */
public class UserDB {
    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
//Method
public static User selectUser(String username, String password){
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
    String qString = "SELECT u FROM User u " + 
            "WHERE u.userName = :USERNAME AND u.password = :PASSWORD";
    TypedQuery<User> q = em.createQuery(qString,  User.class);
    q.setParameter("USERNAME", username);
    q.setParameter("PASSWORD", password);
    try {
        User user = q.getSingleResult();
        return user;
    } catch (NoResultException e){
        return null;
    } finally {
        em.close();
    }
    
}

    
}
