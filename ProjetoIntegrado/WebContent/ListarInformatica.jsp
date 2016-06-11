<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList, To.ToInformatica" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Informática</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">

        </head>

        <body>
            <!-- Modal -->
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir Informática</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este curso?
                        </div>
                        <div class="modal-footer">
                            <form action="manter_informatica.do" method="post">
                                <input type="hidden" name="id" id="id_excluir" />
                                <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.modal -->
           <!-- Barra superior com os menus de navegação -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">cerveja.biz</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="listar_alunos.html">Alunos</a></li>
					<li><a href="listar_artes.html">Artes</a></li>
					<li><a href="listar_informatica.html">Informática</a></li>
				</ul>
			</div>
		</div>
	</nav>

            <!-- Container Principal -->
            <div id="main" class="container-fluid">
                <form action="listar_informatica.do" method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Informática</h2>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Informática (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="ManterInformatica.html" class="btn btn-primary pull-right h2">Novo Informática</a>
                        </div>
                    </div>
                    <!-- /#top -->
                </form>
                <hr />
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Data Início</th>
                                    <th>Data Término</th>
                                    <th>Horário</th>
                                    <th>Vagas</th>
                                    <th>Valor</th>
                                    <th>Número laboratório</th>
                                    <th>Registro de Software</th>
                                    
                                    
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% ArrayList<ToInformatica>lista = (ArrayList
                                    <ToInformatica>)request.getAttribute("lista"); for(ToInformatica to:lista){ %>
                                        <tr>
                                            <td>
                                                <%=to.getId()%>
                                            </td>
                                            <td>
                                                <%=to.getNome() %>
                                            </td>
                                            <td>
                                                <%=to.getDataInicio() %>
                                            </td>
                                            <td>
                                                <%=to.getDataTermino() %>
                                            </td>
                                            
                                            <td>
                                                <%=to.getHorario() %>
                                            </td>
                                            
                                            <td>
                                                <%=to.getVagas() %>
                                            </td>
                                            
                                            <td>
                                                <%=to.getValor() %>
                                            </td>
                                            
                                            <td>
                                                <%=to.getNumLab() %>
                                            </td>
                                            
                                            <td>
                                                <%=to.getRegSoft() %>
                                            </td>
                                            
                                            
                                            
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="manter_informatica.do?acao=Carregar&id=<%=to.getId()%>">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="manter_informatica.do?acao=Atualizar&id=<%=to.getId()%>">Editar</a>
                                                <button id="btn<%=to.getId()%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="<%=to.getId()%>">Excluir</button>
                                            </td>
                                        </tr>
                                        <% } %>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->

                    </div>
                </div>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('cliente');
                    $("#id_excluir").val(recipient);
                });
            </script>
        </body>

        </html>