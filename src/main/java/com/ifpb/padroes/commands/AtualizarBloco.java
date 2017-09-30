
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.BlocoDao;
import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.Dao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarBloco implements Command{

    private Dao dao = new BlocoDao();
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String nome = requisicao.getParameter("nome");
        int id = Integer.parseInt(requisicao.getParameter("id"));
        Bloco bloco = new Bloco(nome);
        bloco.setId(id);
        dao.atualizar(bloco);
        String url = resposta.encodeURL("frontController?comando=GerenciarBlocos");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            Logger.getLogger(AtualizarBloco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
