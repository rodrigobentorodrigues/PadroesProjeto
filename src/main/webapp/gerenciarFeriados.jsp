<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feriados</title>
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/bootstrap.min.css" rel="stylesheet">
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
        
    </head>
    <body>
        <div class="container">
            <h2>Gerenciar Feriados</h2><br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th colspan="4">
                            <div class="btn-group col-md-2">
                                <!--<a href="cadastro.html">-->
                                <button type="button" class="btn btn-primary" title="Adicionar Feriado" id="cadastrarFeriado"><span class="glyphicon glyphicon-plus"></span></button>
                                <!--</a>-->
                            </div>
                            <div class="input-group col-md-10 text-right">
                                <button type="button" class="btn btn-primary" title="Importar Feriados" id="importarFeriados"><span class="glyphicon glyphicon-open"></span>Importar</button>
                            </div>
                        </th>
                    </tr>
                    <tr>
<!--                        <th>Nome</th>
                        <th>Email</th>
                        <th>Matricula</th>
                        <th>Papel</th>       
                        <th>Editar</th>
                        <th>Excluir</th>                        -->
                    </tr>
                </thead>
                <tbody>
                    <%--<c:forEach var="usuario" items="${usuarios}">--%>
<!--                        <tr>
                            <td>${usuario.nome}</td>
                            <td>${usuario.email}</td>
                            <td>${usuario.matricula}</td>
                            <td>${usuario.papel}</td>
                    <form action="frontController" method="POST">
                        <input type="hidden" name="comando" value="EditarUsuario"/>
                        <input type="hidden" name="id" value="${usuario.id}"/>
                        <td><button title="Editar" class="btn btn-info col-md-5" type="submit" value="Editar"><span class="glyphicon glyphicon-pencil"></span></button></td>
                    </form>
                    <form action="frontController" method="POST">
                        <input type="hidden" name="comando" value="ExcluirUsuario"/>
                        <input type="hidden" name="id" value="${usuario.id}"/>
                        <td><button class="btn btn-danger col-md-5" type="submit" value="Excluir"><span class="glyphicon glyphicon-trash"></span></button></td>
                    </form>
                    </tr>-->
                <%--</c:forEach>--%>
                </tbody>
            </table>
            <!--<a href="inicial.jsp">Voltar</a>-->
        </div>
        <div class="modal fade" role="dialog" id="modalCadastrarFeriado" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header cabecalho">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4><span class="glyphicon glyphicon-lock"></span>Cadastrar Feriado</h4>
                    </div>
                    <span id="msgAlerta" class="col-md-12 text-center alert">
                        
                    </span>
                    <div class="modal-body corpo">
                        
                        <form>
                            <!--<input type="hidden" name="comando" value="AdicionarUsuario"/>-->
<!--                            <div class="form-group">
                                <label for="nome">Nome/Login:</label>
                                <input id="nome" class="form-control" type="text" name="nome"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input id="email" class="form-control" type="email" name="email"/>
                            </div>
                            <div class="form-group">
                                <label for="senha">Senha:</label>
                                <input id="senha" class="form-control" type="password" name="senha"/>
                            </div>
                            <div class="form-group">
                                <label for="matricula">Matricula:</label>
                                <input id="matricula" class="form-control" type="number" min="100000" max="999999" name="matricula"/>
                            </div>
                            <div class="form-group">
                                <label for="papel">Papel:</label>
                                <select name="papel" id="papel" class="form-control">
                                    <option>Professor</option>
                                    <option>Administrador</option>
                                    <option>Assistente</option>
                                </select>
                            </div>
                            <button type="button" id="btnCadastrar" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Cadastrar</button>-->
                        </form>
                    </div>
                </div>
            </div>
        </div>
                
        <!-- Modal de importar csv feriados -->
        <div class="modal fade" role="dialog" id="modalImportarFeriados" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header cabecalho">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4><span class="glyphicon glyphicon-lock"></span>Importar Feriados</h4>
                    </div>
                    <span id="msgAlerta" class="col-md-12 text-center alert">
                        
                    </span>
                    <div class="modal-body corpo">                    
                        <form enctype="multipart/form-data" action="frontController" method="post">
                            <div class="form-group">
                                <input type="hidden" name="comando" value="ImportarFeriados" />
                                <input type="file" name="csv" class="form-control" />
                            </div>
                            
                            <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Importar CSV</button>
                         
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Importando o jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <!-- Importando o js do bootstrap -->
        <script src="libs/bootstrap/bootstrap.min.js"></script>
        <script>
            $("#cadastrarFeriado").click(function () {
                $("#modalCadastrarFeriado").modal();
                console.log("clicado cadastrar feriado");
            });
            
            $("#importarFeriados").click(function () {
                $("#modalImportarFeriados").modal();
                console.log("clicado importar feriados");
            });
        </script>
    </body>
</html>
