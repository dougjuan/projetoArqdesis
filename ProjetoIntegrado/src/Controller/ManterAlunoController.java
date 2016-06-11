package Controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.ModelAluno;
import To.ToAluno;


/**
 * Servlet implementation class ManterAlunoController
 */
@WebServlet("/manter_aluno.do")
public class ManterAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterAlunoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pAcao = request.getParameter("acao");	


		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pEndereco = request.getParameter("endereco");
		String pTelefone = request.getParameter("telefone");
		String pEmail = request.getParameter("email");
		String pRg = request.getParameter("rg");
		String pCpf = request.getParameter("cpf");
		String pLogin = request.getParameter("login");
		String pSenha = request.getParameter("senha");

		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		ModelAluno modelAluno = new ModelAluno(id,pNome,pEndereco,pTelefone,pEmail,pRg,pCpf,pLogin,pSenha);
		RequestDispatcher view = null;
	
	
				
		if(pAcao.equals("Inserir")){
			
				try {
					modelAluno.criar();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ArrayList<ToAluno> lista = new ArrayList<>();
				lista.add(modelAluno.getTO());
				request.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarAlunos.jsp");
			
			
		}else if(pAcao.equals("Excluir")){

			modelAluno.excluir();	
			view = request.getRequestDispatcher("listar_alunos.html");


		}else if (pAcao.equals("Atualizar")){

			//ESSE QUE ALTERA
			
			try {
				modelAluno.carregar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			request.setAttribute("alunoTO", modelAluno.getTO());
			view = request.getRequestDispatcher("AlteraAluno.jsp");		

		}else if (pAcao.equals("Carregar")){
			
			try {
				modelAluno.carregar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("alunoTO",modelAluno.getTO() );
			view = request.getRequestDispatcher("VisualizarAluno.jsp");
			
			
		}else if (pAcao.equals("Editar")){
			
			//ESSE VISUALIZA
			
			modelAluno.atualizar();
			request.setAttribute("alunoTO",modelAluno.getTO() );
			view = request.getRequestDispatcher("VisualizarAluno.jsp");
			
			
		}
				
		view.forward(request, response);
		
		


	}

}
