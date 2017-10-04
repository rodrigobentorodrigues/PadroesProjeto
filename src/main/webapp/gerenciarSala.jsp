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
        <link href="libs/bootstrap/bootstrap.min.css" rel="stylesheet">
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
            <h2>!include</h2>        
            <table class="table table-hover">
              <thead>
                <tr>
                    <th colspan="4" class="teste">
                        <div class="btn-group col-md-1">
                            <button type="button" class="btn btn-primary" title="Adicionar Material" id="botaoCadastrarSala"><span class="glyphicon glyphicon-plus"></span></button>
                        </div>
                        <div class="input-group col-md-4">
                            <input type="text" class="form-control" placeholder="Search" name="search">
                            <div class="input-group-btn">
                              <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            </div>
                        </div>
                    </th>
                </tr>
                    
                <tr>
                  <th>Sala</th>
                  <th>Bloco</th>
                  <th>Capacidade</th>
                  <th>Status</th>
                  <th>Editar</th>
                  <th>Excluir</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach var="sala" items="${salas}">
                    <tr>
                      <td>${sala.nome}</td>
                      <td>${sala.bloco}</td>
                      <td>${sala.capacidade}</td>
                      <td>${sala.status}</td>
                      <td><button type="button" class="btn btn-primary" title="Devolver Material"><span class="glyphicon glyphicon-download"></span></button></td>
                      <td><button type="button" class="btn btn-success" title="Editar Material"><span class="glyphicon glyphicon-pencil"></span></button></td>
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
                        <label for="descricao"><span class="glyphicon glyphicon-user"></span>Descriçao</label>
                        <input type="text" class="form-control"  maxlength="50" name="descricao" id="descricao" placeholder="Descrição">
                      </div>
                      
                      <div class="form-group">
                        <label for="bloco"><span class="glyphicon glyphicon-eye-open"></span>Bloco</label>
                        <input type="number" class="form-control" name="bloco" id="bloco">
                      </div>
                      
                      <div class="form-group">
                        <label for="capacidade"><span class="glyphicon glyphicon-eye-open"></span>Capacidade</label>
                        <input type="number" class="form-control" name="capacidade" id="capacidade">
                      </div>
                      
                      <div class="form-group">
                        <label for="sel1">Tipo:</label>
                        <select class="form-control" name="tipo" id="tipo">
                          <option>Comum</option>
                          <option>Laboratorio</option>
                          <option>Oficina</option>
                          <option>Inteligente</option>
                        </select>
                      </div>
                      
                      <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Cadastrar</button>
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
            $(document).ready(function(){
                $("#botaoCadastrarSala").click(function(){
                    $("#modalCadastrarSala").modal();
                });
            });
        </script>
    </body>
</html>
