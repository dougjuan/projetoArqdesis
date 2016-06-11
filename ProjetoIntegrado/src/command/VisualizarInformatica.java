package command;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelArtes;
import Model.ModelInformatica;
import To.ToInformatica;

public class VisualizarInformatica implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHorario = request.getParameter("horario");
		String pVagas = request.getParameter("vagas");
		String pValor = request.getParameter("valor");
		String pNumLab = request.getParameter("numLab");
		String pRegSoft = request.getParameter("regSoft");


		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}		


		Date dataInicio = null;
		try {
			dataInicio = ModelArtes.formataData(pDataInicio);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Date dataTermino = null;
		try {
			dataTermino = ModelArtes.formataData(pDataTermino);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		double valorD = 0.0;

		try {

			valorD = Double.parseDouble(pValor);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		ModelInformatica modelInformatica = new ModelInformatica(id,pNome,dataInicio,dataTermino,pHorario,pVagas,valorD,pNumLab,pRegSoft);

		RequestDispatcher view = null;	
		
		try {
			modelInformatica.carregar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("informaticaTO",modelInformatica.getToInformatica() );
		view = request.getRequestDispatcher("VisualizarInformatica.jsp");
		view.forward(request, response);


	}
	
	public int busca(ModelInformatica modelInformatica, ArrayList<ToInformatica> lista) {
		ToInformatica toInformatica;
		for(int i = 0; i < lista.size(); i++){
			toInformatica= lista.get(i);
			if(toInformatica.getId() == modelInformatica.getId()){
				return i;
			}
		}
		return -1;
	}
	
	

}
