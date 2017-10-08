package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.FeriadoDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodrigobento
 */
public class ExcluirFeriado implements Command {

    @EJB
    private FeriadoDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int id = Integer.parseInt(requisicao.getParameter("id"));
        Feriado feriado = new Feriado();
        feriado.setId(id);
        dao.remover(feriado);
        try {
            resposta.sendRedirect("frontController?comando=GerenciarFeriados");
        } catch (IOException ex) {
            Logger.getLogger(ExcluirFeriado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
