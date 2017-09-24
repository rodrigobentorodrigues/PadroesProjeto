<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <h2>Pagina Inicial</h2>
<!--    <h5>ID: ${usuarioLogado.id} </h5>
        <h5>Nome: ${usuarioLogado.nome} </h5>
        <h5>Senha: ${usuarioLogado.senha}</h5>
        <h5>Email: ${usuarioLogado.email} </h5>
        <h5>Matricula: ${usuarioLogado.matricula} </h5>
        <h5>Papel: ${usuarioLogado.papel} </h5>-->
        <br>
        <!--Utilizar form posteriormente-->
        <a href="frontController?comando=GerenciarUsuarios">Gerenciar Usuarios</a>
        <a href="frontController?comando=GerenciarFeriados">Gerenciar Feriados</a>
    </body>
</html>