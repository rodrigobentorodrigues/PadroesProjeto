package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.interfaces.BlocoDao;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless
@Local(BlocoDao.class)
public class GerenciadorBloco implements BlocoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void adicionar(Bloco objeto) {
        em.persist(objeto);
    }

    @Override
    public void remover(Bloco objeto) {
        Bloco aux = buscaPorId(objeto.getId());
        em.remove(aux);
    }

    @Override
    public void atualizar(Bloco objeto) {
        em.merge(objeto);
    }

    @Override
    public Bloco buscaPorId(int id) {
        return em.find(Bloco.class, id);
    }

    @Override
    public List<Bloco> listarTodos() {
        return em.createQuery("SELECT b FROM Bloco b",
                Bloco.class).getResultList();
    }

}
