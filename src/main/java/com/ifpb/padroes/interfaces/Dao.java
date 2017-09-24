
package com.ifpb.padroes.interfaces;

import java.util.List;

public interface Dao <T> {

    void adicionar(T objeto);
    void remover(T objeto);
    void atualizar(T objeto);
    T buscaPorId(int id);
    List<T> listarTodos();
    
}
