/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.printer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JOptionPane;
import org.apache.log4j.LogManager;

/**
 *
 * @author frank
 */
public class PrinterOptions {
    String commandSet = "";
    FileInputStream fileInput;
    Properties properties;
    private final org.apache.log4j.Logger logger;
    
    public PrinterOptions() {
        this.logger = LogManager.getLogger(getClass());
        try {
            this.fileInput = new FileInputStream(new File("config/project.properties"));
        } catch (FileNotFoundException ex) {
            logger.fatal("Archivo de propiedades no encontrado" + ex);
        }
    }
    

    public String initialize() {
        final byte[] Init = {27, 64};
        commandSet += new String(Init);
        return new String(Init);
    }

    public String chooseFont(int Options) {
        String s = "";
        final byte[] ChooseFontA = {27, 77, 0};
        final byte[] ChooseFontB = {27, 77, 1};
        final byte[] ChooseFontC = {27, 77, 48};
        final byte[] ChooseFontD = {27, 77, 49};

        switch(Options) {
            case 1:
            s = new String(ChooseFontA);
            break;

            case 2:
            s = new String(ChooseFontB);
            break;

            case 3:
            s = new String(ChooseFontC);
            break;

            case 4:
            s = new String(ChooseFontD);
            break;

            default:
            s = new String(ChooseFontB);
        }
        commandSet += s;
        return new String(s);
    }

    public String feedBack(byte lines) {
        final byte[] Feed = {27,101,lines};
        String s = new String(Feed);
        commandSet += s;
        return s;
    }

    public String feed(byte lines) {
        final byte[] Feed = {27,100,lines};
        String s = new String(Feed);
        commandSet += s;
        return s;
    }

    public String alignLeft() {
        final byte[] AlignLeft = {27, 97,48};
        String s = new String(AlignLeft);
        commandSet += s;
        return s;
    }

    public String alignCenter() {
        final byte[] AlignCenter = {27, 97,49};
        String s = new String(AlignCenter);
        commandSet += s;
        return s;
    }

    public String alignRight() {
        final byte[] AlignRight = {27, 97,50};
        String s = new String(AlignRight);
        commandSet += s;
        return s;
    }

    public String newLine() {
        final  byte[] LF = {10};
        String s = new String(LF);
        commandSet += s;
        return s;
   }

   public String reverseColorMode(boolean enabled) {
        final byte[] ReverseModeColorOn = {29, 66, 1};
        final byte[] ReverseModeColorOff = {29, 66, 0};

        String s = "";
        if(enabled)
            s = new String(ReverseModeColorOn);
        else
            s = new String(ReverseModeColorOff);

        commandSet += s;
        return s;
    } 

    public String doubleStrik(boolean enabled) {
        final byte[] DoubleStrikeModeOn = {27, 71, 1};
        final byte[] DoubleStrikeModeOff = {27, 71, 0};

        String s="";
        if(enabled)
            s = new String(DoubleStrikeModeOn);
        else
            s = new String(DoubleStrikeModeOff);

        commandSet += s;
        return s;
    } 

    public String doubleHeight(boolean enabled) {
        final byte[] DoubleHeight = {27, 33, 17};
        final byte[] UnDoubleHeight={27, 33, 0};

        String s = "";
        if(enabled)
            s = new String(DoubleHeight);
        else
            s = new String(UnDoubleHeight);

        commandSet += s;
        return s;
    }

    public String emphasized(boolean enabled) {
        final byte[] EmphasizedOff={27 ,0};
        final byte[] EmphasizedOn={27 ,1};

        String s="";
        if(enabled)
            s = new String(EmphasizedOn);
        else
            s = new String(EmphasizedOff);

        commandSet += s;
        return s;
    } 

    public String underLine(int Options) {
        final byte[] UnderLine2Dot = {27, 45, 50};
        final byte[] UnderLine1Dot = {27, 45, 49};
        final byte[] NoUnderLine = {27, 45, 48};

        String s = "";
        switch(Options) {
            case 0:
            s = new String(NoUnderLine);
            break;

            case 1:
            s = new String(UnderLine1Dot);
            break;

            default:
            s = new String(UnderLine2Dot);
        }
        commandSet += s;
        return new String(s);
    }

    public String color(int Options) {
        final byte[] ColorRed = {27, 114, 49};
        final byte[] ColorBlack = {27, 114, 48};

        String s = "";
        switch(Options) {
            case 0:
            s = new String(ColorBlack);
            break;

            case 1:
            s = new String(ColorRed);
            break;

            default:
            s = new String(ColorBlack);
        }
        commandSet += s;
        return s;
    }

    public String finit() {
        final byte[] FeedAndCut = {29, 'V', 66, 0};

        String s = new String(FeedAndCut);

        final byte[] DrawerKick={27,70,0,60,120};   
        s += new String(DrawerKick);

        commandSet+=s;
        return s;
    }

    public String addLineSeperator() {
        String lineSpace = "------------------------------------------------\n";
        commandSet += lineSpace;
        return lineSpace;
    }

    public void resetAll() {
        commandSet = "";
    }

    public void setText(String s) {
        commandSet+=s;
    }

    public String finalCommandSet() {
        return commandSet;
    }
    
    public boolean feedPrinter(byte[] b) {
        properties = new Properties();
        try {
            properties.load(fileInput);
        } catch (IOException ex) {
            logger.fatal(ex);
            ex.printStackTrace();
        }
    try {       
        AttributeSet attrSet = new HashPrintServiceAttributeSet(new PrinterName(properties.getProperty("PRINTER_NAME", "EPSON TM-T20II"), null)); //EPSON TM-U220 ReceiptE4        
        
        DocPrintJob job = PrintServiceLookup.lookupPrintServices(null, attrSet)[0].createPrintJob(); 
        //System.out.println("Printed located and loaded");
        logger.info("Printed located and loaded");
        //PrintServiceLookup.lookupDefaultPrintService().createPrintJob();  

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(b, flavor, null);
        PrintJobWatcher pjDone = new PrintJobWatcher(job);

        job.print(doc, null);
        //pjDone.waitForDone();
        attrSet.clear();
        System.out.println("Done !");
       
    } catch (javax.print.PrintException pex) {
        logger.fatal("Printer Error " + pex);
        pex.printStackTrace();
        return false;
    } catch(ArrayIndexOutOfBoundsException e){
        logger.fatal("Printer not found " + e);
        JOptionPane.showMessageDialog(null, "Printer not found...");
        e.printStackTrace();
        return false; 
    } catch(Exception e) {
        logger.fatal("Printer Error " + e);
        e.printStackTrace();
        return false;
    }
    return true;
}
    
}