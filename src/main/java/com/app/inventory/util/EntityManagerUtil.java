/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Franklin Castillo
 */
public class EntityManagerUtil {
    
    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("InventoryApp_TPU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
    
//    public static void main(String[] args) {
//        EntityManager manager = EntityManagerUtil.getEntityManager();
//        System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
//    }
}
