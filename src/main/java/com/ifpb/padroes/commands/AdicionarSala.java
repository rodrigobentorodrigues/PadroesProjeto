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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rudan
 */
public class AdicionarSala implements Command{
    
    private SalaDao salaDao = new GerenciadorSala();
    private BlocoDao blocoDao = new GerenciadorBloco();
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String Nome = requisicao.getParameter("nome");
        int idBloco = Integer.parseInt(requisicao.getParameter("idBloco"));
        int capacidade = Integer.parseInt(requisicao.getParameter("capacidade"));
        String tipo = requisicao.getParameter("Tipo");
        
        Bloco bloco = blocoDao.buscaPorId(idBloco);
        
        Sala sala= new Sala(Nome, bloco, capacidade, TipoSala.Comum);
        
        salaDao.adicionar(sala);
    }
    
}
