/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorBloco;
import com.ifpb.padroes.daos.GerenciadorSala;
import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.entidades.Sala;
import com.ifpb.padroes.enums.TipoSala;
import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.SalaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rudan
 */
public class AdicionarSala implements Command{
    
    @EJB
    private SalaDao salaDao;
    private BlocoDao blocoDao = new GerenciadorBloco();
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String Nome = requisicao.getParameter("nome");
        int idBloco = Integer.parseInt(requisicao.getParameter("idBloco"));
        int capacidade = Integer.parseInt(requisicao.getParameter("capacidade"));
        String tipo = requisicao.getParameter("tipo");
        
        Bloco bloco = blocoDao.buscaPorId(idBloco);
        
        try {
            PrintWriter out = resposta.getWriter();
            out.println(bloco);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        //Sala sala= new Sala(Nome, bloco, capacidade, TipoSala.Comum);
        
        //salaDao.adicionar(sala);
    }
    
}
