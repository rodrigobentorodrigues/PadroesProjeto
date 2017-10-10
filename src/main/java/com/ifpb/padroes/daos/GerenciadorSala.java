/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Sala;
import com.ifpb.padroes.interfaces.SalaDao;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local(SalaDao.class)
public class GerenciadorSala implements SalaDao {
    
    @PersistenceContext(unitName = "UPersistence")
    private EntityManager em;
    
    @Override
    public void adicionar(Sala sala) {
        em.persist(sala);
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
        return em.createQuery("SELECT s FROM Sala s", Sala.class).getResultList();
    }
    
}
