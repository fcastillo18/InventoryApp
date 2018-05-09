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
@Table(name = "INV_TRANS_MASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvTransMaster.findAll", query = "SELECT i FROM InvTransMaster i")
    , @NamedQuery(name = "InvTransMaster.findByIdTransMaster", query = "SELECT i FROM InvTransMaster i WHERE i.idTransMaster = :idTransMaster")
    , @NamedQuery(name = "InvTransMaster.findByNoInvoice", query = "SELECT i FROM InvTransMaster i WHERE i.noInvoice = :noInvoice")
    , @NamedQuery(name = "InvTransMaster.findByTotal", query = "SELECT i FROM InvTransMaster i WHERE i.total = :total")
    , @NamedQuery(name = "InvTransMaster.findByCreatedDate", query = "SELECT i FROM InvTransMaster i WHERE i.createdDate = :createdDate")})
public class InvTransMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TRANS_MASTER")
    private Integer idTransMaster;
    @Column(name = "NO_INVOICE")
    private String noInvoice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    public InvTransMaster() {
    }

    public InvTransMaster(Integer idTransMaster) {
        this.idTransMaster = idTransMaster;
    }

    public Integer getIdTransMaster() {
        return idTransMaster;
    }

    public void setIdTransMaster(Integer idTransMaster) {
        this.idTransMaster = idTransMaster;
    }

    public String getNoInvoice() {
        return noInvoice;
    }

    public void setNoInvoice(String noInvoice) {
        this.noInvoice = noInvoice;
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
        hash += (idTransMaster != null ? idTransMaster.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTransMaster)) {
            return false;
        }
        InvTransMaster other = (InvTransMaster) object;
        if ((this.idTransMaster == null && other.idTransMaster != null) || (this.idTransMaster != null && !this.idTransMaster.equals(other.idTransMaster))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.inventory.domain.InvTransMaster[ idTransMaster=" + idTransMaster + " ]";
    }
    
}
