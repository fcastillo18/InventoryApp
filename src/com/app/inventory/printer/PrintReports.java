/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.printer;

import com.app.inventory.dao.controller.MainAppController;
import com.app.inventory.domain.Inventory;
import com.app.inventory.domain.InventoryTrans;
import com.app.inventory.domain.Product;
import com.app.inventory.util.UtilInv;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.LogManager;

/**
 *
 * @author frank
 */
public class PrintReports {
    private PrinterOptions p= new PrinterOptions();
    //MainAppController mainController = new MainAppController();
    private double totalFinal = 0;
    private FileInputStream fileInput;
    private Properties properties;
    private final org.apache.log4j.Logger logger = LogManager.getLogger(getClass());

    public PrintReports() {
        try {
            this.fileInput = new FileInputStream(new File("config/project.properties"));
        } catch (FileNotFoundException ex) {
            logger.error("Error trying loading the property file", ex);
        }
    }
    
    public void productSalesReport(List<Inventory> listInv, List<InventoryTrans> listInvTrans , String[] values){
        properties = new Properties();
        try {
            properties.load(fileInput);
        } catch (IOException ex) {
            Logger.getLogger(PrintReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Preparando reporte de venta");
        p.resetAll();
        p.initialize();
        p.feedBack((byte)2);
//        p.color(1);
        p.alignCenter();
        p.emphasized(true);
        p.setText(properties.getProperty("COMP_NAME", "Company Name"));
        p.newLine();
        p.setText(properties.getProperty("COMP_DESC","Little description"));
        p.newLine();
        p.addLineSeperator();
        //p.newLine();
        p.setText(properties.getProperty("SUB_TITLE", "Invoice")); 
        p.emphasized(true);
        p.newLine();
        p.addLineSeperator();
        p.alignLeft();
        p.setText("No factura \t\t: "+values[0]); 
        p.newLine();
        p.setText("Fecha \t\t\t: "+values[1]);
        p.newLine();
        p.setText("Cliente \t\t: "+values[2]);
        p.newLine();
        p.alignLeft();
        p.addLineSeperator(); //p.newLine();
        p.alignCenter();
        p.setText("Articulos");
        p.newLine();
        p.alignLeft();
//        p.newLine();
        p.addLineSeperator();// p.newLine();
        //p.setText("Producto     Qty     Total");
        p.setText(formatStr(30, "Producto") + formatStr(10,"Cant") + formatStr(8,"Valor"));
        p.newLine();
        p.addLineSeperator();
        
        //Iterar productos
//        product = productController.findProduct(inv.getIdProduct());
        
        listInv.forEach(inv ->{
//            InventoryTrans invTrans = null;
            Product product = MainAppController.productController.findProduct(inv.getIdProduct()); 
//            Query query = EntityManagerUtil.getEntityManager().createNamedQuery("InventoryTrans.findByIdInventoryAndProduct");
//            query.setParameter("idInventory", inv.getIdInventory());
//            query.setParameter("idProduct", product.getIdProduct());
            //(InventoryTrans) query.getResultList().get(0);
            listInvTrans.forEach(invTrans -> {
                if (Objects.equals(invTrans.getIdInventory(), inv.getIdInventory()) 
                        && Objects.equals(invTrans.getIdProduct(), inv.getIdProduct())) {
                    BigDecimal total =  invTrans.getPricexunit().multiply(new BigDecimal(invTrans.getQuantity()));
                    p.setText(
                            product.getProductCode() + "\t" 
                            +"$" +UtilInv.formatNumber(invTrans.getPricexunit().doubleValue()) + "   \n" 
//                            +p.newLine()
                            +formatStr(30,(product.getDescription())) 
                            +formatStr(10, invTrans.getQuantity().toString())
                            +formatStr(8, UtilInv.formatNumber(total.doubleValue()))
                            
                                    );
                    totalFinal = totalFinal + total.doubleValue();
                    p.newLine();
//                    p.addLineSeperator();
//                    p.setText(
//                            product.getProductCode() + "\t" + 
//                            (product.getDescription().length() < 7 ? product.getDescription() + "   \t" : product.getDescription()) 
//                            +"     "+ invTrans.getQuantity()+ "    " 
//                            + UtilInv.formatNumber(invTrans.getPricexunit().intValue()) + "   " 
//                            + UtilInv.formatNumber(total.intValue()));
//                    totalFinal = totalFinal + total.intValue();
//                    p.newLine();
//                    p.alignLeft();
                }
            }); 
            
            
        });
         //p.newLine();
        p.addLineSeperator();
        p.setText("Cant productos: "+listInv.size()+"\t    Total:  RD$ "+UtilInv.formatNumber(totalFinal));
        p.newLine();
        p.newLine();
        p.alignCenter();
        p.setText("***** Fin documento *****");
        p.newLine();
        p.newLine();
        p.setText(properties.getProperty("COMP_FOOTER_QUOTE","Little quote"));
//        p.newLine();
//        p.setText("No factura \t\t: "+values[0]);
//        p.newLine();
        logger.info("Imprimiendo reporte: "+values[0]);
        p.feed((byte)3);
        p.finit();
        
        System.out.println(p.finalCommandSet());
        System.out.println("******************************************************");
        
        p.feedPrinter(p.finalCommandSet().getBytes());
    }
    
    String formatStr(int amt, String text){
        return String.format("%-"+amt+"s", text);
    }
    
    public void printTest(){
        //PrinterOptions p= new PrinterOptions();

        p.resetAll();
        p.initialize();
        p.feedBack((byte)2);
//        p.color(1);
        p.alignCenter();
        p.setText("The Dum Dum Name");
        p.newLine();
        p.setText("Restaurant Dining");
        p.newLine();
        p.addLineSeperator();
        p.newLine();
        p.setText("Bling Bling");
        p.newLine();
        p.addLineSeperator();
        p.newLine();

        p.alignLeft();
        p.setText("POD No \t\t: 2001 \t\t Table \t: E511");
        p.newLine();              

        p.setText("Res Date \t: " +  "01/01/1801 22:59");

        p.newLine();
        p.setText("Session \t: Evening Session");
        p.newLine();
        p.setText("Staff \t\t: Bum Dale");
        p.newLine();
        p.addLineSeperator();
        p.newLine();
        p.alignCenter();
        p.setText(" - Some Items - ");
        p.newLine();
        p.alignLeft();
        p.addLineSeperator();

        p.newLine();

        p.setText("No \tItem\t\tUnit\tQty");
        p.newLine();
        p.addLineSeperator();
        
        p.newLine();
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
        p.newLine();
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
        p.newLine();
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
        p.newLine();
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
        p.newLine();
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
        p.newLine();
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
        p.newLine();
        
        p.addLineSeperator();
        p.feed((byte)3);
        p.finit();

        p.feedPrinter(p.finalCommandSet().getBytes());
        
    }
    
}
