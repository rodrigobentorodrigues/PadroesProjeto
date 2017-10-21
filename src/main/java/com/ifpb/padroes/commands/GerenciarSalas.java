/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.entidades.Sala;
import com.ifpb.padroes.entidades.SalaDTO;
import com.ifpb.padroes.facade.FacadeAlocacaoSala;
import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.SalaDao;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */
public class GerenciarSalas implements Command {
    
    @Inject
    private FacadeAlocacaoSala facadeAlocacaoSala;
    
    @EJB
    private SalaDao salaDao;
    @EJB
    private BlocoDao blocoDao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        try {
            
            List<Sala> todasAsSalas = salaDao.listarTodos();
            List<Sala> salasDisponiveis = facadeAlocacaoSala.listarSalasDisponiveis();
            List<SalaDTO> representacoesSalaDTO = new ArrayList<>();
            
            Iterator<Sala> its = todasAsSalas.iterator();
            while(its.hasNext()){
                Sala sala = its.next();
                int id = sala.getId();
                
                SalaDTO  salaDTO = new SalaDTO();
                salaDTO.setId(id);
                salaDTO.setNome(sala.getNome());
                salaDTO.setCapacidade(sala.getCapacidade());
                salaDTO.setBloco(sala.getBloco());
                salaDTO.setTipo(sala.getTipo());
                
                Iterator<Sala> isd = todasAsSalas.iterator();
                
                boolean alocada = false;
                while (isd.hasNext()) {
                    if(isd.next().getId() == id){
                        alocada = true;
                    }
                }
                
                if(!alocada)
                    salaDTO.setStatus("Disponivel");
                else
                    salaDTO.setStatus("Disponivel");
                
                representacoesSalaDTO.add(salaDTO);
                
            }
                       
            requisicao.setAttribute("salas", representacoesSalaDTO);
            requisicao.setAttribute("blocos", blocoDao.listarTodos());
            
            RequestDispatcher despachante = requisicao.getRequestDispatcher("gerenciarSalas.jsp");
            despachante.forward(requisicao, resposta);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }

    }
    
}
