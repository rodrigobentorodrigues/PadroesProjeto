/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.interfaces;

import com.ifpb.padroes.entidades.Evento;
import java.util.List;

/**
 *
 * @author natan
 */
public interface EventoDao {
    void adicionar(Evento evento);
    void atualizar(Evento evento);
    void remover(Evento evento);
    Evento listarPorId(int id);
    Evento listarPorNome(String nomeEvento);
    List<Evento> listarTodos();
}
