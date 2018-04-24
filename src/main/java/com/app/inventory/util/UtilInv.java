/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.util;

import com.app.inventory.dao.controller.ClientJpaController;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.Component;
import java.awt.Container;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Franklin Castillo
 */
public class UtilInv {
    
    public UtilInv(){
        clientController = new ClientJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    }
    
    private ClientJpaController clientController = null;
    private DefaultTableModel tableModel = null;
    
    public static void clearTextFields(Container container) {
        for (Component c : container.getComponents()) {
       
            if(c instanceof JFormattedTextField){
                JFormattedTextField ftxtField = (JFormattedTextField) c;
                ftxtField.setValue(null);
            }
            if (c instanceof JTextField) {
                if(c instanceof JFormattedTextField){
                    JFormattedTextField ftxtField = (JFormattedTextField) c;
                    ftxtField.setValue(null);
                }else{
                    JTextField f = (JTextField) c;
                    f.setText("");
                }
                
            } 
//            if(c instanceof DatePicker){
//                ((DatePicker) c).setDateToToday();
//            }
            if(c instanceof JTextArea){
                JTextArea area = (JTextArea) c;
                area.setText("");
            }
            
            if (c instanceof JComboBox) {
                ((JComboBox) c).setSelectedIndex(0);
            }
            //debe de estar de penultimo
            if(c != null && c.getName() != null){
                if (c.getName().equals("datePicker")) {
                    ((DatePicker) c).setDateToToday();
                }
            }
            
            else if (c instanceof Container) {
                clearTextFields((Container) c);
            }
        }
    }
    
    public static JFormattedTextField.AbstractFormatterFactory getDecimalFormatFactory(){
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        format.setRoundingMode(RoundingMode.HALF_UP);
        NumberFormatter formatter = new NumberFormatter(format); //create the formatter
        formatter.setAllowsInvalid(false); //must specify that invalid chars are not allowed

        JFormattedTextField field = new JFormattedTextField(formatter); //pass the formatter to the field
        
        return field.getFormatterFactory();
    }
    
    public static JFormattedTextField.AbstractFormatterFactory getIntegerFormatFactory(){
        NumberFormatter formatter = new NumberFormatter(); //create the formatter
        formatter.setAllowsInvalid(false); //must specify that invalid chars are not allowed

        JFormattedTextField field = new JFormattedTextField(formatter); //pass the formatter to the field
        
        return field.getFormatterFactory();
    }
    
    public static JFormattedTextField.AbstractFormatterFactory getDateFormatFactory(){
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//create the formatter
//        formatter.setAllowsInvalid(false); //must specify that invalid chars are not allowed

        JFormattedTextField field = new JFormattedTextField(formatter); //pass the formatter to the field
        
        return field.getFormatterFactory();
    }
    
    public static Timestamp getDateNow(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
       
        return new java.sql.Timestamp(date.getTime());
    }
    
    /*
    
            LocalDate now = LocalDate.now(); // 2015-11-23
//        LocalDate start = now.with(firstDayOfYear()); // 2015-01-01
//        LocalDate end = now.with(lastDayOfYear()); // 2015-12-31
        Date start = Date.from(now.with(firstDayOfYear()).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date end = Date.from(now.with(lastDayOfYear()).atStartOfDay(ZoneId.systemDefault()).withHour(23).withMinute(59).withSecond(59).toInstant());
        
    */
}
