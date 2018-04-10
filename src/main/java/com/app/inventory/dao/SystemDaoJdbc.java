/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franklin Castillo
 */
public class SystemDaoJdbc {
    
    public SystemDaoJdbc() {
        connection = new ConnectionDB().getConnection();
    }
   
    Statement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;
    
    public void execTask(){
        
        try {
            statement = connection.createStatement();
            
            statement.executeUpdate("CREATE TABLE usuario ("
                    + "ID varchar(6),"
                    + "nombre varchar(20) NOT NULL,"
                    + "apellido varchar(20) NOT NULL,"
                    + "login varchar(20) NOT NULL,"
                    + "clave varchar(20) NOT NULL,"
                    + ");");
            
            //     statement
            //       .executeUpdate("truncate table usuario");
            statement
                    .executeUpdate("INSERT INTO usuario VALUES ('1', 'pedro', 'suarez', 'p.suarez', '12345');");
            statement
                    .executeUpdate("INSERT INTO usuario VALUES ('2', 'pablo', 'martinez', 'p.martinez', '12345');");
            statement
                    .executeUpdate("INSERT INTO usuario VALUES ('3', 'pepe', 'peres', 'p.perez', '12345');");
            
            resultSet = statement.executeQuery("SELECT * FROM usuario");
            
            while (resultSet.next()) {
                System.out.println("---Usuario---");
                System.out.println("ID: " + resultSet.getString(1));
                System.out.println("Nombre: " + resultSet.getString(2));
                System.out.println("Apellido: " + resultSet.getString(3));
            }
            //statement.executeUpdate("drop table usuario");
            // Opcional para detener el Servidor
            //statement.executeQuery("SHUTDOWN COMPACT");
        } catch (SQLException ex) {
            Logger.getLogger(SystemDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
