/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorMaterial;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.MaterialDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rudan
 */
public class ExcluirMaterial implements Command{
    
    @EJB
    private MaterialDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int tombamento = Integer.parseInt(requisicao.getParameter("tombamento"));
        
        dao.remover(tombamento); 
        String url = resposta.encodeURL("frontController?comando=GerenciarMaterial");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
