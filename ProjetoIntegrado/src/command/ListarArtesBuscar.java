package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAluno;
import Model.ModelArtes;
import To.ToAluno;
import To.ToArtes;

public class ListarArtesBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String chave = request.getParameter("data[search]");

		ModelArtes modelArtes = new ModelArtes();

		ArrayList<ToArtes> lista = null;

		HttpSession session = request.getSession();


		if (chave != null && chave.length() > 0) {

			try {
				lista = modelArtes.listarArtes(chave);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		} else {

			try {
				lista = modelArtes.listarArtes();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarArtes.jsp");
		dispatcher.forward(request, response);
	}
}
