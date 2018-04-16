/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.view.product;

import com.app.inventory.dao.controller.SupplierJpaController;
import com.app.inventory.dao.controller.InventoryJpaController;
import com.app.inventory.dao.controller.InventoryTransJpaController;
import com.app.inventory.dao.controller.ProductJpaController;
import com.app.inventory.domain.Supplier;
import com.app.inventory.domain.Inventory;
import com.app.inventory.domain.InventoryTrans;
import com.app.inventory.domain.Product;
import com.app.inventory.util.EntityManagerUtil;
import com.app.inventory.util.UtilInv;
import com.app.inventory.view.supplier.SupplierNewForm;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Franklin Castillo
 */
public class ProductEntryForm extends javax.swing.JFrame {
        
    List<Inventory> listInv = null;
    Supplier supplier = null;
    Product product = null;
    InventoryTrans invTrans = null; 
    InventoryJpaController inventoryController = null;
    SupplierJpaController supplierController = null;
    ProductJpaController productController = null;
    InventoryTransJpaController invTransController = null;
    private int lastNoTrans;  
    private int idProductRowClicked;
    private int idSupplierRowClicked;
    
    private void initObjects(){
        inventoryController = new InventoryJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
        supplierController = new SupplierJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
        productController = new ProductJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
        invTransController = new InventoryTransJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
        ftxtQuantity.setFormatterFactory(UtilInv.getIntegerFormatFactory());
        datePicker.setDateToToday();
        datePicker.setName("datePicker");
        listInv = new ArrayList<Inventory>();
        lastNoTrans = inventoryController.getInventoryCount()+1; 
        txtLastTrans.setText(String.valueOf(lastNoTrans));
        fillCombo("product");
        fillCombo("supplier");
    }
    
    private void fillCombo(String combo){
        if(combo.equals("product")){
            comboProduct.addItem("");
            productController.findProductEntities().forEach(prod -> {
                comboProduct.addItem(prod.getIdProduct()+"-"+prod.getDescripcion());
            });
        }else if(combo.equals("supplier")){
            comboSupplier.addItem("");
            supplierController.findSupplierEntities().forEach(sup -> {
                comboSupplier.addItem(sup.getIdSupplier()+"-"+sup.getName());
            });
        }
        
    }
    
    /**
     * Creates new form ProductEntryForm
     */
    public ProductEntryForm() {
        initComponents();
        initObjects();
        loadTable(listInv);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDialog = new javax.swing.JTable();
        btnOk = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRerence = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAddSupplier = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnNewProduct = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ftxtQuantity = new javax.swing.JFormattedTextField();
        txtLastTrans = new javax.swing.JTextField();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();
        comboProduct = new javax.swing.JComboBox<>();
        comboSupplier = new javax.swing.JComboBox<>();
        btnFindProduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        jDialog1.setTitle("Listado de Productos");

        jTableDialog.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDialogMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableDialog);

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de la entrada"));

        jLabel1.setText("Numero:");

        jLabel2.setText("Fecha:");

        jLabel3.setText("Referencia:");

        txtRerence.setText("125DMF");

        jLabel4.setText("Nota:");

        jTextField3.setText("Una nota");

        jLabel5.setText("Proveedor:");

        btnAddSupplier.setText("+");
        btnAddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSupplierActionPerformed(evt);
            }
        });

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
        });

        jLabel7.setText("Producto:");

        btnNewProduct.setText("+");
        btnNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProductActionPerformed(evt);
            }
        });

        jLabel8.setText("Cantidad:");

        ftxtQuantity.setText("25");
        ftxtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ftxtQuantityFocusGained(evt);
            }
        });

        txtLastTrans.setEditable(false);
        txtLastTrans.setName("txtLastTrans"); // NOI18N

        datePicker.setName("datePicker"); // NOI18N

        comboProduct.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProductItemStateChanged(evt);
            }
        });
        comboProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboProductMouseClicked(evt);
            }
        });

        comboSupplier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSupplierItemStateChanged(evt);
            }
        });
        comboSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboSupplierMouseClicked(evt);
            }
        });

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
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFindProduct)
                                .addGap(3, 3, 3)
                                .addComponent(btnNewProduct)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtLastTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRerence, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ftxtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtRerence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtLastTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnNewProduct)
                    .addComponent(jLabel5)
                    .addComponent(btnAddSupplier)
                    .addComponent(comboProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(jLabel8)
                    .addComponent(ftxtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("Totales:");

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

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)
                        .addGap(19, 19, 19)
                        .addComponent(btnSave)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(listInv == null ){
            JOptionPane.showMessageDialog(this, "Debe agregar registros a la lista para poder continuar...", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{ 
            listInv.forEach(inv -> {
                //Inventory
                //hay que verificar si existe para crear o editar 
                inventoryController.create(inv);
                
                /*Inventory Transaction*/
                invTrans = new InventoryTrans();
                invTrans.setIdInventory(1);//sopesar el colocar el id del inventory creado en la linea de arriba
                invTrans.setIdProduct(inv.getIdProduct());
                invTrans.setIdProveedor(inv.getIdProveedor());
                invTrans.setIdClient(0);
                invTrans.setIdUser(1);//modificar cuando se haga modulo de user
                invTrans.setTransType("in");
                invTrans.setDiscount(BigDecimal.ZERO);
                invTrans.setQuantity(inv.getQuantity());
                //pendiente cambiar y poner a guardar en priceunit as bigdecimal`
                BigDecimal price = productController.findProduct(inv.getIdProduct()).getPrice1();
                invTrans.setPricexunit(price);
                invTrans.setTotal(price.multiply(new BigDecimal(inv.getQuantity())));
                invTrans.setCreatedDate(inv.getLastUpdated());
            
                invTransController.create(invTrans);
            });
            
            //Final
            JOptionPane.showMessageDialog(this, "Guardado satisfactoriamente");
            listInv.clear(); //this lista has to be empty to store new products that will be shown on the table
            UtilInv.clearTextFields(this.getContentPane());
            loadTable(listInv);
            lastNoTrans = inventoryController.getInventoryCount()+1;
            txtLastTrans.setText(String.valueOf(lastNoTrans));
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Inventory inv = new Inventory();
        Date date = new Date(datePicker.getText());
//        DateFormat defaultDf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//DateFormat.getDateTimeInstance();
//        System.out.println(defaultDf.format(date));
        
        inv.setIdProduct(product.getIdProduct());
        inv.setIdProveedor(supplier.getIdSupplier());
        inv.setLastUpdated(UtilInv.getDateNow());
        inv.setQuantity(Integer.parseInt(ftxtQuantity.getText().replace(",", "")));
        inv.setLastUpdated(date);
        listInv.add(inv);
        
        product = productController.findProduct(inv.getIdProduct());
        supplier = supplierController.findSupplier(inv.getIdProveedor());
       
        loadTable(listInv);
        UtilInv.clearTextFields(this.getContentPane());
        
        txtLastTrans.setText(String.valueOf(lastNoTrans++));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        UtilInv.clearTextFields(this.getContentPane());
        loadTable(null);
        txtLastTrans.setText(String.valueOf(lastNoTrans++));
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            btnAddActionPerformed(null);
        }
    }//GEN-LAST:event_btnAddKeyPressed

    private void ftxtQuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftxtQuantityFocusGained
        ftxtQuantity.setValue(null);
    }//GEN-LAST:event_ftxtQuantityFocusGained

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
//        Product p = productController.findProduct(idProductRowClicked);
        if (idProductRowClicked !=0) {
            listInv.remove(idProductRowClicked);
    //        System.out.println(p+" remove: "+remove);
            loadTable(listInv);
                txtLastTrans.setText(String.valueOf(lastNoTrans--));    
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para poder continuar...", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
//        Date date = new Date(datePicker.getText());
//        DateFormat defaultDf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//DateFormat.getDateTimeInstance();
//        System.out.println(date);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSupplierActionPerformed
        SupplierNewForm sNew = new SupplierNewForm();
        sNew.setVisible(true);
    }//GEN-LAST:event_btnAddSupplierActionPerformed

    private void btnNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProductActionPerformed
        ProductNewForm pNew = new ProductNewForm();
        pNew.setVisible(true);
    }//GEN-LAST:event_btnNewProductActionPerformed

    private void btnFindProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindProductActionPerformed
        loadTableDialog();
        jDialog1.setSize(600, 350);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_btnFindProductActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        jDialog1.setVisible(false);
    }//GEN-LAST:event_btnOkActionPerformed

    private void jTableDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDialogMouseClicked
        idProductRowClicked = Integer.parseInt(jTableDialog.getModel().getValueAt(jTableDialog.getSelectedRow(), 0).toString());
        idSupplierRowClicked = Integer.parseInt(jTableDialog.getModel().getValueAt(jTableDialog.getSelectedRow(), 1).toString());
        System.out.println("Row seletecd: "+idProductRowClicked);
        
        if (idProductRowClicked != -1) {
            //for product
            product = productController.findProduct(idProductRowClicked);
            comboProduct.setSelectedItem(product.getIdProduct()+"-"+product.getDescripcion());
            
            //for supplier
            supplier = supplierController.findSupplier(idSupplierRowClicked);
            comboSupplier.setSelectedItem(supplier.getIdSupplier()+"-"+supplier.getName());
            
            System.out.println("com.app.inventory.view.ProductListForm.btnEditProductActionPerformed()");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para poder continuar...", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTableDialogMouseClicked

    private void comboProductItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProductItemStateChanged
        if (comboProduct.getSelectedItem().toString() != ""){ 
            idProductRowClicked = Integer.parseInt(comboProduct.getSelectedItem().toString().split("-")[0]);
            product = productController.findProduct(idProductRowClicked);
            
            //for supplier
            idSupplierRowClicked = product.getIdSupplier();
            supplier = supplierController.findSupplier(idSupplierRowClicked);
            comboSupplier.setSelectedItem(supplier.getIdSupplier()+"-"+supplier.getName());
        }
    }//GEN-LAST:event_comboProductItemStateChanged

    private void comboSupplierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSupplierItemStateChanged
        if (comboSupplier.getSelectedItem().toString() != "") {
            idSupplierRowClicked = Integer.parseInt(comboSupplier.getSelectedItem().toString().split("-")[0]);
            supplier = supplier = supplierController.findSupplier(idSupplierRowClicked);
        }
    }//GEN-LAST:event_comboSupplierItemStateChanged

    private void comboProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboProductMouseClicked
//        if (comboProduct.getSelectedItem().toString() != "") {
//            idProductRowClicked = Integer.parseInt(comboProduct.getSelectedItem().toString().split("-")[0]);
//            product = productController.findProduct(idProductRowClicked);
//        }
    }//GEN-LAST:event_comboProductMouseClicked

    private void comboSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboSupplierMouseClicked
//        if (comboProveedor.getSelectedItem().toString() != "") {
//            idSupplierRowClicked = Integer.parseInt(comboProduct.getSelectedItem().toString().split("-")[0]);
//            supplier = supplier = supplierController.findSupplier(idSupplierRowClicked);
//        }
    }//GEN-LAST:event_comboSupplierMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        idProductRowClicked = jTable1.getSelectedRow();//Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString());
        System.out.println(idProductRowClicked);
    }//GEN-LAST:event_jTable1MouseClicked

    private void loadTable(List<Inventory> list){
        jTable1.setModel(this.getTableDataModel(list));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));//to hide the first column ID
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(1));//to hide the first column ID
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(2));//to hide the first column ID
    }
    
    private void loadTableDialog(){
        jTableDialog.setModel(this.getProductDataModel(productController));
        jTableDialog.removeColumn(jTableDialog.getColumnModel().getColumn(0));//to hide the first column ID
        jTableDialog.removeColumn(jTableDialog.getColumnModel().getColumn(1));//to hide the first column ID
    } 
    
    private DefaultTableModel getProductDataModel(ProductJpaController productController){
        String columns[] = {"ID_prod","ID Suplidor" ,"Codigo", "Descripcion", "Categoria", "Precio", "Costo", "Min Stock", "Ideal Stock"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
             
        productController.findProductEntities().forEach(prod -> {
            tableModel.addRow(new Object[]{ prod.getIdProduct(),prod.getIdSupplier(), prod.getProductCode(), prod.getDescripcion(), prod.getCategory(), prod.getPrice1() ,prod.getCost(), prod.getMinStock(), prod.getMaxStock()});
        }); 
        
        return tableModel;
    }
            
    private DefaultTableModel getTableDataModel(List<Inventory> list){
        String columns[] = {"ID","Idprod", "ID_Supplidor", "Codigo", "Descripcion", "Cantidad", "Costo", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        
        try {
            if(list == null ){
            //tableModel.addRow(new Object[]{ }); 
            }else{
                list.forEach(inv -> {
    //                BigDecimal total = new BigDecimal(BigInteger.ZERO,  2);
                    BigDecimal total =  product.getCost().multiply(new BigDecimal(inv.getQuantity()));
                    tableModel.addRow(new Object[]{inv.getIdInventory(), inv.getIdProduct(), inv.getIdProveedor(), product.getProductCode(), product.getDescripcion(), inv.getQuantity(), product.getCost(), total});
                }); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        
        return tableModel;
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
            java.util.logging.Logger.getLogger(ProductEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductEntryForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddSupplier;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFindProduct;
    private javax.swing.JButton btnNewProduct;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboProduct;
    private javax.swing.JComboBox<String> comboSupplier;
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JFormattedTextField ftxtQuantity;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableDialog;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txtLastTrans;
    private javax.swing.JTextField txtRerence;
    // End of variables declaration//GEN-END:variables
}
