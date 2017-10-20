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
import java.util.List;

/**
 *
 * @author natan
 */
public interface FacadeAlocacaoSala {
    List<AlocacaoDTO> listarAlocacoes();
    
    List<Usuario> listarUsuarios();
    void cadastrarEvento(Evento evento, String nomeUsuario);
    
    // Listar os eventos disponiveis para serem listados quado for alocar sala
    List<Evento> listarEventos();
    
    // Listar as salas que não estão alocadas
    List<Sala> listarSalasDisponiveis();
    
    // Listar todos os materiais que não estão alocados
    List<Material> listarMateriaisDisponiveis();
    
    // Persistir uma sala em um evento
    void alocarEvento(Evento evento, Sala sala, List<Material> materiais);
    
    // Simplismente, desalocar a sala
    void desalocarSala(Sala sala);
}
