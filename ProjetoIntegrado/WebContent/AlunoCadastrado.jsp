<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "To.ToAluno" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Aluno Cadastrado</title>
</head>
<body>



	<% 
	
		ToAluno to = (ToAluno)request.getAttribute("alunoTO");
			
	
	
	%>

	<h3>Aluno Cadastrado</h3>
	<p>
	
		Id:<%=to.getId() %><br>
		
		Nome:<%=to.getNome() %><br>
		
		Endereço:<%=to.getEndereco() %><br>
		
		Telefone:<%=to.getTelefone() %><br>
		
		Email:<%=to.getEmail() %><br>
		
		Rg:<%=to.getRg() %><br>
		
		Cpf:<%=to.getCpf() %><br>
		
		Login:<%=to.getLogin() %><br>
		
		Senha:<%=to.getSenha() %><br>
		
	
	</p>

</body>
</html>