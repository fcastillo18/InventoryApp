/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.printer;

import com.app.inventory.dao.controller.MainAppController;
import com.app.inventory.domain.Inventory;
import com.app.inventory.domain.Product;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author frank
 */
public class PrintReports {
    PrinterOptions p= new PrinterOptions();
    //MainAppController mainController = new MainAppController();
    int totalFinal = 0;
    
    public void productSalesReport(List<Inventory> listInv, String[] values){
        System.out.println("Preparando reporte de venta");
        p.resetAll();
        p.initialize();
        p.feedBack((byte)2);
//        p.color(1);
        p.alignCenter();
        p.setText("Company Name");
        p.newLine();
        p.setText("Little description");
        p.newLine();
        p.addLineSeperator();
        //p.newLine();
        p.setText("Invoice"); 
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
        p.setText("Items");
        p.newLine();
        p.alignLeft();
//        p.newLine();
        p.addLineSeperator();// p.newLine();
        p.setText("Codigo\t Producto     Qty   Precio   Total");
        p.newLine();
        p.addLineSeperator();
        
        //Iterar productos
//        product = productController.findProduct(inv.getIdProduct());
        
        listInv.forEach(inv ->{
            Product product = MainAppController.productController.findProduct(inv.getIdProduct()); 
            BigDecimal total =  inv.getPrice1().multiply(new BigDecimal(inv.getStock()));
            p.setText(product.getProductCode() + "\t" + (product.getDescription().length() < 7 ? product.getDescription() + "   \t" : product.getDescription()) +"   "+ inv.getStock() + "   " + inv.getPrice1().intValue() + "   " + total.intValue());
            totalFinal = totalFinal + total.intValue();
            p.newLine();
            p.alignLeft();
        });
        p.addLineSeperator();
        p.setText("\t\t\t Total:RD$ "+totalFinal);
        p.newLine();
        p.setText("Fin documento");
//        p.newLine();
//        p.setText("No factura \t\t: "+values[0]);
//        p.newLine();
        System.out.println("Imprimiendo reporte");
        p.feed((byte)3);
        p.finit();

        p.feedPrinter(p.finalCommandSet().getBytes());
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
