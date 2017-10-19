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
import java.util.List;

/**
 *
 * @author natan
 */
public interface FacadeAlocacaoSala {
    List<AlocacaoDTO> listarAlocacoes();
    boolean cadastrarEvento(Evento evento);
    // Para o evento
    List<Sala> listarSalasDisponiveis(Evento evento);
    List<Evento> listarEventosDisponiveis();
    // Para aquele evento
    List<Material> listarMateriaisDisponiveis(Evento evento);
}
