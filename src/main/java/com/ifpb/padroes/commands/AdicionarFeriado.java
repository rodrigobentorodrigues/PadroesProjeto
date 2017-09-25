
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.FeriadoDao;
import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.Dao;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarFeriado implements Command{

    private Dao dao = new FeriadoDao();
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String nome = requisicao.getParameter("nomeFeriado");
        String data = requisicao.getParameter("data");
        // Dar a responsabilidade de converter a data para outra classe
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataFeriado = LocalDate.parse(data, formato);
        Feriado feriado = new Feriado(nome, dataFeriado);
        dao.adicionar(feriado);
        String url = resposta.encodeURL("frontController?comando=GerenciarFeriados");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
