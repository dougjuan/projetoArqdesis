package Controller;

import java.io.IOException;

import java.sql.Date;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelArtes;
import Model.ModelInformatica;
import To.ToArtes;
import To.ToInformatica;

/**
 * Servlet implementation class ManterInformaticaController
 */
@WebServlet("/manter_informatica.do")
public class ManterInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterInformaticaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String pAcao = request.getParameter("acao");

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


		if(pAcao.equals("Inserir")){

			try {
				modelInformatica.criar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<ToInformatica> lista = new ArrayList<>();
			lista.add(modelInformatica.getToInformatica());
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarInformatica.jsp");



		}else if(pAcao.equals("Excluir")){


			modelInformatica.excluir();
			ArrayList<ToInformatica> lista = (ArrayList<ToInformatica>)session.getAttribute("lista");
			lista.remove(busca(modelInformatica, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarInformatica.jsp");

		}else if (pAcao.equals("Atualizar")){

			//ESSE QUE ALTERA
			try {
				modelInformatica.carregar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("informaticaTO", modelInformatica.getToInformatica());
			view = request.getRequestDispatcher("AlterarInformatica.jsp");		


		}else if (pAcao.equals("Carregar")){

			try {
				modelInformatica.carregar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("informaticaTO",modelInformatica.getToInformatica() );
			view = request.getRequestDispatcher("VisualizarInformatica.jsp");


		}else if (pAcao.equals("Editar")){

			//ESSE VISUALIZA

			modelInformatica.atualizar();
			ArrayList<ToInformatica> lista = (ArrayList<ToInformatica>)session.getAttribute("lista");

			int pos = busca(modelInformatica, lista);
			lista.remove(pos);
			lista.add(pos, modelInformatica.getToInformatica());

			session.setAttribute("lista", lista);
			request.setAttribute("informaticaTO",modelInformatica.getToInformatica() );
			view = request.getRequestDispatcher("VisualizarInformatica.jsp");

		}

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
