
package com.ifpb.padroes.interfaces;

import com.ifpb.padroes.entidades.Feriado;
import java.util.List;

public interface FeriadoDao{

    void adicionar(Feriado Feriado);
    void remover(Feriado feriado);
    void atualizar(Feriado feriado);
    Feriado buscaPorId(int id);
    List<Feriado> listarTodos();
    void persistirTodosFeriados(List<Feriado> feriados);
    
}
