<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Universidade Loki - Criar Artes</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>


<body>
 
 <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
	

	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Incluir Artes</h3>
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
					<label for="dataInicio">Data início</label> <input type="text"
						class="form-control" name="dataInicio" id="dataInicio" required
						maxlength="100" placeholder="data início formato: yyyy-MM-dd">
						
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="dataTermino">Data término</label> <input type="text"
						class="form-control" name="dataTermino" id="dataTermino" required
						maxlength="100" placeholder="data término formato: yyyy-MM-dd">
						
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="horario">Horário</label> <input type="text"
						class="form-control" name="horario" id="horario" required
						maxlength="100" placeholder="horario">
					
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="vagas">Vagas</label> <input type="text" class="form-control"
						name="vagas" id="vagas" required maxlength="100" placeholder="vagas">
						
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="valor">Valor</label> <input type="number"
						class="form-control" name="valor" id="valor" required maxlength="100"
						placeholder="valor">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="descMaterial">Descrição Material</label> <input type="text"
						class="form-control" name="descMaterial" id="descMaterial" required
						maxlength="100" placeholder="descMaterial">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="livros">Livros</label> <input type="text"
						class="form-control" name="livros" id="livros" required
						maxlength="100" placeholder="livros">
				</div>
			</div>
		
			<div id="actions" class="row">
				<div class="col-md-12">

					<button type="submit" class="btn btn-primary" name="command" value="CriarArtes">Inserir</button>

					<a href="index.jsp" class="btn btn-default">Cancelar</a>

				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>