/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.util;

import com.app.inventory.dao.ConnectionDB;
import com.app.inventory.domain.Supplier;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Franklin Castillo
 */
public class EntityManagerUtil {
    
    public static void main(String[] args) {
        getEntityManager();
        //new ConnectionDB().getConnection();
    }
    
    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("InvAppPU3"); 
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Inventory_TPU_SQL");
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Inventory_TPU_Emb");
        EntityManager manager = factory.createEntityManager();
//        Query q = manager.createQuery("select p from Supplier p");
//        List<Supplier> list = q.getResultList();
////        
//        list.forEach(s -> System.out.println(s.getName()));
        
        return manager;
    }
    
//    public static void main(String[] args) {
//        EntityManager manager = EntityManagerUtil.getEntityManager();
//        System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
//    }
}
