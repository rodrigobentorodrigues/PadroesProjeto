
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorBloco;
import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirBloco implements Command {

    @EJB
    private BlocoDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int id = Integer.parseInt(requisicao.getParameter("id"));
        Bloco bloco = (Bloco) dao.buscaPorId(id);
        dao.remover(bloco);
        String url = resposta.encodeURL("frontController?comando=GerenciarBlocos");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
}
