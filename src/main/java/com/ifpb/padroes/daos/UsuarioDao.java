package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.interfaces.Dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UsuarioDao implements Dao<Usuario> {

    private EntityManager em;

    public UsuarioDao() {
        this.em = Persistence.createEntityManagerFactory("UPersistence").
                createEntityManager();
    }

    @Override
    public void adicionar(Usuario objeto) {
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    @Override
    public void remover(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
