/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Evento;
import com.ifpb.padroes.facade.FacadeAlocacaoSala;
import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import java.time.LocalDate;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */
public class AdicionarEvento implements Command {
    
    @Inject
    private FacadeAlocacaoSala facadeAlocacaoSala;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String nome = requisicao.getParameter("nome");
        String descricao = requisicao.getParameter("descricao");
        int participantes = Integer.parseInt(requisicao.getParameter("participantes"));
        String responsavel = requisicao.getParameter("responsavel");
        LocalDate inicio = LocalDate.parse(requisicao.getParameter("inicio"));
        LocalDate fim = LocalDate.parse(requisicao.getParameter("fim"));
        
        System.out.println(nome + descricao + participantes + responsavel + inicio + fim);
        
        Evento evento = new Evento(nome, descricao, participantes, inicio, fim);
        
        // Cadastrando o evento
        facadeAlocacaoSala.cadastrarEvento(evento, responsavel);
        
        String url = resposta.encodeURL("frontController?comando=GerenciarAlocacao");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
