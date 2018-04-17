/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory;

import com.app.inventory.util.EntityManagerUtil;
import com.app.inventory.view.MainForm;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.codehaus.griffon.runtime.lookandfeel.synthetica.SyntheticaLookAndFeelHandler;

/**
 *
 * @author Franklin Castillo
 */
public class App {
    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(org.codehaus.griffon.runtime.lookandfeel.synthetica.SyntheticaLookAndFeelModule"");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
        MainForm mainForm = new MainForm();
        EntityManagerUtil.getEntityManager();
        mainForm.setVisible(true);
//        new ConnectionDB().startServer();
//        SystemDaoJdbc daoJdbc = new SystemDaoJdbc();
//        daoJdbc.execTask();
//        //Some comment

    }
}
