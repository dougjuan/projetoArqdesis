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

import To.ToArtes;


/**
 * Servlet implementation class ManterArtes
 */
@WebServlet("/manter_artes.do")
public class ManterArtes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterArtes() {
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

		if(pAcao.equals("Inserir")){
			
			

			try {
				modelArtes.criar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<ToArtes> lista = new ArrayList<>();
			lista.add(modelArtes.getToArtes());
			request.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarArtes.jsp");

		}else if(pAcao.equals("Excluir")){

			modelArtes.excluir();	
			view = request.getRequestDispatcher("listar_artes.html");

		}else if (pAcao.equals("Atualizar")){

			//ESSE QUE ALTERA

			
			
			try {
				modelArtes.carregar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("artesTO", modelArtes.getToArtes());
			view = request.getRequestDispatcher("AlteraArtes.jsp");		


		}else if (pAcao.equals("Carregar")){

			try {
				modelArtes.carregar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("artesTO",modelArtes.getToArtes() );
			view = request.getRequestDispatcher("VisualizarArtes.jsp");

		
		}else if (pAcao.equals("Editar")){

			//ESSE VISUALIZA

			modelArtes.atualizar();
			request.setAttribute("artesTO",modelArtes.getToArtes() );
			view = request.getRequestDispatcher("VisualizarArtes.jsp");


		}

		view.forward(request, response);
		
		





	}




}
