<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/bootstrap.min.css" rel="stylesheet">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <!--Utilizar form posteriormente-->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="#">Sistema x</a>
              </div>
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Administração
                    <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="frontController?comando=GerenciarUsuarios">Gerenciar Usuarios</a></li>
                      <li><a href="frontController?comando=GerenciarFeriados">Gerenciar Feriados</a></li>
                    </ul>
                </li>
                
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Infraestrutura e Recursos
                    <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="frontController?comando=GerenciarMaterial">Gerenciar Materiais</a></li>
                      <li><a href="frontController?comando=GerenciarBlocos">Gerenciar Blocos</a></li>
                      <li><a href="frontController?comando=GerenciarSalas">Gerenciar Salas</a></li>
                      <li><a href="frontController?comando=GerenciarAlocacao">Gerenciar Alocações</a></li>
                    </ul>
                </li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="frontController?comando=Logout"><span class="glyphicon glyphicon-user"></span>Sair</a> 
              </ul>
            </div>
        </nav>

        <script src="libs/jquery.min.js"></script>
        <script src="libs/bootstrap/bootstrap.min.js"></script>   
    </body>
</html>