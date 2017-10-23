<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alocação de Salas</title>
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
        
    </head>
    <body>
        <div class="container">
            <h2>Alocação de Salas</h2><br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th colspan="4">
                            <div class="btn-group col-md-1">
                                <button type="button" class="btn btn-primary" title="Cadastrar Evento" id="cadastrarEvento"><span class="glyphicon glyphicon-flag"></span></button>
                            </div>
                            <div class="btn-group col-md-1">
                                <button type="button" class="btn btn-primary" title="Alocar Evento"  id="alocarEvento"><span class="glyphicon glyphicon-plus"></span></button>
                            </div>
                            <div class="btn-group col-md-1">
                                <button type="button" class="btn btn-primary" title="Alocar Materiais"  id="alocarMateriais"><span class="glyphicon glyphicon-wrench"></span></button>
                            </div>
                            <div class="input-group col-md-9">
                                <form class="form-inline" action="frontController" method="POST">
                                    <input type="hidden" name="comando" value="GerenciarAlocacao" />
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Buscar alocação..." name="pesquisa">
                                    </div>
                                    <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                                </form>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th>Data</th>
                        <th>Evento</th>
                        <th>Situacao</th> 
                        <th>Local</th>
                        <th>Editar</th>
                        <th>Excluir</th>                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="alocacao" items="${alocacoes}">
                        <tr>
                            <td>${alocacao.dataHoraInicio}</td>
                            <td>${alocacao.nomeEvento}</td>
                            <td>${alocacao.situacao}</td>
                            <td>${alocacao.local}</td>
<!--                    <form action="frontController" method="POST">
                        <input type="hidden" name="comando" value="EditarUsuario"/>
                        <input type="hidden" name="id" value=""/>
                        <td><button title="Editar" class="btn btn-info col-sd-6" type="submit" value="Editar"><span class="glyphicon glyphicon-pencil"></span></button></td>
                    </form>
                    <form action="frontController" method="POST">
                        <input type="hidden" name="comando" value="ExcluirUsuario"/>
                        <input type="hidden" name="id" value=""/>
                        <td><button class="btn btn-danger col-sd-6" type="submit" value="Excluir"><span class="glyphicon glyphicon-trash"></span></button></td>
                    </form>-->
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="inicial.jsp"><button class="btn btn-primary" title="Voltar">Voltar</button></a>
        </div>
        
        <div class="modal fade" role="dialog" id="modalCadastrarEvento" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header cabecalho" style="background-color: #46358c">
                        <button type="button" class="close" style="background-color: #46358c" data-dismiss="modal">&times;</button>
                        <h4 style="background-color: #46358c"><span class="glyphicon glyphicon-lock"></span>Cadastrar Evento</h4>
                    </div>
                    <span id="msgAlerta" class="col-md-12 text-center alert">
                        
                    </span>
                    <div class="modal-body corpo">
                        
                        <form method="POST" action="frontController">
                            <input type="hidden" name="comando" value="AdicionarEvento"/>
                            <div class="form-group">
                                <label for="nome">Nome do Evento:</label>
                                <input id="nome" class="form-control" type="text" name="nome"/>
                            </div>
                            <div class="form-group">
                                <label for="descricao">Descrição:</label>
                                <textarea id="descricao" name="descricao" class="form-control" rows="4" style="resize: none"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="participantes">Participantes:</label>
                                <input id="participantes" class="form-control" type="number" name="participantes" min="1"/>
                            </div>
                            <div class="form-group">
                                <label for="Responsável">Responsável:</label>
                                <select name="responsavel" id="responsavel" class="form-control">
                                    <c:forEach items="${usuarios}" var="usuario">
                                        <option value="${usuario.nome}">
                                            ${usuario.nome}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inicio">Inicio:</label>
                                <input type="date" name="inicio" id="inicio" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="fim">Fim:</label>
                                <input type="date" name="fim" id="fim" class="form-control" />
                            </div>
                            <button type="submit" id="btnCadastrar" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-off"></span>Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal fade" role="dialog" id="modalAlocarEvento" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header cabecalho">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4><span class="glyphicon glyphicon-lock"></span>Alocar Evento</h4>
                    </div>
                    <span id="msgAlerta" class="col-md-12 text-center alert">
                        
                    </span>
                    <div class="modal-body corpo">
                        
                        <form method="post" action="frontController">
                            <input type="hidden" name="comando" value="AlocarEvento"/>
                            <div class="form-group">
                                <label for="evento">Selecione o evento:</label>
                                <select name="evento" id="evento" class="form-control">
                                    <c:forEach items="${eventos}" var="evento">
                                        <option value="${evento.nome}">
                                            ${evento.nome}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="sala">Selecione a sala:</label>
                                <select name="sala" id="sala" class="form-control">
                                    <c:forEach items="${salas}" var="sala">
                                        <option value="${sala.nome}">
                                            ${sala.nome}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            
                            <button type="submit" id="btnAlocar" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Alocar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal fade" role="dialog" id="modalAlocarMateriais" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header cabecalho" style="background-color: #ff9d00">
                        <button type="button" class="close" style="background-color: #ff9d00" data-dismiss="modal">&times;</button>
                        <h4 style="background-color: #ff9d00"><span class="glyphicon glyphicon-lock"></span>Alocar Materiais</h4>
                    </div>
                    <span id="msgAlerta" class="col-md-12 text-center alert">
                        
                    </span>
                    <div class="modal-body corpo">
                        
                        <form method="POST" action="frontController">
                            <input type="hidden" name="comando" value="AlocarMaterial"/>
                            <div class="form-group">
                                <label for="evento">Selecione o Alocação/Evento:</label>
                                <select name="evento" id="evento" class="form-control">
                                    <c:forEach items="${eventos}" var="evento">
                                        <option value="${evento.nome}">
                                            ${evento.nome}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="material">Selecione o material:</label>
                                <select name="material" id="material" class="form-control">
                                    <c:forEach items="${materiais}" var="material">
                                        <option value="${material.nome}">
                                            ${material.nome}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button type="submit" id="btnAlocarMateriais" class="btn btn-warning btn-block"><span class="glyphicon glyphicon-off"></span>Alocar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Importando o jQuery -->
        <script src="libs/jquery.min.js"></script>
        <!-- Importando o js do bootstrap -->
        <script src="libs/bootstrap/js/bootstrap.js"></script>
        <script>
            
            $(document).ready(function(){
                $("#cadastrarEvento").click(function () {
                    $("#modalCadastrarEvento").modal();
                    console.log("clicado");
                });
                
                $("#alocarEvento").click(function () {
                    $("#modalAlocarEvento").modal();
                    console.log("clicado");
                });
                
                $("#alocarMateriais").click(function () {
                    $("#modalAlocarMateriais").modal();
                    console.log("clicado");
                });
            });
        </script>
    </body>
</html>
