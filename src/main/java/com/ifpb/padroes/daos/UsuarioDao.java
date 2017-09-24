package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.interfaces.Dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.ifpb.padroes.interfaces.Autentica;
import javax.persistence.Query;

public class UsuarioDao implements Dao<Usuario>, Autentica {

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
        em.close();
    }

    @Override
    public void remover(Usuario objeto) {
        // Implementar
        
    }

    @Override
    public void atualizar(Usuario objeto) {
        System.out.println(objeto.toString());
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Usuario> listarTodos() {
        String sql = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> createQuery = em.createQuery(sql, Usuario.class);
        List<Usuario> usuarios = createQuery.getResultList();
        return usuarios;
    }
    
    @Override
    public Usuario buscaPorId(int id){
        return em.find(Usuario.class, id);
    }
    
    @Override
    public Usuario autentica(String login, String senha){
        Query createQuery = em.createNamedQuery("Usuario.login", Usuario.class);
        createQuery.setParameter("login", login);
        createQuery.setParameter("senha", senha);
        List<Usuario> usuarios = createQuery.getResultList();
        if(usuarios.isEmpty()){
            return null;
        } else {
            Usuario usuario = usuarios.get(0);
            return usuario;
        }
    }

}
