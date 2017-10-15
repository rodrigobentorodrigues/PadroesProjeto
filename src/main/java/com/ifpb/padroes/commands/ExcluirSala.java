/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorMaterial;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.MaterialDao;
import com.ifpb.padroes.interfaces.SalaDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rudan
 */
public class ExcluirSala implements Command{
    
    @EJB
    private SalaDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int idSala = Integer.parseInt(requisicao.getParameter("idSala"));
        
        dao.remover(idSala); 
        String url = resposta.encodeURL("frontController?comando=GerenciarSalas");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
