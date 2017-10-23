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
import javax.persistence.TypedQuery;

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
        Sala sala = buscaPorId(idSala);
        if(sala != null)
           em.remove(sala);
    }

    @Override
    public void atualizar(Sala sala) {
        Sala s = em.find(Sala.class, sala.getId());
        s.setAlocacao(sala.getAlocacao());
        s.setNome(sala.getNome());
        s.setBloco(sala.getBloco());
        s.setTipo(sala.getTipo());
        s.setCapacidade(sala.getCapacidade());
        em.merge(s);
    }

    @Override
    public Sala buscaPorId(int idSala) {
        return em.find(Sala.class, idSala);
    }
    
    @Override
    public Sala listarPorNome(String nomeSala){
        TypedQuery<Sala> createQuery = em.createQuery("select s from Sala s where s.nome like :nomeSala", Sala.class);
        createQuery.setParameter("nomeSala", nomeSala);
        return createQuery.getSingleResult();
    }
    
    @Override
    public List<Sala> listarTodos() {
        return em.createQuery("SELECT s FROM Sala s", Sala.class).getResultList();
    }
    
}
