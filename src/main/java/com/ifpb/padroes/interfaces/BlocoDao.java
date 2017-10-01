
package com.ifpb.padroes.interfaces;

import com.ifpb.padroes.entidades.Bloco;
import java.util.List;

public interface BlocoDao{

    void adicionar(Bloco bloco);
    void remover(Bloco bloco);
    void atualizar(Bloco bloco);
    Bloco buscaPorId(int id);
    List<Bloco> listarTodos();
    
}
