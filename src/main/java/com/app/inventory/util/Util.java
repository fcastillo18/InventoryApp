/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.util;

import com.app.inventory.dao.controller.ClientJpaController;
import com.app.inventory.domain.Client;
import java.awt.Component;
import java.awt.Container;
import java.util.Vector;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franklin Castillo
 */
public class Util {
    
    public Util(){
        clientController = new ClientJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    }
    
    private ClientJpaController clientController = null;
    private DefaultTableModel tableModel = null;
    
    public void clearTextFields(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField) {
                JTextField f = (JTextField) c;
                f.setText("");
            } else if (c instanceof Container) {
                clearTextFields((Container) c);
            }
            if(c instanceof JTextArea){
                JTextArea area = (JTextArea) c;
                area.setText("");
            }
        }
    }
    
    public DefaultTableModel getClientDataModel(){
        String columns[] = {"Column1", "Column2"};
        tableModel = new DefaultTableModel(columns, 0);
        
        clientController.findClientEntities().forEach(client -> {
            tableModel.addRow(new Object[]{ client.getDocument(), client.getName()});
        }); 
        return tableModel;
    }
}
