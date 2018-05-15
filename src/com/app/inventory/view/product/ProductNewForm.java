/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.view.product;

import com.app.inventory.dao.controller.InventoryJpaController;
import com.app.inventory.dao.controller.InventoryTransJpaController;
import com.app.inventory.dao.controller.MainAppController;
import com.app.inventory.dao.controller.ProductJpaController;
import com.app.inventory.domain.Inventory;
import com.app.inventory.domain.InventoryTrans;
import com.app.inventory.domain.Product;
import com.app.inventory.domain.Supplier;
import com.app.inventory.util.EntityManagerUtil;
import com.app.inventory.util.UtilInv;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author frank
 */
public class ProductNewForm extends javax.swing.JFrame {

    private int idSupplierClicked;
    private MainAppController mainController = new MainAppController();
    private final ProductJpaController productController = new ProductJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    private final InventoryJpaController inventoryController = new InventoryJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    private final InventoryTransJpaController invTransController = new InventoryTransJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    private Supplier supplier;
   
    /**
     * Creates new form frmProduct
     */
    public ProductNewForm() {
        initComponents();
        
        ftxtPrice1.setFormatterFactory(UtilInv.getDecimalFormatFactory());
        ftxtPrice2.setFormatterFactory(UtilInv.getDecimalFormatFactory());
        ftxtPrice3.setFormatterFactory(UtilInv.getDecimalFormatFactory());
        ftxtCost.setFormatterFactory(UtilInv.getDecimalFormatFactory());
        jlPrice2.setVisible(false);
        jlPrice3.setVisible(false);
        ftxtPrice2.setVisible(false);
        ftxtPrice3.setVisible(false);
        jTableDialogSupplier.setDefaultEditor(Object.class, null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialogSupplier = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDialogSupplier = new javax.swing.JTable();
        btnOkSupplier = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        jlPrice3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlPrice2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNote = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSupplier = new javax.swing.JTextField();
        jpInitialStock = new javax.swing.JSpinner();
        jpMinStock = new javax.swing.JSpinner();
        ftxtPrice1 = new javax.swing.JFormattedTextField();
        ftxtPrice2 = new javax.swing.JFormattedTextField();
        ftxtPrice3 = new javax.swing.JFormattedTextField();
        ftxtCost = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jrYes = new javax.swing.JRadioButton();
        jrNo = new javax.swing.JRadioButton();
        btnFindProduct = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        jDialogSupplier.setTitle("Listado de Productos");

        jTableDialogSupplier.setAutoCreateRowSorter(true);
        jTableDialogSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDialogSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDialogSupplierMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableDialogSupplierMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDialogSupplier);

        btnOkSupplier.setText("Ok");
        btnOkSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogSupplierLayout = new javax.swing.GroupLayout(jDialogSupplier.getContentPane());
        jDialogSupplier.getContentPane().setLayout(jDialogSupplierLayout);
        jDialogSupplierLayout.setHorizontalGroup(
            jDialogSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSupplierLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jDialogSupplierLayout.setVerticalGroup(
            jDialogSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOkSupplier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de nuevo producto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del producto"));

        jLabel1.setText("Codigo:");

        jLabel2.setText("Descripcion:");

        jLabel3.setText("Categoria:");

        jlPrice3.setText("Precio 3:");

        jLabel5.setText("Precio 1:");

        jLabel7.setText("Costo:");

        jlPrice2.setText("Precio 2:");

        jLabel9.setText("Nota:");

        txtAreaNote.setColumns(20);
        txtAreaNote.setRows(5);
        jScrollPane1.setViewportView(txtAreaNote);

        jLabel6.setText("Stock Inicial:");

        jLabel10.setText("Stock Min:");

        jLabel11.setText("Proveedor:");

        txtSupplier.setEnabled(false);
        txtSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSupplierKeyPressed(evt);
            }
        });

        jpInitialStock.setModel(new javax.swing.SpinnerNumberModel());
        jpInitialStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpInitialStockKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpInitialStockKeyTyped(evt);
            }
        });

        jpMinStock.setModel(new javax.swing.SpinnerNumberModel());
        jpMinStock.setToolTipText("");

        ftxtPrice1.setText("0");
        ftxtPrice1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ftxtPrice1.setNextFocusableComponent(ftxtPrice2);
        ftxtPrice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtPrice1KeyTyped(evt);
            }
        });

        ftxtPrice2.setText("0");
        ftxtPrice2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ftxtPrice2.setNextFocusableComponent(ftxtPrice3);

        ftxtPrice3.setText("0");
        ftxtPrice3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ftxtPrice3.setNextFocusableComponent(txtAreaNote);

        ftxtCost.setText("0");
        ftxtCost.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ftxtCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftxtCostKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtCostKeyTyped(evt);
            }
        });

        jLabel12.setText("ITBIS incluido:");

        buttonGroup1.add(jrYes);
        jrYes.setSelected(true);
        jrYes.setText("Si");

        buttonGroup1.add(jrNo);
        jrNo.setText("No");

        btnFindProduct.setText("Find");
        btnFindProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jpInitialStock, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jpMinStock, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 27, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtCategory)
                                    .addGap(24, 24, 24)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtSupplier)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnFindProduct))
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                    .addComponent(txtCode))
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jlPrice2)
                                    .addComponent(jlPrice3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftxtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrYes)
                                .addGap(6, 6, 6)
                                .addComponent(jrNo))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1)))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ftxtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jrYes)
                    .addComponent(jrNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(ftxtPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jpInitialStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpMinStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlPrice3)
                            .addComponent(ftxtPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlPrice2)
                        .addComponent(ftxtPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(17, 17, 17))
        );

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClear)
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave)
                    .addComponent(btnClear))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        UtilInv.clearTextFields(this.getContentPane());
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (Integer.parseInt(jpInitialStock.getValue().toString()) <= 0) {
            JOptionPane.showMessageDialog(this, "Debe introducir cantidad en stock para poder continuar...", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        if (txtSupplier.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo de proveedor es obliigatorio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtSupplier.requestFocus();
        }else if(ftxtPrice1.getValue() == null || ftxtPrice1.getValue().toString().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Campo de precio es obliigatorio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            ftxtPrice1.requestFocus();
        }else{
    //        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            Product product = new Product();
            product.setCategory(txtCategory.getText());
            product.setCreatedDate(new java.sql.Timestamp(date.getTime()));
            product.setIdSupplier(idSupplierClicked);//Pendiente colocar el ID de un supplidor registrado
            product.setProductCode(txtCode.getText().replace(",", ""));
            product.setStatus(true);
            product.setDescription(txtDescripcion.getText());
            productController.create(product);

            //Obteniendo el ID_PRODUCT creado
            Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Product.findByProductCode");
            query.setParameter("productCode", product.getProductCode());
            product.setIdProduct(((Product)query.getResultList().get(0)).getIdProduct());

            //Entrada inicial al inventario
            Inventory inventory = new Inventory();
            inventory.setIdSupplier(idSupplierClicked);//(Integer.parseInt(txtSupplier.getText()));
            BigDecimal cost;
            if (jrYes.isSelected()) {
                //Costo viene con ITBIS
                cost = ftxtCost.getText().trim().equals("") ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(ftxtCost.getText().trim().replace(",", "")));
            }else{
                //Costo viene sin ITBIS
                cost = ftxtCost.getText().trim().equals("") ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(ftxtCost.getText().trim().replace(",", ""))).multiply(new BigDecimal(1.18));
            }
            inventory.setCost(cost);
            inventory.setAvgCost(cost);
            inventory.setMinStock(Integer.parseInt(jpMinStock.getValue().toString()));
            inventory.setStock(Integer.parseInt(jpInitialStock.getValue().toString()));
            inventory.setPrice1(ftxtPrice1.getText().trim().equals("") ? BigDecimal.ZERO :(BigDecimal) (ftxtPrice1.getText().trim().replace(",", "").isEmpty() ? 0 : BigDecimal.valueOf(Double.parseDouble(ftxtPrice1.getText().trim())))); 
            inventory.setPrice2(ftxtPrice2.getText().trim().equals("") ? BigDecimal.ZERO : (BigDecimal) (ftxtPrice2.getText().trim().replace(",", "").isEmpty() ? 0 : BigDecimal.valueOf(Double.parseDouble(ftxtPrice2.getText().trim())))); 
            inventory.setPrice3(ftxtPrice3.getText().trim().equals("") ? BigDecimal.ZERO : (BigDecimal) (ftxtPrice3.getText().trim().replace(",", "").isEmpty() ? 0 : BigDecimal.valueOf(Double.parseDouble(ftxtPrice3.getText().trim())))); 
            inventory.setPrice4(BigDecimal.ZERO);
            inventory.setIdProduct(product.getIdProduct());
            inventory.setTax(inventory.getCost().multiply(BigDecimal.valueOf(0.18)).intValue());//Pending
            inventory.setLastUpdated(new java.sql.Timestamp(date.getTime()));
            inventoryController.create(inventory);

            //Registrar detalle de la transaccion
            InventoryTrans invTrans = new InventoryTrans();
            invTrans.setNoDocument("000000");
            invTrans.setCostxunit(inventory.getCost());
            invTrans.setCreatedDate(inventory.getLastUpdated());
            invTrans.setDiscount(BigDecimal.ZERO);
            invTrans.setIdClient(0); //0 for purshasing
            invTrans.setIdInventory(inventory.getIdInventory());
            invTrans.setIdProduct(inventory.getIdProduct());
            invTrans.setIdSupplier(inventory.getIdSupplier());
            invTrans.setIdUser(1);
            invTrans.setPricexunit(BigDecimal.ZERO);//Para las compras este campo sera 0
            invTrans.setQuantity(inventory.getStock());
            invTrans.setTax(BigDecimal.ZERO);
            invTrans.setTotal(inventory.getCost().multiply(BigDecimal.valueOf(inventory.getStock().doubleValue())));
            invTrans.setTransType("compra");
            invTransController.create(invTrans);


            JOptionPane.showMessageDialog(this, "Guardado satisfactoriamente");
            UtilInv.clearTextFields(this.getContentPane());
            jpMinStock.setValue(0);
            jpInitialStock.setValue(0);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void ftxtCostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtCostKeyPressed
//        System.out.println("Pressed: " +evt.getKeyChar());
//        System.out.println(ftxtCost.getValue().toString());
//        double cost= Double.parseDouble(ftxtCost.getValue().toString().replace(",", "").replace(".", ""));
//        ftxtPrice1.setValue(getValueWithPercentage(cost, 1.3));
//        
//        double price1= Double.parseDouble(ftxtPrice1.getValue().toString().replace(",", "").replace(".", ""));
//        ftxtPrice2.setValue(getValueWithPercentage(price1, 1.2));
//        ftxtPrice3.setValue(getValueWithPercentage(price1, 1.1));
    }//GEN-LAST:event_ftxtCostKeyPressed

    private void ftxtPrice1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtPrice1KeyTyped
//        double price1= Double.parseDouble(ftxtPrice1.getValue().toString());
//       
//        ftxtPrice2.setValue(getValueWithPercentage(price1, 1.2));
//        ftxtPrice3.setValue(getValueWithPercentage(price1, 1.1));
    }//GEN-LAST:event_ftxtPrice1KeyTyped

    private void btnFindProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindProductActionPerformed
        loadTableDialogSupplier(mainController.getSupplierTableModel());
        jDialogSupplier.setSize(600, 350);
        jDialogSupplier.setLocationRelativeTo(null);
        jDialogSupplier.setVisible(true);
    }//GEN-LAST:event_btnFindProductActionPerformed

    private void jTableDialogSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDialogSupplierMouseClicked
        idSupplierClicked = Integer.parseInt(jTableDialogSupplier.getModel().getValueAt(jTableDialogSupplier.getSelectedRow(), 0).toString());
        //System.out.println("Row seletecd: "+idProductRowClicked);

        if (idSupplierClicked != -1) {
            //for product
            supplier = MainAppController.supplierController.findSupplier(idSupplierClicked);
            txtSupplier.setText(supplier.getDocument());
            //txtClientName.setText(supplier.getName());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para poder continuar...", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTableDialogSupplierMouseClicked

    private void btnOkSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkSupplierActionPerformed
        jDialogSupplier.setVisible(false);
        txtSupplier.requestFocus();
    }//GEN-LAST:event_btnOkSupplierActionPerformed

    private void txtSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            supplier = MainAppController.supplierController.findSupplier(idSupplierClicked);
            Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Supplier.findByDocument");
            query.setParameter("document", txtSupplier.getText().trim());
            List<Supplier> listSupplier = query.getResultList();
            if (listSupplier.isEmpty()) {
                System.out.println("Not found, char: "+evt.getKeyChar());
                JOptionPane.showMessageDialog(this, "Suplidor no existe en el sistema");
                txtSupplier.requestFocus();
            }else{
                supplier = listSupplier.get(0);
            }
        }
    }//GEN-LAST:event_txtSupplierKeyPressed
    String numberTyped = "";
    private void ftxtCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtCostKeyTyped
//        System.out.println("Pressed: " +evt.getKeyChar());
////        for (char c : numberTyped.toCharArray()){
//            if (Character.isDigit(evt.getKeyChar())) { //Solo entra si el caracter es un numero
//                numberTyped = ftxtCost.getValue() == null ? "1" : ftxtCost.getValue().toString() + evt.getKeyChar() ;
//                
//                double cost= Double.parseDouble(numberTyped);        
//        //        double price1= getValueWithPercentage(cost, 1.3);//Double.parseDouble(ftxtPrice1.getValue().toString().replace(",", "").replace(".", ""));
//                ftxtPrice1.setValue(getValueWithPercentage(cost, 1.3));
//                ftxtPrice2.setValue(getValueWithPercentage(cost, 1.2));
//                ftxtPrice3.setValue(getValueWithPercentage(cost, 1.1));
//            }
////        }
    }//GEN-LAST:event_ftxtCostKeyTyped

    private void jpInitialStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpInitialStockKeyPressed
        
    }//GEN-LAST:event_jpInitialStockKeyPressed

    private void jpInitialStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpInitialStockKeyTyped
        System.out.println("Pressed: " +evt.getKeyChar());
        for (char c : numberTyped.toCharArray()){
            if (Character.isDigit(c)) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_jpInitialStockKeyTyped

    private void jTableDialogSupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDialogSupplierMousePressed
        if (evt.getClickCount() == 2 && jTableDialogSupplier.getSelectedRow() != 1) {
            System.out.println("Clicked twice");
            jDialogSupplier.setVisible(false);
            txtSupplier.requestFocus();
        }
    }//GEN-LAST:event_jTableDialogSupplierMousePressed
   
    private void loadTableDialogSupplier(DefaultTableModel model){
        jTableDialogSupplier.setModel(model);
        jTableDialogSupplier.removeColumn(jTableDialogSupplier.getColumnModel().getColumn(0));//to hide the first column ID
    } 
    
    private double getValueWithPercentage(double value, double percentage){
        double cost= value  * percentage;
        
        return cost;
    }
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
            java.util.logging.Logger.getLogger(ProductNewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductNewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductNewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductNewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductNewForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFindProduct;
    private javax.swing.JButton btnOkSupplier;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField ftxtCost;
    private javax.swing.JFormattedTextField ftxtPrice1;
    private javax.swing.JFormattedTextField ftxtPrice2;
    private javax.swing.JFormattedTextField ftxtPrice3;
    private javax.swing.JDialog jDialogSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDialogSupplier;
    private javax.swing.JLabel jlPrice2;
    private javax.swing.JLabel jlPrice3;
    private javax.swing.JSpinner jpInitialStock;
    private javax.swing.JSpinner jpMinStock;
    private javax.swing.JRadioButton jrNo;
    private javax.swing.JRadioButton jrYes;
    private javax.swing.JTextArea txtAreaNote;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtSupplier;
    // End of variables declaration//GEN-END:variables
}
