<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Blocos</title>
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h2>Gerenciar Blocos</h1>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th colspan="4">
                                <div class="btn-group col-md-1">
                                    <button type="button" class="btn btn-primary" title="Adicionar Bloco" id="cadastrarBloco"><span class="glyphicon glyphicon-plus"></span></button>
                                </div>
                                <div class="input-group col-md-10">
                                    <form class="form-inline" method="POST" action="frontController">
                                        <input type="hidden" name="comando" value="GerenciarBlocos"/>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Buscar blocos..." name="pesquisa">
                                        </div>
                                        <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                                    </form>
                                </div>
                            </th>
                        </tr>
                        <tr>
                            <td>Nome</td>
                            <td>Editar</td>
                            <td>Excluir</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="bloco" items="${blocos}">
                            <tr>
                                <td>${bloco.nome}</td>
                        <form action="frontController" method="POST">
                            <input type="hidden" name="comando" value="EditarBloco"/>
                            <input type="hidden" name="id" value="${bloco.id}"/>
                            <td><button class="btn btn-info col-sm-2" type="submit" value="Excluir"><span class="glyphicon glyphicon-pencil"></span></button></td>
                        </form>
                        <form action="frontController" method="POST">
                            <input type="hidden" name="comando" value="ExcluirBloco"/>
                            <input type="hidden" name="id" value="${bloco.id}"/>
                            <td><button class="btn btn-danger col-sm-2" type="submit" value="Excluir"><span class="glyphicon glyphicon-trash"></span></button></td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="inicial.jsp"><button class="btn btn-primary" title="Voltar">Voltar</button></a>
                <!--<a href="inicial.jsp">Voltar</a>--> 
                <div class="modal fade" role="dialog" id="modalBloco">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header cabecalho">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4><span class="glyphicon glyphicon-lock"></span>Cadastrar Bloco</h4>
                            </div>
                            <div class="modal-body corpo">
                                <form action="frontController" method="POST">
                                    <input type="hidden" name="comando" value="AdicionarBloco"/>
                                    <div class="form-group">
                                        <label for="nomeBloco">Nome do bloco:</label>
                                        <input type="text" id="nomeBloco" class="form-control" name="nome"/>
                                    </div>
                                    <button type="submit" value="Cadastrar Bloco" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Cadastrar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Importando o jQuery -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
                <!-- Importando o js do bootstrap -->
                <script src="libs/bootstrap/js/bootstrap.js"></script>
                <script src="js/gerenciarBloco.js"></script>
        </div>
    </body>
</html>
