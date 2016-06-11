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


import Model.ModelArtes;
import Model.ModelInformatica;

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


		if(pAcao.equals("Inserir")){

			try {
				modelInformatica.criar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<ToInformatica> lista = new ArrayList<>();
			lista.add(modelInformatica.getToInformatica());
			request.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarInformatica.jsp");



		}else if(pAcao.equals("Excluir")){


			modelInformatica.excluir();	
			view = request.getRequestDispatcher("listar_informatica.html");



		}else if (pAcao.equals("Atualizar")){

			//ESSE QUE ALTERA
			try {
				modelInformatica.carregar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("informaticaTO", modelInformatica.getToInformatica());
			view = request.getRequestDispatcher("AlteraInformatica.jsp");		


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
			request.setAttribute("informaticaTO",modelInformatica.getToInformatica() );
			view = request.getRequestDispatcher("VisualizarInformatica.jsp");


		}

		view.forward(request, response);







	}

}
