/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.view.trans;

import com.app.inventory.dao.controller.InventoryJpaController;
import com.app.inventory.dao.controller.MainAppController;
import com.app.inventory.dao.controller.ProductJpaController;
import com.app.inventory.domain.Inventory;
import com.app.inventory.domain.Product;
import com.app.inventory.util.EntityManagerUtil;
import com.sun.glass.events.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author frank
 */
public class InventoryList extends javax.swing.JFrame {

    /**
     * Creates new form InventoryList
     */
    public InventoryList() {
        initComponents();
        inventoryController = new InventoryJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
        inventoryList = inventoryController.findInventoryEntities();
        productController = new ProductJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
        loadTable(new MainAppController().getProductInvTableModel(MainAppController.inventoryController.findInventoryEntities()));
        jTable1.setDefaultEditor(Object.class, null);
    }
    
    private Inventory inventory = null;
    private InventoryJpaController inventoryController = null;
    private List<Inventory> inventoryList = null;
    private Product product = null;
    private ProductJpaController productController= null;
    private MainAppController mainController = new MainAppController();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtProductFilter = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel3.setText("Producto:");

        txtProductFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductFilterKeyPressed(evt);
            }
        });

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        btnSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProductFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProductFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnRefresh.setText("Actualizar");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String textToFilter = txtProductFilter.getText().trim();
        
        loadTable(mainController.getProductInvTableModel(textToFilter));
//        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Product.findByFilters");
//        query.setParameter("productCode", "%"+textToFilter+"%");
//        query.setParameter("description", "%"+textToFilter+"%");
//        List<Product> listProduct = query.getResultList();
//        listProduct.forEach(prod -> {
//            MainAppController.inventoryController.fin
//        });
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtProductFilterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductFilterKeyPressed
        if (txtProductFilter.getText().length() >= 1) {
            String textToFilter = txtProductFilter.getText().trim();
            System.out.println("Length: "+txtProductFilter.getText().length()+" - "+textToFilter);
            loadTable(mainController.getProductInvTableModel(textToFilter));
        }else{
            loadTable(new MainAppController().getProductInvTableModel(MainAppController.inventoryController.findInventoryEntities()));
        }
    }//GEN-LAST:event_txtProductFilterKeyPressed

    private void btnSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSearchKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            String textToFilter = txtProductFilter.getText().trim();
            loadTable(mainController.getProductInvTableModel(textToFilter));
        }
    }//GEN-LAST:event_btnSearchKeyPressed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadTable(new MainAppController().getProductInvTableModel(MainAppController.inventoryController.findInventoryEntities()));
    }//GEN-LAST:event_btnRefreshActionPerformed

    
    private void loadTable(DefaultTableModel model){
        jTable1.setModel(model);
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));//to hide the first column ID
//        jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));//to hide the first column ID
//        jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));//to hide the first column ID
    }
    
//    private DefaultTableModel getTableDataModel(List<Inventory> list){
//        String columns[] = {"ID_inv","ID Prod", "Codigo", "Descripcion", "Cantidad"};
//        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
//        
//        try {
//            if(list == null ){
//            //tableModel.addRow(new Object[]{ }); 
//            }else{
//                list.forEach(inv -> {
//                    product = productController.findProduct(inv.getIdProduct());
//                    BigDecimal total =  product.getPrice1().multiply(new BigDecimal(inv.getQuantity()));
//                    tableModel.addRow(new Object[]{inv.getIdInventory(), inv.getIdProduct(), product.getProductCode(), product.getDescripcion(), inv.getQuantity()});
//                }); 
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//        
//        return tableModel;
//    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtProductFilter;
    // End of variables declaration//GEN-END:variables
}
