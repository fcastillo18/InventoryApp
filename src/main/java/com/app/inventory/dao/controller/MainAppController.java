/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.dao.controller;

import com.app.inventory.domain.Client;
import com.app.inventory.domain.Inventory;
import com.app.inventory.domain.InventoryTrans;
import com.app.inventory.domain.Product;
import com.app.inventory.domain.Supplier;
import com.app.inventory.util.EntityManagerUtil;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franklin Castillo
 */
public class MainAppController {

    public MainAppController() {
        //Inicializando controladores
        listInv = new ArrayList<>();
        listInvTrans = new ArrayList<>();
        listProduct = new ArrayList<>();
        listSupplier = new ArrayList<>();
        listClient = new ArrayList<>();
    }
    //Entidades 
    private Supplier supplier = null;
    private Product product = null;
    private Inventory inventory = null;
    private Client client = null;
    private InventoryTrans invTrans = null;
    
    //Lista de Entidades
    private List<Inventory> listInv = null;
    private List<InventoryTrans> listInvTrans = null;
    private List<Product> listProduct = null;
    private List<Supplier> listSupplier = null;
    private List<Client> listClient = null;
    
    //Controladores de Entidades
    public static SupplierJpaController supplierController = new SupplierJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    public static ProductJpaController productController = new ProductJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    public static ClientJpaController clientController = new ClientJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    public static InventoryJpaController inventoryController = new InventoryJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    public static InventoryTransJpaController invTransController = new InventoryTransJpaController(EntityManagerUtil.getEntityManager().getEntityManagerFactory());
    
    //otras variables
    private DecimalFormat df = new DecimalFormat( "#,###,###,##0" );
    
    /************Metodos para retornar tabla
     * @return s*************/
    public DefaultTableModel getClientTableModel(){
        String columns[] = {"ID","Documento", "Nombre", "Telefono"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    
        listClient = clientController.findClientEntities();
        
        if (listClient == null) {
            tableModel.addRow(new Object[]{ }); 
        }else{
            listClient.forEach(client -> {
                if (client.getStatus()) {
                    tableModel.addRow(new Object[]{client.getIdClient(), 
                        client.getDocument(), client.getName(), client.getPhone()});
                }

            });
        }
        
        return tableModel;
    }
    
    public DefaultTableModel getProductTableModel(){
        String columns[] = {"Idprod", "ID_Supplidor", "Codigo", "Descripcion", "Cantidad", "Costo", "Precio"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        
        List<Inventory> listInv2 = inventoryController.findInventoryEntities();
        
        try {
            if(listInv2 == null ){
                tableModel.addRow(new Object[]{ }); 
            }else{
                listInv2.forEach(inv -> {
                    product = productController.findProduct(inv.getIdProduct());
    //                BigDecimal total = new BigDecimal(BigInteger.ZERO,  2);
//                    BigDecimal total =  inv.getCost().multiply(new BigDecimal(inv.getStock()));
                    tableModel.addRow(new Object[]{inv.getIdProduct(), inv.getIdSupplier(), 
                        product.getProductCode(), product.getDescription(), inv.getStock(), 
                        df.format(inv.getCost().doubleValue()), df.format(inv.getPrice1().doubleValue())
                    });
                }); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        listInv2.clear();
        return tableModel;
    }
    public DefaultTableModel getPurchaseProductTableModel(){
        String columns[] = {"ID","Idprod", "ID_Supplidor", "Codigo", "Descripcion", "Cantidad", "Costo", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        
        try {
            if(getListInv() == null ){
                tableModel.addRow(new Object[]{ }); 
            }else{
                getListInv().forEach(inv -> {
                    product = productController.findProduct(inv.getIdProduct());
    //                BigDecimal total = new BigDecimal(BigInteger.ZERO,  2);
                    BigDecimal total =  inv.getCost().multiply(new BigDecimal(inv.getStock()));
                    tableModel.addRow(new Object[]{inv.getIdInventory(), inv.getIdProduct(), 
                        inv.getIdSupplier(), product.getProductCode(), product.getDescription(), 
                        df.format(inv.getStock().doubleValue()), 
                        df.format(inv.getCost().doubleValue()), 
                        df.format(total.doubleValue())
                    });
                }); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        
        return tableModel;
    }
    
    public DefaultTableModel getSalesProductTableModel(){
        String columns[] = {"ID","Idprod", "ID_Supplidor", "Codigo", "Descripcion", "Cantidad", "Precio", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        
        try {
            if(getListInv() == null ){
                tableModel.addRow(new Object[]{ }); 
            }else{
                getListInv().forEach(inv -> {
                    product = productController.findProduct(inv.getIdProduct());
    //                BigDecimal total = new BigDecimal(BigInteger.ZERO,  2);
                    BigDecimal total =  inv.getPrice1().multiply(new BigDecimal(inv.getStock()));
                    tableModel.addRow(new Object[]{inv.getIdInventory(), inv.getIdProduct(), 
                        inv.getIdSupplier(), product.getProductCode(), product.getDescription(), 
                        df.format(inv.getStock().doubleValue()), 
                        df.format(inv.getPrice1().doubleValue()),
                        df.format(total.doubleValue())
                    });
                }); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        
        return tableModel;
    }
    /**
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the invTrans
     */
    public InventoryTrans getInvTrans() {
        return invTrans;
    }

    /**
     * @param invTrans the invTrans to set
     */
    public void setInvTrans(InventoryTrans invTrans) {
        this.invTrans = invTrans;
    }

    /**
     * @return the listInv
     */
    public List<Inventory> getListInv() {
        return listInv;
    }

    /**
     * @param listInv the listInv to set
     */
    public void setListInv(List<Inventory> listInv) {
        this.listInv = listInv;
    }

    /**
     * @return the listInvTrans
     */
    public List<InventoryTrans> getListInvTrans() {
        return listInvTrans;
    }

    /**
     * @param listInvTrans the listInvTrans to set
     */
    public void setListInvTrans(List<InventoryTrans> listInvTrans) {
        this.listInvTrans = listInvTrans;
    }

    /**
     * @return the listProduct
     */
    public List<Product> getListProduct() {
        return listProduct;
    }

    /**
     * @param listProduct the listProduct to set
     */
    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    /**
     * @return the listSupplier
     */
    public List<Supplier> getListSupplier() {
        return listSupplier;
    }

    /**
     * @param listSupplier the listSupplier to set
     */
    public void setListSupplier(List<Supplier> listSupplier) {
        this.listSupplier = listSupplier;
    }

    /**
     * @return the listClient
     */
    public List<Client> getListClient() {
        return listClient;
    }

    /**
     * @param listClient the listClient to set
     */
    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }

    /**
     * @param aSupplierController the supplierController to set
     */
    public static void setSupplierController(SupplierJpaController aSupplierController) {
        supplierController = aSupplierController;
    }

    /**
     * @param aProductController the productController to set
     */
    public static void setProductController(ProductJpaController aProductController) {
        productController = aProductController;
    }

    /**
     * @param aClientController the clientController to set
     */
    public static void setClientController(ClientJpaController aClientController) {
        clientController = aClientController;
    }

    /**
     * @param aInventoryController the inventoryController to set
     */
    public static void setInventoryController(InventoryJpaController aInventoryController) {
        inventoryController = aInventoryController;
    }

    /**
     * @param aInvTransController the invTransController to set
     */
    public static void setInvTransController(InventoryTransJpaController aInvTransController) {
        invTransController = aInvTransController;
    }
    
    
    
}
