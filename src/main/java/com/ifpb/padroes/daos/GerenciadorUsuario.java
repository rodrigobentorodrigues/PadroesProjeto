package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.ifpb.padroes.interfaces.Autentica;
import com.ifpb.padroes.interfaces.UsuarioDao;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(UsuarioDao.class)
public class GerenciadorUsuario implements UsuarioDao {

    @PersistenceContext(unitName = "UPersistence")
    private EntityManager em;

    @Override
    public void adicionar(Usuario objeto) {
        em.persist(objeto);
    }

    @Override
    public void remover(Usuario objeto) {
        Usuario auxiliar = buscaPorId(objeto.getId());
        em.remove(auxiliar);
    }

    @Override
    public void atualizar(Usuario objeto) {
        em.merge(objeto);
    }

    @Override
    public List<Usuario> listarTodos() {
        String sql = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> createQuery = em.createQuery(sql, Usuario.class);
        List<Usuario> usuarios = createQuery.getResultList();
        return usuarios;
    }

    @Override
    public Usuario buscaPorId(int id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public Usuario autentica(String login, String senha) {
        Query createQuery = em.createNamedQuery("Usuario.login", Usuario.class);
        createQuery.setParameter("login", login);
        createQuery.setParameter("senha", senha);
        createQuery.setParameter("email", login);
        List<Usuario> usuarios = createQuery.getResultList();
        if (usuarios.isEmpty()) {
            return null;
        } else {
            Usuario usuario = usuarios.get(0);
            return usuario;
        }
    }

}
