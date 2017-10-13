/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.padroes.interfaces.MaterialDao;
import javax.ejb.EJB;

public class AdicionarMaterial implements Command{

    @EJB
    private MaterialDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        
        String descricao = requisicao.getParameter("descricao");
        int quantidade = Integer.parseInt(requisicao.getParameter("quantidade"));
   
        Material material = new Material(descricao);
        
        dao.adicionar(material, quantidade);
        
        String url = resposta.encodeURL("frontController?comando=GerenciarMaterial");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
