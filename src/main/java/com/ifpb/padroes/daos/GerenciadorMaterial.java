/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Material;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.ifpb.padroes.interfaces.MaterialDao;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
@Local(MaterialDao.class)
public class GerenciadorMaterial implements MaterialDao{
    
    @PersistenceContext()
    private EntityManager em;

    @Override
    public void adicionar(Material material, int quantidade) {
        for(int k=1; k<=quantidade; k++){
            Material novo = new Material(material.getNome());
            em.persist(novo);
        }
    }

    @Override
    public void remover(int tombamento) {
        Material material = em.find(Material.class, tombamento);
        em.remove(material);
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
