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
import To.ToArtes;

public class ExcluirArtes implements Command {

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




		ModelArtes modelArtes = new ModelArtes(id,pNome,dataInicio,dataTermino,pHorario,pVagas,valorD,pDescMaterial,pLivros);
		RequestDispatcher view = null;

		HttpSession session = request.getSession();
		
		modelArtes.excluir();	

		@SuppressWarnings("unchecked")
		ArrayList<ToArtes> lista = (ArrayList<ToArtes>)session.getAttribute("lista");

		lista.remove(busca(modelArtes, lista));
		session.setAttribute("lista", lista);

		view = request.getRequestDispatcher("ListarArtes.jsp");
		
		view.forward(request, response);
		
	}
	
	public int busca(ModelArtes modelArtes, ArrayList<ToArtes> lista) {
		ToArtes toArtes;
		for(int i = 0; i < lista.size(); i++){
			toArtes = lista.get(i);
			if(toArtes.getId() == modelArtes.getId()){
				return i;
			}
		}
		return -1;
	}

}
