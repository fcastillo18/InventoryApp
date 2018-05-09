/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory;

import com.app.inventory.dao.controller.MainAppController;
import com.app.inventory.util.EntityManagerUtil;
import com.app.inventory.view.MainForm;
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

//        try {
//            UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
//        } catch (ParseException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }

        MainForm mainForm = new MainForm();
        EntityManagerUtil.getEntityManager();
        mainForm.setVisible(true);
        //String formatted to use in report.
        System.out.println(String.format("%-10s", "Texto"));
        System.out.println(String.format("%-10.10s", "Texto"));
        
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
    }
    
   
}
