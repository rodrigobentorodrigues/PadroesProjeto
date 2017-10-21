/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Alocacao;
import com.ifpb.padroes.interfaces.AlocacaoDao;
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
@Local(AlocacaoDao.class)
@Stateless
public class GerenciadorAlocacao implements AlocacaoDao {
    
    @PersistenceContext(unitName = "UPersistence")
    private EntityManager em;

    @Override
    public void adicionar(Alocacao alocacao) {
        em.persist(alocacao);
    }

    @Override
    public void atualizar(Alocacao alocacao) {
        em.merge(alocacao);
    }

    @Override
    public void remover(Alocacao alocacao) {
        Alocacao a = em.find(Alocacao.class, alocacao.getId());
        em.remove(a);
    }

    @Override
    public Alocacao listarPorId(int id) {
        return em.find(Alocacao.class, id);
    }
    
    @Override
    public Alocacao listarPorNomeEvento(String nomeEvento){
        TypedQuery<Alocacao> createQuery = em.createQuery("select a from Alocacao a where a.evento.nome like :nomeEvento", Alocacao.class);
        createQuery.setParameter("nomeEvento", nomeEvento);
        return createQuery.getSingleResult();
    }

    @Override
    public List<Alocacao> listarTodos() {
        TypedQuery<Alocacao> createQuery = em.createQuery("select a from Alocacao a", Alocacao.class);
        return createQuery.getResultList();
    }
    
}
