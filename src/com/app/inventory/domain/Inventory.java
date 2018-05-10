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
@Table(name = "INVENTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
    , @NamedQuery(name = "Inventory.findByIdInventory", query = "SELECT i FROM Inventory i WHERE i.idInventory = :idInventory")
    , @NamedQuery(name = "Inventory.findByIdProduct", query = "SELECT i FROM Inventory i WHERE i.idProduct = :idProduct")
    , @NamedQuery(name = "Inventory.findByIdSupplier", query = "SELECT i FROM Inventory i WHERE i.idSupplier = :idSupplier")
    , @NamedQuery(name = "Inventory.findByPrice1", query = "SELECT i FROM Inventory i WHERE i.price1 = :price1")
    , @NamedQuery(name = "Inventory.findByPrice2", query = "SELECT i FROM Inventory i WHERE i.price2 = :price2")
    , @NamedQuery(name = "Inventory.findByPrice3", query = "SELECT i FROM Inventory i WHERE i.price3 = :price3")
    , @NamedQuery(name = "Inventory.findByPrice4", query = "SELECT i FROM Inventory i WHERE i.price4 = :price4")
    , @NamedQuery(name = "Inventory.findByCost", query = "SELECT i FROM Inventory i WHERE i.cost = :cost")
    , @NamedQuery(name = "Inventory.findByAvgCost", query = "SELECT i FROM Inventory i WHERE i.avgCost = :avgCost")
    , @NamedQuery(name = "Inventory.findByTax", query = "SELECT i FROM Inventory i WHERE i.tax = :tax")
    , @NamedQuery(name = "Inventory.findByStock", query = "SELECT i FROM Inventory i WHERE i.stock = :stock")
    , @NamedQuery(name = "Inventory.findByMinStock", query = "SELECT i FROM Inventory i WHERE i.minStock = :minStock")
    , @NamedQuery(name = "Inventory.findByLastUpdated", query = "SELECT i FROM Inventory i WHERE i.lastUpdated = :lastUpdated")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INVENTORY")
    private Integer idInventory;
    @Column(name = "ID_PRODUCT")
    private Integer idProduct;
    @Column(name = "ID_SUPPLIER")
    private Integer idSupplier;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE1")
    private BigDecimal price1;
    @Column(name = "PRICE2")
    private BigDecimal price2;
    @Column(name = "PRICE3")
    private BigDecimal price3;
    @Column(name = "PRICE4")
    private BigDecimal price4;
    @Column(name = "COST")
    private BigDecimal cost;
    @Column(name = "AVG_COST")
    private BigDecimal avgCost;
    @Column(name = "TAX")
    private Integer tax;
    @Column(name = "STOCK")
    private Integer stock;
    @Column(name = "MIN_STOCK")
    private Integer minStock;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    public Inventory() {
    }

    public Inventory(Integer idInventory) {
        this.idInventory = idInventory;
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

    public BigDecimal getPrice1() {
        return price1;
    }

    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }

    public BigDecimal getPrice2() {
        return price2;
    }

    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }

    public BigDecimal getPrice3() {
        return price3;
    }

    public void setPrice3(BigDecimal price3) {
        this.price3 = price3;
    }

    public BigDecimal getPrice4() {
        return price4;
    }

    public void setPrice4(BigDecimal price4) {
        this.price4 = price4;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(BigDecimal avgCost) {
        this.avgCost = avgCost;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventory != null ? idInventory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.idInventory == null && other.idInventory != null) || (this.idInventory != null && !this.idInventory.equals(other.idInventory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.inventory.domain.Inventory[ idInventory=" + idInventory + " ]";
    }
    
}
