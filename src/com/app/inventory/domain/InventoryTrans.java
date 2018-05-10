/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Franklin Castillo
 */
@Entity
@Table(name = "INVENTORY_TRANS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventoryTrans.findAll", query = "SELECT i FROM InventoryTrans i")
    , @NamedQuery(name = "InventoryTrans.findByIdInvTrans", query = "SELECT i FROM InventoryTrans i WHERE i.idInvTrans = :idInvTrans")
    , @NamedQuery(name = "InventoryTrans.findByNoDocument", query = "SELECT i FROM InventoryTrans i WHERE i.noDocument = :noDocument")
    , @NamedQuery(name = "InventoryTrans.findByIdInventory", query = "SELECT i FROM InventoryTrans i WHERE i.idInventory = :idInventory")
    , @NamedQuery(name = "InventoryTrans.findByIdProduct", query = "SELECT i FROM InventoryTrans i WHERE i.idProduct = :idProduct")
    , @NamedQuery(name = "InventoryTrans.findByIdSupplier", query = "SELECT i FROM InventoryTrans i WHERE i.idSupplier = :idSupplier")
    , @NamedQuery(name = "InventoryTrans.findByIdClient", query = "SELECT i FROM InventoryTrans i WHERE i.idClient = :idClient")
    , @NamedQuery(name = "InventoryTrans.findByIdUser", query = "SELECT i FROM InventoryTrans i WHERE i.idUser = :idUser")
    , @NamedQuery(name = "InventoryTrans.findByTransType", query = "SELECT i FROM InventoryTrans i WHERE i.transType = :transType")
    , @NamedQuery(name = "InventoryTrans.findByDiscount", query = "SELECT i FROM InventoryTrans i WHERE i.discount = :discount")
    , @NamedQuery(name = "InventoryTrans.findByQuantity", query = "SELECT i FROM InventoryTrans i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "InventoryTrans.findByCostxunit", query = "SELECT i FROM InventoryTrans i WHERE i.costxunit = :costxunit")
    , @NamedQuery(name = "InventoryTrans.findByPricexunit", query = "SELECT i FROM InventoryTrans i WHERE i.pricexunit = :pricexunit")
    , @NamedQuery(name = "InventoryTrans.findByTax", query = "SELECT i FROM InventoryTrans i WHERE i.tax = :tax")
    , @NamedQuery(name = "InventoryTrans.findByTotal", query = "SELECT i FROM InventoryTrans i WHERE i.total = :total")
    , @NamedQuery(name = "InventoryTrans.findByCreatedDate", query = "SELECT i FROM InventoryTrans i WHERE i.createdDate = :createdDate")})
public class InventoryTrans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INV_TRANS")
    private Integer idInvTrans;
    @Column(name = "NO_DOCUMENT")
    private String noDocument;
    @Column(name = "ID_INVENTORY")
    private Integer idInventory;
    @Column(name = "ID_PRODUCT")
    private Integer idProduct;
    @Column(name = "ID_SUPPLIER")
    private Integer idSupplier;
    @Column(name = "ID_CLIENT")
    private Integer idClient;
    @Column(name = "ID_USER")
    private Integer idUser;
    @Column(name = "TRANS_TYPE")
    private String transType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISCOUNT")
    private BigDecimal discount;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "COSTXUNIT")
    private BigDecimal costxunit;
    @Column(name = "PRICEXUNIT")
    private BigDecimal pricexunit;
    @Column(name = "TAX")
    private BigDecimal tax;
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    public InventoryTrans() {
    }

    public InventoryTrans(Integer idInvTrans) {
        this.idInvTrans = idInvTrans;
    }

    public Integer getIdInvTrans() {
        return idInvTrans;
    }

    public void setIdInvTrans(Integer idInvTrans) {
        this.idInvTrans = idInvTrans;
    }

    public String getNoDocument() {
        return noDocument;
    }

    public void setNoDocument(String noDocument) {
        this.noDocument = noDocument;
    }

    public Integer getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCostxunit() {
        return costxunit;
    }

    public void setCostxunit(BigDecimal costxunit) {
        this.costxunit = costxunit;
    }

    public BigDecimal getPricexunit() {
        return pricexunit;
    }

    public void setPricexunit(BigDecimal pricexunit) {
        this.pricexunit = pricexunit;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvTrans != null ? idInvTrans.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventoryTrans)) {
            return false;
        }
        InventoryTrans other = (InventoryTrans) object;
        if ((this.idInvTrans == null && other.idInvTrans != null) || (this.idInvTrans != null && !this.idInvTrans.equals(other.idInvTrans))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.inventory.domain.InventoryTrans[ idInvTrans=" + idInvTrans + " ]";
    }
    
}
