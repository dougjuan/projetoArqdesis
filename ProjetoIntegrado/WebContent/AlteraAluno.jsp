<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="To.ToAluno"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Alterar Cliente</title>

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
	<%ToAluno toAluno = (ToAluno)request.getAttribute("alunoTO"); %>

	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">
			Alterar Aluno #<%=toAluno.getId() %></h3>
		<!-- Formulario para alteração de clientes -->
		<form action="manter_aluno.do" method="post">
			<!-- area de campos do form -->
			<input type="hidden" name="id" value="<%=toAluno.getId() %>" />


			<div class="row">
				<div class="form-group col-md-12">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome" required
						maxlength="100" placeholder="nome completo"
						value="<%=toAluno.getNome()%>">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" name="endereco" id="endereco" required
						maxlength="100" placeholder="endereço"
						value="<%=toAluno.getEndereco()%>">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="telefone">Telefone</label> <input type="text"
						class="form-control" name="telefone" id="telefone" required
						maxlength="100" placeholder="telefone"
						value="<%=toAluno.getTelefone()%>">
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="email">Email</label> <input type="text"
						class="form-control" name="email" id="email" required
						maxlength="100" placeholder="email"
						value="<%=toAluno.getEmail()%>">
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="rg">Rg</label> <input type="text" class="form-control"
						name="rg" id="rg" required maxlength="100" placeholder="rg"
						value="<%=toAluno.getRg()%>">
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="cpf">Cpf</label> <input type="text"
						class="form-control" name="cpf" id="cpf" required maxlength="100"
						placeholder="cpf" value="<%=toAluno.getCpf()%>">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="login">Login</label> <input type="text"
						class="form-control" name="login" id="login" required
						maxlength="100" placeholder="login"
						value="<%=toAluno.getLogin()%>">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="senha">Senha</label> <input type="text"
						class="form-control" name="senha" id="senha" required
						maxlength="100" placeholder="senha"
						value="<%=toAluno.getSenha()%>">
				</div>
			</div>

			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="Editar">Salvar</button>
					<a href="listar_alunos.html" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>