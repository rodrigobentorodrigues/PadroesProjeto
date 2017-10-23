/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.facade.FacadeAlocacaoSala;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.UsuarioDao;
import java.io.IOException;
import java.util.Collections;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */ 
public class GerenciarAlocacao implements Command {
    
    @Inject
    private FacadeAlocacaoSala facadeAlocacaoSala;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        requisicao.getSession().setAttribute("alocacoes", facadeAlocacaoSala.listarAlocacoes());
        
        requisicao.getSession().setAttribute("usuarios", facadeAlocacaoSala.listarUsuarios());
        
        // Carregar eventos 
        requisicao.getSession().setAttribute("eventos", facadeAlocacaoSala.listarEventos());
        
        // Carregar salas
        requisicao.getSession().setAttribute("salas", facadeAlocacaoSala.listarSalasDisponiveis());
//        System.out.println(facadeAlocacaoSala.listarSalasDisponiveis());
        
        // Carregar materiais 
        requisicao.getSession().setAttribute("materiais", facadeAlocacaoSala.listarMateriaisDisponiveis());
//        System.out.println(facadeAlocacaoSala.listarMateriaisDisponiveis());
        
        String url = resposta.encodeURL("gerenciarAlocacao.jsp");
        try {
            resposta.sendRedirect(url);
//        RequestDispatcher despachante = requisicao.getRequestDispatcher(url);
//        despachante.forward(requisicao, resposta);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
