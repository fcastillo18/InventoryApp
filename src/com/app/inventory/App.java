/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory;

import com.app.inventory.dao.controller.MainAppController;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
//import java.text.ParseException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;


//import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;


/**
 *
 * @author Franklin Castillo
 */
public class App {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
        } catch (ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        

//        MainForm mainForm = new MainForm();
//        mainForm.setVisible(true);
        //String formatted to use in report.
//        System.out.println(String.format("%-10s", "Texto"));
//        System.out.println(String.format("%-10.10s", "Texto"));
        
        //new MainAppController().getAndPrintInvTransByDocument("000002");
        
//          MainAppController app = new MainAppController();
//          app.nextDocNo();

        //System.exit(0);
//        new ConnectionDB().startServer();
//        SystemDaoJdbc daoJdbc = new SystemDaoJdbc();
//        daoJdbc.execTask();
//        //Some comment
//            try {
//                PrinterService printerService = new PrinterService();
//		
//		System.out.println(printerService.getPrinters());
//				
//		//print some stuff
//		printerService.printString("EPSON TM-T20II", "\n\n testing testing 1 2 3eeeee \n\n\n\n\n\n\n\n\n\n\n testing");
// 
//		// cut that paper!
//		byte[] cutP = new byte[] { 0x1d, 'V', 1 };
// 
//		printerService.printBytes("EPSON TM-T20II", cutP);
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                e.printStackTrace();
//                
//            }   

        String[] columns = {"Column1", "Column2", "Column3", "Column4"};
        String[] row = {"Cell1", "Cell2", "Cell3", "Cell4"};
        String[] row2 = {"Cell11", "Cell22", "Cell33", "Cell44"};
        String[] row3 = {"Cell111", "Cell222", "Cell333", "Cell444"};
        ArrayList<Object[]> list = new ArrayList<>();
        list.add(row);
        list.add(row2);
        list.add(row3);
        String path= "C:/excel.xlsx";
        
        MainAppController.writeExcelFile(list, columns, true, path);
        
    }
    
    
    
    
   
}


