/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.dao.jdbc;

import com.app.inventory.dao.ConnectionDB;
import com.app.inventory.dao.controller.ClientJpaController;
import com.app.inventory.domain.Client;
import com.app.inventory.util.EntityManagerUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Franklin Castillo
 */
public class SystemDaoJdbc {
    
    public SystemDaoJdbc() {
        con= new ConnectionDB().getConnection();
        em = EntityManagerUtil.getEntityManager();
    }
   
    Statement statement = null;
    ResultSet resultSet = null;
    Connection con = null;
    EntityManager em = null; 
    ClientJpaController clientController = null;
    
    public void createClient(Client client){
        clientController = new ClientJpaController(em.getEntityManagerFactory());
        clientController.create(client);
        System.out.println("com.app.inventory.dao.jdbc.SystemDaoJdbc.createClient()");
    }
    
    public void execTask(){
        
        try {
//            statement = connection.createStatement();
//            
//            statement.execute("CREATE TABLE usuario ("
//                    + "ID varchar(6) primary key,"
//                    + "nombre varchar(20) NOT NULL,"
//                    + "apellido varchar(20) NOT NULL,"
//                    + "login varchar(20) NOT NULL,"
//                    + "clave varchar(20) NOT NULL,"
//                    + ");");
//            
//            //     statement
//            //       .executeUpdate("truncate table usuario");
//            statement
//                    .execute("INSERT INTO usuario VALUES ('1', 'pedro', 'suarez', 'p.suarez', '12345');");
//            statement
//                    .execute("INSERT INTO usuario VALUES ('2', 'pablo', 'martinez', 'p.martinez', '12345');");
//            statement
//                    .execute("INSERT INTO usuario VALUES ('3', 'pepe', 'peres', 'p.perez', '12345');");
//            con.createStatement().execute("create table usuario2( id_usuario INT PRIMARY KEY, " +
//                                            "nombre varchar(20), " + 
//                                            "apellidos varchar(20), " + 
//                                            "password varchar(20) )");
//            con.createStatement().execute("insert into usuario2 values " + 
//                                                    "(1, 'Carlos', 'Garcia', 'notodocodigo') ," +
//                                                    "(2, 'Pepe', 'Gómez', 'contraseña')");
            
            resultSet = con.createStatement().executeQuery("SELECT * FROM USERS");
            while (resultSet.next()) {
                System.out.println("---Usuario---");
                System.out.println("ID: " + resultSet.getString(1));
                System.out.println("Nombre: " + resultSet.getString(2));
                System.out.println("Apellido: " + resultSet.getString(3));
            }
            //statement.executeUpdate("drop table usuario");
            // Opcional para detener el Servidor
            //statement.executeQuery("SHUTDOWN COMPACT");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SystemDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
