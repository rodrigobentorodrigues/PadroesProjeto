<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Editar Bloco</h2>
        <form action="frontController" method="POST">
            <input type="hidden" name="comando" value="AtualizarBloco"/>
            Nome: <input type="text" name="nome" value="${blocoEdit.nome}"/>
            <input type="hidden" name="id" value="${blocoEdit.id}"/>
            <input type="submit" value="Atualizar"/>
        </form>
    </body>
</html>
