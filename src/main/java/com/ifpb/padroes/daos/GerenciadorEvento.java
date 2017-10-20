/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Evento;
import com.ifpb.padroes.interfaces.EventoDao;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author natan
 */
@Local(EventoDao.class)
@Stateless
public class GerenciadorEvento implements EventoDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void adicionar(Evento evento) {
        em.persist(evento);
    }

    @Override
    public void atualizar(Evento evento) {
        em.merge(evento);
    }

    @Override
    public void remover(Evento evento) {
        Evento e = em.find(Evento.class, evento.getId());
        em.remove(e);
    }

    @Override
    public Evento listarPorId(int id) {
        return em.find(Evento.class, id);
    }

    @Override
    public List<Evento> listarTodos() {
        TypedQuery<Evento> createQuery = em.createQuery("select e from Evento e", Evento.class);
        return createQuery.getResultList();
    }
    
}
