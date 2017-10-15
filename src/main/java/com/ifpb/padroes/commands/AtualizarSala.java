
package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.entidades.Sala;
import com.ifpb.padroes.enums.TipoSala;
import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.MaterialDao;
import com.ifpb.padroes.interfaces.SalaDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarSala implements Command {
    
    @EJB
    private SalaDao salaDao;
    @EJB
    private BlocoDao blocoDao;

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int idSala = Integer.parseInt(requisicao.getParameter("idSala"));
        String nome = requisicao.getParameter("nome");
        int capacidade = Integer.parseInt(requisicao.getParameter("capacidade"));
        int idBloco = Integer.parseInt(requisicao.getParameter("idBloco"));
        String tipoSalaString  = requisicao.getParameter("tipo");
        TipoSala tipoSalaEnum = TipoSala.valueOf(tipoSalaString);
        
        Bloco bloco = blocoDao.buscaPorId(idBloco);
        
        Sala sala = new Sala(nome, bloco, capacidade, tipoSalaEnum);
        sala.setId(idSala);
         
        salaDao.atualizar(sala);
        String url = resposta.encodeURL("frontController?comando=GerenciarSalas");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
