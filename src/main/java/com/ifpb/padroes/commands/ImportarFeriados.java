/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.FeriadoDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author natan
 */
public class ImportarFeriados implements Command {

    @Inject
    private FeriadoDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        
        Part path = null;
        OutputStream outputStream = null;
        File file = null;
        try {
            path = requisicao.getPart("csv");
            System.out.println(path);
            
            // Criar a pasta para armazenar o csv dentro do caminho target/Padroes-1/
            String appPath = requisicao.getServletContext().getRealPath("");
            System.out.println(appPath);
            String upPath = appPath + File.separator + "csv";
            File up = new File(upPath);
            if(!up.exists()) up.mkdirs();
            
            // Dentro de target/Padroes-1, será criado um arquivo "arq.csv"
            file = new File(upPath + File.separator + "arq.csv");
            outputStream = new FileOutputStream(file);
            
            // Pego os dados do CSV importado e ponho dentro de arq.csv
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read = path.getInputStream().read(bytes)) != -1) outputStream.write(bytes, 0, read);
            
            this.tratarCSV(file);
            
        } catch (IOException | ServletException ex) {
            Logger.getLogger(ImportarFeriados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//            try {
//                if(path.getInputStream() != null) path.getInputStream().close();
//            } catch (IOException ex) {
//                Logger.getLogger(ImportarFeriados.class.getName()).log(Level.SEVERE, null, ex);
//            }
            if (outputStream != null) {
		try {		
                    outputStream.close();
		} catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        try {
            resposta.sendRedirect("frontController?comando=GerenciarFeriados");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void tratarCSV(File file) throws FileNotFoundException, IOException {
        System.out.println(file);
        Reader reader = new FileReader(file);
//        Iterable<CSVRecord> registros = CSVFormat.RFC4180.parse(reader);
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
//        List<Feriado> feriados = new ArrayList<>();
//        
//        for(CSVRecord registro: registros) {
//            LocalDate localDate = LocalDate.parse(registro.get(0), dateTimeFormatter);
//            String nomeFeriado = registro.get(2);
//            Feriado f = new Feriado(nomeFeriado, localDate);
//            System.out.println(f.toString());
////            feriados.add(f);
//        }
        
//        dao.persistirTodosFeriados(feriados);
    }
    
}
