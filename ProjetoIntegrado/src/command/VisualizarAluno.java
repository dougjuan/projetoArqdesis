package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelAluno;
import To.ToAluno;

public class VisualizarAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pEndereco = request.getParameter("endereco");
		String pTelefone = request.getParameter("telefone");
		String pEmail = request.getParameter("email");
		String pRg = request.getParameter("rg");
		String pCpf = request.getParameter("cpf");
		String pLogin = request.getParameter("login");
		String pSenha = request.getParameter("senha");

		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		ModelAluno modelAluno = new ModelAluno(id,pNome,pEndereco,pTelefone,pEmail,pRg,pCpf,pLogin,pSenha);
		RequestDispatcher view = null;
		
		try {
			modelAluno.carregar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("alunoTO",modelAluno.getTO() );
		view = request.getRequestDispatcher("VisualizarAluno.jsp");
		view.forward(request, response);

	}
	

	public int busca(ModelAluno modelAluno, ArrayList<ToAluno> lista) {
		ToAluno toAluno;
		for(int i = 0; i < lista.size(); i++){
			toAluno = lista.get(i);
			if(toAluno.getId() == modelAluno.getId()){
				return i;
			}
		}
		return -1;
	}

}
