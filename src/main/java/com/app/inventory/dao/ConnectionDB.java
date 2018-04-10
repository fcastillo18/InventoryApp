/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;

/**
 *
 * @author Franklin Castillo
 */
public class ConnectionDB {
    
    Connection connection = null;
    
    public Connection getConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/invdb", "sa", "");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
      
    public static void startServer(){
        HsqlProperties hsqlProperties = new HsqlProperties();
         hsqlProperties
           .setProperty("server.database.0",
             "file:C:/hsqldb/DBJava/HSQLDB/inventoryDB");
         hsqlProperties.setProperty("server.dbname.0", "invdb");

         Server server = new Server();
        try {
            server.setProperties(hsqlProperties);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServerAcl.AclFormatException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         server.setTrace(false);
         System.out.println(server.getState() + " "
           + server.getStateDescriptor());
         server.start();
    }
    
}