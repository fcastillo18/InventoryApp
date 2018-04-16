/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventory.dao.controller;

import com.app.inventory.dao.controller.exceptions.NonexistentEntityException;
import com.app.inventory.domain.InventoryTrans;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author frank
 */
public class InventoryTransJpaController1 implements Serializable {

    public InventoryTransJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InventoryTrans inventoryTrans) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(inventoryTrans);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InventoryTrans inventoryTrans) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            inventoryTrans = em.merge(inventoryTrans);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = inventoryTrans.getIdInvTrans();
                if (findInventoryTrans(id) == null) {
                    throw new NonexistentEntityException("The inventoryTrans with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InventoryTrans inventoryTrans;
            try {
                inventoryTrans = em.getReference(InventoryTrans.class, id);
                inventoryTrans.getIdInvTrans();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inventoryTrans with id " + id + " no longer exists.", enfe);
            }
            em.remove(inventoryTrans);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InventoryTrans> findInventoryTransEntities() {
        return findInventoryTransEntities(true, -1, -1);
    }

    public List<InventoryTrans> findInventoryTransEntities(int maxResults, int firstResult) {
        return findInventoryTransEntities(false, maxResults, firstResult);
    }

    private List<InventoryTrans> findInventoryTransEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InventoryTrans.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public InventoryTrans findInventoryTrans(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InventoryTrans.class, id);
        } finally {
            em.close();
        }
    }

    public int getInventoryTransCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InventoryTrans> rt = cq.from(InventoryTrans.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
