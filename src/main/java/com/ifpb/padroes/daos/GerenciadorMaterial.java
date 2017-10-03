/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.entidades.MaterialDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.ifpb.padroes.interfaces.MaterialDao;

/**
 *
 * @author Rudan
 */
public class GerenciadorMaterial implements MaterialDao{
    
    private EntityManager em;

    public GerenciadorMaterial() {
        this.em = Persistence.createEntityManagerFactory("UPersistence").createEntityManager();
    }

    @Override
    public void adicionar(Material material, int quantidade) {
        em.getTransaction().begin();
        for(int k=1; k<=quantidade; k++){
            //Material novo = materialPrototype.clonar(materialPrototype);
            //em.persist(novo);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remover(int tombamento) {
        em.getTransaction().begin();
        Material material = em.find(Material.class, tombamento);
        em.remove(material);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(Material objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Material buscaPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Material> listarTodos() {
        String sql = "SELECT m FROM Material m";
        TypedQuery<Material> createQuery = em.createQuery(sql, Material.class);
        List<Material> materiais = createQuery.getResultList();
        return materiais;
    }   
    
}
