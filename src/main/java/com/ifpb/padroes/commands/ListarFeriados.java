/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.google.gson.Gson;
import com.ifpb.padroes.entidades.CalendarDTO;
import com.ifpb.padroes.interfaces.Command;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.padroes.interfaces.MaterialDao;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author Rudan
 */
public class ListarFeriados implements Command{

    @EJB
    private MaterialDao dao;
        
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        
        List l = new ArrayList();
 
        CalendarDTO a = new CalendarDTO();
        a.setId(1);
        a.setStart("2017-10-01");
        a.setTitle("Feriado A");
        
        CalendarDTO b = new CalendarDTO();
        b.setId(2);
        b.setStart("2017-10-05");
        b.setTitle("Feriado B");

       

        l.add(a);
        l.add(b);
        

        resposta.setContentType("application/json");
        resposta.setCharacterEncoding("UTF-8");
        PrintWriter out;
        try {
            out = resposta.getWriter();
            out.write(new Gson().toJson(l));
        } catch (IOException ex) {
            Logger.getLogger(ListarFeriados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
