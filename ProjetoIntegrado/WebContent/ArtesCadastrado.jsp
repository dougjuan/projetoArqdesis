<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "To.ToArtes" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Artes Cadastrada</title>
</head>
<body>



	<% 
	
		ToArtes to = (ToArtes)request.getAttribute("artesTO");
			
	
	
	%>

	<h3>Artes Cadastrada</h3>
	<p>
	
		Id:<%=to.getId() %><br>
		
		Nome:<%=to.getNome() %><br>
		
		Data in�cio:<%=to.getDataInicio() %><br>
		
		Data t�rmino:<%=to.getDataTermino() %><br>
		
		Hor�rio:<%=to.getHorario() %><br>
		
		Vagas:<%=to.getVagas() %><br>
		
		Valor:<%=to.getValor() %><br>
		
		Descri��o material:<%=to.getDescMat() %><br>
		
		Livros:<%=to.getLivros() %><br>
		
	</p>

</body>
</html>