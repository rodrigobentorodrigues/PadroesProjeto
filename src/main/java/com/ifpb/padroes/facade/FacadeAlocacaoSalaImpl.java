/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.facade;

import com.ifpb.padroes.entidades.Alocacao;
import com.ifpb.padroes.entidades.AlocacaoDTO;
import com.ifpb.padroes.entidades.Evento;
import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.entidades.Sala;
import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.interfaces.AlocacaoDao;
import com.ifpb.padroes.interfaces.EventoDao;
import com.ifpb.padroes.interfaces.MaterialDao;
import com.ifpb.padroes.interfaces.SalaDao;
import com.ifpb.padroes.interfaces.UsuarioDao;
import java.util.ArrayList;
import java.util.List;
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
    @Inject
    private SalaDao salaDao;
    @Inject
    private MaterialDao materialDao;
    
    @Override
    public List<AlocacaoDTO> listarAlocacoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override 
    public List<Alocacao> listarAlocacoesDisponiveis() {
        return alocacaoDao.listarTodos();
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
        usuario.add(evento);
        eventoDao.adicionar(evento);
        usuarioDao.atualizar(usuario);
    }

    @Override
    public List<Evento> listarEventos() {
        return eventoDao.listarTodos();
    }

    @Override
    public List<Sala> listarSalasDisponiveis() {
        List<Sala> salas = salaDao.listarTodos();
        List<Sala> listaAux = new ArrayList<>();
        
        for(Sala sala : salas) {
            if(sala.getAlocacao() == null) listaAux.add(sala);
        }
        
        return listaAux;
    }

    @Override
    public void alocarEvento(String nomeEvento, String nomeSala) {
        Evento evento = eventoDao.listarPorNome(nomeEvento);
        Sala sala = salaDao.listarPorNome(nomeSala);
        Alocacao alocacao = new Alocacao();
        alocacao.setEvento(evento);
        alocacao.setSala(sala);
        
        alocacaoDao.adicionar(alocacao);
        
        // Jogadando a alocação no evento
        evento.addAlocacao(alocacao);
        eventoDao.atualizar(evento);
        
        // Jogando alocação na sala
        sala.setAlocacao(alocacao);
        salaDao.atualizar(sala);    
    }
    
    @Override
    public List<Material> listarMateriaisDisponiveis() {
        return materialDao.buscarPorMateriaisNaoAlocados();
    }
    
    @Override
    public void alocarMaterial(String nomeEvento, String nomeMaterial) {
        Alocacao alocacao = alocacaoDao.listarPorNomeEvento(nomeEvento);
          
        Material material =  materialDao.buscarPorNome(nomeMaterial);
        
        // Adicionei o material na lista de materiais em alocacao
        alocacao.addMaterial(material);
        alocacaoDao.atualizar(alocacao);
        
        // Set de alocação no material para trasmitir que aquele material tá alocado
        material.setAlocacao(alocacao);
        materialDao.atualizar(material);
    }

    @Override
    public void desalocarSala(Sala sala) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
