package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAluno;
import To.ToAluno;

public class ListarAlunoBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("data[search]");

		ModelAluno modelAluno = new ModelAluno();

		ArrayList<ToAluno> lista = null;

		HttpSession session = request.getSession();


		if (chave != null && chave.length() > 0) {

			try {
				lista = modelAluno.listarAlunos(chave);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		} else {

			try {
				lista = modelAluno.listarAlunos();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarAluno.jsp");
		dispatcher.forward(request, response);

	}
}
