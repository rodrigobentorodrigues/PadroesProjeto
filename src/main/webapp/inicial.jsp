<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <a href="frontController?comando=Logout">Sair</a>
        <h2>Pagina Inicial</h2>
        <br>
        <!--Utilizar form posteriormente-->
        <a href="frontController?comando=GerenciarUsuarios">Gerenciar Usuarios</a>
        <a href="frontController?comando=GerenciarFeriados">Gerenciar Feriados</a>
        <a href="frontController?comando=GerenciarBlocos">Gerenciar Blocos</a>
        <a href="frontController?comando=GerenciarMaterial">Gerenciar Material</a>
        <!--<a href="frontController?comando=GerenciarBlocos">Gerenciar Sala</a>-->
    </body>
</html>