
package com.ifpb.padroes.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    
    void execute(HttpServletRequest requisicao, HttpServletResponse resposta);
    
    
//    default void pesquisaGenerica(HttpServletRequest requisicao, List<T> todosListado) {
//        String pesquisa = requisicao.getParameter("pesquisa");        
//        
//        if((pesquisa == null) || (pesquisa.equals(""))) {
//            requisicao.getSession().setAttribute("usuarios", todosListado);
//        } else {
//            List<T> usuarios = todosListado;
//            List<T> resultPesquisa = new ArrayList<>();
//            
//            for(T u: usuarios) {
//                if(u.getNome().startsWith(pesquisa, 0)) resultPesquisa.add(u);
//            }
//            
//            requisicao.getSession().setAttribute("usuarios", resultPesquisa);
//        }
//    }
}
