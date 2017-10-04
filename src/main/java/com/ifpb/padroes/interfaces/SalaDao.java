/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.interfaces;

import com.ifpb.padroes.entidades.Sala;
import java.util.List;

/**
 *
 * @author rudan
 */
public interface SalaDao {
    void adicionar(Sala sala);
    void remover(int idSala);
    void atualizar(Sala sala);
    Sala buscaPorId(int idSala);
    List<Sala> listarTodos();
}
