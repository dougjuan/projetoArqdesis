<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Universidade Loki - Criar Aluno</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>


<body>
 
 <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
	

	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Incluir Aluno</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="controller.do" method="post">

			<!-- area de campos do form -->


			<div class="row">
				<div class="form-group col-md-12">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome" required
						maxlength="100" placeholder="nome completo">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" name="endereco" id="endereco" required
						maxlength="100" placeholder="endereço">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="telefone">Telefone</label> <input type="text"
						class="form-control" name="telefone" id="telefone" required
						maxlength="100" placeholder="telefone">
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="email">Email</label> <input type="text"
						class="form-control" name="email" id="email" required
						maxlength="100" placeholder="email">
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="rg">Rg</label> <input type="text" class="form-control"
						name="rg" id="rg" required maxlength="100" placeholder="rg">
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="cpf">Cpf</label> <input type="text"
						class="form-control" name="cpf" id="cpf" required maxlength="100"
						placeholder="cpf">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="login">Login</label> <input type="text"
						class="form-control" name="login" id="login" required
						maxlength="100" placeholder="login">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="senha">Senha</label> <input type="text"
						class="form-control" name="senha" id="senha" required
						maxlength="100" placeholder="senha">
				</div>
			</div>


			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">

					<button type="submit" class="btn btn-primary" name="command" value="CriarAluno">Inserir</button>

					<a href="index.jsp" class="btn btn-default">Cancelar</a>

				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>