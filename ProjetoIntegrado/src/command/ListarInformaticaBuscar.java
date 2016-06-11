package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelInformatica;
import To.ToInformatica;

public class ListarInformaticaBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String chave = request.getParameter("data[search]");
				
		ModelInformatica modelInformatica = new ModelInformatica();

		ArrayList<ToInformatica> lista = null;
		
		HttpSession session = request.getSession();
		
		if (chave != null && chave.length() > 0) {
			try {
				lista = modelInformatica.listarInformatica(chave);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				lista = modelInformatica.listarInformatica();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarInformatica.jsp");
		dispatcher.forward(request, response);
		
		
	

	}

}
