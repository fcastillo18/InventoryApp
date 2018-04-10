/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory;

import com.app.inventory.dao.ConnectionDB;
import com.app.inventory.dao.SystemDaoJdbc;
import com.app.inventory.view.MainForm;

/**
 *
 * @author Franklin Castillo
 */
public class App {
    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        //mainForm.setVisible(true);
        new ConnectionDB().startServer();
        SystemDaoJdbc daoJdbc = new SystemDaoJdbc();
        daoJdbc.execTask();
        //Some comment
    }
}
