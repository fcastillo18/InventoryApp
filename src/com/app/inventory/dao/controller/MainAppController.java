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
import com.app.inventory.printer.PrintReports;
import com.app.inventory.util.EntityManagerUtil;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Franklin Castillo
 */
public class MainAppController extends InputVerifier{

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
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    /************Metodos para retornar tabla**************/
   
    short rowNo = 1;
    int idx = 0;    
    public static void writeExcelFile(ArrayList<Object[]> dataList, String[] columnNames, boolean includeHeaders ,String filePath ){
        if(dataList != null && !dataList.isEmpty()){
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            Row headingRow = sheet.createRow(0);

            for (int i = 0; i < columnNames.length; i++) {
                //Seteando nombre de las columnas
                headingRow.createCell((short)i).setCellValue(columnNames[i]);
            } 
            
            short rowNo = 1;
            int idx = 0;
            for (Object[] obj : dataList) {
                //creando linea o row
                Row row = sheet.createRow(rowNo);
                
                for (Object obj1 : obj) {
                    //Por cada columna o elemento en el row(arreglo) crea una celda
                    row.createCell((short)idx).setCellValue(obj1.toString());
                    idx++;
                }
                rowNo++;
                idx = 0;
            }
             
            try{
                FileOutputStream fos = new FileOutputStream(filePath);
                workbook.write(fos);
                fos.flush();
                fos.close();
                workbook.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
                System.out.println("Invalid directory or file not found");
            }catch(IOException e){
                e.printStackTrace();
                System.out.println("Error occurred while writting excel file to directory");
            }
        }
    }
    
    int idClient = 0;
    String doc ="";
    public boolean getAndPrintInvTransByDocument(String noDocument){
        boolean success = false;
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        Query query  = em.createQuery("SELECT i from InventoryTrans i where i.noDocument = :noDocument");
        query.setParameter("noDocument", noDocument);
//        query.setParameter("description", "%"+textToFilter.toLowerCase()+"%");
        
        List<InventoryTrans> invTransResult = query.getResultList();
        List<Inventory> inventoryList = new ArrayList<>();
        
        if (invTransResult.isEmpty()) {
            success = false;
        }else{
            invTransResult.forEach(invTrans -> {
                doc = String.valueOf(invTrans.getIdClient());
                inventoryList.add(inventoryController.findInventory(invTrans.getIdProduct()));
            });
            
           /********************imprimir reporte*****************************/
            PrintReports printReport = new PrintReports();
            MainAppController.clientController.findClientEntities().forEach(cli -> {
                if (cli.getDocument().equals(doc)) {
                    idClient = cli.getIdClient();
                }
            });
            DateFormat defaultDf = new SimpleDateFormat("yyyy-MM-dd");
            String[] values = {noDocument, defaultDf.format(invTransResult.get(0).getCreatedDate()), MainAppController.clientController.findClient(idClient).getName()};
            printReport.productSalesReport(inventoryList, invTransResult ,values);
            success = true;
                    
        }
        
        em.getTransaction().commit();
        em.close();
        
        return success;        
    }
    
    public DefaultTableModel getSupplierTableModel(){
        String columns[] = {"ID","Documento", "Nombre", "Telefono", "Email", "Direccion"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    
        listSupplier = supplierController.findSupplierEntities();
        if (listSupplier == null) {
            tableModel.addRow(new Object[]{ }); 
        }else{
            listSupplier.forEach(supplier -> {
                if (supplier.getStatus()) {
                    tableModel.addRow(new Object[]{supplier.getIdSupplier(), 
                        supplier.getDocument(), supplier.getName(), supplier.getPhone(),
                        supplier.getEmail(), supplier.getZone()
                    });
                }
            });
        }
        return tableModel;
    }
    
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
    
    public int nextDocNo(){
        int value = 0;
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        Query query  = em.createQuery("select i.noDocument from InventoryTrans i\n" +
                                "where i.transType = 'venta'\n" +
                                "and i.idInvTrans = (\n" +
                                "                    select max(a.idInvTrans)\n" +
                                "                    from InventoryTrans a \n" +
                                "                    where a.transType = 'venta'\n" +
                                "                    )\n");
        List<Object> result = query.getResultList();
        if (result.size() > 0) {
            value = Integer.parseInt(result.get(0).toString());
        }else{
            value = 0;
        }
        
        return value;
    }
    
    public DefaultTableModel getProductInvTableModel(String textToFilter){
    EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        Query query  = em.createQuery("SELECT i.idInventory ,p.productCode, p.description, i.stock, i.cost, i.price1 FROM Product p, Inventory i WHERE p.idProduct = i.idProduct "
                + "and (LOWER(p.productCode) like :productCode or LOWER(p.description) like :description)");
        query.setParameter("productCode", "%"+textToFilter.toLowerCase()+"%");
        query.setParameter("description", "%"+textToFilter.toLowerCase()+"%");
        List<Object[]> results = query.getResultList();
        List<Inventory> listInvFilter = new ArrayList<>();
        
        results.stream().map((result) -> {
            //System.out.println(result[0] + " " + result[1] + " - " + result[2]);
            return result;
        }).map((result) -> inventoryController.findInventory(Integer.parseInt(result[0].toString()))).forEachOrdered((inv) -> {
            listInvFilter.add(inv);
        });
        em.getTransaction().commit();
        em.close();
        
        return getProductInvTableModel(listInvFilter);        
    }
    
    public DefaultTableModel getProductInvTableModel(List<Inventory> listInv2){
        String columns[] = {"Idprod", "ID_Supplidor", "Codigo", "Descripcion", "Cantidad", "Costo", "Precio", "Min stock", };
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        
//   
        try {
            if(listInv2 == null ){
                tableModel.addRow(new Object[]{ }); 
            }else{
                listInv2.forEach(inv -> {
                    product = productController.findProduct(inv.getIdProduct());
    //                BigDecimal total = new BigDecimal(BigInteger.ZERO,  2);
//                    BigDecimal total =  inv.getCost().multiply(new BigDecimal(inv.getStock()));
                    //boolean exist = getListInv().stream().filter(i -> inv.hashCode() == inventory.hashCode()).findFirst().isPresent();
                    boolean existPrevAddSales = getListInv().stream()
                                            .filter(i -> i.getIdInventory() == inv.getIdInventory())
                                            .findFirst().isPresent();
                    
                    tableModel.addRow(new Object[]{inv.getIdProduct(), inv.getIdSupplier(), 
                        product.getProductCode(), product.getDescription(), 
                        existPrevAddSales ? inv.getStock() - getListInv().stream()
                                                        .filter(i -> i.getIdInventory() == inv.getIdInventory())
                                                        .findFirst().get().getStock() : inv.getStock(),
                        //inv.getStock(), la linea de arriba es para descontar de la lista a mostrar la cantidad, de modo que se muestre actualizada 
                        df.format(inv.getCost().doubleValue()), df.format(inv.getPrice1().doubleValue()),
                        inv.getMinStock()
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
    
    public DefaultTableModel getInventoryProfitsTableModel(String transType, String textToFilter, Date dateFrom, Date dateTo){
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        Query query = null;
        String  statement= "select i.noDocument, sum(i.quantity * i.costxunit) as total_cost , "
                + "sum(i.quantity * i.pricexunit) as total_sales,   "
                + "sum(i.quantity * i.pricexunit) - sum(i.quantity * i.costxunit) as profit " //, i.createdDate "
                + "from InventoryTrans i " ;
        
        String addFilter = " i.transType = '"+transType+"' ";
        String groupBy = "  group by i.noDocument";       
        
        if (!"".equals(textToFilter.trim())) {
            String value = statement + " where i.noDocument like :document and "+addFilter+groupBy;
            query = em.createQuery(value);
            query.setParameter("document", "%"+textToFilter+"%");
        }else if(dateFrom != null && dateTo != null){
            String value = statement + " where i.createdDate between :dateFrom and :dateTo and "+addFilter+groupBy;
            query = em.createQuery(value);
            query.setParameter("dateFrom", dateFrom);
            query.setParameter("dateTo", dateTo);
        }else{
            query = em.createQuery(statement + "where" + addFilter + groupBy);//, i.createdDate");
        }
//        query.setParameter("productCode", "%"+textToFilter.toLowerCase()+"%");
//        query.setParameter("description", "%"+textToFilter.toLowerCase()+"%");
//        query.setParameter("document", "%"+textToFilter.toLowerCase()+"%");
//        query.setParameter("dateFrom",Timestamp.from(dateFrom.toInstant()));
//        query.setParameter("dateTo", Timestamp.from(dateTo.toInstant()));
        //System.out.println(query.toString());
        System.out.println(query.toString());
        List<Object[]> results = query.getResultList();
        List<Object[]> listInvTransFilter = new ArrayList<>();
        
        
        results.forEach(obj -> {    
            listInvTransFilter.add(obj);
        });
//        results.stream().map((result) -> {
//            //System.out.println(result[0] + " " + result[1] + " - " + result[2]);
//            listInvTransFilter.add(result);
//            return result;
//        });
        
        em.getTransaction().commit();
        em.close();
        
        return getInventoryProfitTableModel(listInvTransFilter); //(listInvTransFilter);        
    }
    
    public DefaultTableModel getInventoryProfitTableModel(List<Object[]> listInvTrans){
        String columns[] = {"No Documento","Costo total","Precio vendido", "Ganancia"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        
        //listInvTrans = invTransController.findInventoryTransEntities();
        
        try {
            if(listInvTrans == null ){
                tableModel.addRow(new Object[]{ }); 
            }else{
                listInvTrans.forEach(inv -> {
//                    System.out.println(inv[0] +" - "+ inv[1] +" - "+ inv[2] +" - "+ inv[3] +" - "+ inv[4]);
                    tableModel.addRow(new Object[]{inv[0], 
//                        new BigDecimal(val)
                        BigDecimal.valueOf(Double.parseDouble(inv[1].toString())), 
                        BigDecimal.valueOf(Double.parseDouble(inv[2].toString())),
                        BigDecimal.valueOf(Double.parseDouble(inv[3].toString()))
                        });
//                        inv[4]});
                }); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        listInvTrans.clear();
        return tableModel;
    }
    
    public DefaultTableModel getInventoryTransTableModel(String transType, String textToFilter, Date dateFrom, Date dateTo){
    EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        Query query  = em.createQuery("SELECT i.idInvTrans, i.idInventory, i.idProduct,  "
                + "i.noDocument, p.productCode, i.idClient, i.idUser, i.transType, "
                + "i.quantity, i.costxunit, i.pricexunit, i.total, i.createdDate "
                + "FROM Product p, InventoryTrans i WHERE p.idProduct = i.idProduct "
                + "and (LOWER(p.productCode) like :productCode or LOWER(p.description) like :description or LOWER(i.noDocument) like :document )");//or i.createdDate between :dateFrom and :dateTo)");
        query.setParameter("productCode", "%"+textToFilter.toLowerCase()+"%");
        query.setParameter("description", "%"+textToFilter.toLowerCase()+"%");
        query.setParameter("document", "%"+textToFilter.toLowerCase()+"%");
//        query.setParameter("dateFrom",Timestamp.from(dateFrom.toInstant()));
//        query.setParameter("dateTo", Timestamp.from(dateTo.toInstant()));
        //System.out.println(query.toString());
        List<Object[]> results = query.getResultList();
        List<InventoryTrans> listInvTransFilter = new ArrayList<>();
        
        results.stream().map((result) -> {
            //System.out.println(result[0] + " " + result[1] + " - " + result[2]);
            return result;
        }).map((result) -> invTransController.findInventoryTrans(Integer.parseInt(result[0].toString()))).forEachOrdered((inv) -> {
            listInvTransFilter.add(inv);
        });
        em.getTransaction().commit();
        em.close();
        
        return getInventoryTransTableModel(listInvTransFilter); //(listInvTransFilter);        
    }
    
    public DefaultTableModel getInventoryTransTableModel(List<InventoryTrans> listInvTrans){
        String columns[] = {"ID_inv_trans","ID Inv","ID Prod", "Documento", "Cod Prod","ID cliente", "ID user", 
                            "Trans type", "Cantidad", "Costo-und", "Precio-und", "Total", "Fecha"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        
        //listInvTrans = invTransController.findInventoryTransEntities();
        
        try {
            if(listInvTrans == null ){
                tableModel.addRow(new Object[]{ }); 
            }else{
                listInvTrans.forEach(inv -> {
                    product = productController.findProduct(inv.getIdProduct());
                    //product = productController.findProduct(inv.getIdProduct());
                    //inventory = inventoryController.findInventory(inv.getIdInventory());
    //                BigDecimal total = new BigDecimal(BigInteger.ZERO,  2);
//                    BigDecimal total =  inv.getCost().multiply(new BigDecimal(inv.getStock()));
                    tableModel.addRow(new Object[]{inv.getIdInvTrans(), inv.getIdInventory(),
                        inv.getIdProduct(), inv.getNoDocument(), product.getProductCode(),
                        inv.getIdClient(), inv.getIdUser(),inv.getTransType(), 
                        inv.getQuantity(), inv.getCostxunit(),inv.getPricexunit(), 
                        inv.getTotal(), dateFormat.format(inv.getCreatedDate())
                    });
                }); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        listInvTrans.clear();
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

    @Override
    public boolean verify(JComponent input) {
        //Check type of the control
        String text = "";

        if(input instanceof JTextField) {   
                JTextField tf = (JTextField) input; 
                text = tf.getText().trim(); 
            }

        boolean matches = !text.equals("");
        input.setBackground( ( matches ) ? Color.WHITE :  Color.RED);
        
        return matches; 
    }
    
    
    
}
