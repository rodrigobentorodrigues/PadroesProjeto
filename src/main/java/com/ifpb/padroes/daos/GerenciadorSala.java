/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Sala;
import com.ifpb.padroes.interfaces.SalaDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author rudan
 */
public class GerenciadorSala implements SalaDao{
    
    private EntityManager em;
    
    public GerenciadorSala(){
        this.em = Persistence.createEntityManagerFactory("UPersistence").createEntityManager();
    }
    
    @Override
    public void adicionar(Sala sala) {
        em.getTransaction().begin();
        em.persist(sala);
        em.getTransaction().commit();
    }

    @Override
    public void remover(int idSala) {
        
    }

    @Override
    public void atualizar(Sala sala) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sala buscaPorId(int idSala) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sala> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
