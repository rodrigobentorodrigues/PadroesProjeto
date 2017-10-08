package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.FeriadoDao;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodrigobento
 */
public class AtualizarFeriado implements Command {

    @EJB
    private FeriadoDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int id = Integer.parseInt(requisicao.getParameter("id"));
        String nome = requisicao.getParameter("nome");
        String data = requisicao.getParameter("data");
        // Dar a responsabilidade de converter a data para outra classe
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataFeriado = LocalDate.parse(data, formato);
        Feriado feriado = new Feriado(nome, dataFeriado);
        feriado.setId(id);
        dao.atualizar(feriado);
        try {
            resposta.sendRedirect("frontController?comando=GerenciarFeriados");
        } catch (IOException ex) {
            Logger.getLogger(ExcluirFeriado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
