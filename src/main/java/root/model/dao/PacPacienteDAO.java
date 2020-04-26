/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import root.model.dao.exceptions.NonexistentEntityException;
import root.model.dao.exceptions.PreexistingEntityException;
import root.model.entities.PacPaciente;

/**
 *
 * @author postgres
 */
public class PacPacienteDAO implements Serializable {
        
        public PacPacienteDAO(){
                
        }

        public PacPacienteDAO(EntityManagerFactory emf) {
                this.emf = emf;
        }
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

        public EntityManager getEntityManager() {
                return emf.createEntityManager();
        }

        public void create(PacPaciente pacPaciente) throws PreexistingEntityException, Exception {
                EntityManager em = null;
                try {
                        em = getEntityManager();
                        em.getTransaction().begin();
                        em.persist(pacPaciente);
                        em.getTransaction().commit();
                } catch (Exception ex) {
                        if (findPacPaciente(pacPaciente.getPacRut()) != null) {
                                throw new PreexistingEntityException("PacPaciente " + pacPaciente + " already exists.", ex);
                        }
                        throw ex;
                } finally {
                        if (em != null) {
                                em.close();
                        }
                }
        }

        public void edit(PacPaciente pacPaciente) throws NonexistentEntityException, Exception {
                EntityManager em = null;
                try {
                        em = getEntityManager();
                        em.getTransaction().begin();
                        pacPaciente = em.merge(pacPaciente);
                        em.getTransaction().commit();
                } catch (Exception ex) {
                        String msg = ex.getLocalizedMessage();
                        if (msg == null || msg.length() == 0) {
                                String id = pacPaciente.getPacRut();
                                if (findPacPaciente(id) == null) {
                                        throw new NonexistentEntityException("The pacPaciente with id " + id + " no longer exists.");
                                }
                        }
                        throw ex;
                } finally {
                        if (em != null) {
                                em.close();
                        }
                }
        }

        public void destroy(String id) throws NonexistentEntityException {
                EntityManager em = null;
                try {
                        em = getEntityManager();
                        em.getTransaction().begin();
                        PacPaciente pacPaciente;
                        try {
                                pacPaciente = em.getReference(PacPaciente.class, id);
                                pacPaciente.getPacRut();
                        } catch (EntityNotFoundException enfe) {
                                throw new NonexistentEntityException("The pacPaciente with id " + id + " no longer exists.", enfe);
                        }
                        em.remove(pacPaciente);
                        em.getTransaction().commit();
                } finally {
                        if (em != null) {
                                em.close();
                        }
                }
        }

        public List<PacPaciente> findPacPacienteEntities() {
                return findPacPacienteEntities(true, -1, -1);
        }

        public List<PacPaciente> findPacPacienteEntities(int maxResults, int firstResult) {
                return findPacPacienteEntities(false, maxResults, firstResult);
        }

        private List<PacPaciente> findPacPacienteEntities(boolean all, int maxResults, int firstResult) {
                EntityManager em = getEntityManager();
                try {
                        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
                        cq.select(cq.from(PacPaciente.class));
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

        public PacPaciente findPacPaciente(String id) {
                EntityManager em = getEntityManager();
                try {
                        return em.find(PacPaciente.class, id);
                } finally {
                        em.close();
                }
        }

        public int getPacPacienteCount() {
                EntityManager em = getEntityManager();
                try {
                        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
                        Root<PacPaciente> rt = cq.from(PacPaciente.class);
                        cq.select(em.getCriteriaBuilder().count(rt));
                        Query q = em.createQuery(cq);
                        return ((Long) q.getSingleResult()).intValue();
                } finally {
                        em.close();
                }
        }
        
}



