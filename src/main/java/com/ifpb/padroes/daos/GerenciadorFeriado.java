package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.interfaces.FeriadoDao;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless
@Local(FeriadoDao.class)
public class GerenciadorFeriado implements FeriadoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void adicionar(Feriado objeto) {
        em.persist(objeto);
    }

    @Override
    public void remover(Feriado objeto) {
        Feriado auxiliar = buscaPorId(objeto.getId());
        em.remove(auxiliar);
    }

    @Override
    public void atualizar(Feriado objeto) {
        em.merge(objeto);
    }

    @Override
    public Feriado buscaPorId(int id) {
        return em.find(Feriado.class, id);
    }

    @Override
    public List<Feriado> listarTodos() {
        return em.createQuery("SELECT f FROM Feriado f",
                Feriado.class).getResultList();
    }

}
