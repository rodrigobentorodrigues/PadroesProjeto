package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.interfaces.BlocoDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class GerenciadorBloco implements BlocoDao{

    private EntityManager em;
    
    public GerenciadorBloco(){
        this.em = Persistence.createEntityManagerFactory("UPersistence").
                createEntityManager();
    }
    
    @Override
    public void adicionar(Bloco objeto) {
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remover(Bloco objeto) {
        Bloco aux = buscaPorId(objeto.getId());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(Bloco objeto) {
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        em.close();
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
