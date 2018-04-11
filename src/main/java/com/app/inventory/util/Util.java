/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.util;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Franklin Castillo
 */
public class Util {
    
    
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
}
