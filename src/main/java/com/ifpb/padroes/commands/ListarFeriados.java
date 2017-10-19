/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.google.gson.Gson;
import com.ifpb.padroes.entidades.CalendarDTO;
import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.FeriadoDao;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.padroes.interfaces.MaterialDao;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Rudan
 */
public class ListarFeriados implements Command{

    @EJB
    private FeriadoDao feriadoDao;
        
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        
        List<Feriado> feriadosBD = feriadoDao.listarTodos();
        List<CalendarDTO> feriadosCalendar = new ArrayList<>();
        DateTimeFormatter formatadorTraco = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        Iterator<Feriado> f = feriadosBD.iterator();
        while(f.hasNext()){
            Feriado feriado = f.next();
            
            int id = feriado.getId();
            String nome = feriado.getNome();
            LocalDate data = feriado.getDataFeriado();
            String start = formatadorTraco.format(data);
            
            CalendarDTO calendarDTO = new CalendarDTO(id, nome, start);
            feriadosCalendar.add(calendarDTO);
        }
             
        resposta.setContentType("application/json");
        resposta.setCharacterEncoding("UTF-8");
        PrintWriter out;
        try {
            out = resposta.getWriter();
            out.write(new Gson().toJson(feriadosCalendar));
        } catch (IOException ex) {
            Logger.getLogger(ListarFeriados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
