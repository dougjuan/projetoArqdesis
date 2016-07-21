package command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelArtes;

public class EditarArtes implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHorario = request.getParameter("horario");
		String pVagas = request.getParameter("vagas");
		String pValor = request.getParameter("valor");
		String pDescMaterial = request.getParameter("descMaterial");
		String pLivros = request.getParameter("livros");

		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}		

		Date dataInicio = null;
		try {
			dataInicio = ModelArtes.formataData(pDataInicio);
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}

		Date dataTermino = null;
		try {
			dataTermino = ModelArtes.formataData(pDataTermino);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}

		double valorD = 0.0;

		try {

			valorD = Double.parseDouble(pValor);

		} catch (Exception e1) {
			
			e1.printStackTrace();
		}

		ModelArtes modelArtes = new ModelArtes(id,pNome,dataInicio,dataTermino,pHorario,pVagas,valorD,pDescMaterial,pLivros);
		RequestDispatcher view = null;
		


		try {
			modelArtes.carregar();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}

		request.setAttribute("artesTO", modelArtes.getToArtes());
		view = request.getRequestDispatcher("AlterarArtes.jsp");		
		

		view.forward(request, response);
		
	}

}
