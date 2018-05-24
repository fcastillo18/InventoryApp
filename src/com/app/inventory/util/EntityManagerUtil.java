/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Franklin Castillo
 */
public class EntityManagerUtil {
    
    private static FileInputStream fileInput;
    private static Properties properties = new Properties();
    private static final Logger logger = LogManager.getLogger(EntityManager.class);
    
//    protected EntityManager getEntityManager(String driver, String url, String username, String password) {
//    EntityManager em = null;
//    Map properties = new HashMap();
//    properties.put("javax.persistence.jdbc.driver", driver);
//    properties.put("javax.persistence.jdbc.url", url);
//    properties.put("javax.persistence.jdbc.user", username);
//    properties.put("javax.persistence.jdbc.password", password);
//    try {
//        emf = Persistence.createEntityManagerFactory("dynamicJPA", properties);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    return em = (EntityManager) emf.createEntityManager();
//}
    
    
    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = null;
         EntityManager manager = null;
        try {
            fileInput = new FileInputStream(new File("config/project.properties"));
            properties.load(fileInput);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(EntityManagerUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Map mapProp = new HashMap();
        mapProp.put("javax.persistence.jdbc.driver", properties.getProperty("DRIVER"));
        mapProp.put("javax.persistence.jdbc.url", properties.getProperty("URL"));
        mapProp.put("javax.persistence.jdbc.user", properties.getProperty("USER"));
        mapProp.put("javax.persistence.jdbc.password", properties.getProperty("PASSWORD"));
        try { 
            factory = Persistence.createEntityManagerFactory(properties.getProperty("CON_UNIT_NAME"), mapProp);
            //System.out.println(factory.getProperties());
            manager = factory.createEntityManager();
        } catch (Exception e) {
            System.out.println("Error creating the EntityManager ");
            logger.fatal("Error creating the EntityManager", e);
            e.printStackTrace();
        }
        
        return manager;
    }
    
//    public static void main(String[] args) {
//        EntityManager manager = EntityManagerUtil.getEntityManager();
//        System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
//    }
}
