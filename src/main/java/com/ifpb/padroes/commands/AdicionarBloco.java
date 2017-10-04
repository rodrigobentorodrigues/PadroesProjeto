
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorBloco;
import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarBloco implements Command {
    
    @EJB
    private BlocoDao dao;

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String nome = requisicao.getParameter("nome");
        Bloco bloco = new Bloco(nome);
        dao.adicionar(bloco);
        String url = resposta.encodeURL("frontController?comando=GerenciarBlocos");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
