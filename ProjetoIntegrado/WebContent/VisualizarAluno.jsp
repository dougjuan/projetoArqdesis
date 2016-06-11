<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="To.ToAluno"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Visualizar Cliente</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
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


	<%
		ToAluno toAluno = (ToAluno) request.getAttribute("alunoTO");
	%>
	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Cliente</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este cliente?
				</div>
				<div class="modal-footer">
					<form action="manter_aluno.do" method="post">
						<input type="hidden" name="id" value="<%=toAluno.getId()%>" />
						<button type="submit" class="btn btn-primary" name="acao"
							value="Excluir">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->

	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">
			Visualizar Cliente #<%=toAluno.getId()%></h3>


		<div class="row">
			<div class="col-md-6">
				<p>
					<strong>Nome</strong>
				</p>
				<p>
					<%=toAluno.getNome()%>
				</p>
			</div>




			<div class="col-md-6">
				<p>
					<strong>Endereço</strong>
				</p>
				<p>
					<%=toAluno.getEndereco()%>
				</p>
			</div>



			<div class="col-md-6">
				<p>
					<strong>Telefone</strong>
				</p>
				<p>
					<%=toAluno.getTelefone()%>
				</p>
			</div>


			<div class="col-md-6">
				<p>
					<strong>Email</strong>
				</p>
				<p>
					<%=toAluno.getEmail()%>
				</p>
			</div>


			<div class="col-md-6">
				<p>
					<strong>Rg</strong>
				</p>
				<p>
					<%=toAluno.getRg()%>
				</p>
			</div>


			<div class="col-md-6">
				<p>
					<strong>Cpf</strong>
				</p>
				<p>
					<%=toAluno.getCpf()%>
				</p>
			</div>


			<div class="col-md-6">
				<p>
					<strong>Login</strong>
				</p>
				<p>
					<%=toAluno.getLogin()%>
				</p>
			</div>


			<div class="col-md-6">
				<p>
					<strong>Senha</strong>
				</p>
				<p>
					<%=toAluno.getSenha()%>
				</p>
			</div>
		</div>


		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="manter_aluno.do?acao=Atualizar&id=<%=toAluno.getId()%>"
					class="btn btn-primary">Editar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal">Excluir</a> <a
					href="listar_alunos.html" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>