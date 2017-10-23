<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Salas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/css/bootstrap.css" rel="stylesheet">
	<!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
                        
        <style>
            .modal-header, h4, .close {
                background-color: #5cb85c;
                color:white !important;
                text-align: center;
                font-size: 30px;
            }
            .modal-footer {
                background-color: #f9f9f9;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Gerenciar Salas</h2>        
            <table class="table table-hover">
              <thead>
                <tr>
                    <th colspan="4" class="teste">
                        <div class="btn-group col-md-1">
                                <button type="button" class="btn btn-primary" title="Adicionar Sala" id="botaoCadastrarSala"><span class="glyphicon glyphicon-plus"></span></button>
                            </div>
                            <div class="input-group col-md-10">
                                <form class="form-inline" action="frontController" method="POST">
                                    <input type="hidden" name="comando" value="GerenciarSalas" />
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Buscar sala..." name="pesquisa">
                                    </div>
                                    <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                                </form>
                            </div>
                    </th>
                </tr>                    
                <tr>
                  <th>Sala</th>
                  <th>Bloco</th>
                  <th>Capacidade</th>
                  <th>Tipo</th>
                  <th>Status</th>
                  <th>Editar</th>
                  <th>Excluir</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach var="sala" items="${salas}">
                    <tr>
                      <td>${sala.nome}</td>
                      <td>${sala.bloco.nome}</td>
                      <td>${sala.capacidade}</td>
                      <td>${sala.tipo}</td>
                      <td>${sala.status}</td>
                      <td>
                          <form action="frontController" method="post">
                              <input type="hidden" name="comando" value="EditarSala">
                              <input type="hidden" name="idSala" value="${sala.id}">
                              <button type="submit" class="btn btn-success" title="Editar Sala"><span class="glyphicon glyphicon-pencil"></span></button>
                          </form>
                      </td>
                      <td>
                          <form action="frontController" method="post">
                              <input type="hidden" name="comando" value="ExcluirSala">
                              <input type="hidden" name="idSala" value="${sala.id}">
                              <button type="submit" class="btn btn-danger" title="Excluir Sala"><span class="glyphicon glyphicon-trash"></span></button>
                          </form>
                      </td>
                          
                    </tr>
                  </c:forEach>
              </tbody>
            </table>
            <a href="inicial.jsp"><button class="btn btn-primary" title="Voltar">Voltar</button></a>            
          </div>        
        <!-- Modal -->
        <div class="modal fade" id="modalCadastrarSala" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-home"></span>Cadastrar Sala</h4>
              </div>
              <div class="modal-body" style="padding:40px 50px;">
                  <form role="form" action="frontController" method="post">
                      <input type="hidden" name="comando" value="AdicionarSala"/>
                      <div class="form-group">
                        <label for="nome"><span class="glyphicon glyphicon-user"></span>Descriçao</label>
                        <input type="text" class="form-control"  maxlength="50" name="nome" id="nome" placeholder="Descrição">
                      </div>
                      
                      <div class="form-group">
                        <label for="bloco"><span class="glyphicon glyphicon-eye-open"></span>Bloco</label>
                        <select class="form-control" name="idBloco" id="idBloco" required> 
                            <option value=""></option>
                            <c:forEach var="bloco" items="${blocos}">
                                <option value="${bloco.id}">${bloco.nome}</option>
                            </c:forEach>
                        </select>
                      </div>
                      
                      <div class="form-group">
                        <label for="capacidade"><span class="glyphicon glyphicon-eye-open"></span>Capacidade</label>
                        <input type="number" class="form-control" name="capacidade" id="capacidade" min="1">
                      </div>
                      
                      <div class="form-group">
                        <label for="sel1">Tipo:</label>
                        <select class="form-control" name="tipo" id="tipo">                         
                          <option value="Comum">Comum</option>
                          <option value="Laboratorio">Laboratorio</option>
                          <option value="Oficina">Oficina</option>
                          <option value="Inteligente">Inteligente</option>
                        </select>
                      </div>
                      
                      <button type="submit" class="btn btn-success btn-block">Cadastrar <span class="glyphicon glyphicon-ok"></span></button>
                </form>
              </div>
            </div>
          </div>
        </div> 
             

        <!-- Importando o jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

        <!-- Importando o js do bootstrap -->
        <script src="libs/bootstrap/js/bootstrap.js"></script>

        <script>
            $(document).ready(function(){
                $("#botaoCadastrarSala").click(function(){
                    $("#modalCadastrarSala").modal();
                });
            });
        </script>
    </body>
</html>
