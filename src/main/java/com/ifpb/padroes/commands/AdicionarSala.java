/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.entidades.Sala;
import com.ifpb.padroes.enums.TipoSala;
import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.SalaDao;
import java.io.IOException;
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
    @EJB
    private BlocoDao blocoDao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String Nome = requisicao.getParameter("nome");
        int idBloco = Integer.parseInt(requisicao.getParameter("idBloco"));
        int capacidade = Integer.parseInt(requisicao.getParameter("capacidade"));
        String tipoSalaString  = requisicao.getParameter("tipo");
        TipoSala tipoSalaEnum = TipoSala.valueOf(tipoSalaString);
        
        Bloco bloco = blocoDao.buscaPorId(idBloco);
        Sala sala= new Sala(Nome, bloco, capacidade, tipoSalaEnum);
        
        salaDao.adicionar(sala);
        
        String url = resposta.encodeURL("frontController?comando=GerenciarSalas");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }       
        
    }
    
}
