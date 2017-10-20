/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.facade;

import com.ifpb.padroes.entidades.AlocacaoDTO;
import com.ifpb.padroes.entidades.Evento;
import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.entidades.Sala;
import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.interfaces.AlocacaoDao;
import com.ifpb.padroes.interfaces.EventoDao;
import com.ifpb.padroes.interfaces.UsuarioDao;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author natan
 */
@Local(FacadeAlocacaoSala.class)
@Stateless
public class FacadeAlocacaoSalaImpl implements FacadeAlocacaoSala {

    @Inject
    private AlocacaoDao alocacaoDao;
    @Inject
    private UsuarioDao usuarioDao;
    @Inject
    private EventoDao eventoDao;
    
    @Override
    public List<AlocacaoDTO> listarAlocacoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.listarTodos();
    }
    
    @Override
    public void cadastrarEvento(Evento evento, String nomeUsuario) {
        Usuario usuario = usuarioDao.buscarPorNome(nomeUsuario);
        System.out.println(usuario.toString());
        evento.setResponsavel(usuario);
        eventoDao.adicionar(evento);
    }

    @Override
    public List<Evento> listarEventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sala> listarSalasDisponiveis() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Material> listarMateriaisDisponiveis() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alocarEvento(Evento evento, Sala sala, List<Material> materiais) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desalocarSala(Sala sala) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
