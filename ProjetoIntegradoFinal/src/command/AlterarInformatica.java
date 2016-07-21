package command;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelArtes;
import Model.ModelInformatica;
import To.ToInformatica;

public class AlterarInformatica implements Command {

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

		HttpSession session = request.getSession();
		
		modelInformatica.atualizar();
		@SuppressWarnings("unchecked")
		ArrayList<ToInformatica> lista = (ArrayList<ToInformatica>)session.getAttribute("lista");

		int pos = busca(modelInformatica, lista);
		lista.remove(pos);
		lista.add(pos, modelInformatica.getToInformatica());

		session.setAttribute("lista", lista);
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
