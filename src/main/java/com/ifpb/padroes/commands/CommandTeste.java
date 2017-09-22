package com.ifpb.padroes.commands;

import com.ifpb.padroes.interfaces.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandTeste implements Command {

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
    }
}
