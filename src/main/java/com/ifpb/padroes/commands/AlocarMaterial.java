/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.facade.FacadeAlocacaoSala;
import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */
public class AlocarMaterial implements Command {
    
    @Inject
    private FacadeAlocacaoSala facadeAlocacaoSala;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        
        String evento = requisicao.getParameter("evento");
        String material = requisicao.getParameter("material");
        
//        facadeAlocacaoSala.alocarMaterial(evento, material);
        
        String url = resposta.encodeURL("frontController?comando=GerenciarAlocacao");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    
}
