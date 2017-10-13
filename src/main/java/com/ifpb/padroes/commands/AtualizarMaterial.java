
package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.MaterialDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarMaterial implements Command {
    
    @EJB
    private MaterialDao dao;

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int tombamento = Integer.parseInt(requisicao.getParameter("tombamento"));
        String nome = requisicao.getParameter("nome");
        
        Material material = new Material(nome); 
        material.setTombamento(tombamento);
        dao.atualizar(material);
        String url = resposta.encodeURL("frontController?comando=GerenciarMaterial");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
