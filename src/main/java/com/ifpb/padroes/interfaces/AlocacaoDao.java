/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.interfaces;

import com.ifpb.padroes.entidades.Alocacao;
import java.util.List;

/**
 *
 * @author natan
 */
public interface AlocacaoDao {
    void adicionar(Alocacao alocacao);
    void atualizar(Alocacao alocacao);
    void remover(Alocacao alocacao);
    Alocacao listarPorId(int id);
    List<Alocacao> listarTodos();
}
