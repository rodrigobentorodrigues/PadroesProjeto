/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorMaterial;
import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.entidades.MaterialDTO;
import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.padroes.interfaces.MaterialDao;

public class AdicionarMaterial implements Command{

    private MaterialDao dao = new GerenciadorMaterial();
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String descricao = requisicao.getParameter("descricao");
        int quantidade = Integer.parseInt(requisicao.getParameter("quantidade"));
   
        Material material = new Material(descricao);
        
        dao.adicionar(material, quantidade);
        
        PrintWriter out;
        try {
            out = resposta.getWriter();
            out.println(quantidade);
        } catch (IOException ex) {
            Logger.getLogger(AdicionarMaterial.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
