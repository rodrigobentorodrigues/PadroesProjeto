/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.FeriadoDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author natan
 */
public class ImportarFeriados implements Command {

    @Inject
    private FeriadoDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        System.out.println("Commando Importar Feriados");
    }
    
    private void tratarCSV(File file) throws FileNotFoundException, IOException {
        Reader reader = new FileReader(file);
        Iterable<CSVRecord> registros = CSVFormat.RFC4180.parse(reader);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        List<Feriado> feriados = new ArrayList<>();
        
        for(CSVRecord registro: registros) {
            LocalDate localDate = LocalDate.parse(registro.get(0), dateTimeFormatter);
            String nomeFeriado = registro.get(2);
            Feriado f = new Feriado(nomeFeriado, localDate);
            feriados.add(f);
        }
        
        dao.persistirTodosFeriados(feriados);
    }
    
}
