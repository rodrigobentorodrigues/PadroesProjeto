<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Feriado</title>
    </head>
    <body>
        <form action="frontController" method="POST">
            <input type="hidden" name="comando" value="AtualizarFeriado"/>
            <input type="hidden" name="id" value="${feriado.id}"/>
            Nome: <input type="text" name="nome" value="${feriado.nome}"/><br>
            Data: <input type="date" name="data" value="${feriado.dataFeriado}"/><br>
            <input type="submit" value="Atualizar"/>
        </form>        
    </body>
</html>
